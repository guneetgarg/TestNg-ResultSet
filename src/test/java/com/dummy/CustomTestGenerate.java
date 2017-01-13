package com.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.testng.xml.XmlSuite.ParallelMode;

import com.report.CustomReporter2;

public class CustomTestGenerate {
	Map<String, String> parameters = new HashMap<String, String>();

	public void setSuiteParameter() {
		parameters.put("config-file", "c:\\test.xml");
		parameters.put("broewser", "chrome");
	}

	public void generateTestNG() {

		XmlSuite suite = new XmlSuite();
		suite.setName("TmpSuite");
		suite.setFileName("tt.xml");
		suite.setParallel(ParallelMode.TESTS);
		suite.setParameters(parameters);

		XmlTest test = new XmlTest(suite);
		test.setName("TmpTest");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.script1.TestCase1"));
		test.setXmlClasses(classes);

		XmlTest test1 = new XmlTest(suite);
		test1.setName("test set 2");
		List<XmlClass> classes1 = new ArrayList<XmlClass>();
		classes1.add(new XmlClass("com.script1.TestCase2"));
		classes1.add(new XmlClass("com.script2.TestCase4"));

		test1.setXmlClasses(classes1);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		
		List<Class<? extends ITestNGListener>> clssListener = new ArrayList<>();
		clssListener.add(CustomReporter2.class);
		tng.setListenerClasses(clssListener);
		
		tng.run();
	}

	public static void main(String[] args) {
		new CustomTestGenerate().generateTestNG();

	}
}
