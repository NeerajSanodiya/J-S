<%@page import="com.js.tracker.ws.util.TrackerDate"%>
<%@page import="com.js.tracker.ws.dto.ImageDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.js.tracker.ws.dao.ImageDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.imageclass{
	width: 135px;
	height: 135px;
	float: left;
	padding : 3px;
	border-color:blue;
	margin-bottom: 10px;
	-webkit-box-shadow: 0px 0px 0px 1px rgba(30,51,100,1);
	-moz-box-shadow: 	0px 0px 0px 1px rgba(30,51,100,1);
	box-shadow: 		0px 0px 0px 1px rgba(30,51,100,1);
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	$('#delete_id').click(function() {
		$('#deleteImageform').submit();
		return false;
	});
	$('#deleteImageform').submit(function() {		
		if (validatedeleteImageForm() == false) {
			return false;
		} else {
			deleteImage();
		}
		return false;
	});
});
function validatedeleteImageForm(){
	var max = document.getElementById("max_id").value;
	var mycheck=false;
	for(var i=1;i<=max;i++){							
		mycheck=document.getElementById("checkbox_id"+i).checked;
		if(mycheck){
			break;
		}
	}
	if(!mycheck){
		alert("Please select image for delete.");
		return false;
	}
	return mycheck;
}
function deleteImage() {
	$.post('deleteimage.jsp', $('#deleteImageform').serialize())
			.success(function(response) {
				var nameid=document.getElementById("image_usename_id").value;
				var dateid=document.getElementById("image_date_id").value;
				loadImageData(nameid, dateid);
			}).error(function(e) {
				alert(e);
			});
}
</script>
</head>
<body>
	<% 
		String username=request.getParameter("username");
		String date=request.getParameter("date");
		
		List<ImageDTO>imageDTOs=new ImageDAO().getAllImageDataByDateAndUser(date, username);
	
	%>
	<form action="#" method="post" id="deleteImageform">
	<div style="width: 300px;" align="center">
			<b style="font-size: 12px;color: white;">
			<table width="90%">
	  			<tr>
	    			<td width="25%">Name : </td>
	    			<td width="75%" colspan="2"><%=username %></td>
	    			<input type="hidden" id="image_usename_id" value="<%=username %>"/>
	    		</tr>
	    			
	    		<tr>
	    			<td width="25%">Date : </td>
	    			<td width="75%" colspan="2"><%=date %></td>
	    			<input type="hidden" id="image_date_id" value="<%=date %>"/>
	  			</tr>
	  			<tr>
	    			<td width="25%" align="right"><input disabled="disabled" type="checkbox" id="check_all" onchange="selectAll(this);"/></td>
	    			<td width="25%">Select All</td>
	    			<td width="50%" align="right"><input disabled="disabled" type="submit" value="Delete selected" id="delete_id"/></td>
	  			</tr>
			</table></b>
		
		<br>
	</div>
	
	<div style="width: 300px;height: 480px;overflow: scroll;" >
		
		<%		
			if(imageDTOs!=null){
		%>
			<script>
				document.getElementById("check_all").disabled=false;
				document.getElementById("delete_id").disabled=false;
				
				function selectAll(thiz){
					var x = thiz.checked;
					var max = document.getElementById("max_id").value;
					
					if(x){						
						for(var i=1;i<=max;i++){							
							document.getElementById("checkbox_id"+i).checked = true;							
						}	
					}else{
						for(var i=1;i<=max;i++){
							document.getElementById("checkbox_id"+i).checked = false;
						}						
					}				
				}
				function desectCheck(thiz){
					var x = thiz.checked;
					if(!x){
						document.getElementById("check_all").checked = false;
					}
				}
				function openGallery(){
					
				}
			</script>
		<%
				int count=1;
				out.println("<table width='100%'>");
				for(ImageDTO imageDTO:imageDTOs){
					if(count%2==1)
						out.println("<tr>");
		%>
			<div  class="imageclass" align="center">	
				<a class="group2" href="../../<%=imageDTO.getFpath()%>" title="Me and my grandfather on the Ohoopee">			
					<img onclick="openGallery();" style="width: 120px;height: 110px" alt="" src="../../<%=imageDTO.getFpath()%>"/>
				</a>
				<input onchange="desectCheck(this)" class="checkbox_class" id="checkbox_id<%=count %>" type="checkbox" name="id<%=count %>" value="<%=imageDTO.getId()%>"/>
				<input type="hidden" name="image<%=count %>" value="<%=imageDTO.getFpath()%>"/>
				<b style="font-size: 12px;color: white;"><%=TrackerDate.getInstance().getTimeFormat(Long.parseLong(imageDTO.getC_time())) %></b>
			</div>
		
		<%			if(count%2==1)
						out.println("</tr>");
					count++;
				}
				out.println("<input type='hidden' name='maxcount' id='max_id' value='"+(count-1)+"'/>");
				out.println("</table>");
			}
		%>
		
	</div>
	</form>
</body>
</html>