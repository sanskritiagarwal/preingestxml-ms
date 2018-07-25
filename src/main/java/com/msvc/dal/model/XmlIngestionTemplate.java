
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
 * @author sanskriti
 *
 */
@DynamoDBTable(tableName = "XmlIngestionTemplate")
public class XmlIngestionTemplate {

	
	private String SubmitterName;
	@DynamoDBHashKey
	private String SubmitterID;
	
	private List<EmployeeRecord> employeeRecord;

	public String getSubmitterName() {
		return SubmitterName;
	}

	public void setSubmitterName(String submitterName) {
		SubmitterName = submitterName;
	}

	public String getSubmitterID() {
		return SubmitterID;
	}

	public void setSubmitterID(String submitterID) {
		SubmitterID = submitterID;
	}

	public List<EmployeeRecord> getEmployeeRecord() {
		return employeeRecord;
	}

	public void setEmployeeRecord(List<EmployeeRecord> employeeRecord) {
		this.employeeRecord = employeeRecord;
	}

	public List<Attributes> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getMaxRecords() {
		if(employeeRecord!=null)
			return employeeRecord.size();
		else
			return 0;
	}
	
	
}
