package com.dataProviderPkg;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPro1 {
	@DataProvider(name = "test1")
	public Object[][] createData1() {
		return new Object[][] { { "A", new Integer(36) }, { "B", new Integer(37) } };
	}

	@Test(dataProvider = "test1")
	public void verifyData1(String n1, Integer n2) {
		System.out.println(n1 + " " + n2);
	}

	@DataProvider(name = "dp")
	public Object[][] createData(Method m) {
		System.out.println(m.getName()); // print test method name
		if (m.getName().equalsIgnoreCase("Test2")) {
			return new Object[][] { new Object[] { "AAACedric" } };
		} else {
			return new Object[][] { { "AA", "AA1" }, { "BB", "BB1" } };
		}
	}

	@Test(dataProvider = "dp")
	public void test1(String s, String ss) {
	}

	@Test(dataProvider = "dp")
	public void test2(String s) {
	}

	@Test(dataProvider = "data-provider", dataProviderClass = DataProviderClass.class)
	public void testMethod(String data) {
		System.out.println("Data is: " + data);
	}
}
