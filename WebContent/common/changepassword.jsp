<jsp:useBean id="changePassword" class="com.js.dto.ChangePassword"></jsp:useBean>
<jsp:setProperty property="*" name="changePassword"/>
<jsp:useBean id="loginController" class="com.js.controller.LoginController"></jsp:useBean>
<%
	String res=loginController.changePassword(request, response, changePassword);
	out.println(res);
%>
