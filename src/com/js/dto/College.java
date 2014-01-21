package com.js.dto;

public class College {
	private String collegeName;
	private String collegeCode;
	
	public College(String collegeName) {
		super();
		this.collegeName = collegeName;
	}

	public College() {
		super();
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}
	
}
