package com.msvc.util;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XsdValidationUtil {

	public static void main(String args[]) {
		
		String xml="E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\20180717120822111testmembersieimportexport.xml";
		String xsd="E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\SIEMember.xsd";
		
		if(validateXMLSchema(xsd,xml))
		{
			System.out.println("XML is valid");
		}
		else
		{
			System.out.println("XML is not valid ");
		}
		
		
	}
	
	public static boolean validateXMLSchema(String xsdPath, String xmlPath){
	      try {
	         SchemaFactory factory =
	            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            Schema schema = factory.newSchema(new File(xsdPath));
	            Validator validator = schema.newValidator();
	            validator.validate(new StreamSource(new File(xmlPath)));
	      } catch (IOException e){
	         System.out.println("Exception: "+e.getMessage());
	         return false;
	      }catch(SAXException e1){
	         System.out.println("SAX Exception: "+e1.getMessage());
	         return false;
	      }
			
	      return true;
		
	   }
}
