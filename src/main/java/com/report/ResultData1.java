package com.report;

import java.util.LinkedList;

public class ResultData1 {

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

	public void setPassCount(Integer passCount) {
		this.passCount += passCount;
	}

	// fail count
	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount += failCount;
	}

	// skip count
	public Integer getSkipCount() {
		return SkipCount;
	}

	public void setSkipCount(Integer skipCount) {
		this.SkipCount += skipCount;
	}

}
