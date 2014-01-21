<jsp:useBean id="dto" class="com.js.tracker.ws.dto.LoginDTO"></jsp:useBean>
<jsp:useBean id="loginController"
	class="com.js.tracker.ws.controller.LoginController"></jsp:useBean>
<jsp:setProperty property="*" name="dto" />
<%
	out.print(loginController.updatePassword(dto));
%>
