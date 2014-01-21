package com.js.service;

import java.util.List;

import com.js.dao.CollegeDAO;
import com.js.dto.College;

public class CollegeService {
	public List<College> getAllEnquiryedCollege(String branchid) throws Exception{
		return new CollegeDAO().getAllEnquiryedCollege(branchid);
	}
	public List<College> getAllCollege() throws Exception{
		return new CollegeDAO().getAllCollege();
	}	
}
