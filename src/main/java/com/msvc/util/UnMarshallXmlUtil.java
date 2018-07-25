package com.msvc.util;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXB;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msvc.dal.model.Catalog;

public class UnMarshallXmlUtil {

	public static void main(String[] args) {
		
		String xmlFile="E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\XmlMergeResult.xml";
		Catalog catalog = JAXB.unmarshal(new File(xmlFile),  Catalog.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(System.out, catalog);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
