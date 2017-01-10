package com.script1;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.Reporter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Demo {
	public static Document convertToDocument(Object xmlContent) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		try {
			builder = builderFactory.newDocumentBuilder();
			if (xmlContent instanceof String) {
				document = builder.parse((String) xmlContent);
			} else if (xmlContent instanceof File) {
				document = builder.parse((File) xmlContent);
			}
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		document.getDocumentElement().normalize();

		return document;
	}
	
	public static String getXmlNodeValue(String fileName, String tagName, String attribute) {

		File xmlContent = new File(fileName);

		Document doc = convertToDocument(xmlContent);
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName(tagName);
		for (int i = 0; i < nList.getLength(); i++) {
			Element e = (Element) nList.item(i);
			if (attribute.equalsIgnoreCase(e.getAttribute("name"))) {
				System.out
						.println("Name :- " + e.getAttribute("name") + "    " + "Value :- " + e.getAttribute("value"));
				return e.getAttribute("value");
			}
		}
		return null;
	}

	public static String getEnvironment() {
		String env = (getXmlNodeValue(
				Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getSuite().getFileName(),
				"parameter", "config-file"));
		return env;
	}
}
