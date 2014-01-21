<jsp:useBean id="dto" class="com.js.tracker.ws.dto.TimeLogDTO"></jsp:useBean>
<jsp:useBean id="loginController"
	class="com.js.tracker.ws.controller.TimeLogController"></jsp:useBean>
<%
	out.print(loginController.updateTimeLog(request));
%>
