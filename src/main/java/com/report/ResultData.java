package com.report;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.testng.ITestContext;

public class ResultData {

	enum DataType {
		PackageName, MethodName, DescriptionMethod, GroupName, ExceptionMessage
	}

	static int count = 0;
	static int countFail = 0;
	static int countSkip = 0;

	public Integer passCount = 0;
	public Integer failCount = 0;
	public Integer SkipCount = 0;

	LinkedList<String> passList = new LinkedList<String>();
	LinkedList<String> failList = new LinkedList<String>();
	LinkedList<String> skipList = new LinkedList<String>();

	Map<Integer, ResultSet> passHashMap = new LinkedHashMap<Integer, ResultSet>();
	Map<Integer, ResultSet> failHashMap = new LinkedHashMap<Integer, ResultSet>();
	Map<Integer, ResultSet> skipHashMap = new LinkedHashMap<Integer, ResultSet>();

	// pass arraylist
	public LinkedList<String> getPassedList() {
		return passList;
	}

	public void setPassedList(LinkedHashMap<String, String> pass) {
		this.passHashMap.put(count,
				new ResultSet(pass.get(DataType.PackageName.toString()), pass.get(DataType.MethodName.toString()),
						pass.get(DataType.DescriptionMethod.toString()), pass.get(DataType.GroupName.toString()), " "));
		count++;
	}

	public Map<Integer, ResultSet> getPassed() {
		return passHashMap;
	}

	// fail arraylist
	public Map<Integer, ResultSet> getFailesList() {
		return failHashMap;
	}

	public void setFailedList(LinkedHashMap<String, String> fail) {
		this.failHashMap.put(countFail,
				new ResultSet(fail.get(DataType.PackageName.toString()), fail.get(DataType.MethodName.toString()),
						fail.get(DataType.DescriptionMethod.toString()), fail.get(DataType.GroupName.toString()),
						fail.get(DataType.ExceptionMessage.toString())));
		countFail++;
	}

	// Skip arraylist
	public Map<Integer, ResultSet> getSkippedList() {
		return skipHashMap;
	}

	public void setSkippedList(LinkedHashMap<String, String> skip) {
		this.skipHashMap.put(countSkip,
				new ResultSet(skip.get(DataType.PackageName.toString()), skip.get(DataType.MethodName.toString()),
						skip.get(DataType.DescriptionMethod.toString()), skip.get(DataType.GroupName.toString()),
						skip.get(DataType.ExceptionMessage.toString())));
		countSkip++;
	}

	// pass count
	public Integer getPassCount() {
		return passCount;
	}

	public void setPassCount(ITestContext context) {
		this.passCount += context.getPassedTests().size();
	}

	// fail count
	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(ITestContext context) {
		this.failCount += context.getFailedTests().size();
	}

	// skip count
	public Integer getSkipCount() {
		return SkipCount;
	}

	public void setSkipCount(ITestContext context) {
		this.SkipCount += context.getSkippedTests().size();
	}

}
