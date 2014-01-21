package com.js.tracker.ws.dto;

import java.util.List;
import java.util.Map;

import com.js.tracker.ws.util.TrackerDate;

public class UserDateWiseDTO {
	String date;
	String day;
	String stime;
	String etime;
	String slote;
	String totalhours;
	List<TimeLogDTO> list;

	public String getDay() {
		return day;
	}

	public String getSlote() {
		return slote;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
		if (!date.equalsIgnoreCase("")) {
			day = TrackerDate.getInstance().getDay(date);
		}
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		if (stime.equalsIgnoreCase("")) {
			stime = "0";
		}
		this.stime = stime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		if (etime.equalsIgnoreCase("")) {
			etime = "0";
		}
		this.etime = etime;
	}

	public String getTotalhours() {
		return totalhours;
	}

	public void setTotalhours(String totalhours) {
		if (totalhours.equalsIgnoreCase("")) {
			totalhours = "0";
		}
		this.totalhours = totalhours;
	}

	public List<TimeLogDTO> getList() {
		return list;
	}

	public void setList(List<TimeLogDTO> list) {
		this.list = list;
		this.slote = "" + list.size();
	}

}
