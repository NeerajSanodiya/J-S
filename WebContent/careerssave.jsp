<%
request.setAttribute("message", "Resume successfully submited");

request.getRequestDispatcher("careers.jsp").forward(request, response);
%>