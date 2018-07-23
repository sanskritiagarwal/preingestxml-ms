package com.msvc.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.wiztools.xsdgen.ParseException;
import org.wiztools.xsdgen.XsdGen;

public class XsdValidationUtil {

	public static void main(String args[]) {
		
		String xml="E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\SIEMember1.xml";
		String xsd="E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\SIE_Member_onlineoutput.xsd";
		
		if(validateXMLSchema(xsd,xml))
		{
			System.out.println(xml +"XML is valid against "+xsd);
		}
		else
		{
			System.out.println(xml +"XML is not valid against "+xsd);
		}
		
		
		File file = new File(xml);
		File xsdFile = new File("E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\SIE_Member_javaoutput.xsd");
        try {
        	XsdGen xsdObj=null;
			if(!xsdFile.exists())
        		if(xsdFile.createNewFile())
        		{
        			xsdObj = new XsdGen().parse(file);
					xsdObj.write(new FileOutputStream(xsdFile));
        		}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	         e1.printStackTrace();
	         return false;
	      }
			
	      return true;
		
	   }
	
	public static String formatXSD(String xsdString) {
	    try {
	 
	        Source xmlInput = new StreamSource(new StringReader(xsdString));
	        StringWriter stringWriter = new StringWriter();
	        StreamResult xmlOutput = new StreamResult(stringWriter);
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        transformerFactory.setAttribute("indent-number", 2);
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.transform(xmlInput, xmlOutput);
	 
	        return xmlOutput.getWriter().toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
