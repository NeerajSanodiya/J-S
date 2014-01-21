<%@include file="../common/chk.jsp" %>

<jsp:useBean id="enquiryDTO" class="com.js.dto.NewTrainingEnquiryDTO"></jsp:useBean>
<jsp:useBean id="enquiryController" class="com.js.controller.EnquiryController"></jsp:useBean>
<jsp:setProperty property="*" name="enquiryDTO"/>
<%
	try{
		enquiryController.updateTrainingEnquiry(enquiryDTO, request, response);
		out.println("Enquiry successfully updated");
	}catch(Exception ex){			
		out.println("Enquiry not updated");
		ex.printStackTrace();
	}
%>
