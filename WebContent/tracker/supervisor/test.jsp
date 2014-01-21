<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="imageupload.jsp" method="post" enctype='multipart/form-data' >
	<input type="file" name="fpath"/>
	<input type="text" name="username"/>
	<input type="date" name="c_date"/>
	<input type="date" name="c_time"/>
	<input type="submit"/>
	</form>
</body>
</html>