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

package com.msvc.vo;

/**
 * 
 * supposed to store all the constant
 * 
 * @author anand.jha
 *
 */

public interface Constant {

	/** CPOC_INGEST_OBJECT_TOPIC_ARN */
	String CPOC_INGEST_OBJECT_TOPIC_ARN = "arn:aws:sns:us-east-1:940998307548:xmlvalidationobject";

	/** CPOC_INGEST_EXCEPTION_TOPIC_ARN */
	String CPOC_INGEST_EXCEPTION_TOPIC_ARN = "arn:aws:sns:us-east-1:940998307548:xmlvalidationobject_exception";

	/** INVALID_OBJECT_DUE_TO_EXCEEDING_NO_OF_LINES */
	String INVALID_OBJECT_DUE_TO_EXCEEDING_NO_OF_LINES = "Pre Ingestion validation failed due to exceeding no of lines";
	
	/** INVALID_OBJECT_DUE_TO_EXCEEDING_NO_OF_LINES */
	String INVALID_OBJECT_DUE_TO_EXCEEDING_NO_OF_LINES_AND_INVALID_OBJECT_SIZE = "Pre Ingestion validation faild due to exceeding no of lines and invalid Object Size";

	/** INVALID_OBJECT_DUE_TO_INVALID_OBJECT_SIZE */
	String INVALID_OBJECT_DUE_TO_INVALID_OBJECT_SIZE = "Pre Ingestion validation faild due to invalid Object size";

	/** INVALID_OBJECT_DUE_TO_DUPLICATE_CHECKSUM */
	String INVALID_OBJECT_DUE_TO_DUPLICATE_CHECKSUM = "Pre Ingestion validation faild due to duplicate checksum";

	/** OBJECT_PROCESS_ERROR_MESSAGEE */
	String OBJECT_PROCESS_ERROR_MESSAGE = "Error while processing the s3bucket files";

	/** OBJECT_PROCESS_ERROR_MESSAGEE */
	String OBJECT_PROCESS_SUCESS_MESSAGE = "processing the s3bucket files has been done successfully";
	
	/** OBJECT_PROCESS_ERROR_MESSAGEE */
	String XML_VALID_SUCESS_MESSAGE = "XML has been successfully validated against XSD";

	/** CHECKSUM */
	String CHECKSUM = "checksum";

	/** PREINGESTIONEVENT_TABLE */
	String XMLINGESTIONEVENT = "xmlingestionevent";

	/** REGION */
	String REGION = "US_EAST_1";
	
	/** TEMPLATE */
	String TEMPLATE = "processtransactionxml-ms";
	
	/** SNS_MESSAGE */
	String SNS_MESSAGE = "message";

	String INGEST_VALIDATE_TRANSACTION_TOPIC_ARN = null;

	String INGEST_STORE_TRANSACTION_TOPIC_ARN = null;

	String INGESTION_EXCEPTION_TOPIC_ARN = null;

	Integer LINE_DELIMITERS = 2;
	
	Integer MIN_TRANSACTION_CHUNK_SIZE = 1;
	Integer MAX_TRANSACTION_CHUNK_SIZE = 5;

	Integer TRANSACTION_CHUNK_SIZE = 1;

	enum EventType {

		INGEST_OBJECT_EVENT("ingest_object_event"), INGEST_XACTION_EVENT("ingest_xaction_event");

		private String event;
		/**
		 * @return the event
		 */
		public String getEvent() {
			return event;
		}

		EventType(String event) {
			this.event = event;
		}
	}
}
