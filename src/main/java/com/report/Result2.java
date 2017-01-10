package com.report;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class Result2 {

	Map<Integer, ResultSet> map = new LinkedHashMap<Integer, ResultSet>();

	@Test
	public void main() {
		map.put(1, new ResultSet("aa", "bb", "cc", "dd", " "));
		map.put(2, new ResultSet("aa1", "bb1", "cc1", "dd1", " "));

		map.put(3, new ResultSet("aa1", "bb1", "cc1", "dd1", " "));

		for (Map.Entry<Integer, ResultSet> entry : map.entrySet()) {
			ResultSet b = entry.getValue();

			System.out.println(entry.getKey() + " -> " + b.DescriptionMethod + " -> " + b.MethodName + " -> "
					+ b.PackageName + " -> " + b.GroupName);
		}

	}
}