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
	<jsp:useBean id="newAcademicProjectEnquiryDTO" class="com.js.dto.NewAcademicProjectEnquiryDTO"></jsp:useBean>
	<jsp:setProperty property="*" name="newAcademicProjectEnquiryDTO"/>
	<jsp:useBean id="enquiryController" class="com.js.controller.EnquiryController"></jsp:useBean>
	<%
		try{
			enquiryController.saveNewAcademicProjectEnquiry(newAcademicProjectEnquiryDTO, request);
			out.println("Enquiry successfully saved");
		}catch(Exception e){
			out.println("Enquiry not saved");
		}
	%>
</body>
</html>