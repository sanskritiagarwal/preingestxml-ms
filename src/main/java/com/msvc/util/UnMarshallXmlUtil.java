package com.msvc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.amazonaws.services.dynamodbv2.xspec.S;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.msvc.dal.model.EmployeeRecord;
import com.msvc.dal.model.EmployeeRecordsList;
import com.msvc.dal.model.IngestionEvent;
import com.msvc.dal.model.Member;
import com.msvc.dal.model.Member2;
import com.msvc.sns.message.MessageEvent;
import com.msvc.vo.Constant;

public class UnMarshallXmlUtil {

	static int chunkSize=1;
	
	public static void main(String[] args) {

		/// preingestxml-ms/src/main/resources/20180717120822111.xml
		// File xmlFile = new
		/// File("E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\SIEMember1.xml");

		File xmlFile = new File("E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\SIEMember1.xml");

		String xml;
		try {
			xml = FileUtils.readFileToString(xmlFile);

			InputStream in = IOUtils.toInputStream(xml, "UTF-8");
			//List<Map<String, Object>> list = getXmlDataAsList(in);

			// getXmlDataUsingSTAX(in);
			
			getListfromJSON(in);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (JAXBException e) {
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
		}*/
	}
	
	
	private static  String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}
	private static List<Map<String, Object>> getListfromJSON(InputStream xmlFile)
	{
		List<EmployeeRecord> list = new ArrayList<EmployeeRecord>();
		List<Map<String, Object>> listOfMaps = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String xmlStr=null;
		
		 try {
			 
	            JSONObject xmlJSONObj = XML.toJSONObject(getStringFromInputStream(xmlFile));
	            
	            JSONArray array = xmlJSONObj.getJSONObject("Member").getJSONObject("EmployeeRecordsList").getJSONArray("EmployeeRecord");
	            
	            ArrayList<JSONObject> myArrayList = new ArrayList<JSONObject>();
	            System.out.println("array.length()=>"+array.length());
	            for (int i = 0; i<array.length();i++) {
	            	JSONObject rt = (JSONObject)array.get(i);
	            	myArrayList.add(rt);
	            	//System.out.println(rt.get("EmployeeCertificateNumber"));
					if (chunkSize == myArrayList.size()) 
					{
						JSONArray transaction = new JSONArray(myArrayList);
						
						int noOfRecords = myArrayList.size();
						
						//System.out.println("====>"+(JSONObject)array.get(i));

						i = 0;
						myArrayList.clear();
					}
	            }
	         
	        } catch (JSONException je) {
	            System.out.println(je.toString());
	        }
		return null;
		
	}
	public static String getXmlDataInJSON(InputStream xmlFile) throws JAXBException, XMLStreamException,
			TransformerFactoryConfigurationError, TransformerException, IOException {

		Map<String, Object> properties = new HashMap<String, Object>(1);
		properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
		JAXBContext jc = JAXBContext.newInstance(new Class[] { EmployeeRecord.class }, properties);

		Unmarshaller unmarshaller = jc.createUnmarshaller();
		File json = new File("src/forum16365788/input.json");
		EmployeeRecord objectA = (EmployeeRecord) unmarshaller.unmarshal(json);

		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(objectA, System.out);
		return null;
	}

	public static List<Map<String, Object>> getXmlDataUsingSTAX(InputStream xmlFile) throws JAXBException,
			XMLStreamException, TransformerFactoryConfigurationError, TransformerException, IOException {
		List<EmployeeRecord> list = new ArrayList<EmployeeRecord>();
		List<Map<String, Object>> listOfMaps = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataMap = null;
		XMLInputFactory inFactory = XMLInputFactory.newFactory();
		// xmlFile.reset();
		XMLStreamReader reader = inFactory.createXMLStreamReader(xmlFile);

		reader = inFactory.createFilteredReader(reader, new ContentFinder());
		Unmarshaller unmar = JAXBContext.newInstance(EmployeeRecord.class).createUnmarshaller();
		Unmarshaller memberUnmarshall = JAXBContext.newInstance(EmployeeRecordsList.class).createUnmarshaller();

		ObjectMapper mapper = new ObjectMapper();

		Transformer tformer = TransformerFactory.newInstance().newTransformer();
		String empRecStr = null;

		while (reader.hasNext()) {
			if (reader.isStartElement())
				if (reader.getEventType() == 1 && reader.getLocalName().equals("EmployeeRecord"))
				{
					JAXBElement<EmployeeRecord> element = (JAXBElement<EmployeeRecord>) unmar.unmarshal(reader,
							EmployeeRecord.class);
					EmployeeRecord emp = element.getValue();
					list.add(emp);
					empRecStr = mapper.writeValueAsString(emp);
					 System.out.println("data found: "+empRecStr);
				}

			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();
			dataMap = new Gson().fromJson(empRecStr, type);

			for (Iterator<Map.Entry<String, Object>> it = dataMap.entrySet().iterator(); it.hasNext();) {
				Map.Entry<String, Object> entry = it.next();
				if (entry.getValue() == null || entry.getValue().equals("")) {
					it.remove();
				} else if (entry.getValue() instanceof ArrayList) {
					if (((ArrayList<?>) entry.getValue()).isEmpty()) {
						it.remove();
					} else {
						List<Map<String, String>> list1 = (ArrayList<Map<String, String>>) entry.getValue();
						//removeSubListEmptyString(list1);
						if (list1.isEmpty()) {
							it.remove();
						}

					}
				}
			}

			listOfMaps.add(dataMap);
			empRecStr = new GsonBuilder().setPrettyPrinting().create().toJson(dataMap);
			System.out.println("NON EMPTY=>" + empRecStr);
		}
		System.out.println("listOfMaps size: " + listOfMaps.size());

		// return list;
		// return empRecStr;
		return listOfMaps;
	}

	private static void removeSubListEmptyString(List<Map<String, String>> list1) {
		ListIterator<Map<String, String>> it1 = list1.listIterator();
		while (it1.hasNext()) {
			Map<String, String> value = (LinkedTreeMap<String, String>) it1.next();
			if (value.isEmpty()) {
				it1.remove();
			} else {
				for (Iterator<Map.Entry<String, String>> ite = value.entrySet().iterator(); ite.hasNext();) {
					Map.Entry<String, String> entry = ite.next();
					if (entry.getValue() == null || entry.getValue().equals(""))
						ite.remove();
				}
			}
		}
	}
	
	
	
	public static List<Map<String, Object>> getXmlDataAsList(InputStream xmlFile) throws JAXBException,
			XMLStreamException, TransformerFactoryConfigurationError, TransformerException, IOException 
	
	{
		List<EmployeeRecord> list = new ArrayList<EmployeeRecord>();
		List<Map<String, Object>> listOfMaps = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		XMLInputFactory inFactory = XMLInputFactory.newFactory();
		XMLStreamReader reader = inFactory.createXMLStreamReader(xmlFile);

		reader = inFactory.createFilteredReader(reader, new ContentFinder());
		Unmarshaller memberUnmarshall = JAXBContext.newInstance(Member.EmployeeRecordsList.class).createUnmarshaller();

		ObjectMapper mapper = new ObjectMapper();

		Transformer tformer = TransformerFactory.newInstance().newTransformer();
		String empRecStr = null;

		while (reader.hasNext()) {
			System.out.println(reader.getLocalName());
			if (reader.isStartElement())
				if (reader.getEventType() == 1 && reader.getLocalName().equals("EmployeeRecordsList"))
				{
					JAXBElement<Member.EmployeeRecordsList> element = (JAXBElement<Member.EmployeeRecordsList>) memberUnmarshall.unmarshal(reader, Member.EmployeeRecordsList.class);
					Member.EmployeeRecordsList emp = element.getValue();
					List<Serializable> empList =  emp.getContent();
				
					Iterator<Serializable> itr= empList.iterator();
					
					while(itr.hasNext())
					{
						if( itr.next() instanceof String)
						{
							JAXBElement<?> temp = (JAXBElement<?>) itr.next();
							System.out.println("LIST Name: "+temp.getName());
							System.out.println("LIST Value: "+temp.getValue());
							Member.EmployeeRecordsList.EmployeeRecord er = (Member.EmployeeRecordsList.EmployeeRecord) temp.getValue();
							
							List<Serializable> empList2 =  er.getContent();
							
							Iterator<Serializable> itr2= empList2.iterator();
							
							while(itr2.hasNext())
							{
								if( itr2.next() instanceof String)
								{
									JAXBElement<?> temp2 = (JAXBElement<?>) itr2.next();
									if(temp2.getValue()!=null || !temp2.getValue().equals(""))
									dataMap.put(temp2.getName().toString(), temp2.getValue());
									
									
								}
							}
							listOfMaps.add(dataMap);
						}
						
					}
					
					//empRecStr = mapper.writeValueAsString(empList);
					//System.out.println("data found: "+empRecStr);
				}

		/*	Type type = new TypeToken<Map<String, Object>>() {}.getType();
			dataMap = new Gson().fromJson(empRecStr, type);

			if(dataMap!=null)
			for (Iterator<Map.Entry<String, Object>> it = dataMap.entrySet().iterator(); it.hasNext();) {
				Map.Entry<String, Object> entry = it.next();
				if (entry.getValue() == null || entry.getValue().equals("")) {
					it.remove();
				} else if (entry.getValue() instanceof ArrayList) {
					if (((ArrayList<?>) entry.getValue()).isEmpty()) {
						it.remove();
					} else {
						List<Map<String, String>> list1 = (ArrayList<Map<String, String>>) entry.getValue();
						removeSubListEmptyString(list1);
						if (list1.isEmpty()) {
							it.remove();
						}

					}
				}
			}
			listOfMaps.add(dataMap);
*/
			
			//empRecStr = new GsonBuilder().setPrettyPrinting().create().toJson(dataMap);
			//System.out.println("NON EMPTY=>" + empRecStr);
		}
		System.out.println("listOfMaps size: " + listOfMaps.size());
		return listOfMaps;
	}
}

class ContentFinder implements StreamFilter {
	private boolean capture = false;

	@Override
	public boolean accept(XMLStreamReader xml) {
		if (xml.isStartElement() && "EmployeeRecordsList".equals(xml.getLocalName())) {
			capture = true;
		} else if (xml.isEndElement() && "EmployeeRecordsList".equals(xml.getLocalName())) {
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
		return !(getParent().isEndElement() && "EmployeeRecordsList".equals(getParent().getLocalName()));
	}
}