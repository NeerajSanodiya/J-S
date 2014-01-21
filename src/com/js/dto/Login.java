package com.js.dto;

public class Login {
	private String unm;
	private String up;
	private String ul;
	public Login(String unm, String up, String ul) {
		super();
		this.unm = unm;
		this.up = up;
		this.ul = ul;
	}
	public Login() {
		super();
	}
	public Login(String unm, String up) {
		super();
		this.unm = unm;
		this.up = up;
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
		this.up = up;
	}
	public String getUl() {
		return ul;
	}
	public void setUl(String ul) {
		this.ul = ul;
	}	
}
