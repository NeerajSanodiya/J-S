<%@page import="com.js.tracker.ws.dto.ImageDTO"%>
<%@page import="com.js.tracker.ws.controller.ImageController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<% 
		String maxString=request.getParameter("maxcount");
		int max=Integer.parseInt(maxString);
		List<ImageDTO>list=new ArrayList<ImageDTO>();
		for(int i=1;i<=max;i++){
			String imageid=request.getParameter("id"+i);
			String imagePath=request.getParameter("image"+i);
			if(imageid!=null){
				ImageDTO dto=new ImageDTO();
				dto.setId(imageid);
				dto.setFpath(imagePath);
				list.add(dto);
			}			
		}
		new ImageController().deleteImages(request,response,list);				
%>