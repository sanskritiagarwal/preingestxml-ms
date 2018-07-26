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

import com.msvc.dal.model.IngestXactionEvent;
import com.msvc.dal.model.IngestionEvent;
import com.msvc.dal.model.IngestionTemplate;
import com.msvc.dal.model.XmlIngestionTemplate;

/**
 * 
 *  PreIngestXmlDao interface to access the dynamo database
 *    
 *  @author anand.jha
 *
 */

public interface PreIngestXmlDao {
	
	/**
	 * verify the Checksum if duplicate
	 * 
	 * @param checksum
	 * @return
	 */
	boolean isDuplicateChecksum(String checksum);
	
	/**
	 * load template
	 * 
	 * @return
	 */
	IngestionTemplate loadTemplate();

	IngestionTemplate loadTemplate(String bucketName);
	
	void persistData(IngestionEvent ingestionEvent);

	void persistTransactionData(IngestXactionEvent transactionEvent);
}
