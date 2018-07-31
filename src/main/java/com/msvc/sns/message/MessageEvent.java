
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

package com.msvc.sns.message;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.msvc.dal.model.EmployeeRecord;

/**
 * 
 * serialized object that supposed to send to topic
 * 
 * @author anand.jha
 *
 */

public class MessageEvent {

	private String bucketName;
	private String bucketKey;
	private String eventMessage;
	private String checksum;
	private Integer noOfLines;
	private Long objectSize;
	private String eventType;
	private String template;
	private Map<String, Object> transaction;
	private List<Map<String, String>> transactionList;
	private List<EmployeeRecord> emptransactionList;
	
	@DynamoDBIgnore
	private String exceptionCode;
	private String exceptionDescription;
	private String ingestEventUuid;
	private String transactionEventUuid;
	private String ingestionTimestamp;

	/**
	 * @return the transection
	 */
	public Map<String, Object> getTransaction() {
		return transaction;
	}

	/**
	 * @param xmlMap the transection to set
	 */
	public void setTransaction(Map<String, Object> xmlMap) {
		this.transaction = xmlMap;
	}

	/**
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param template the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * @return the bucketName
	 */
	public String getBucketName() {
		return bucketName;
	}

	/**
	 * @param bucketName
	 *            the bucketName to set
	 */
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	/**
	 * @return the bucketKey
	 */
	public String getBucketKey() {
		return bucketKey;
	}

	/**
	 * @param bucketKey
	 *            the bucketKey to set
	 */
	public void setBucketKey(String bucketKey) {
		this.bucketKey = bucketKey;
	}

	/**
	 * @return the eventMessage
	 */
	public String getEventMessage() {
		return eventMessage;
	}

	/**
	 * @param eventMessage
	 *            the eventMessage to set
	 */
	public void setEventMessage(String eventMessage) {
		this.eventMessage = eventMessage;
	}

	/**
	 * @return the checksum
	 */
	public String getChecksum() {
		return checksum;
	}

	/**
	 * @param checksum
	 *            the checksum to set
	 */
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	/**
	 * @return the noOfLines
	 */
	public Integer getNoOfLines() {
		return noOfLines;
	}

	/**
	 * @param noOfLines
	 *            the noOfLines to set
	 */
	public void setNoOfLines(Integer noOfLines) {
		this.noOfLines = noOfLines;
	}

	/**
	 * @return the objectSize
	 */
	public Long getObjectSize() {
		return objectSize;
	}

	/**
	 * @param objectSize
	 *            the objectSize to set
	 */
	public void setObjectSize(Long objectSize) {
		this.objectSize = objectSize;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType
	 *            the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	
	/**
	 * @param transactionList the transactionList to set
	 */
	public void setTransactionList(List<Map<String, String>> transactionList) {
		this.transactionList = transactionList;
	}

	public List<Map<String, String>> getTransactionList() {
		return this.transactionList;
	}

	/**
	 * @return the exceptionCode
	 */
	public String getExceptionCode() {
		return exceptionCode;
	}

	/**
	 * @param exceptionCode the exceptionCode to set
	 */
	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	/**
	 * @return the exceptionDescription
	 */
	public String getExceptionDescription() {
		return exceptionDescription;
	}

	/**
	 * @param exceptionDescription the exceptionDescription to set
	 */
	public void setExceptionDescription(String exceptionDescription) {
		this.exceptionDescription = exceptionDescription;
	}

	/**
	 * @return the ingestEventUuid
	 */
	public String getIngestEventUuid() {
		return ingestEventUuid;
	}

	/**
	 * @param ingestEventUuid the ingestEventUuid to set
	 */
	public void setIngestEventUuid(String ingestEventUuid) {
		this.ingestEventUuid = ingestEventUuid;
	}

	/**
	 * @return the transactionEventUuid
	 */
	public String getTransactionEventUuid() {
		return transactionEventUuid;
	}

	/**
	 * @param transactionEventUuid the transactionEventUuid to set
	 */
	public void setTransactionEventUuid(String transactionEventUuid) {
		this.transactionEventUuid = transactionEventUuid;
	}

	/**
	 * @return the ingestionTimestamp
	 */
	public String getIngestionTimestamp() {
		return ingestionTimestamp;
	}

	/**
	 * @param ingestionTimestamp the ingestionTimestamp to set
	 */
	public void setIngestionTimestamp(String ingestionTimestamp) {
		this.ingestionTimestamp = ingestionTimestamp;
	}

	public List<EmployeeRecord> getEmptransactionList() {
		return emptransactionList;
	}

	public void setEmptransactionList(List<EmployeeRecord> emptransactionList) {
		this.emptransactionList = emptransactionList;
	}
	
}
