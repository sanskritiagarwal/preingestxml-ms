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

import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

/**
 * 
 * model class to map with DynamoDB
 * 
 * @author anand.jha
 *
 */
@DynamoDBDocument
public class Data {

	private String exceptionCode;
	private String exceptionDescription;
	private String masterRecordUuid;
	private Map<String, String> transactiondata;

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

	public String getMasterRecordUuid() {
		return masterRecordUuid;
	}

	public void setMasterRecordUuid(String masterRecordUuid) {
		this.masterRecordUuid = masterRecordUuid;
	}

	public Map<String, String> getTransactiondata() {
		return transactiondata;
	}

	public void setTransactiondata(Map<String, String> transactiondata) {
		this.transactiondata = transactiondata;
	}

	@Override
	public String toString() {
		return "Data [exceptionCode=" + exceptionCode + ", exceptionDescription=" + exceptionDescription
				+ ", masterRecordUuid=" + masterRecordUuid + ", transactiondata=" + transactiondata + "]";
	}

}
