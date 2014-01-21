package com.js.dto;

public class Remark {
	private String enquiry_id;
	private String remark_date;
	private String remark;
	private String remark_alert;
	private String employee_id;
	private String councillor;
	
	
	public String getCouncillor() {
		return councillor;
	}

	public void setCouncillor(String councillor) {
		this.councillor = councillor;
	}

	public Remark(String enquiry_id, String remark_date, String remark,
			String remark_alert, String employee_id) {
		super();
		this.enquiry_id = enquiry_id;
		this.remark_date = remark_date;
		this.remark = remark;
		this.remark_alert = remark_alert;
		this.employee_id = employee_id;
	}
	
	public Remark() {
		super();
	}
	
	public String getEnquiry_id() {
		return enquiry_id;
	}
	public void setEnquiry_id(String enquiry_id) {
		this.enquiry_id = enquiry_id;
	}
	public String getRemark_date() {
		return remark_date;
	}
	public void setRemark_date(String remark_date) {
		this.remark_date = remark_date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark_alert() {
		return remark_alert;
	}
	public void setRemark_alert(String remark_alert) {
		this.remark_alert = remark_alert;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}	
}
