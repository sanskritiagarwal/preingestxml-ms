
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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
import com.msvc.dal.model.EmployeeRecord;
import com.msvc.dal.model.XmlIngestionTemplate;
import com.msvc.exception.PreIngestXmlException;
import com.msvc.sns.message.MessageEvent;
import com.msvc.sns.message.SNSMessage;
import com.msvc.util.PreIngestXmlUtil;
import com.msvc.vo.Constant;

/**
 * 
 * Handler class to parse and validate the ingestion file object
 * 
 * @author anand.jha
 *
 */
public class MsvcPreIngestXmlHandler implements RequestHandler<S3Event, String> {

	private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

	private PreIngestXmlDao preIngestXmlDao = new PreIngestXmlDaoImpl();

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

		try {
			S3Object response = s3.getObject(new GetObjectRequest(bucketName, bucketKey));

			MessageEvent messageEvent = this.getMessageEvent(bucketName, bucketKey);

			PreIngestXmlUtil.addObjectValidationAttribs(response.getObjectContent(), messageEvent);
			
			XmlIngestionTemplate template = preIngestXmlDao.loadTemplate();

			List<EmployeeRecord> attrs = template.getEmployeeRecord();

			
			
			return messageEvent.getEventMessage();

		} catch (Exception e) {

			throw new PreIngestXmlException(Constant.OBJECT_PROCESS_ERROR_MESSAGE);
		}
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
		message.publishMessage(messageEvent);
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
	private boolean validateChecksum(MessageEvent messageEvent,  Context context) {
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