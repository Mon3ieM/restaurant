package com.restaurant.utils;

<<<<<<< HEAD
import java.text.DateFormat;
=======
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
<<<<<<< HEAD
import java.util.Locale;
=======
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9

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
	
<<<<<<< HEAD
	public static String getTomorrowAsString() {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, +1);
		SimpleDateFormat formatter_2 = new SimpleDateFormat("yyyy-MM-dd");
		String yestDate = formatter_2.format(cal.getTime());
	    return yestDate + " 03:00:00";
	}
	public static Date getTomorrow() throws ParseException {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, +1);
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter_2 = new SimpleDateFormat("yyyy-MM-dd");
		String yestDate = formatter_2.format(cal.getTime());
	    return formatter.parse(yestDate + " 03:00:00");
	}
	
=======
>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
	public static String getTodayAsString() {
	    final Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter_2 = new SimpleDateFormat("yyyy-MM-dd");
		String toDate = formatter_2.format(cal.getTime());
	    return toDate + " 03:00:00";
	}
	
<<<<<<< HEAD
	public static Date getDateFromString(String dateStr) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		Date date = format.parse(dateStr + " 00:00:00");
	    return date;
	}
=======

>>>>>>> 95427e7b70ec812f9d113fa19c90a374f0daabc9
	
	public static String getCurrentDateAsString() {
	    final Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter_2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String toDate = formatter_2.format(cal.getTime());
	    return toDate;
	}
	
	
	
}
