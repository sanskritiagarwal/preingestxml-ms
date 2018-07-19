
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

package com.msvc.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msvc.sns.message.MessageEvent;

/**
 * 
 * Util class to calculate all the validation prop
 * 
 * @author anand.jha
 *
 */

public class PreIngestXmlUtil {

	private static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * get ObjectValidation Attribs
	 * 
	 * @param stream
	 * @return
	 * @throws IOException
	 */
	public static MessageEvent addObjectValidationAttribs(InputStream stream, MessageEvent messageEvent)
			throws IOException {

		byte[] bytes = IOUtils.toByteArray(stream);

		try (ByteArrayInputStream calBytes = new ByteArrayInputStream(bytes)) {

			byte[] c = new byte[1024];
			int noOfLines = 0;
			int readChars = 0;
			long objectSize = 0;
			boolean endsWithoutNewLine = false;
			while ((readChars = calBytes.read(c)) != -1) {
				objectSize += readChars;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n')
						++noOfLines;
				}
				endsWithoutNewLine = (c[readChars - 1] != '\n');
			}
			if (endsWithoutNewLine) {
				++noOfLines;
			}

			messageEvent.setNoOfLines(noOfLines);
			messageEvent.setObjectSize(objectSize);
			messageEvent.setChecksum(calMd5CheckSum(bytes));
			System.out.println("md5Checksum :" + messageEvent.getChecksum() + ", noOflines :"
					+ messageEvent.getNoOfLines() + ", objectsize : " + messageEvent.getObjectSize());
			return messageEvent;
		} finally {
			stream.close();
		}
	}

	/**
	 * calculate md5 CheckSum with the byte Array
	 * 
	 * @param bytes
	 * @return
	 */
	private static String calMd5CheckSum(byte[] bytes) {
		String md5Checksum = null;

		try (ByteArrayInputStream md5Bytes = new ByteArrayInputStream(bytes)) {

			md5Checksum = DigestUtils.md5Hex(md5Bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return md5Checksum;
	}

	/**
	 * writeAsJsonString
	 * 
	 * @param obj
	 * @return
	 */
	public static String writeAsJsonString(Object obj) {
		String jsonString = null;
		if (obj != null) {
			try {
				return mapper.writeValueAsString(obj);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jsonString;
	}

}
