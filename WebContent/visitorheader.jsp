<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>J S Informatics</title>
		<meta name="keywords" content="glossy box, web design, colorful background, free templates, website templates, CSS, HTML" />
		<meta name="description" content="Glossy Box | free website template with a colorful background" />
		<script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>
		<script src="js/myalert/jquery.ui.draggable.js" type="text/javascript"></script>		
		<script src="js/myalert/jquery.alerts.js" type="text/javascript"></script>
		<link href="js/myalert/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
		
		<style type="text/css">
        .web_dialog_overlay
        {
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            height: 100%;
            width: 100%;
            margin: 0;
            padding: 0;
            background: #000000;
            opacity: .15;
            filter: alpha(opacity=15);
            -moz-opacity: .15;
            z-index: 101;
            display: none;
        }
        .web_dialog
        {
            display: none;
            position: fixed;
            width: 380px;
            height: 200px;
            top: 50%;
            left: 50%;
            margin-left: -190px;
            margin-top: -100px;
            background-color: #333333;
            border: 2px solid #336699;
            padding: 0px;
            z-index: 102;
            font-family: Verdana;
            font-size: 10pt;
        }
        .web_dialog_title
        {
            border-bottom: solid 2px #336699;
            background-color: #336699;
            padding: 4px;
            color: White;
            font-weight:bold;
        }
        .web_dialog_title a
        {
            color: White;
            text-decoration: none;
        }
        .align_right
        {
            text-align: right;
        }
    </style>
		
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#btnClose").click(function (e)
			{
				HideDialog();
			    e.preventDefault();
			});
			$("#mymsg").click(function (e)
			{
				HideDialog();
			    e.preventDefault();
			});
		$('a.login-window').click(function() {
		
                //Getting the variable's value from a link 
		var loginBox = $(this).attr('href');

		//Fade in the Popup
		$(loginBox).fadeIn(300);
		
		//Set the center alignment padding + border see css style
		var popMargTop = ($(loginBox).height() + 24) / 2; 
		var popMargLeft = ($(loginBox).width() + 24) / 2; 
		
		$(loginBox).css({ 
			'margin-top' : -popMargTop,
			'margin-left' : -popMargLeft
		});
		
		// Add the mask to body
		$('body').append('<div id="mask"></div>');
		$('#mask').fadeIn(300);
		
		return false;
	});
	
	$("#id_loginButton").click(function (e)
    {
		var username=document.getElementById('username');
		var password=document.getElementById('password');
		

		if(username.value.length==0){						
			username.style.borderColor = 'red';
			alert("Please enter username");
			username.focus();
			return false;
		}
		else if(password.value.length==0){
			password.style.borderColor = 'red';
			alert("Please enter password");
			password.focus();
			return false;
		}else{	    
    		$('#id_loginForm').submit();
		}                            
         
    });	
	
	// When clicking on the button close or the mask layer the popup closed
	$('a.close, #mask').live('click', function() { 
	  $('#mask , .login-popup').fadeOut(300 , function() {
		$('#mask').remove();  
	}); 
	return false;
	});
});
			
			function ShowDialog(modal)
	        {
	            $("#overlay").show();
	            $("#dialog").fadeIn(300);

	            if (modal)
	            {
	                $("#overlay").unbind("click");
	            }
	            else
	            {
	                $("#overlay").click(function (e)
	                {
	                    HideDialog();
	                });
	            }
	        }
	        function HideDialog()
	        {
	            $("#overlay").hide();
	            $("#dialog").fadeOut(300);
	        } 
			
		</script>
		
		<style type="text/css">
		/* Mask for background, by default is not display */
#mask {
	display: none;
	background: #000; 
	position: fixed; left: 0; top: 0; 
	z-index: 10;
	width: 100%; height: 100%;
	opacity: 0.8;
	z-index: 999;
}

/* You can customize to your needs  */
.login-popup{
	display:none;
	background: #333;
	padding: 10px; 	
	border: 2px solid #ddd;
	float: left;
	font-size: 1.2em;
	position: fixed;
	top: 50%; left: 50%;
	z-index: 99999;
	box-shadow: 0px 0px 20px #999; /* CSS3 */
        -moz-box-shadow: 0px 0px 20px #999; /* Firefox */
        -webkit-box-shadow: 0px 0px 20px #999; /* Safari, Chrome */
	border-radius:3px 3px 3px 3px;
        -moz-border-radius: 3px; /* Firefox */
        -webkit-border-radius: 3px; /* Safari, Chrome */
}

img.btn_close { Position the close button
	float: right; 
	margin: -28px -28px 0 0;
}

fieldset { 
	border:none; 
}

form.signin .textbox label { 
	display:block; 
	padding-bottom:7px; 
}

form.signin .textbox span { 
	display:block;
}

form.signin p, form.signin span { 
	color:#999; 
	font-size:11px; 
	line-height:18px;
} 

form.signin .textbox input { 
	background:#666666; 
	border-bottom:1px solid #333;
	border-left:1px solid #000;
	border-right:1px solid #333;
	border-top:1px solid #000;
	color:#fff; 
        border-radius: 3px 3px 3px 3px;
	-moz-border-radius: 3px;
        -webkit-border-radius: 3px;
	font:13px Arial, Helvetica, sans-serif;
	padding:6px 6px 4px;
	width:200px;
}

form.signin input:-moz-placeholder { color:#bbb; text-shadow:0 0 2px #000; }
form.signin input::-webkit-input-placeholder { color:#bbb; text-shadow:0 0 2px #000;  }

.button { 
	background: -moz-linear-gradient(center top, #f3f3f3, #dddddd);
	background: -webkit-gradient(linear, left top, left bottom, from(#f3f3f3), to(#dddddd));
	background:  -o-linear-gradient(top, #f3f3f3, #dddddd);
        filter: progid:DXImageTransform.Microsoft.gradient(startColorStr='#f3f3f3', EndColorStr='#dddddd');
	border-color:#000; 
	border-width:1px;
        border-radius:4px 4px 4px 4px;
	-moz-border-radius: 4px;
        -webkit-border-radius: 4px;
	color:#333;
	cursor:pointer;
	display:inline-block;
	padding:6px 6px 4px;
	margin-top:10px;
	font:12px; 
	width:214px;
}
.button:hover { background:#ddd; }
		</style>
	</head>
	<body>		
		<div id="login-box" class="login-popup" title="Login">
			<a href="#" class="close"><img src="images/close_pop.png" class="btn_close" title="Close Window" alt="Close" /></a>
			<form  method="post" class="signin" action="common/loginvarify.jsp" id="id_loginForm" name="loginForm">
                <fieldset class="textbox">
                <%
                	String msg=(String)request.getSession(true).getAttribute("LOGINMSG");
                    if(msg!=null){%>
                    <input type="hidden" id="id_loging_msg" value="<%=msg %>"/>
                    	<script type="text/javascript">
                    		//alert("Invalid username or password");
                    		//jAlert('This is a custom alert box', 'Alert Dialog');
                    		$(function() {
								ShowDialog();			
		  					});
                    	</script>
                    	<%
                    	//out.println("<h6 style='color: #ff0000;'>"+msg+"</h6>");
                    	request.getSession(true).removeAttribute("LOGINMSG");
                    }
                %>
            	<label class="username">
                <span>Username</span>
                <input id="username" name="unm" value="" type="text" autocomplete="on" placeholder="Username">
                </label>
                <label class="password">
                <span>Password</span>
                <input id="password" name="up" value="" type="password" placeholder="Password">
                </label>
                <button class="submit button" id="id_loginButton" >Sign in</button>
                <p>
                <a class="forgot" href="#">Forgot your password?</a>
                </p>        
                </fieldset>
          </form>
		</div>
		<div id="dialog" class="web_dialog">
		<form action="#" method="post" id="mymsg" name="mymsg">
        <table style="width: 100%; border: 0px;" cellpadding="3" cellspacing="0">
            <tr>
                <td class="web_dialog_title">Login Message</td>
                <td class="web_dialog_title align_right">
                    <a href="#" id="btnClose">Close</a>
                </td>
            </tr>
       	</table>
       	<table bgcolor='#333333' width="100%">
       		<tr>
       			<td width="1000%" align="center">
       				&nbsp;
       			</td>       			
       		</tr>  
       		<tr>
       			<td width="1000%" align="center">
       				&nbsp;
       			</td>       			
       		</tr>      		      		  
       		<tr>
       			<td align="center">
       				<h4 style="color: #ff0000;">
       				<script type="text/javascript">  
       				document.write(document.getElementById("id_loging_msg").value);
						
                   	</script>
       				
       				</h4> 
       			</td>       			
       		</tr>
       		<tr>
       			<td width="1000%" align="center">
       				&nbsp;
       			</td>       			
       		</tr>
       		
            <tr>
                <td align="center">
                	<input type="submit" value="&nbsp;&nbsp;&nbsp;Ok&nbsp;&nbsp;&nbsp;" id="btnSubmit"/>                    
                </td>
            </tr>            
        </table>
        </form>
    </div>
		
	</body>
</html>
	
	


 