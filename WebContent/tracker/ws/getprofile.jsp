<jsp:useBean id="dto" class="com.js.tracker.ws.dto.EmployeDTO"></jsp:useBean>
<jsp:useBean id="loginController"
	class="com.js.tracker.ws.controller.EmployeController"></jsp:useBean>
<jsp:setProperty property="*" name="dto" />
<%
	out.print(loginController.getEmploeeById(dto));
%>
