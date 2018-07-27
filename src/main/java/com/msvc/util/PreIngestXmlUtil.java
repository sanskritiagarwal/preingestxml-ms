
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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
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
	static {
		 mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		 mapper.setSerializationInclusion(Include.NON_NULL);
		 mapper.getSerializerProvider().setNullKeySerializer(new MyNullKeySerializer());
	}

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

	public static String convertXmltoJSON(String xml)
	{
		JSONObject jsonObject = XML.toJSONObject(xml);

	/*
		InputStream inputStream = null;
		
		            BufferedReader bufferedReader = null;
					try {
						bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            StringBuilder responseStrBuilder = new StringBuilder();

		            String inputStr;
		            try {
						while ((inputStr = bufferedReader.readLine()) != null) {
						    responseStrBuilder.append(inputStr);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		            jsonObject = XML.toJSONObject(responseStrBuilder.toString());*/
		       
		return jsonObject.toString();
	}
	public static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        try  
        {  
            builder = factory.newDocumentBuilder();  
            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
            return doc;
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return null;
    }
	
	static class MyNullKeySerializer extends JsonSerializer<Object>
	{
	  @Override
	  public void serialize(Object nullKey, JsonGenerator jsonGenerator, SerializerProvider unused) 
	      throws IOException, JsonProcessingException
	  {
	    jsonGenerator.writeFieldName("");
	  }
	}
}
