package com.js.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import com.js.dto.*;

public class CourseDAO {
	public List<Course> getAllCourse(String branchid) throws Exception{
		List <Course>cList=new ArrayList<Course>();
		Connection con= new com.js.db.MyConnection().getConnection();
		Statement st= con.createStatement();
		
		ResultSet rs= st.executeQuery("select * from tbl_cource where course_id like '"+branchid+"%'");
		while(rs.next()){
			Course c=new Course();
			c.setCourse_Id(rs.getString("course_id"));
			c.setCourse_Name(rs.getString("course_name"));
			c.setPrerequisite_Knowledge(rs.getString("prerequisite_knowledge"));
			c.setCourse_Duration(rs.getString("course_duration"));
			c.setCourse_File_Path(rs.getString("course_file_path"));
			cList.add(c);
		}
		rs.close();
		st.close();
		st.close();
		return cList;
	}
	public List<Course> getAllEnquiredCourse(String branchid) throws Exception{
		List <Course>cList=new ArrayList<Course>();
		Connection con= new com.js.db.MyConnection().getConnection();
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select DISTINCT course_id from tbl_intrested_course where enquiry_id like '"+branchid+"%'");
		while(rs.next()){
			Course c=new Course();
			c.setCourse_Id(rs.getString("course_id"));
			Statement tst=con.createStatement();
			ResultSet trs=tst.executeQuery("select * from tbl_cource where course_id='"+c.getCourse_Id()+"'");
			if(trs.next()){
				c.setCourse_Name(trs.getString("course_name"));
			}
			trs.close();
			tst.close();			
			cList.add(c);
		}
		rs.close();
		st.close();
		st.close();
		return cList;
	}
}
