package com.report;

public class ResultSet {

	public String PackageName, MethodName, DescriptionMethod, GroupName;

	public ResultSet(String PackageName, String MethodName, String DescriptionMethod, String GroupName) {
		this.PackageName = PackageName;
		this.MethodName = MethodName;
		this.DescriptionMethod = DescriptionMethod;
		this.GroupName = GroupName;
	}
}