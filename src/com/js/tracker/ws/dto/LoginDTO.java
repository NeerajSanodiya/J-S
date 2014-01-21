package com.js.tracker.ws.dto;

import com.google.gson.Gson;

public class LoginDTO {
	private String unm = "";
	private String up = "";
	private String mac = "";
	private String level = "";
	private String newpassword;
	private String active_staatus;

	public LoginDTO() {
		super();
	}

	public LoginDTO(String unm, String up, String mac, String level) {
		super();
		this.unm = unm;
		this.up = up;
		this.mac = mac;
		this.level = level;
	}

	public String getActive_staatus() {
		return active_staatus;
	}

	public void setActive_staatus(String active_staatus) {
		this.active_staatus = active_staatus;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getUnm() {
		return unm;
	}

	public void setUnm(String unm) {
		this.unm = unm;
	}

	public String getUp() {
		return up;
	}

	public void setUp(String up) {
		if (up == null) {
			up = "";
		}
		this.up = up;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getJsonObject() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}
