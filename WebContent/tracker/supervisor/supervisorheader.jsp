<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@page import="java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>JS Informatics</title>
<meta name="keywords"
	content="java, Android, PHP, Software, Programming,JS Informatics, JEE, Struts, Spring, Hibernate" />
<meta name="description" content="" />
<link href="../../templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="../../css/jquery.ennui.contentslider.css" rel="stylesheet"
	type="text/css" media="screen,projection" />

<!-- date picker -->
<link rel="stylesheet" href="css/jquery-ui.css" rel="stylesheet"
	type="text/css" />
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>
<!-- date picker -->

<style type="text/css">
body {
	font-family: Tahoma, Geneva, sans-serif;
}

.popupBox {
	display: none;
	position: fixed;
	width: 40%;
	left: 30%;
	top: 15%;
	background: url(opaqueDark.png);
	margin: 0px auto;
	z-index: 2000;
	border-radius: 8px;
	padding: 10px;
}

.popupBox>.boxheader {
	background: #6D84B4;
	border: #3B5998 1px solid;
	border-bottom: none;
	padding: 6px;
	color: #FFF;
	font-weight: bold;
}

.popupBox>.boxbody {
	background: #FFF;
	border: #666 1px solid;
	border-top: none;
	border-bottom: none;
	padding: 10px;
	color: #000;
	font-size: 22px;
}

.popupBox>.boxfooter {
	background: #F2F2F2;
	border: #666 1px solid;
	border-top: #CCC 1px solid;
	padding: 6px;
	color: #333;
	font-size: 12px;
	text-align: right;
}

/* fd */
#dialog-overlay { /* set it to fill the whil screen */
	width: 100%;
	height: 100%;
	/* transparency for different browsers */
	filter: alpha(opacity = 50);
	-moz-opacity: 0.5;
	-khtml-opacity: 0.5;
	opacity: 0.5;
	background: #000;
	/* make sure it appear behind the dialog box but above everything else */
	position: absolute;
	top: 0;
	left: 0;
	z-index: 3000;
	/* hide it by default */
	display: none;
}

#dialog-box { /* css3 drop shadow */
	-webkit-box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
	-moz-box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
	/* css3 border radius */
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	background: #eee;
	/* styling of the dialog box, i have a fixed dimension for this demo */
	width: 328px;
	/* make sure it has the highest z-index */
	position: absolute;
	z-index: 5000;
	/* hide it by default */
	display: none;
}

#dialog-box .dialog-content { /* style the content */
	text-align: left;
	padding: 10px;
	margin: 13px;
	color: #666;
	font-family: arial;
	font-size: 11px;
}

a.button { /* styles for button */
	margin: 10px auto 0 auto;
	text-align: center;
	display: block;
	width: 50px;
	padding: 5px 10px 6px;
	color: #fff;
	text-decoration: none;
	font-weight: bold;
	line-height: 1;
	/* button color */
	background-color: #e33100;
	/* css3 implementation :) */
	/* rounded corner */
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	/* drop shadow */
	-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.5);
	/* text shaow */
	text-shadow: 0 -1px 1px rgba(0, 0, 0, 0.25);
	border-bottom: 1px solid rgba(0, 0, 0, 0.25);
	position: relative;
	cursor: pointer;
}

a.button:hover {
	background-color: #c33100;
}
/* extra styling */
#dialog-box .dialog-content p {
	font-weight: 700;
	margin: 0;
}

#dialog-box .dialog-content ul {
	margin: 10px 0 10px 20px;
	padding: 0;
	height: 50px;
}
</style>
</head>
<body>
	<div class="popupBox" id="popbox1">
		<div class="boxheader">Message</div>
		<div class="boxbody" id="message_block_div">Your Booking is
			successful</div>
		<div class="boxfooter">
			<button onmousedown="togglePopup('popbox1')">Ok</button>
		</div>
	</div>
	<div id="dialog-overlay"></div>
	<div id="dialog-box">
		<div class="dialog-content">
			<div id="dialog-message"></div>
			<a href="#" class="button">Close</a>
			
		</div>
	</div>
	<div id="templatemo_wrapper_outer">
		<div id="templatemo_wrapper">
			<div id="templatemo_header">
				<div id="site_title">
					<h1>
						<a href="http://www.jsinformatics.com">J S Informatics<span>Passion
								to Excel...</span> </a>
					</h1>
				</div>
				<!-- end of site_title -->

				<ul id="social_box">
					<li><a
						href="https://www.facebook.com/pages/J-S-Informatics/139323982806197"><img
							src="../../images/facebook.png" alt="facebook" /> </a>
					</li>
					<li><a href="#"><img src="../../images/twitter.png"
							alt="twitter" /> </a>
					</li>
					<li><a href="#"><img src="../../images/linkedin.png"
							alt="linkin" /> </a>
					</li>
					<li><a
						href="https://maps.google.co.in/maps?f=q&source=s_q&hl=en&geocode=&authuser=0&q=Trade%20Center,%20South%20Tukoganj,%20Tukoganj,%20Indore,%20MP&aq=&vps=3&jsv=470c&sll=22.725588,75.865818&sspn=0.00147,0.002411&vpsrc=6&ie=UTF8&oi=georefine&ct=clnk&cd=1&spell=1"><img
							src="../../images/gmap-icon.png" alt="linkin" /> </a>
					</li>
					<p style="text-align: right; color: white;">+91-731-4263751</p>
				</ul>
				<div class="cleaner"></div>
			</div>
			<div id="templatemo_menu">
				<ul>
					<%
						String requestedPagePath = request.getServletPath();
						String requestedPageName = new File(requestedPagePath).getName();
						String homeClass = "class=\"current\"";
						String logsClass = "";
						String employeClass = "";

						if (requestedPageName.equalsIgnoreCase("home.jsp")) {
							homeClass = "class=\"current\"";
							logsClass = "";
							employeClass = "";

						} else if (requestedPageName.equalsIgnoreCase("logs.jsp")) {
							homeClass = "";
							logsClass = "class=\"current\"";
							employeClass = "";

						} else if (requestedPageName.equalsIgnoreCase("employee.jsp")) {
							homeClass = "";
							logsClass = "";
							employeClass = "class=\"current\"";

						}
					%>

					<li><a href="home.jsp" <%=homeClass%>>Home</a>
					</li>
					<li><a href="logs.jsp" <%=logsClass%>>Logs</a>
					</li>
					<li><a href="employee.jsp" <%=employeClass%>>Employee</a>
					</li>
					<li><a href="#" id="id_show_changePassword_dialog">Settings</a>
					</li>
					<li><a href="../../common/logout.jsp">Logout</a>
					</li>

				</ul>
			</div>