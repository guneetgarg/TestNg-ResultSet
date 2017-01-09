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
	LinkedHashMap<String, String> hmap = new LinkedHashMap<String, String>();
	ResultData RD = new ResultData();

	LinkedHashSet<String> passList = new LinkedHashSet<String>();

	public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> iSuite, String s) {
		for (ISuite suite : iSuite) {
			
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			
			for (String testName : suiteResults.keySet()) {
				ISuiteResult suiteResult = suiteResults.get(testName);

				ITestContext testContext = suiteResult.getTestContext();

				System.out.println("Passed Test Case -> " + testContext.getPassedTests().size());
				System.out.println("Failed Test Case -> " + testContext.getFailedTests().size());
				System.out.println("Skipped Test Case -> " + testContext.getSkippedTests().size());

				// hmap.put("Start Time",testContext.getStartDate().toString());
				// hmap.put("End Time",testContext.getEndDate().toString());

				// pass
				IResultMap passResult = testContext.getPassedTests();
				Set<ITestResult> testsPassed = passResult.getAllResults();
				if (testsPassed.size() > 0) {
					for (ITestResult testResult : testsPassed) {
						System.out.println(ReportUtil.getTime(testResult.getStartMillis())+ " -> " + ReportUtil.getTime(testResult.getEndMillis()));
						System.out.println("Package  ->   "+testResult.getInstanceName());
						System.out.println(testResult.getName());
						if (testResult.getMethod().getDescription() != null)
							System.out.println(testResult.getName()+"  -> "+testResult.getMethod().getDescription());
						else {
							RD.setPassedList(" ");
						}
						String[] tcGroup = testResult.getMethod().getGroups();
						for (String ss : tcGroup) {
							System.out.println(ss);
						}

					}
				}

				// Failed Test Case
			/*	IResultMap failedResult = testContext.getFailedTests();
				Set<ITestResult> testsFailed = failedResult.getAllResults();
				if (testsFailed.size() > 0) {
					for (ITestResult testResult : testsFailed) {
						System.out.println(ReportUtil.getTime(testResult.getStartMillis())+ " -> " + ReportUtil.getTime(testResult.getEndMillis()));

						RD.setFailedList(ReportUtil.getTime(testResult.getStartMillis()));
						RD.setFailedList(ReportUtil.getPackageName(testResult.getInstanceName()));
						RD.setFailedList(testResult.getName());
						if (testResult.getThrowable().toString().length() > 0) {
							RD.setFailedList(testResult.getThrowable().toString());
						} else {
							RD.setFailedList(" ");
						}
						System.out.println(" ");
						String[] tcGroup = testResult.getMethod().getGroups();
						for (String ss : tcGroup) {
							System.out.print(ss + ",  ");
						}
					}

				}*/

				// SkipTest Case
			/*	IResultMap skipResult = testContext.getSkippedTests();
				Set<ITestResult> testsSkip = skipResult.getAllResults();
				if (testsSkip.size() > 0) {
					for (ITestResult testResult : testsSkip) {
						System.out.println(ReportUtil.getTime(testResult.getStartMillis())+ " -> " + ReportUtil.getTime(testResult.getEndMillis()));
						RD.setSkippedList(ReportUtil.getTime(testResult.getStartMillis()));
						RD.setSkippedList(ReportUtil.getPackageName(testResult.getInstanceName()));
						RD.setSkippedList(testResult.getName());
						if (testResult.getThrowable().toString().length() > 0) {
							RD.setSkippedList(testResult.getThrowable().toString());
						} else {
							RD.setSkippedList(" ");
						}
						String[] tcGroup = testResult.getMethod().getGroups();
						for (String ss : tcGroup) {
							System.out.println(ss);
						}
					}
				}*/
			}
		}

	}
}