package com.script1;

import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase2 {

	@Test(testName = "TestCase2 Custom Google test name1", groups = "group TestCase2")
	public void PageBTest1() {
		Assert.assertEquals(true, false);
	}

	@Test
	public void PageBTest2() {
		Reporter.log("Google WAS CALLED");
		assertTrue(true);
	}

	@Test(testName = "Custom Google test name3", groups = { "group TestCase2", "grp 1" })
	public void PageBTest3() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}
}
