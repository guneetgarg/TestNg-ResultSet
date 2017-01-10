package com.report;

import java.util.LinkedList;

import org.testng.ITestContext;

public class ResultData {
	
	enum DataType { PackageName, MethodName, DescriptionMethod}  

	public Integer passCount = 0;
	public Integer failCount = 0;
	public Integer SkipCount = 0;

	LinkedList<String> passList = new LinkedList<String>();
	LinkedList<String> failList = new LinkedList<String>();
	LinkedList<String> skipList = new LinkedList<String>();

	// pass arraylist
	public LinkedList<String> getPassedList() {
		return passList;
	}

	public void setPassedList(String pass) {
		this.passList.add(pass);
	}

	// fail arraylist
	public LinkedList<String> getFailesList() {
		return failList;
	}

	public void setFailedList(String fail) {
		this.failList.add(fail);
	}

	// Skip arraylist
	public LinkedList<String> getSkippedList() {
		return skipList;
	}

	public void setSkippedList(String skip) {
		this.skipList.add(skip);
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
