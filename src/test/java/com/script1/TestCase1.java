package com.script1;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase1 {

	@Test(description = "TestCase1 description A")
	public void PageATest1() {
		assertTrue(true);
	}

	@Test(groups = { "group TestCase1", "group TestCase2", "group TestCase3", "group TestCase4" })
	public void PageATest2() throws InterruptedException {
		// Thread.sleep(5000);
		assertTrue(true);
	}

	@Test(groups = { "bonding", "strong_ties" })
	public void PageATest3() {
		assertTrue(true);
	}

	@Test(description = "test description")
	public void PageATest4() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Test(description = " description PageATest5", groups = "group TestCase1")
	public void PageATest5() {
		Assert.assertEquals(true, false, "FAILED QWERTYUHGCZXCGHGFD");
	}

	@Test(description = "test description PageATest6", groups = "group TestCase1")
	public void PageATest6() throws InterruptedException {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Test(description = "test description4 PageATest7")
	public void PageATest7() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

}