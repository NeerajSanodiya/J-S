<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="searchEnquiry" class="com.js.dto.SearchEnquiry"></jsp:useBean>
	<jsp:setProperty name="searchEnquiry" property="*"/>
	<jsp:useBean id="registrationController" class="com.js.controller.RegistrationController"></jsp:useBean>
	<%
		registrationController.searchTranningRegistration(searchEnquiry,request,response,(String)request.getSession(false).getAttribute("BRANCHID"));
	%>
</body>
</html>