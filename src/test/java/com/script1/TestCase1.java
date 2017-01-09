package com.script1;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase1 {

	@Test(description = "TestCase1 description A")
	public void PageATest() {
		assertTrue(true);
	}

	@Test()
	public void PageBTest() {
		assertTrue(true);
	}

	@Test(groups = { "bonding", "strong_ties" }) // (description = "test													// descriptionC")
	public void PageCTest() {
		assertTrue(true);
	}

	@Test(description = "test description")
	public void Page4Test() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Test(description = "Lorem ipsum  tellus in aliquam bibendum")
	public void Page1Test1() {
		Assert.assertEquals(true, false, "FAILED QWERTYUHGCZXCGHGFD");
	}

	@Test(description = "test description")
	public void Page2Test1() throws InterruptedException {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Test(description = "test description4")
	public void Page3Test1() {
		System.out.println("Page3Test WAS CALLED");
		throw new SkipException("Skipping - This is not ready for testing ");
	}

}
