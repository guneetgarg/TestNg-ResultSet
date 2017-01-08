package com.script2;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SmitjainSkipCountTest {

	@Test()
	public void skip1Test() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Test()
	public void skip2Test() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Test()
	public void skip3Test() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Test(description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut porttitor ut augue ut sodales. Vivamus maximus arcu ac odio vehicula, convallis fringilla arcu malesuada. Aenean eleifend in sem at ultricies. Proin molestie bibendum diam, ac tincidunt neque ornare non. Mauris ultricies est vel turpis volutpat, quis imperdiet leo sodales. Fusce ullamcorper lacus eros, rutrum consequat erat tempor vel. Suspendisse finibus sapien hendrerit rhoncus tempor. Nam congue tellus in aliquam bibendum")
	public void skip4Test() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}
}
