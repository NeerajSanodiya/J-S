<%@page import="com.js.msg.MyMessage"%>
<%@page import="java.util.*" %>
<jsp:useBean id="paymentController" class="com.js.controller.PaymentController"></jsp:useBean>
<%
	List candidateList=paymentController.searchResultForMakePayment(request, response);	
	request.setAttribute("SEARCHFORPAYMENTCANDIDATELIST",candidateList);
	MyMessage myMessage=new MyMessage();
	myMessage.setPaymentMessage(request.getParameter("dialog_source"));
	request.setAttribute("CANDIDATEFOUNDIN",myMessage);
	//out.println("hi");
	request.getRequestDispatcher("payment.jsp").forward(request,response);	
%>