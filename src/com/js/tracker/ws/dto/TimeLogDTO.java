package com.js.tracker.ws.dto;

public class TimeLogDTO {
	private String log_id;
	private String username;
	private String c_date;
	private String start_time;
	private String end_time;
	private String status;
	private String log_type;
	private String m_entry_reason;
	private String m_entry_status;
	
	public String getM_entry_status() {
		return m_entry_status;
	}
	public void setM_entry_status(String m_entry_status) {
		this.m_entry_status = m_entry_status;
	}
	public String getLog_id() {
		return log_id;
	}
	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLog_type() {
		return log_type;
	}
	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}
	public String getM_entry_reason() {
		return m_entry_reason;
	}
	public void setM_entry_reason(String m_entry_reason) {
		this.m_entry_reason = m_entry_reason;
	}
	
}
