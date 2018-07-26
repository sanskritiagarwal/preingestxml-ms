/**
 * 
 */
package com.msvc.dal.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * @author anoop.singh
 *
 */
@DynamoDBTable(tableName = "INGEST_OBJECT_EVENT")
public class IngestionEvent {
	
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private String eventUuid;
	
	private String bucketName;

	private String bucketKey;
	
	private String templateName;
	
	private Long ingestionTimestamp;
	
	private String checksum;
	
	private String exceptionCode;
	
	private String exceptionDescription;
	
	private Integer totalNbrTransactions;
	
	private Integer totalNbrRecords;
	
	public String getEventUuid() {
		return eventUuid;
	}

	public void setEventUuid(String eventUuid) {
		this.eventUuid = eventUuid;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getBucketKey() {
		return bucketKey;
	}

	public void setBucketKey(String bucketKey) {
		this.bucketKey = bucketKey;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Long getIngestionTimestamp() {
		return ingestionTimestamp;
	}

	public void setIngestionTimestamp(Long ingestionTimestamp) {
		this.ingestionTimestamp = ingestionTimestamp;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionDescription() {
		return exceptionDescription;
	}

	public void setExceptionDescription(String exceptionDescription) {
		this.exceptionDescription = exceptionDescription;
	}

	public Integer getTotalNbrTransactions() {
		return totalNbrTransactions;
	}

	public void setTotalNbrTransactions(Integer totalNbrTransactions) {
		this.totalNbrTransactions = totalNbrTransactions;
	}
	
	public Integer getTotalNbrRecords() {
		return totalNbrRecords;
	}

	public void setTotalNbrRecords(Integer totalNbrRecords) {
		this.totalNbrRecords = totalNbrRecords;
	}

	@Override
	public String toString() {
		return "IngestionEvent [eventUuid=" + eventUuid + ", bucketName=" + bucketName + ", bucketKey=" + bucketKey
				+ ", templateName=" + templateName + ", ingestionTimestamp=" + ingestionTimestamp + ", checksum="
				+ checksum + ", exceptionCode=" + exceptionCode + ", exceptionDescription=" + exceptionDescription
				+ ", totalNbrTransactions=" + totalNbrTransactions +"]";
	}


}
