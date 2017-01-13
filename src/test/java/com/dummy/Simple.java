package com.dummy;

import org.testng.Assert;
import org.testng.SkipException;

public class Simple {

	public void skipATest1() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	public void skipATest2() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	public void skipATest3() throws InterruptedException {
		Assert.fail();
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	public void skipATest4() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	public void Test3Passed() {
	}
}