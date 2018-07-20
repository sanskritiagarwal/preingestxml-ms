package com.msvc.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class XmlProcessingUtil {

	public static void main(String[] args) throws Exception {
	    // proper error/exception handling omitted for brevity
	    File file1 = new File("E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\20180717120822111.xml");
	    File file2 = new File("E:\\NewWorkspace\\preingestxml-ms\\src\\main\\resources\\SIEMember1.xml");
	    Document doc = merge("/Member//EmployeeRecordsList", file1, file2);
	    print(doc);
	  }

	  private static Document merge(String expression, File... files) throws Exception {
	    XPathFactory xPathFactory = XPathFactory.newInstance();
	    XPath xpath = xPathFactory.newXPath();
	    XPathExpression compiledExpression = xpath
	        .compile(expression);
	    return merge(compiledExpression, files);
	  }

	  private static Document merge(XPathExpression expression,
	      File... files) throws Exception {
	    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
	        .newInstance();
	    docBuilderFactory
	        .setIgnoringElementContentWhitespace(true);
	    DocumentBuilder docBuilder = docBuilderFactory
	        .newDocumentBuilder();
	    Document base = docBuilder.parse(files[0]);

	    Node results = (Node) expression.evaluate(base,
	        XPathConstants.NODE);
	    if (results == null) {
	      throw new IOException(files[0]
	          + ": expression does not evaluate to node");
	    }

	    for (int i = 1; i < files.length; i++) {
	      Document merge = docBuilder.parse(files[i]);
	      Node nextResults = (Node) expression.evaluate(merge,
	          XPathConstants.NODE);
	      while (nextResults.hasChildNodes()) {
	        Node kid = (Node) nextResults.getFirstChild();
	        nextResults.removeChild(kid);
	        kid = (Node) base.importNode(kid, true);
	        results.appendChild(kid);
	      }
	    }

	    return base;
	  }

	  private static void print(Document doc) throws Exception {
	    TransformerFactory transformerFactory = TransformerFactory
	        .newInstance();
	    Transformer transformer = transformerFactory
	        .newTransformer();
	    DOMSource source = new DOMSource(doc);
	    Result result = new StreamResult(new File("XmlMergeResult.xml"));
	    transformer.transform(source, result);
	  }


}
