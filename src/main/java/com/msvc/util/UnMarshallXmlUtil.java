package com.msvc.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.selectItem_return;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

import com.amazonaws.services.dynamodbv2.xspec.S;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.msvc.dal.model.EmployeeRecord;
import com.msvc.dal.model.EmployeeRecordsList;
import com.msvc.dal.model.Member;


public class UnMarshallXmlUtil {

	public static void main(String[] args) {

		///preingestxml-ms/src/main/resources/20180717120822111.xml
		//File xmlFile = new File("E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\SIEMember1.xml");

		File xmlFile = new File("E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\20180717120822111.xml");
		
		String xml;
		try 
		{
			xml = FileUtils.readFileToString(xmlFile);
	
			InputStream in = IOUtils.toInputStream(xml, "UTF-8");
			//List<EmployeeRecord> list = getXmlDataUsingSTAX(in);
			getXmlDataUsingSTAX(in);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static String getXmlDataInJSON(InputStream xmlFile) throws JAXBException, XMLStreamException, TransformerFactoryConfigurationError, TransformerException, IOException
	{
		
		 Map<String, Object> properties = new HashMap<String, Object>(1);
	     properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
	     JAXBContext jc = JAXBContext.newInstance(new Class[] {EmployeeRecord.class}, properties);
	
	     Unmarshaller unmarshaller = jc.createUnmarshaller();
	     File json = new File("src/forum16365788/input.json");
	     EmployeeRecord objectA = (EmployeeRecord) unmarshaller.unmarshal(json);
	
	     Marshaller marshaller = jc.createMarshaller();
	     marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	     marshaller.marshal(objectA, System.out);
		return null;
	}
	
	public static Map<String, Object> getXmlDataUsingSTAX(InputStream xmlFile) throws JAXBException, XMLStreamException, TransformerFactoryConfigurationError, TransformerException, IOException
	{
		List<EmployeeRecord> list = new ArrayList<EmployeeRecord>();
		List<Map<String,Object>> listOfMaps = new ArrayList<Map<String,Object>>();
		Map<String, Object> dataMap =null;
		XMLInputFactory inFactory = XMLInputFactory.newFactory();
		//xmlFile.reset();
		XMLStreamReader reader = inFactory.createXMLStreamReader(xmlFile);
		
		
		reader = inFactory.createFilteredReader(reader, new ContentFinder());
		Unmarshaller unmar = JAXBContext.newInstance(EmployeeRecord.class).createUnmarshaller();
		Unmarshaller memberUnmarshall = JAXBContext.newInstance(EmployeeRecordsList.class).createUnmarshaller();
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		Transformer tformer = TransformerFactory.newInstance().newTransformer();
		String empRecStr=null;
		
		
		while (reader.hasNext()) 
		{
			
			
			if(reader.isStartElement())
			if(reader.getEventType() ==1 && reader.getLocalName().equals("EmployeeRecord"));
			{
				JAXBElement<EmployeeRecord> element = (JAXBElement<EmployeeRecord>)  unmar.unmarshal(reader,EmployeeRecord.class);
				EmployeeRecord emp=element.getValue();
				list.add(emp);
				empRecStr = mapper.writeValueAsString(emp);
			//	System.out.println("data found: "+empRecStr);
			}
			
			Type type = new TypeToken<Map<String, Object>>() {}.getType();
			dataMap = new Gson().fromJson(empRecStr, type);
			
			for (Iterator<Map.Entry<String, Object>> it = dataMap.entrySet().iterator(); it.hasNext();) {
			    Map.Entry<String, Object> entry = it.next();
			    if (entry.getValue() == null || entry.getValue().equals("")) {
			        it.remove();
			    } else if (entry.getValue() instanceof ArrayList) {
			        if (((ArrayList<?>) entry.getValue()).isEmpty()) {
			            it.remove();
			        }
			        else
			        {
			        	List<Map<String,String>> list1 = (ArrayList<Map<String,String>>) entry.getValue();
			        	removeSubListEmptyString(list1);
			        	if(list1.isEmpty())
			        	{
			        		 it.remove();
			        	}
			        	
			        }
			    }
			}

			listOfMaps.add(dataMap);
			empRecStr = new GsonBuilder().setPrettyPrinting().create().toJson(dataMap);
			System.out.println("NON EMPTY=>"+empRecStr);
		}
		System.out.println(list.size());
		
		//return list;
		//return empRecStr;
		return dataMap;
	}
	
	private static void removeSubListEmptyString(List<Map<String,String>> list1 )
	{
		ListIterator<Map<String, String>> it1 = list1.listIterator();
		while(it1.hasNext())
		{
			Map<String, String> value  = (LinkedTreeMap<String,String>) it1.next();
			if(value.isEmpty())
			{
				it1.remove();
			}
			else
			{
				for(Iterator<Map.Entry<String, String>> ite = value.entrySet().iterator(); ite.hasNext();)
				{
					Map.Entry<String, String> entry = ite.next();
				    if (entry.getValue() == null || entry.getValue().equals("")) 
				        ite.remove();
				}
			}
		}
	}
}




class ContentFinder implements StreamFilter {
    private boolean capture = false;

    @Override
    public boolean accept(XMLStreamReader xml) {
      if (xml.isStartElement() && "EmployeeRecord".equals(xml.getLocalName())) {
        capture = true;
      } else if (xml.isEndElement() && "EmployeeRecord".equals(xml.getLocalName())) {
        capture = false;
        return true;
      }
      return capture;
    }
  }

  class Limiter extends StreamReaderDelegate {
    Limiter(XMLStreamReader xml) {
      super(xml);
    }

    @Override
    public boolean hasNext() throws XMLStreamException {
      return !(getParent().isEndElement()
               && "EmployeeRecord".equals(getParent().getLocalName()));
    }
  }