package com.script2;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTestCase3 {

	@Test(groups = { "group skipATest" })
	public void skipATest1() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Test()
	public void skipATest2() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Test(groups = { "group skipATest", "tmp" })
	public void skipATest3() {
		Assert.fail();
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Test(description = "Laliquam bibendum")
	public void skipATest4() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}
}
