<%@include file="../common/chk.jsp" %>
<jsp:useBean id="newEnquiry" class="com.js.dto.NewEnquiry"></jsp:useBean>
<jsp:useBean id="enquiryController" class="com.js.controller.EnquiryController"></jsp:useBean>
<jsp:setProperty name="newEnquiry" property="*" />

<%
	try{
		enquiryController.saveNewEnquiry(newEnquiry, request, response);
		out.println("Enquiry successfully saved");
	}catch(Exception ex){
		out.println("Enquiry not saved");
		ex.printStackTrace();
	}
%>
