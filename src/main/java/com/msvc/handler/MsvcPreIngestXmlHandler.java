
/***************************************************************************
 * Copyright (C) Centivo 
 * 
 * The reproduction, transmission or use of this document or its contents is not permitted without
 * prior express written consent of Centivo. Offenders will be liable for damages. All rights,
 * including but not limited to rights created by patent grant or registration of a utility model or
 * design, are reserved.
 * 
 * Centivo reserves the right to modify technical specifications and features.
 * 
 * Technical specifications and features are binding only insofar as they are specifically and
 * expressly agreed upon in a written contract.
 * 
 **************************************************************************/

package com.msvc.handler;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.msvc.dal.dao.PreIngestXmlDao;
import com.msvc.dal.dao.PreIngestXmlDaoImpl;
import com.msvc.dal.model.Attributes;
import com.msvc.dal.model.Data;
import com.msvc.dal.model.EmployeeRecord;
import com.msvc.dal.model.IngestXactionEvent;
import com.msvc.dal.model.IngestionEvent;
import com.msvc.dal.model.IngestionTemplate;
import com.msvc.exception.PreIngestXmlException;
import com.msvc.sns.message.MessageEvent;
import com.msvc.sns.message.SNSMessage;
import com.msvc.util.XsdValidationUtil;
import com.msvc.vo.Constant;

/**
 * 
 * Handler class to parse and validate the ingestion file object
 * 
 * @author anand.jha
 *
 */
public class MsvcPreIngestXmlHandler implements RequestHandler<S3Event, String> {

	private static final boolean IS_TRANSACTION_VALIDATION_REQUIRED = false;

	private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

	private PreIngestXmlDao preIngestXmlDao = new PreIngestXmlDaoImpl();

	List<EmployeeRecord> transactionList = new ArrayList<EmployeeRecord>();
	
	private static final int chunkSize = Constant.MIN_TRANSACTION_CHUNK_SIZE;

	/**
	 * process s3 event
	 * 
	 * @param s3event
	 * @param context
	 * 
	 * @return String
	 */
	@Override
	public String handleRequest(S3Event s3event, Context context) {
		context.getLogger().log("Received event: " + s3event);

		String bucketName = s3event.getRecords().get(0).getS3().getBucket().getName();
		String bucketKey = s3event.getRecords().get(0).getS3().getObject().getKey();

		context.getLogger().log("bucket name:" + bucketName);

		Instant starttime = null;
		Instant endtime = null;

		List<Map<String, Object>> xmlMap = null;

		try {

			S3Object response = s3.getObject(new GetObjectRequest(bucketName, bucketKey));

			MessageEvent messageEvent = this.getMessageEvent(bucketName, bucketKey);

			byte[] bytes = IOUtils.toByteArray(response.getObjectContent());

			// context.getLogger().log("Time taken in xml reading from S3 bucket:" +
			// (endtime - starttime));

			IngestionTemplate template = preIngestXmlDao.loadTemplate(bucketName);

			List<Attributes> attrs = template.getAttributes();

			String xsdString = attrs.get(0).getFieldName();

			context.getLogger().log("xsdString: " + xsdString);

			int extractedTransactionCount = 0;

			context.getLogger().log("publish event type INGEST_OBJECT_EVENT");

			

			// boolean isValidChecksum = validateChecksum(messageEvent, context);
			boolean isValidChecksum = true;

			if (isValidChecksum) {

				context.getLogger().log(Constant.OBJECT_PROCESS_SUCESS_MESSAGE);

				publishIngestObjectEvent(messageEvent);

				starttime = Instant.now();
				
				IngestionEvent ingestionEvent = saveIngestObjectEventData(messageEvent);


				// XML VALIDATE FROM INPUTSTREAM

				if (XsdValidationUtil.validateInputStreamFromXSD(xsdString, bytes)) {
					context.getLogger().log(Constant.XML_VALID_SUCESS_MESSAGE);

					ByteArrayInputStream xmlIs = new ByteArrayInputStream(bytes);

					//xmlMap = UnMarshallXmlUtil.getXmlDataUsingSTAX(xmlIs);
					//xmlMap = UnMarshallXmlUtil.getXmlDataAsList(xmlIs);

					xmlMap = getListfromJSON(xmlIs,messageEvent,ingestionEvent);
					
					//extractedTransactionCount = xmlMap.size();

					//context.getLogger().log("Transaction saved:" + extractedTransactionCount);

					//messageEvent.setTransaction(xmlMap.get(0));

				} else {
					context.getLogger().log(" XML is not valid against xsd");
				}

				endtime = Instant.now();

				Double secondsPassed = (double) (endtime.toEpochMilli() - starttime.toEpochMilli())/1000;

				context.getLogger().log("[ALERT] Total time taken in XML Validation + Parsing : " + secondsPassed);

				// TODO: convertXmltoJSON

				//messageEvent.setNoOfLines(xmlMap.size());

				
				
			}

			context.getLogger().log("[Sanskriti] after publish::" + messageEvent.getEventMessage());

			return messageEvent.getEventMessage();

		} catch (Exception e) {
			e.printStackTrace();

			throw new PreIngestXmlException(Constant.OBJECT_PROCESS_ERROR_MESSAGE);
		} finally {

		}
	}

	private  String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}
	private List<Map<String, Object>> getListfromJSON(InputStream xmlFile, MessageEvent messageEvent, IngestionEvent ingestionEvent)
	{
		List<EmployeeRecord> list = new ArrayList<EmployeeRecord>();
		List<Map<String, Object>> listOfMaps = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		 ArrayList<JSONObject> myArrayList = new ArrayList<JSONObject>();
         
		
		 try {
			 
	            JSONObject xmlJSONObj = XML.toJSONObject(getStringFromInputStream(xmlFile));
	            
	            System.out.println("xmlJSONObj ="+ xmlJSONObj);
	            
	            JSONObject jsonObj = xmlJSONObj.getJSONObject("Member").getJSONObject("EmployeeRecordsList");
	            
	            Iterator<String> keys = jsonObj.keys();
	            
	            int i=0;
	            
	            while(keys.hasNext())
	            {
	                String key = (String)keys.next();
	                if ( jsonObj.get(key) instanceof JSONObject )
	                {
	                    JSONObject employeeRec = new JSONObject(jsonObj.get(key).toString());
	                    myArrayList.add(employeeRec);
	                    System.out.println("AlternateID1=>"+employeeRec.get("AlternateID1"));
	                    
	                    if (chunkSize == myArrayList.size()) 
						{
							JSONArray transaction = new JSONArray(myArrayList);
							
							int noOfRecords = myArrayList.size();
							
							messageEvent.setJsonArray(transaction);

							// Get transactionEventUuid which will be use to update transactionEvent data
							// TODO: later
							String transactionEventUuid = this.saveTransactionEvent(messageEvent, ingestionEvent, noOfRecords);

							messageEvent.setTransactionEventUuid(transactionEventUuid);
							
							messageEvent.setEventMessage(Constant.OBJECT_PROCESS_SUCESS_MESSAGE);

							// publish TranactionEvent to Topic
							publishIngestTransactionEvent(messageEvent, ingestionEvent);

							i = 0;
							myArrayList.clear();
						}
	                }
	            }

		 } catch (JSONException je) {
	        	
	           je.printStackTrace();
	        }
		return null;
		
	}
	
	
	
	private Map<String, String> convertJSONtoMAP(String xmlJson) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * publishIngestObjectEvent
	 * 
	 * @param messageEvent
	 */
	private void publishIngestObjectEvent(MessageEvent messageEvent) {
		messageEvent.setEventMessage(Constant.OBJECT_PROCESS_SUCESS_MESSAGE);
		messageEvent.setTemplate(Constant.TEMPLATE);
		messageEvent.setEventType(Constant.EventType.INGEST_OBJECT_EVENT.getEvent());
		publishMessage(messageEvent);
	}

	/**
	 * retreiveSaveIngestEvent method will return ingestionEvent with generated uuid
	 * 
	 * @param messageEvent
	 * @return
	 */
	private IngestionEvent saveIngestObjectEventData(MessageEvent messageEvent) {
		System.out.println("Start retreiveSaveIngestEvent");
		IngestionEvent ingestionEvent = new IngestionEvent();
		ingestionEvent.setBucketName(messageEvent.getBucketName());
		ingestionEvent.setChecksum(messageEvent.getChecksum());
		ingestionEvent.setBucketKey(messageEvent.getBucketKey());
		ingestionEvent.setTemplateName(messageEvent.getTemplate());
		ingestionEvent.setTotalNbrTransactions(Constant.TRANSACTION_CHUNK_SIZE);
		ingestionEvent.setTotalNbrRecords(messageEvent.getNoOfLines());
		ingestionEvent.setIngestionTimestamp((Instant.now().toEpochMilli()));
		if (Objects.nonNull(messageEvent.getExceptionCode())) {
			ingestionEvent.setExceptionCode(messageEvent.getExceptionCode());
			ingestionEvent.setExceptionDescription(messageEvent.getExceptionDescription());
		}

		System.out.println("prepare ingestionEvent to insert into db:" + ingestionEvent);
		preIngestXmlDao.persistData(ingestionEvent);
		System.out.println("Data persited into INGEST_OBJECT_EVENT successfully.");
		System.out.println("End retreiveSaveIngestEvent");
		return ingestionEvent;
	}

	/**
	 * 
	 * @param messageEvent
	 * @param template
	 * @param transaction
	 * @param ingestionEvent
	 * @param transactionList
	 * @param extractedTransactionCount
	 */
	public void extractTransaction(MessageEvent messageEvent, IngestionTemplate template, IngestionEvent ingestionEvent,
			List<Map<String, String>> transactionList, int extractedTransactionCount) {

		System.out.println("Start extractTransaction with messageEvent =" + messageEvent);
		System.out.println("ingestionEvent     =" + ingestionEvent);

		Map<String, String> transactionMap = new HashMap<String, String>();

		// By default it will be chunk size , ex: if file size is 8 and chink size is 5
		// then noOfRecords will have 5 and 3 value only
		int noOfRecords = 0;

		int remainingChunkSize = messageEvent.getNoOfLines() - extractedTransactionCount;

		System.out.println("remainingChunkSize: " + remainingChunkSize + " transactionList.size()::"
				+ transactionList.size() + " Constant.TRANSACTION_CHUNK_SIZE::" + Constant.TRANSACTION_CHUNK_SIZE);

		// setExtractedTransactionData(messageEvent, template, transaction,
		// transactionList, transactionMap);

		if (transactionList.size() == Constant.TRANSACTION_CHUNK_SIZE || remainingChunkSize == 0) {
			System.out.println("chunk size:" + transactionList.size());
			try {

				noOfRecords = transactionList.size();

				// Get transactionEventUuid which will be use to update transactionEvent data
				// later
				String transactionEventUuid = saveTransactionEvent(messageEvent, ingestionEvent, noOfRecords);

				messageEvent.setTransactionEventUuid(transactionEventUuid);

				// publish TranactionEvent into topic
				publishIngestTransactionEvent(messageEvent, ingestionEvent);

				System.out.println("publish messageEvent" + messageEvent);

				// clear transaction list as this list filled based on chunk size
				transactionList.clear();

				System.out.println("transaction list size clear : " + transactionList.size());
			} catch (Exception e) {

				System.err.println("Error while publishIngestTransactionEvent message");
				e.printStackTrace();
			}
		}

	}

	/**
	 * @param messageEvent
	 * @param template
	 * @param transaction
	 * @param transactionList
	 * @param transactionMap
	 */
	private void setExtractedTransactionData(MessageEvent messageEvent, IngestionTemplate template, String transaction,
			List<Map<String, Object>> transactionList, Map<String, Object> transactionMap) {
		System.out.println("Start setExtractedTransactionData ");
		for (Attributes attr : template.getAttributes()) {

			// System.out.println("value extracted for start: "+
			// attr.getStartPosition().intValue() + ", end : "+
			// attr.getEndPosition().intValue());
			String val = transaction.substring(attr.getStartPosition().intValue() - 1,
					attr.getEndPosition().intValue() - 1);
			val = val.trim();
			if (val.isEmpty()) {
				// System.out.println(attr.getFieldName() + " is empty.");
				continue;
			}

			transactionMap.put(attr.getMasterAttr(), val);

		}

		System.out.println("transactionList size ::" + transactionList.size());
		if (transactionList.size() < Constant.TRANSACTION_CHUNK_SIZE) {
			transactionList.add(transactionMap);
		}

		messageEvent.setTransactionList(transactionList);
		System.out.println("End setExtractedTransactionData ");
	}

	/**
	 * @param messageEvent
	 * @param ingEvent
	 */
	public void publishIngestTransactionEvent(MessageEvent messageEvent, IngestionEvent ingEvent) {
		messageEvent.setEventType(Constant.EventType.INGEST_XACTION_EVENT.getEvent());
		messageEvent.setIngestEventUuid(ingEvent.getEventUuid());
		messageEvent.setIngestionTimestamp(String.valueOf(ingEvent.getIngestionTimestamp()));
		publishMessage(messageEvent);
	}

	/**
	 * saveTransactionEvent
	 * 
	 * @param messageEvent
	 * @param ingEvent
	 * @param noOfRecords
	 */
	private String saveTransactionEvent(MessageEvent messageEvent, IngestionEvent ingEvent, int noOfRecords) {
		System.out.println("Start saveTransactionEvent");

		//final IngestXactionEvent transactionEvent = setIngestTransactionData(messageEvent, ingEvent, noOfRecords);
		IngestXactionEvent transactionEvent =new IngestXactionEvent();
		System.out.println("prepare transactionEvent to insert into db:" + transactionEvent);

		// preIngestXmlDao.persistTransactionData(transactionEvent);

		System.out.println("End saveTransactionEvent");
		return transactionEvent.getEventUuid();
	}

	/**
	 * @param messageEvent
	 * @param ingEvent
	 * @param noOfRecords
	 * @return
	 */
	private IngestXactionEvent setIngestTransactionData(MessageEvent messageEvent, IngestionEvent ingEvent,
			int noOfRecords) {
		IngestXactionEvent transactionEvent = new IngestXactionEvent();
		transactionEvent.setIngestionTimestamp(ingEvent.getIngestionTimestamp());
		transactionEvent.setIngestObjectEventUuid(ingEvent.getEventUuid());
		transactionEvent.setTemplateName(messageEvent.getTemplate());

		//List<Map<String, Object>> transactionList = messageEvent.getTransactionList();
		
		
		List<Data> transactionDatList = new ArrayList<Data>();

		/*for (Map<String, Object> transactionData : transactionList) {
			Data data = new Data();
			data.setTransactiondata(transactionData);
			transactionDatList.add(data);
		}
*/
		transactionEvent.setRecord(transactionDatList);
		transactionEvent.setNbrRecords(noOfRecords);
		return transactionEvent;
	}

	/**
	 * get MessageEvent
	 * 
	 * @param bucketName
	 * @param bucketKey
	 * @return
	 */
	private MessageEvent getMessageEvent(String bucketName, String bucketKey) {
		MessageEvent messageEvent = new MessageEvent();
		messageEvent.setBucketName(bucketName);
		messageEvent.setBucketKey(bucketKey);
		return messageEvent;
	}

	/**
	 * publishMessage
	 * 
	 * @param messageEvent
	 */
	private void publishMessage(MessageEvent messageEvent) {
		SNSMessage message = new SNSMessage();
		message.publishMessage(messageEvent, IS_TRANSACTION_VALIDATION_REQUIRED);
	}

	/**
	 * publishExceptionMessage
	 * 
	 * @param messageEvent
	 */
	private void publishExceptionMessage(MessageEvent messageEvent) {
		SNSMessage message = new SNSMessage();
		message.publishException(messageEvent);
	}

	/**
	 * validate no of lines as template max records
	 * 
	 * @param actualNoOflines
	 * @param templateNoOfLines
	 */
	private boolean validateNoOfLines(MessageEvent messageEvent, int templateNoOfLines, Context context) {
		boolean result = true;
		if (messageEvent.getNoOfLines() > templateNoOfLines) {
			context.getLogger().log(Constant.INVALID_OBJECT_DUE_TO_EXCEEDING_NO_OF_LINES);
			result = false;
		}
		return result;
	}

	/**
	 * validate object size as per template
	 * 
	 * @param actualObjectSize
	 * @param templateObjectSize
	 */
	private boolean validateObjectSize(MessageEvent messageEvent, long templateObjectSize, Context context) {
		boolean result = true;
		if (messageEvent.getObjectSize() != templateObjectSize) {
			context.getLogger().log(Constant.INVALID_OBJECT_DUE_TO_INVALID_OBJECT_SIZE);
			result = false;
		}
		return result;
	}

	/**
	 * validate Checksum if it is duplicate
	 * 
	 * @param checksum
	 */
	private boolean validateChecksum(MessageEvent messageEvent, Context context) {
		boolean result = true;
		if (preIngestXmlDao.isDuplicateChecksum(messageEvent.getChecksum())) {
			context.getLogger().log(Constant.INVALID_OBJECT_DUE_TO_DUPLICATE_CHECKSUM);
			messageEvent.setEventMessage(Constant.INVALID_OBJECT_DUE_TO_DUPLICATE_CHECKSUM);
			publishExceptionMessage(messageEvent);
			result = false;
		}
		return result;
	}

}