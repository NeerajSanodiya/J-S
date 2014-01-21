package com.js.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.js.dto.EnquiryRemark;
import com.js.dto.NewEnquiry;
import com.js.dto.Remark;
import com.js.service.RegistrationRemarkService;

public class RegistrationRemarkController {
	public String saveNewRemark(HttpServletRequest request) throws Exception{
		Remark remark=new Remark();
		String employeeId=(String)request.getSession(false).getAttribute("USERNAME");
		Date date=new Date();
		String c_date=(1900+date.getYear())+"-"+(1+date.getMonth())+"-"+date.getDate();
		remark.setEmployee_id(employeeId);
		remark.setRemark(request.getParameter("remark"));
		remark.setRemark_alert(request.getParameter("alertdate"));		
		remark.setRemark_date(c_date);
		remark.setEnquiry_id(request.getParameter("enquiryid"));		
		return new RegistrationRemarkService().saveNewRemark(remark);
	}
	public List<Remark> getAllRemarkForAnRegistration(String registrationId) throws Exception{
		return new RegistrationRemarkService().getAllRemarkForAnRegistration(registrationId);
	}
}
