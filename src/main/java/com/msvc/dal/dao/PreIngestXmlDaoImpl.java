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

package com.msvc.dal.dao;

import java.util.HashMap;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.msvc.dal.model.IngestXactionEvent;
import com.msvc.dal.model.IngestionEvent;
import com.msvc.dal.model.IngestionTemplate;
import com.msvc.vo.Constant;

/**
 * 
 *  PreIngestDaoImpl class to access the dynamo database
 *    
 *  @author anand.jha
 *
 */

public class PreIngestXmlDaoImpl implements PreIngestXmlDao{

	
	/** AmazonDynamoDB client*/
	private static AmazonDynamoDB client;
	
	/** DynamoDBMapper */
	private static DynamoDBMapper mapper;
		
	
	/**
     * initialize DynamoDB client
     * @return
     */
	public PreIngestXmlDaoImpl(){
		  client =  AmazonDynamoDBClientBuilder.standard()
                  .withRegion(Constant.REGION)                               
                  .build();
		  
		  mapper = new DynamoDBMapper(client);
	}
	
	    
    /**
     * verify the Checksum if duplicate
     * 
     * @param checksum
     * @return
     */
    public boolean isDuplicateChecksum(String checksum) {
    	HashMap<String, Condition> scanFilter = new HashMap<String, Condition>();
        Condition condition = new Condition()
            .withComparisonOperator(ComparisonOperator.EQ.toString())
            .withAttributeValueList(new AttributeValue().withS(checksum));
        scanFilter.put(Constant.CHECKSUM, condition);
        ScanRequest scanRequest = new ScanRequest(Constant.XMLINGESTIONEVENT).withScanFilter(scanFilter);
        ScanResult scanResult = client.scan(scanRequest);
        System.out.println("scanResult : "+ scanResult);
        return scanResult.getCount().intValue()>0;
    }


    /**
     * load all the attribute of XmlIngestionTemplate  
     * 
     * @return
    */
   /* public XmlIngestionTemplate loadTemplate() {
        XmlIngestionTemplate template = mapper.load(XmlIngestionTemplate.class, Constant.TEMPLATE);
        System.out.println("template = "+ template);
        
        return template;
    }*/
    /**
     * load all the attribute of IngestionTemplate  
     * 
     * @return
     */
    public IngestionTemplate loadTemplate(String bucketName) {
        IngestionTemplate template = mapper.load(IngestionTemplate.class, bucketName);
        System.out.println("template = "+ template);
        
        return template;
    }


	@Override
	public void persistData(IngestionEvent ingestionEvent) {
		mapper.save(ingestionEvent);
		System.out.println("messageEvent = "+ ingestionEvent);
	}


	@Override
	public void persistTransactionData(IngestXactionEvent transactionEvent) {
		mapper.save(transactionEvent);
		System.out.println("transactionEvent = "+ transactionEvent);
		
	}


	@Override
	public IngestionTemplate loadTemplate() {
		IngestionTemplate template = mapper.load(IngestionTemplate.class, Constant.TEMPLATE);
        System.out.println("template = "+ template);
        
        return template;
	}


	

}
