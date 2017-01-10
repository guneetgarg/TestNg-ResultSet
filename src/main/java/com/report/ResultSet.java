package com.report;

public class ResultSet {

	public String PackageName, MethodName, DescriptionMethod, GroupName, ExceptionMessage;

	public ResultSet(String PackageName, String MethodName, String DescriptionMethod, String GroupName,
			String ExceptionMessage) {
		this.PackageName = PackageName;
		this.MethodName = MethodName;
		this.DescriptionMethod = DescriptionMethod;
		this.GroupName = GroupName;
		this.ExceptionMessage = ExceptionMessage;
	}
}