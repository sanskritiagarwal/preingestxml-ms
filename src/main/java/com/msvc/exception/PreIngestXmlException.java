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

package com.msvc.exception;

/**
 * 
 *  exception class to preingestion process
 *    
 *  @author anand.jha
 *
 */

public class PreIngestXmlException extends RuntimeException{
	
	public PreIngestXmlException(String message) {
		super(message);
	}

}
