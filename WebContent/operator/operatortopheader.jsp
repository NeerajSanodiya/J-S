<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@page import="java.io.File" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>JS Informatics</title>
		<meta name="keywords" content="java, Android, PHP, Software, Programming,JS Informatics, JEE, Struts, Spring, Hibernate" />
		<meta name="description" content="" />
		<link href="../templatemo_style.css" rel="stylesheet" type="text/css" />
		<link href="../css/jquery.ennui.contentslider.css" rel="stylesheet" type="text/css" media="screen,projection" />
	</head>
	<body>
	<div id="templatemo_wrapper_outer">
		<div id="templatemo_wrapper">
    		<div id="templatemo_header">
				<div id="site_title">
					<h1><a href="http://www.jsinformatics.com">J S Informatics<span>Passion to Excel...</span></a></h1>
				</div> <!-- end of site_title -->
				
				<ul id="social_box">
					<li><a href="https://www.facebook.com/pages/J-S-Informatics/139323982806197"><img src="../images/facebook.png" alt="facebook" /></a></li>
					<li><a href="#"><img src="../images/twitter.png" alt="twitter" /></a></li>
					<li><a href="#"><img src="../images/linkedin.png" alt="linkin" /></a></li>
					<li><a href="https://maps.google.co.in/maps?f=q&source=s_q&hl=en&geocode=&authuser=0&q=Trade%20Center,%20South%20Tukoganj,%20Tukoganj,%20Indore,%20MP&aq=&vps=3&jsv=470c&sll=22.725588,75.865818&sspn=0.00147,0.002411&vpsrc=6&ie=UTF8&oi=georefine&ct=clnk&cd=1&spell=1"><img src="../images/gmap-icon.png" alt="linkin" /></a></li>
					<p style="text-align: right; color: white;">+91-731-4263751</p>
				</ul>
				<div class="cleaner"></div>
			</div>
        	<div id="templatemo_menu">
            	<ul>
            		<%
            			String requestedPagePath=request.getServletPath();
            			String requestedPageName=new File(requestedPagePath).getName();
            			String homeClass="class=\"current\"";
            			String enquiryClass="";
            			String registrationClass="";
            			String paymentClass="";
            			
            			if(requestedPageName.equalsIgnoreCase("home.jsp")){
            				homeClass="class=\"current\"";
            				enquiryClass="";
            				registrationClass="";   
            				paymentClass="";
            			}
            			else if(requestedPageName.equalsIgnoreCase("enquiry.jsp")||requestedPageName.equalsIgnoreCase("enq_aca_project.jsp")||requestedPageName.equalsIgnoreCase("enquiry_visitor.jsp")){
            				homeClass="";
            				enquiryClass="class=\"current\"";
            				registrationClass="";    
            				paymentClass="";
            			}
            			else if(requestedPageName.equalsIgnoreCase("registration.jsp")){
            				homeClass="";
            				enquiryClass="";
            				registrationClass="class=\"current\"";    
            				paymentClass="";
            			}
            			else if(requestedPageName.equalsIgnoreCase("payment.jsp")){
            				homeClass="";
            				enquiryClass="";
            				registrationClass="";  
            				paymentClass="class=\"current\"";
            			}
            		%>               	
                	
                	<li><a href="home.jsp" <%=homeClass%>>Home</a></li>
                	<li><a href="enquiry.jsp" <%=enquiryClass%> >Enquiry</a></li>
                	<li><a href="registration.jsp" <%=registrationClass%> >Registration</a></li>
                	<li><a href="#" id="id_show_payment_dialog" <%=paymentClass%> >Payment</a></li>
                	<li><a href="#" id="id_show_changePassword_dialog">Settings</a></li>
					<li><a href="../common/logout.jsp">Logout</a></li>
                	                	
            	</ul>    	
        	</div> <!-- end of templatemo_menu -->
    	
