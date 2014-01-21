<jsp:useBean id="logDTO" class="com.js.tracker.ws.dto.TimeLogDTO"></jsp:useBean>
<jsp:setProperty property="*" name="logDTO" />
<jsp:useBean id="logController"
	class="com.js.tracker.ws.controller.TimeLogController"></jsp:useBean>
<%
	String mysubmit = request.getParameter("mysubmit");
	if (mysubmit.equalsIgnoreCase("Approve")) {
		String ret = logController.approveManualRequest(logDTO);
		out.println(ret);
		
	}
	if (mysubmit.equalsIgnoreCase("Reject")) {
		String ret = logController.rejectManualRequest(logDTO);
		out.println(ret);
		
	}
	response.sendRedirect("logs.jsp");
	
%>