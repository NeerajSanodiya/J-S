<%@include file="../common/chk.jsp" %>
<jsp:useBean id="enquiryController" class="com.js.controller.EnquiryController"></jsp:useBean>




<%	try{
	enquiryController.saveNewAcademicProjectRemark(request);		
	out.println("Remark successfully saved");
}catch(Exception ex){		
	out.println("Remark not saved");
	ex.printStackTrace();
}
%>