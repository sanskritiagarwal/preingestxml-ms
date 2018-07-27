package com.msvc.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stax.StAXSource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msvc.dal.model.Catalog;
import com.msvc.dal.model.EmployeeRecord;
import com.msvc.dal.model.Member;

public class UnMarshallXmlUtil {

	public static void main(String[] args) {

		/*String xmlFile = "E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\XmlMergeResult.xml";
		Catalog catalog = JAXB.unmarshal(new File(xmlFile), Catalog.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(System.out, catalog);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		File xmlFile = new File("E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\SIEMember1.xml");
		
		String xml;
		try 
		{
			xml = FileUtils.readFileToString(xmlFile);
	
			InputStream in = IOUtils.toInputStream(xml, "UTF-8");
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

	public static List<EmployeeRecord> getXmlDataUsingSTAX(InputStream xmlFile) throws JAXBException, XMLStreamException, TransformerFactoryConfigurationError, TransformerException
	{
		List<EmployeeRecord> list = new ArrayList<EmployeeRecord>();
		XMLInputFactory inFactory = XMLInputFactory.newFactory();
		XMLStreamReader reader = inFactory.createXMLStreamReader(xmlFile);
		reader = inFactory.createFilteredReader(reader, new ContentFinder());
		Unmarshaller unmar = JAXBContext.newInstance(EmployeeRecord.class).createUnmarshaller();
		Transformer tformer = TransformerFactory.newInstance().newTransformer();
		while (reader.hasNext()) {
			XMLStreamReader limiter = new Limiter(reader);
			Source src = new StAXSource(limiter);
			DOMResult res = new DOMResult();
			tformer.transform(src, res);
			System.out.println(res.getNode().getNodeName());
			System.out.println(res.getNode().getNodeValue());
			/*JAXBElement element = (JAXBElement)  unmar.unmarshal(res.getNode());
			if(element.getName().equals("Member"))
			{
				
			}
			else if(element.getName().equals("EmployeeRecord"))
			{
				EmployeeRecord emp = (EmployeeRecord) element.getValue();
				ObjectMapper mapper = new ObjectMapper();
				try {
					mapper.writeValue(System.out, emp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.add(emp);
			}
			else if(element.getName().equals("EmployeeRecordList"))
			{
				list = (List<EmployeeRecord>)element.getValue();
			}*/
				
			//System.out.println(employee.toString());
		}
		
		return list;
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