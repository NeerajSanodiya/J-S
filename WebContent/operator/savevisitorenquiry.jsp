<%@page import="com.js.controller.EnquiryController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="newVisitorEnquiryDTO" class="com.js.dto.NewVisitorEnquiryDTO"></jsp:useBean>
	<jsp:setProperty name="newVisitorEnquiryDTO" property="*" />
	<%
		try{
			new EnquiryController().saveNewVisitorEnquiry(newVisitorEnquiryDTO, request);
			out.println("Enquiry successfully save");
			System.out.println("Enquiry successfully save");
		}catch(Exception exception){
			out.println("Enquiry not save");
			System.out.println("Enquiry not save");
		}
	%>
</body>
</html>