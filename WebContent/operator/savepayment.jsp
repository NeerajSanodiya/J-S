<%@page import="com.js.dto.*" %>
<%@page import="java.util.*" %>
<jsp:useBean id="payment" class="com.js.dto.Payment"></jsp:useBean>
<jsp:setProperty name="payment" property="*"/>
<jsp:useBean id="paymentController" class="com.js.controller.PaymentController"></jsp:useBean>
<%	
	Payment tpayment=paymentController.makePayment(request,response,payment);
	if(tpayment==null){		
		out.println("Payment not saved");		
	}else{		
		out.println(tpayment.getPayment_id()+"$Payment successfully saved");		
	}
%>