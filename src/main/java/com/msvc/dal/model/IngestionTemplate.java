
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
package com.msvc.dal.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * 
 * model class to map with DynamoDB
 * 
 * @author anand.jha
 *
 */
@DynamoDBTable(tableName = "INGESTION_TEMPLATE")
public class IngestionTemplate {

	@DynamoDBHashKey
	private String bucketName;
	private String version;
	private Integer minRecords;
	private Integer maxRecords;
	private String fileType;
	private String tableName;
	private String name;
	private String storeTransactionTopicArn;
	private String validateTransactionTopicArn;
	

	private List<Attributes> attributes;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the minRecords
	 */
	public Integer getMinRecords() {
		return minRecords;
	}

	/**
	 * @param minRecords
	 *            the minRecords to set
	 */
	public void setMinRecords(Integer minRecords) {
		this.minRecords = minRecords;
	}

	/**
	 * @return the maxRecords
	 */
	public Integer getMaxRecords() {
		return maxRecords;
	}

	/**
	 * @param maxRecords
	 *            the maxRecords to set
	 */
	public void setMaxRecords(Integer maxRecords) {
		this.maxRecords = maxRecords;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType
	 *            the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	
	/**
	 * @return the attributes
	 */
	public List<Attributes> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes
	 *            the attributes to set
	 */
	public void setAttributes(List<Attributes> attributes) {
		this.attributes = attributes;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getStoreTransactionTopicArn() {
		return storeTransactionTopicArn;
	}

	public void setStoreTransactionTopicArn(String storeTransactionTopicArn) {
		this.storeTransactionTopicArn = storeTransactionTopicArn;
	}

	public String getValidateTransactionTopicArn() {
		return validateTransactionTopicArn;
	}

	public void setValidateTransactionTopicArn(String validateTransactionTopicArn) {
		this.validateTransactionTopicArn = validateTransactionTopicArn;
	}

	@Override
	public String toString() {
		return "IngestionTemplate [name=" + name + ", version=" + version + ", minRecords=" + minRecords
				+ ", maxRecords=" + maxRecords + ", fileType=" + fileType + ", tableName=" + tableName + ", bucketName="
				+ bucketName + ", storeTransactionTopicArn=" + storeTransactionTopicArn
				+ ", validateTransactionTopicArn=" + validateTransactionTopicArn + ", attributes=" + attributes + "]";
	}
}
