/*
 * Copyright 2015 Uttesh Kumar T.H..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.script2;

import org.testng.Assert;
import org.testng.Reporter;
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
