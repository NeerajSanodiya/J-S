<jsp:useBean id="mailController" class="com.js.controller.MailController"></jsp:useBean>
<%

mailController.sendcontactmail(request, response);
request.setAttribute("message", "Request successfully sent");
request.getRequestDispatcher("contact.jsp").forward(request, response);
%>