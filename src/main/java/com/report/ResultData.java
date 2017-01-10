package com.report;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;

public class ResultData {

	enum DataType {
		PackageName, MethodName, DescriptionMethod, GroupName
	}

	static int count = 0;
	
	public Integer passCount = 0;
	public Integer failCount = 0;
	public Integer SkipCount = 0;

	LinkedList<String> passList = new LinkedList<String>();
	LinkedList<String> failList = new LinkedList<String>();
	LinkedList<String> skipList = new LinkedList<String>();

	Map<Integer, ResultSet> passHashMap = new LinkedHashMap<Integer,ResultSet>();

	// pass arraylist
	public LinkedList<String> getPassedList() {
		return passList;
	}

//	public void setPassedList(String pass) {
//		this.passList.add(pass);
//	}

	public void setPassedList(LinkedHashMap<String, String> pass) {
		this.passHashMap.put(count,new ResultSet(pass.get(DataType.PackageName.toString()), pass.get(DataType.MethodName.toString()), pass.get(DataType.DescriptionMethod.toString()), pass.get(DataType.GroupName.toString())));
		count++;
	}

	public Map<Integer, ResultSet> getPassed() {
		return passHashMap;
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
