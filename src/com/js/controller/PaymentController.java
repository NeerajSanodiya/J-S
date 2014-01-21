package com.js.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dto.Payment;

public class PaymentController {
	public List searchResultForMakePayment(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String code=request.getParameter("dialog_code");
		String fullName=request.getParameter("dialog_name");
		String source=request.getParameter("dialog_source");
		String branchid=(String)request.getSession(false).getAttribute("BRANCHID");
		System.out.println(branchid);
		String employeeid=(String)request.getSession(false).getAttribute("USERNAME");
		return new com.js.dao.PaymentDAO().searchResultForMakePayment(code, fullName, source, branchid, employeeid);
	}
	public Payment makePayment(HttpServletRequest request,HttpServletResponse response,Payment payment) throws Exception{
		
		String branchcode=(String)request.getSession(false).getAttribute("BRANCHID");
		System.out.println(branchcode);
		payment.setReceived_by((String)request.getSession(false).getAttribute("USERNAME"));
		Date date=new Date();	
		String c_date=(1900+date.getYear())+"-"+(1+date.getMonth())+"-"+date.getDate();
		payment.setPayment_date(c_date);
		return new com.js.service.PaymentService().makePayment(payment, branchcode);
	} 
}
