package com.restaurant.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaUtils {


	public static Date getYesterday() throws ParseException {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -1);
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter_2 = new SimpleDateFormat("yyyy-MM-dd");
		String yestDate = formatter_2.format(cal.getTime());
	    return formatter.parse(yestDate + " 03:00:00");
	}
	public static String getYesterdayAsString() {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -1);
		SimpleDateFormat formatter_2 = new SimpleDateFormat("yyyy-MM-dd");
		String yestDate = formatter_2.format(cal.getTime());
	    return yestDate + " 03:00:00";
	}
	
	public static Date getToday() throws ParseException {
	    final Calendar cal = Calendar.getInstance();
	   
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter_2 = new SimpleDateFormat("yyyy-MM-dd");
		String toDate = formatter_2.format(cal.getTime());
	    return formatter.parse(toDate + " 03:00:00");
	}
	
	public static String getTodayAsString() {
	    final Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter_2 = new SimpleDateFormat("yyyy-MM-dd");
		String toDate = formatter_2.format(cal.getTime());
	    return toDate + " 03:00:00";
	}
	

	
	public static String getCurrentDateAsString() {
	    final Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter_2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String toDate = formatter_2.format(cal.getTime());
	    return toDate;
	}
	
	
	
}
