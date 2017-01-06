package com.report;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jfree.data.general.DefaultPieDataset;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter {
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
					}
				}

			}
		}

		PdfCreate create = new PdfCreate("automation1.pdf");
		create.titlePdf("Automation Report");
		hmap.put("Total", String.valueOf(RD.getPassCount() + RD.getFailCount() + RD.getSkipCount()));
		hmap.put("Passed", RD.getPassCount().toString());
		hmap.put("Failed", RD.getFailCount().toString());
		hmap.put("Skipped", RD.getSkipCount().toString());

		DefaultPieDataset dataSet = new DefaultPieDataset();
		dataSet.setValue("Failed", RD.getFailCount());
		dataSet.setValue("Skipped", RD.getSkipCount());
		dataSet.setValue("Passed", RD.getPassCount());

		new Graph().generateChart(dataSet);
		create.createTable(hmap);
		create.addNewLine(2);

		create.addImage("chart.png");
		if (RD.getPassedList().size() > 0) {
			create.newPage();
			create.writePassData(RD.getPassedList());
		}

		if (RD.getFailesList().size() > 0) {
			create.newPage();
			create.writeFailData(RD.getFailesList());
		}

		if (RD.getSkippedList().size() > 0) {
			create.newPage();
			create.writeSkipData(RD.getSkippedList());
		}

		create.closeDocument();

	}
}