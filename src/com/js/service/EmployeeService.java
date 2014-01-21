package com.js.service;

import com.js.dao.EmployeeDAO;
import com.js.dto.Employee;

public class EmployeeService {
	public Employee getEmployeeDetailByEmployeeId(Employee employee) throws Exception{
		return new EmployeeDAO().getEmployeeDetailByEmployeeId(employee);
	}
}
