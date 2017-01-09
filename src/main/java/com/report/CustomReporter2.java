package com.report;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class CustomReporter2 implements IReporter {

	public void getResultSize(ITestContext context) {
		System.out.println("\n***********************************************");
		System.out.println("Passed Test Case -> " + context.getPassedTests().size());
		System.out.println("Failed Test Case -> " + context.getFailedTests().size());
		System.out.println("Skipped Test Case -> " + context.getSkippedTests().size());

		System.out.println("getSkippedConfigurations Test Case -> " + context.getSkippedConfigurations().size());
		System.out.println("getFailedConfigurations Test Case -> " + context.getFailedConfigurations().size());
		System.out.println("getPassedConfigurations Test Case -> " + context.getPassedConfigurations().size());

	}

	public void getData(ITestResult testResult) {
		System.out.println(" ");
		System.out.println("============================================");
		System.out.println("Start Time " + ReportUtil.getTime(testResult.getStartMillis()) + " End Time "
				+ ReportUtil.getTime(testResult.getEndMillis()));
		System.out.println("Package  ->   " + testResult.getInstanceName());
		System.out.println("Method Name -> " + testResult.getName());
		if (testResult.getMethod().getDescription() != null)
			System.out.println(
					"Description --> " + testResult.getName() + "  -> " + testResult.getMethod().getDescription());
		else {
			System.out.println("No Description");
		}
		String[] tcGroup = testResult.getMethod().getGroups();
		System.out.print("Number of Group --> " + tcGroup.length);
		for (String ss : tcGroup) {
			System.out.print(ss + ",  ");
		}
	}

	LinkedHashMap<String, String> hmap = new LinkedHashMap<String, String>();
	ResultData RD = new ResultData();

	LinkedHashSet<String> passList = new LinkedHashSet<String>();

	public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> iSuite, String s) {
		for (ISuite suite : iSuite) {
			String suiteName = suite.getName();
			System.out.println();

			Map<String, ISuiteResult> suiteResults = suite.getResults();

			for (String testName : suiteResults.keySet()) {
				ISuiteResult suiteResult = suiteResults.get(testName);

				ITestContext testContext = suiteResult.getTestContext();
				getResultSize(testContext);

				// pass
				IResultMap passResult = testContext.getPassedTests();
				Set<ITestResult> testsPassed = passResult.getAllResults();
				if (testsPassed.size() > 0) {
					for (ITestResult testResult : testsPassed) {
						getData(testResult);
					}
				}

				// Failed Test Case
				System.out.println("____________________________________________________________________________");
				IResultMap failedResult = testContext.getFailedTests();
				Set<ITestResult> testsFailed = failedResult.getAllResults();
				if (testsFailed.size() > 0) {
					for (ITestResult testResult : testsFailed) {
						getData(testResult);
						if (testResult.getThrowable().toString().length() > 0) {
							System.out.println(testResult.getThrowable().toString());
						}

					}

				}

				System.out.println(
						"______________________________SkipTest Case______________________________________________");
				// SkipTest Case
				IResultMap skipResult = testContext.getSkippedTests();
				Set<ITestResult> testsSkip = skipResult.getAllResults();
				if (testsSkip.size() > 0) {
					for (ITestResult testResult : testsSkip) {
						getData(testResult);

						int i = 0;
						try {
							i = testResult.getThrowable().toString().length();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(i + "*********");
						if (i > 0) {
							System.out.println(testResult.getThrowable().toString());
						}
					}
				}

			}
		}

	}
}