package com.script1;

import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@Test(description = "test descriptionA")
	public void PageATest() {
		assertTrue(true);
	}
	
	@Test()
	public void PageBTest() {
		assertTrue(true);
	}

	@Test(description = "test descriptionC")
	public void PageCTest() {
		assertTrue(true);
	}


	
	/*@Test(description = "Lorem ipsum ds in aliquam bibendum")
	public void Page1Test() {
		Assert.assertEquals(true, false, "FAILED QWERTYUHGCZXCGHGFD");
	}

	@Test(description = "test description")
	public void Page2Test() throws InterruptedException {
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

	@Test(description = "test description")
	public void Page4Test1() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Test(description = "test description")
	public void Page4Test12() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}
*/
}
