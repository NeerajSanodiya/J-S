package com.js.tracker.ws.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TrackerDate {
	private static TrackerDate singleon;
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private DateFormat df1= new SimpleDateFormat("dd-MM-yyyy");
	private DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
	
	private String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

	private TrackerDate() {
	}

	public static TrackerDate getInstance() {
		if (TrackerDate.singleon == null) {
			synchronized (TrackerDate.class) {
				if (TrackerDate.singleon == null) {
					TrackerDate.singleon = new TrackerDate();
				}
			}
		}
		return TrackerDate.singleon;
	}
	public String changeDateFormate_df1_df(String date){
		try {
			return df1.format(df.parse(date.trim()));
		} catch (ParseException e) {
		}
		return date;
	}
	public String changeDateFormate_df_df1(String date){
		try {
			return df.format(df1.parse(date.trim()));
		} catch (ParseException e) {
		}
		return date;
	}
	public String changeDateFormate_df_df2(String date){
		try {
			return df.format(df2.parse(date.trim()));
		} catch (ParseException e) {
		}
		return date;
	}
	public String changeDateFormate_df2_df(String date){
		try {
			return df2.format(df.parse(date.trim()));
		} catch (ParseException e) {
		}
		return date;
	}
	public static void main(String args[]) {
		long i=Long.parseLong("1386146652000");
		long j=Long.parseLong("1386139332000");
		System.out.println(TrackerDate.getInstance().formatTimeInHours(i-j));
	}
	public String getTimeFormat(long time) {
		DateFormat timeFormater = new SimpleDateFormat("HH:mm:ss");
		return timeFormater.format(new Date(time));
	}

	public String getDateFormat(long time) {
		Date date = new Date(time);
		return df.format(date);
	}

	public String formatTimeInHours(long diff) {
	        String msg = "";
	        long diffSeconds = diff / 1000 % 60;
	        long diffMinutes = diff / (60 * 1000) % 60;
	        long diffHours = diff / (60 * 60 * 1000);
//	        if (diffDays != 0) {
//	        }
	        if (diffHours != 0) {
	            String h = "" + diffHours;
	            if (h.length() < 2) {
	                h = "0" + h;
	            }
	            msg = msg + h + " : ";
	        } else {
	            msg = msg + "00" + " : ";
	        }
	        if (diffMinutes != 0) {
	            String m = "" + diffMinutes;
	            if (m.length() < 2) {
	                m = "0" + m;
	            }
	            msg = msg + m + " : ";
	        } else {
	            msg = msg + "00" + " : ";
	        }
	        if (diffSeconds != 0) {
	            String s = "" + diffSeconds;
	            if (s.length() < 2) {
	                s = "0" + s;
	            }
	            msg = msg + s + "";
	        } else {
	            msg = msg + "00" + "";
	        }
	        return msg;
	    }

	public String getDay(String sDate) {
		String day = "";
		try {
			Date date = df.parse(sDate);
			day = days[date.getDay()];
		} catch (Exception e) {
			day = "";
		}
		return day;
	}

	

	public String getDate_YYYY_MM_DD(Date date) {
		return df.format(date);
	}

	public String getFirstDayOfWeek(Date today) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		Calendar first = (Calendar) cal.clone();
		first.add(Calendar.DAY_OF_WEEK,
				first.getFirstDayOfWeek() - first.get(Calendar.DAY_OF_WEEK) + 1);
		return df.format(first.getTime());
	}

	public String getlastDayOfWeek(Date today) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		Calendar first = (Calendar) cal.clone();
		first.add(Calendar.DAY_OF_WEEK,
				first.getFirstDayOfWeek() - first.get(Calendar.DAY_OF_WEEK) + 1);
		Calendar last = (Calendar) first.clone();
		last.add(Calendar.DAY_OF_YEAR, 6);
		return df.format(last.getTime());
	}
}
