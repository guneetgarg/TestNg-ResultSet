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

				RD.setPassCount(testContext.getPassedTests().size());
				RD.setFailCount(testContext.getFailedTests().size());
				RD.setSkipCount(testContext.getSkippedTests().size());

				// hmap.put("Start Time",testContext.getStartDate().toString());
				// hmap.put("End Time",testContext.getEndDate().toString());

				// pass
				IResultMap passResult = testContext.getPassedTests();
				Set<ITestResult> testsPassed = passResult.getAllResults();
				if (testsPassed.size() > 0) {
					for (ITestResult testResult : testsPassed) {
						RD.setPassedList(ReportUtil.getTime(testResult.getStartMillis()));
						RD.setPassedList(ReportUtil.getPackageName(testResult.getInstanceName()));
						RD.setPassedList(testResult.getName());
						if (testResult.getMethod().getDescription() != null)
							RD.setPassedList(testResult.getMethod().getDescription());
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
				IResultMap failedResult = testContext.getFailedTests();
				Set<ITestResult> testsFailed = failedResult.getAllResults();
				if (testsFailed.size() > 0) {
					for (ITestResult testResult : testsFailed) {
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
							System.out.print(ss+",  ");
						}
					}

				}

				// SkipTest Case
				IResultMap skipResult = testContext.getSkippedTests();
				Set<ITestResult> testsSkip = skipResult.getAllResults();
				if (testsSkip.size() > 0) {
					for (ITestResult testResult : testsSkip) {
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
				}

			}
		}

	}
}