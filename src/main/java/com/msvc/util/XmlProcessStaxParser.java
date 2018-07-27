/**
 * 
 */
package com.msvc.util;

/**
 * @author Sanskriti.Agarwal
 *
 */

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.msvc.dal.model.EmployeeRecord;

public class XmlProcessStaxParser {

	public static void main(String[] args) throws Exception {
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		SAXHandler handler = new SAXHandler();
		parser.parse(ClassLoader.getSystemResourceAsStream("xml/employee.xml"), handler);

		// Printing the list of employees obtained from XML
		for (EmployeeRecord emp : handler.empList) {
			System.out.println(emp);
		}
	}
}

/**
 * The Handler for SAX Events.
 */
class SAXHandler extends DefaultHandler {

	List<EmployeeRecord> empList = new ArrayList<>();
	EmployeeRecord emp = null;
	String content = null;

	@Override
	// Triggered when the start of tag is found.
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		
		System.out.println(qName);
		switch (qName) {
		// Create a new Employee object when the start tag is found
		case "EmployeeRecord":
			System.out.println(attributes);
			System.out.println(uri);
			
			emp = new EmployeeRecord();
			
			for(int i=0;i<attributes.getLength();i++)
			{
				System.out.println(attributes.getValue(i));
			}
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		/*switch (qName) {
		// Add the employee to list once end tag is found
		case "employee":
			//empList.add(emp);
			break;
		// For all other end tags the employee has to be updated.
		case "firstName":
			emp.firstName = content;
			break;
		case "lastName":
			emp.lastName = content;
			break;
		case "location":
			emp.location = content;
			break;
		}*/
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}

}

class Employee {

	String id;
	String firstName;
	String lastName;
	String location;

	@Override
	public String toString() {
		return firstName + " " + lastName + "(" + id + ")" + location;
	}
}
