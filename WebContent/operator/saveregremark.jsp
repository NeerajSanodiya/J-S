<%@include file="../common/chk.jsp" %>
<jsp:useBean id="controller" class="com.js.controller.RegistrationRemarkController"></jsp:useBean>
<%
	try{
		controller.saveNewRemark(request);	
		out.println("Remark successfully saved");
	}catch(Exception ex){		
		out.println("Remark not saved");
		ex.printStackTrace();
	}
%>