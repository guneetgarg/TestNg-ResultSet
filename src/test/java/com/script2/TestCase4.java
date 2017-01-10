package com.script2;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase4 {

	@BeforeTest
	public void TC4BT() {
		Assert.assertEquals("title", "var");
		System.out.println("TestCase4 -> Before Test");
	}

	@AfterTest
	public void TC4AT() {
		System.out.println("TestCase4 -> After Test");
	}

	@Test
	public void TC4TT1() {
		System.out.println("TestCase4 -> Test 1");
	}

	@Test(groups = "ABC")
	public void TC4TT2() {
		System.out.println("TestCase4 -> Test 2");
	}

	@BeforeMethod
	public void TC4BM() {
		System.out.println("TestCase4 -> Before Method");
	}

	@AfterMethod
	public void TC4AM() {
		System.out.println("TestCase4 -> After Method");
	}

	@BeforeClass
	public void TC4BC() {
		System.out.println("TestCase4 -> Before Class");
	}

	@AfterClass
	public void TC4AC() {
		System.out.println("TestCase4 -> After Class");
	}

}
