<%@include file="../common/chk.jsp" %>

<jsp:useBean id="enquiryController" class="com.js.controller.EnquiryController"></jsp:useBean>
<jsp:useBean id="projectDTO" class="com.js.dto.NewAcademicProjectEnquiryDTO"></jsp:useBean>
<jsp:setProperty property="*" name="projectDTO"/>
<%
	try{
		enquiryController.updateAcademicProjectEnquiry(projectDTO, request, response);
		out.println("Enquiry successfully updated");
	}catch(Exception ex){			
		out.println("Enquiry not updated");
		ex.printStackTrace();
	}
%>
