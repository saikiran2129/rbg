package com.surveillance.utilitiy;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.apache.poi.util.SystemOutLogger;

public class DateAndTimeFormate 
{
	//1 minute = 60 seconds
	//1 hour = 60 x 60 = 3600
	//1 day = 3600 x 24 = 86400
	/**
	 * Method Name	: printDifference
	 * purpose		: returns the time taken to execute all the testcases.
	 * parameters 	: startDate, endDate 
	 * Example		: <>, <>
	 */

	public static String printDifference(Date startDate, Date endDate){

		//milliseconds
		long different = endDate.getTime() - startDate.getTime();
		//
		//		System.out.println("startDate : " + startDate);
		//		System.out.println("endDate : "+ endDate);
		//		System.out.println("different : " + different);

		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;

		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;

		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;

		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;

		long elapsedSeconds = different / secondsInMilli;

		String elapced=""+elapsedDays+" days, "+elapsedHours+" hours, "+elapsedMinutes+" minutes, "+elapsedSeconds+" seconds";
		//		System.out.printf(
		//		    "%d days, %d hours, %d minutes, %d seconds%n", elapsedDays,
		//		    elapsedHours, elapsedMinutes, elapsedSeconds);
		//System.out.println("different : " + elapced);
		return elapced;
	}

	public static String dateFormate(String formateType)
	{
		String formate= new SimpleDateFormat(formateType).format(new Date());
		return formate;
	}
}