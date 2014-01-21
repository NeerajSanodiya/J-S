package com.js.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.js.dto.*;
import com.js.msg.MyMessage;
import com.js.service.EmployeeService;

public class LoginController {
	public void loginVarify(HttpServletRequest request,HttpServletResponse response,Login login){
		Login tlogin=null;
		try{
			System.out.print("hello1");
			tlogin=new com.js.service.LoginService().loginVarify(login);
			System.out.println("hello");
			if(tlogin==null){
				HttpSession https= request.getSession(true);
				https.setAttribute("LOGINMSG","Invalid username or passowrd");				
				response.sendRedirect("../index.jsp");				
			}else{
				String branchid=tlogin.getUnm().substring(0,12);
				HttpSession https= request.getSession(true);
				Employee emp=new EmployeeService().getEmployeeDetailByEmployeeId(new Employee(tlogin.getUnm()));
				https.setAttribute("USERFULLNAME",emp.getFull_name());
				https.setAttribute("USERNAME",tlogin.getUnm());
				https.setAttribute("USERLEVEL",tlogin.getUl());		
				https.setAttribute("BRANCHID",branchid);				
				if(tlogin.getUl().equalsIgnoreCase("operator")){
					MyMessage myMessage=new MyMessage();
					request.setAttribute("LOGINMSG",myMessage);
					myMessage.setLoginMessage("Success");
					response.sendRedirect("../operator/home.jsp");					
				}else if(tlogin.getUl().equalsIgnoreCase("tracker supervisor")){
					MyMessage myMessage=new MyMessage();
					request.setAttribute("LOGINMSG",myMessage);
					myMessage.setLoginMessage("Success");
					response.sendRedirect("../tracker/supervisor/home.jsp");					
				}
			}
		}catch(Exception ex){
			
			//ex.printStackTrace();
			System.out.println("hi");
			HttpSession https= request.getSession(true);
			https.setAttribute("LOGINMSG","Server side error");				
			try {
				response.sendRedirect("../index.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	public String changePassword(HttpServletRequest request,HttpServletResponse response, ChangePassword changePassword) throws Exception{
		changePassword.setUsername((String)request.getSession(false).getAttribute("USERNAME"));
		return new com.js.service.LoginService().changePassword(changePassword);
	}
}

