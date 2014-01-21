package com.js.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import com.js.dto.*; 

public class CollegeDAO {
	public List<College> getAllEnquiryedCollege(String branchid) throws Exception{
		List <College>collegeList=new ArrayList<College>();
		Connection con= new com.js.db.MyConnection().getConnection();
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select DISTINCT college from tbl_enquiry where enquiry_id like '"+branchid+"%'");
		while(rs.next()){
			College c=new College();
			c.setCollegeCode(rs.getString("college"));
			Statement tst=con.createStatement();
			ResultSet trs=tst.executeQuery("select * from tbl_college where college_code='"+c.getCollegeCode()+"'");
			if(trs.next()){
				c.setCollegeName(trs.getString("college_name"));
			}else{
				c.setCollegeName(c.getCollegeCode());
			}
			trs.close();
			tst.close();	
			collegeList.add(c);
		}
		rs.close();
		st.close();
		return collegeList;
	}
	public List<College> getAllCollege() throws Exception{
		List <College>collegeList=new ArrayList<College>();
		Connection con= new com.js.db.MyConnection().getConnection();
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select * from tbl_college");
		while(rs.next()){
			College c=new College();			
			c.setCollegeCode(rs.getString("college_code"));
			c.setCollegeName(rs.getString("college_name"));
			collegeList.add(c);
		}
		rs.close();
		st.close();
		return collegeList;
	} 
}
