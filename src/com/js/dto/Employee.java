package com.js.dto;

public class Employee {
	private String employee_id;
	private String full_name;
	
	
	public Employee(String employee_id) {
		super();
		this.employee_id = employee_id;
	}
	public Employee(String employee_id, String full_name) {
		super();
		this.employee_id = employee_id;
		this.full_name = full_name;
	}
	public Employee() {
		super();
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}	
}
