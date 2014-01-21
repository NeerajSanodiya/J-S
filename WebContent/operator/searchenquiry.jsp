<%@include file="../common/chk.jsp"%>
<%@page import="com.js.dto.*"%>
<%@page import="java.util.*"%>

<jsp:useBean id="searchEnquiry" class="com.js.dto.SearchEnquiry"></jsp:useBean>
<jsp:setProperty name="searchEnquiry" property="*" />
<jsp:useBean id="enquiryController"
	class="com.js.controller.EnquiryController"></jsp:useBean>
<%
	String search_purpose = request.getParameter("search_purpose");
	if (search_purpose.equalsIgnoreCase("Training")) {
		enquiryController.searchTraningEnquiryBranchWise(searchEnquiry,
				request, response, (String) request.getSession(false)
						.getAttribute("BRANCHID"));
	} else if (search_purpose.equalsIgnoreCase("Academic Project")) {
		enquiryController.searchAcadenicEnquiryBranchWise(
				searchEnquiry, request, response, (String) request
						.getSession(false).getAttribute("BRANCHID"));
	} else if (search_purpose.equalsIgnoreCase("Visitor")) {
		enquiryController.searchVisitorEnquiryBranchWise(searchEnquiry,
				request, response, (String) request.getSession(false)
						.getAttribute("BRANCHID"));
	}
%>
