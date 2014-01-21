package com.js.tracker.ws.dto;

public class EmployeDTO {
	private String id;
	private String name;
	private String fatherName;
	private String email;
	private String address;
	private String mno;
	private String salery;
	private String fromDate;
	private String toDate;
	private String supId;
	private String gender;
	private String dob;
	private String active_statis;
	
	

	public String getActive_statis() {
		return active_statis;
	}

	public void setActive_statis(String active_statis) {
		this.active_statis = active_statis;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSupId() {
		return supId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setSupId(String supId) {
		this.supId = supId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getSalery() {
		return salery;
	}

	public void setSalery(String salery) {
		this.salery = salery;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
}
