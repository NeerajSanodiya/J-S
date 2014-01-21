<%@page import="com.js.tracker.ws.dto.LoginDTO"%>
<jsp:useBean id="employeDTO" class="com.js.tracker.ws.dto.EmployeDTO"></jsp:useBean>
<jsp:setProperty property="*" name="employeDTO" />
<jsp:useBean id="employeController"
	class="com.js.tracker.ws.controller.EmployeController"></jsp:useBean>
<%
	String type = request.getParameter("type");
	if (type.equalsIgnoreCase("save")) {
		employeController.saveEmploye(request, response, employeDTO);
	} else if (type.equalsIgnoreCase("update")) {
		employeController.updateEmploye(request, response, employeDTO);
	} else if (type.equalsIgnoreCase("active")) {
		employeController.employeActiveStatusChange(employeDTO,
				response);
	} else if (type.equalsIgnoreCase("macreset")) {
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUnm(employeDTO.getId());
		loginDTO.setMac("");
		employeController.resetMac(loginDTO, response);
	}
%>

