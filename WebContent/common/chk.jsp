<%
	response.addHeader("Cache-Control","no-cache");
	response.addHeader("Cache-Control","no-store");
	
	HttpSession httpSession =request.getSession(false);
	if(httpSession==null){
		response.sendRedirect("../index.jsp");
		return;
	}else{
		String myusername=(String)httpSession.getAttribute("USERNAME");
		if(myusername==null){
			response.sendRedirect("../index.jsp");
			return;
		}
	}	
	
%>
