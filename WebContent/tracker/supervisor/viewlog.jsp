<%@include file="chk.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dto" class="com.js.tracker.ws.dto.SearchDTO"></jsp:useBean>
	<jsp:setProperty property="*" name="dto"/>
	<jsp:useBean id="logController" class="com.js.tracker.ws.controller.TimeLogController"></jsp:useBean>
	<% 
	logController.searchTimeLog(dto, request, response);
	%>
</body>
</html>