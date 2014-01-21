package com.js.tracker.ws.dto;

public class ImageDTO {
	private String id;
	private String username;
	private String c_date;
	private String c_time;
	private String fpath;
	private String ret_path;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ImageDTO() {
		super();
	}

	public ImageDTO(String ret_path) {
		super();
		this.ret_path = ret_path;
	}

	public String getRet_path() {
		return ret_path;
	}

	public void setRet_path(String ret_path) {
		this.ret_path = ret_path;
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

	public String getC_time() {
		return c_time;
	}

	public void setC_time(String c_time) {
		this.c_time = c_time;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		this.fpath = fpath;
	}

}
