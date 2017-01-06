package com.report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtil {

	public static String getTime(long currentDateTime) {
		Date currentDate = new Date(currentDateTime);
		DateFormat df = new SimpleDateFormat("MMM dd yyyy,HH:mm:ss");
		return df.format(currentDate).toString();
	}
	
	public static String getPackageName(String val){
		String[] words = val.split("\\.");
		return words[words.length - 1];
	}
}
