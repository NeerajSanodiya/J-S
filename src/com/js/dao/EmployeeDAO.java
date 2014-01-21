package com.js.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.js.dto.Employee;

public class EmployeeDAO {
	public Employee getEmployeeDetailByEmployeeId(Employee employee) throws Exception{
		Employee tEmployee=null;
		Connection con=null;
		try{
			con=new com.js.db.MyConnection().getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from tbl_employee where employee_id='"+employee.getEmployee_id()+"'");
			if(rs.next()){
				employee.setEmployee_id(rs.getString("employee_id"));
				employee.setFull_name(rs.getString("full_name"));
				tEmployee=employee;
			}
			rs.close();
			st.close();
		}finally{
			con.close();
		}
		return tEmployee;
	}
}
