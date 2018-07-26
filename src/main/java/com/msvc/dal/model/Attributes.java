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
public class Attributes {

	public Attributes() {

	}

	private String fieldName;
	private Integer fieldLength;
	private String format;
	private Integer startPosition;
	private Integer endPosition;
	private String description;

	@DynamoDBAttribute(attributeName = "import")
	private String importAttr;
	private String masterAttr;

	/**
	 * @return the masterAttr
	 */
	public String getMasterAttr() {
		return masterAttr;
	}

	/**
	 * @param masterAttr
	 *            the masterAttr to set
	 */
	public void setMasterAttr(String masterAttr) {
		this.masterAttr = masterAttr;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName
	 *            the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the fieldLength
	 */
	public Integer getFieldLength() {
		return fieldLength;
	}

	/**
	 * @param fieldLength
	 *            the fieldLength to set
	 */
	public void setFieldLength(Integer fieldLength) {
		this.fieldLength = fieldLength;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format
	 *            the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @return the startPosition
	 */
	public Integer getStartPosition() {
		return startPosition;
	}

	/**
	 * @param startPosition
	 *            the startPosition to set
	 */
	public void setStartPosition(Integer startPosition) {
		this.startPosition = startPosition;
	}

	/**
	 * @return the endPosition
	 */
	public Integer getEndPosition() {
		return endPosition;
	}

	/**
	 * @param endPosition
	 *            the endPosition to set
	 */
	public void setEndPosition(Integer endPosition) {
		this.endPosition = endPosition;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the importAttr
	 */
	public String getImportAttr() {
		return importAttr;
	}

	/**
	 * @param importAttr
	 *            the importAttr to set
	 */
	public void setImportAttr(String importAttr) {
		this.importAttr = importAttr;
	}

	@Override
	public String toString() {
		return "[fieldName=" + fieldName + ", fieldLength=" + fieldLength + ", format=" + format + ", startPosition="
				+ startPosition + ", endPosition=" + endPosition + ", description=" + description + ", importAttr="
				+ importAttr + "]";
	}

}
