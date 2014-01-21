
<%@page import="com.js.dto.TrainingRegistrationDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="registrationController"
		class="com.js.controller.RegistrationController" />
	<%
		try {
			String path = getServletContext().getRealPath("/");
			String ret = registrationController.saveTrainingRegistration(
					request, response, path);
			//out.println(ret);
			request.setAttribute("REGMSG", ret);
			request.getRequestDispatcher("registration.jsp").forward(
					request, response);

		} catch (Exception e) {
			out.println("registration not save");
		}
	%>
</body>
</html>