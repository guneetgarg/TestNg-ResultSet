package com.report;

import java.util.Arrays;
import java.util.LinkedHashMap;
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

import com.report.ResultData.DataType;

public class CustomReporter2 implements IReporter {

	LinkedHashMap<String, String> hmap = new LinkedHashMap<String, String>();
	ResultData RD = new ResultData();

	public void getResultSize(ITestContext context) {
		RD.setPassCount(context);
		RD.setFailCount(context);
		RD.setSkipCount(context);

	}

	public void getData(ITestResult testResult, String res) {
		hmap.put(DataType.PackageName.toString(), testResult.getInstanceName());
		hmap.put(DataType.MethodName.toString(), testResult.getName());

		if (testResult.getMethod().getDescription() != null) {
			hmap.put(DataType.DescriptionMethod.toString(), testResult.getName());
		} else {
			hmap.put(DataType.DescriptionMethod.toString(), " ");
		}

		hmap.put(DataType.GroupName.toString(), Arrays.toString(testResult.getMethod().getGroups()));

		if (res.equalsIgnoreCase("fail")) {
			if (testResult.getThrowable().toString().length() > 0) {
				hmap.put(DataType.ExceptionMessage.toString(), testResult.getThrowable().toString());
				RD.setFailedList(hmap);
			}
		} else if (res.equalsIgnoreCase("skip")) {
			int i = 0;
			try {
				i = testResult.getThrowable().toString().length();
			} catch (Exception e) {
			}
			if (i > 0) {
				hmap.put(DataType.ExceptionMessage.toString(), testResult.getThrowable().toString());
			}
			RD.setSkippedList(hmap);
		} else if (res.equalsIgnoreCase("pass")) {
			RD.setPassedList(hmap);
		}

	}

	public void generateReport(List<XmlSuite> xmlSuite, List<ISuite> iSuite, String s) {
		for (ISuite suite : iSuite) {
			String suiteName = suite.getName();
			System.out.println("___________________--------" + suiteName);

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
						getData(testResult, "pass");
					}
				}

				// Failed Test Case
				IResultMap failedResult = testContext.getFailedTests();
				Set<ITestResult> testsFailed = failedResult.getAllResults();
				if (testsFailed.size() > 0) {
					for (ITestResult testResult : testsFailed) {
						getData(testResult, "fail");
					}
				}

				// SkipTest Case
				IResultMap skipResult = testContext.getSkippedTests();
				Set<ITestResult> testsSkip = skipResult.getAllResults();
				if (testsSkip.size() > 0) {
					for (ITestResult testResult : testsSkip) {
						getData(testResult, "skip");
					}
				}
				System.out.println(testContext.getIncludedGroups().length);
				System.out.println(Arrays.toString(testContext.getIncludedGroups()));
			}
		}

/*		for (Map.Entry<Integer, ResultSet> entry : RD.getPassed().entrySet()) {
			ResultSet b = entry.getValue();

			System.out.println(entry.getKey() + " -> " + b.DescriptionMethod + " -> " + b.MethodName + " -> "
					+ b.PackageName + " -> " + b.GroupName);
		}
		System.out.println("------------------------------------------------------------");
		for (Map.Entry<Integer, ResultSet> entry : RD.getFailesList().entrySet()) {
			ResultSet b = entry.getValue();
			System.out.println(entry.getKey() + " -> " + b.DescriptionMethod + " -> " + b.MethodName + " -> "
					+ b.PackageName + " -> " + b.GroupName + " -> " + b.ExceptionMessage);
		}
		System.out.println("------------------------------------------------------------");
		for (Map.Entry<Integer, ResultSet> entry : RD.getSkippedList().entrySet()) {
			ResultSet b = entry.getValue();
			System.out.println(entry.getKey() + " -> " + b.DescriptionMethod + " -> " + b.MethodName + " -> "
					+ b.PackageName + " -> " + b.GroupName + " -> " + b.ExceptionMessage);
		}
*/
	}
}