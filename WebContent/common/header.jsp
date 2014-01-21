<%@page import="com.js.msg.MyMessage;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script src="../js/jquery-1.9.0.js"></script>
		<script src="../js/myalert/jquery.ui.draggable.js" type="text/javascript"></script>		
		<script src="../js/myalert/jquery.alerts.js" type="text/javascript"></script>
		<link href="../js/myalert/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
		<script>
				
			function printDiv(divId) {
    				window.frames["print_frame"].document.body.innerHTML=document.getElementById(divId).innerHTML;
    				window.frames["print_frame"].window.focus();
    				window.frames["print_frame"].window.print();
			}
		</script>
		    
		    
		    
		    
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

        $(document).ready(function ()
        {
            
        	
        	$("#id_ok_successMessageDialog").click(function (e)
            {
                	HideSuccessMessageDialog();
                    e.preventDefault();
            	
            });
        	$("#id_ok_errorMessageDialog").click(function (e)
            {
        		HideErrorMessageDialog();
                e.preventDefault();
                    	
            });
        	$("#id_close_successMessageDialog").click(function (e)
            {
            	HideSuccessMessageDialog();
                e.preventDefault();
           	});
            $("#id_close_errorMessageDialog").click(function (e)
            {
            	HideErrorMessageDialog();
                e.preventDefault();
            });
            $("#id_show_payment_dialog").click(function (e)
            {
                ShowDialog(true);
                e.preventDefault();
            });

            $("#btnClose").click(function (e)
            {
                HideDialog();
                e.preventDefault();
            });
            
            
            $("#btnSubmit").click(function (e)
            {
            	var dialog_source=document.getElementById('id_dialog_source').value;
            	if(dialog_source=='Select'){                	
                	alert("Please select payment source");
                	return false;
               	}else{
            		$('#searchforpayment').submit();                            
                	HideDialog();
               	}                
            });
			
            $("#id_show_changePassword_dialog").click(function (e)
           	{
            	ShowChangePasswordDialog(true);
                e.preventDefault();
          	});

            $("#changePasswordClose").click(function (e)
             {
            		HideChangePasswordDialog();
             		e.preventDefault();
             });
                       
            $('#id_changePasswordSubmit').click(function() {
                          	
					var dialogCurrentPassword=document.getElementById('id_dialog_current_password');
					var dialogNewPassword=document.getElementById('id_dialog_new_password');
					var dialogRePassword=document.getElementById('id_dialog_re_password');

					if(dialogCurrentPassword.value.length==0){						
						dialogCurrentPassword.style.borderColor = 'red';
						alert("Please enter current password");
						dialogCurrentPassword.focus();
						return false;
					}
					else if(dialogNewPassword.value.length==0){
						dialogNewPassword.style.borderColor = 'red';
						alert("Please enter new password");
						dialogNewPassword.focus();
						return false;
					}
					else if(dialogRePassword.value.length==0){
						dialogRePassword.style.borderColor = 'red';
						alert("Please enter Re - password");
						dialogRePassword.focus();
						return false;
					}
					else if(dialogNewPassword.value!=dialogRePassword.value){
						dialogNewPassword.style.borderColor = 'red';
						dialogRePassword.style.borderColor = 'red';						
						alert("Password and Re - password not matched");
						dialogRePassword.focus();
						return false;
					}else{
						changePassword();
						HideChangePasswordDialog();				    					     			
					}           			             
             });                    
            
        });
        function changePassword() {            
            $.post('../common/changepassword.jsp', $('#id_changePasswordForm').serialize()).success(
        		function(response) {
        			var res=mytrimExtraSpaces(response);				
        			alert(res);   
        			HideChangePasswordDialog();	     			
        		}).error(function(e) {
        			alert(e);
        		}
        	);	
        }
	
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
        function closemydialog(){
        	HideSuccessMessageDialog();
        }
        function printPreviousSlip(id){
        	var val = new Array();
			val[0] = document.getElementById("previous_paymentdate"+id).value;
			val[1] = document.getElementById("previous_paymenttime"+id).value;;
			val[2] = document.getElementById("previous_myid"+id).value;
			val[3] = document.getElementById("previous_paymentid"+id).value;
			val[4] = document.getElementById("previous_source"+id).value;
			val[5] = document.getElementById("previous_cdetail"+id).value;
			val[6] = document.getElementById("previous_id_payment_mode"+id).value;
			val[7] = document.getElementById("previous_id_candidateName"+id).value;
			val[8] = document.getElementById("previous_id_receiverName"+id).value;
			val[9] = document.getElementById("previous_my_id_amount"+id).value;

			document.getElementById("id_c_slip_date").innerHTML="<strong>Payment Date :</strong>"+val[0];
			document.getElementById("id_c_slip_time").innerHTML="<strong>Print Date : </strong>"+val[1];				
			document.getElementById("id_c_slip_candidateid").innerHTML="<strong>Candidate Id :</strong> "+val[2];
			document.getElementById("id_c_slip_paymentid").innerHTML="<strong>Payment Id : </strong>"+val[3];				
			document.getElementById("id_c_slip_source").innerHTML=val[4];
			document.getElementById("id_c_slip_paymentfor").innerHTML=val[5];
			document.getElementById("id_c_slip_paymentmode").innerHTML=val[6];
			document.getElementById("id_c_slip_candidatename").innerHTML=val[7];
			document.getElementById("id_c_slip_receivedby").innerHTML=val[8];
			document.getElementById("id_c_slip_amount").innerHTML=val[9];

			document.getElementById("id_b_slip_date").innerHTML="<strong>Payment Date :</strong>"+val[0];
			document.getElementById("id_b_slip_time").innerHTML="<strong>Print Date : </strong>"+val[1];				
			document.getElementById("id_b_slip_candidateid").innerHTML="<strong>Candidate Id :</strong> ";
			document.getElementById("id_b_slip_candidateid_val").innerHTML=""+val[2];				
			document.getElementById("id_b_slip_source").innerHTML=val[4];
			document.getElementById("id_b_slip_paymentfor").innerHTML=val[5];
			document.getElementById("id_b_slip_paymentmode").innerHTML=val[6];
			document.getElementById("id_b_slip_candidatename").innerHTML=val[7];
			document.getElementById("id_b_slip_receivedby").innerHTML=val[8];
			document.getElementById("id_b_slip_amount").innerHTML=val[9];


			
        	openPrintDialog();	
       	}
        function openPrintDialog(){
            
        	printDiv('id_div_paymentSlip'); 
        	HideSuccessMessageDialog();
        } 
        /*$("#id_printButton").click(function (e)
       	{
           	
        	printDiv('id_div_paymentSlip');            
        });*/
        function ShowSuccessMessageDialog(title,message,val)
        {
			//alert("Hi");
        	var mytitle=document.getElementById('id_title_successMessageDialog');        	
			mytitle.innerHTML=title;

			var mymessage=document.getElementById('id_msg_successMessageDialog');
			mymessage.innerHTML="<h4>"+message+"</h4>";

			if(message.indexOf("PAYMENT")!=-1){
				var div_to_add_printButton=document.getElementById("id_div_to_add_printButton");
				div_to_add_printButton.innerHTML="<input type='button' value='&nbsp;Print&nbsp;' onclick='openPrintDialog();' id='id_printButton'/>";

				document.getElementById("id_c_slip_date").innerHTML="<strong>Date :</strong>"+val[0];
				document.getElementById("id_c_slip_time").innerHTML="<strong>Time : </strong>"+val[1];				
				document.getElementById("id_c_slip_candidateid").innerHTML="<strong>Candidate Id :</strong> "+val[2];
				document.getElementById("id_c_slip_paymentid").innerHTML="<strong>Payment Id : </strong>"+val[3];				
				document.getElementById("id_c_slip_source").innerHTML=val[4];
				document.getElementById("id_c_slip_paymentfor").innerHTML=val[5];
				document.getElementById("id_c_slip_paymentmode").innerHTML=val[6];
				document.getElementById("id_c_slip_candidatename").innerHTML=val[7];
				document.getElementById("id_c_slip_receivedby").innerHTML=val[8];
				document.getElementById("id_c_slip_amount").innerHTML=val[9];

				document.getElementById("id_b_slip_date").innerHTML="<strong>Date :</strong>"+val[0];
				document.getElementById("id_b_slip_time").innerHTML="<strong>Time : </strong>"+val[1];				
				document.getElementById("id_b_slip_candidateid").innerHTML="<strong>Candidate Id :</strong> ";
				document.getElementById("id_b_slip_candidateid_val").innerHTML=""+val[2];				
				document.getElementById("id_b_slip_source").innerHTML=val[4];
				document.getElementById("id_b_slip_paymentfor").innerHTML=val[5];
				document.getElementById("id_b_slip_paymentmode").innerHTML=val[6];
				document.getElementById("id_b_slip_candidatename").innerHTML=val[7];
				document.getElementById("id_b_slip_receivedby").innerHTML=val[8];
				document.getElementById("id_b_slip_amount").innerHTML=val[9];
							
				
			}else{
				var div_to_add_printButton=document.getElementById("id_div_to_add_printButton");
				div_to_add_printButton.innerHTML="<input type='button' value='&nbsp;Close&nbsp;' onclick='closemydialog();' id='id_closedialog'/>";
			}		
            $("#overlay").show();
            $("#id_maindiv_sussessMessageDialog").fadeIn(300);    		
	           
           	$("#overlay").click(function (e)
           	{
           		HideSuccessMessageDialog();
           	});           
        }
        function HideSuccessMessageDialog()
        {
            $("#overlay").hide();
            $("#id_maindiv_sussessMessageDialog").fadeOut(300);
        } 
        function ShowErrorMessageDialog(title,message)
        {
            $("#overlay").show();
            $("#id_maindiv_errorMessageDialog").fadeIn(300);

    		var mytitle=document.getElementById('id_title_errorMessageDialog');
    		mytitle.innerHTML=title;

			var mymessage=document.getElementById('id_msg_errorMessageDialog');
			mymessage.innerHTML="<h4 style=\"color: #ff0000;\">"+message+"</h4>";
	           
           	$("#overlay").click(function (e)
           	{
           		HideErrorMessageDialog();
           	});           
        }
        function HideErrorMessageDialog()
        {
            $("#overlay").hide();
            $("#id_maindiv_errorMessageDialog").fadeOut(300);
        } 
        function mytrimExtraSpaces (theField){
        	var trimValue = "";	
        	trimValue= theField.toUpperCase();
        	trimValue = trimValue.replace(/\s+/g," ");
        	trimValue = trimValue.replace(/^\s+|\s+$/g,"");
        	return trimValue;	 
        }
        
        function ShowChangePasswordDialog(modal)
        {
            $("#overlay").show();
            $("#dialog_changePassword").fadeIn(300);

            if (modal)
            {
                $("#overlay").unbind("click");
            }
            else
            {
                $("#overlay").click(function (e)
                {
                	HideChangePasswordDialog();
                });
            }
        }

        function HideChangePasswordDialog()
        {
            $("#overlay").hide();
            $("#dialog_changePassword").fadeOut(300);
        } 
        
    </script>


		
	</head>
	<body>
		
		
	<div id="dialog_changePassword" class="web_dialog">
		<form action="#" method="post" id="id_changePasswordForm" name="name_changePasswordForm">
        <table style="width: 100%; border: 0px;" cellpadding="3" cellspacing="0">
            <tr>
                <td class="web_dialog_title">Change Password</td>
                <td class="web_dialog_title align_right">
                    <a href="#" id="changePasswordClose" style="color: #FFFFFF;">Close</a>
                </td>
            </tr>
       	</table>
       	<table bgcolor='#333333' width="100%">
       		<tr>
       			<td width="40%">
       				&nbsp;
       			</td>
       			<td>
       				&nbsp; 
       			</td>
       		</tr>  
       		<tr>
       			<td align="right">
       				Current Password : 
       			</td>
       			<td align="center">
       				<input type="password" id="id_dialog_current_password" name="dialog_current_password" size="20" style="width: 140px;"/>	      				 
       			</td>
       		</tr>       		  
       		<tr>
       			<td align="right">
       				New Password : 
       			</td>
       			<td align="center">
       				<input type="password" id="id_dialog_new_password" name="dialog_new_password" size="20" style="width: 140px;"/> 
       			</td>
       		</tr>
       		<tr>
       			<td align="right">
       				Re - Password : 
       			</td>
       			<td align="center">
       				<input type="password" id="id_dialog_re_password" name="dialog_re_password" size="20" style="width: 140px;"/> 
       			</td>
       		</tr>  
            <tr>
                <td colspan="2">
                	<input type="button" value="Save" id="id_changePasswordSubmit" style="float: right; display: block; width: 100px; height: 26px; margin-top: 10px; margin-right:10px; padding-top: 4px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(../images/templatemo_btn.png) no-repeat;"/>                    
                </td>
            </tr>            
        </table>
        </form>
    </div>
	
	<div id="dialog" class="web_dialog">
		<form action="../<%=request.getSession(false).getAttribute("USERLEVEL")%>/searchforpayment.jsp" method="post" id="searchforpayment" name="searchforpayment">
        <table style="width: 100%; border: 0px;" cellpadding="3" cellspacing="0">
            <tr>
                <td class="web_dialog_title">Payment</td>
                <td class="web_dialog_title align_right">
                    <a href="#" id="btnClose" style="color: #FFFFFF;">Close</a>
                </td>
            </tr>
       	</table>
       	<table bgcolor='#333333' width="100%">
       		<tr>
       			<td width="30%">
       				&nbsp;
       			</td>
       			<td>
       				&nbsp; 
       			</td>
       		</tr>  
       		<tr>
       			<td align="right">
       				Source : 
       			</td>
       			<td align="center">
       				<select name="dialog_source" id="id_dialog_source" style="width: 142px;">
       					<option value="Select">Select</option>
       					<option value="Live Project">Live Project</option>
       					<option value="Academic Project">Academic Project</option>
       					<option value="Training">Training</option>
       					<option value="Certificate">Certificate</option>
       					<option value="Experience">Experience</option>
       				</select>       				 
       			</td>
       		</tr>       		  
       		<tr>
       			<td align="right">
       				Full Name : 
       			</td>
       			<td align="center">
       				<input type="text" id="id_dialog_name" name="dialog_name" size="20" style="width: 140px;"/> 
       			</td>
       		</tr>
       		<tr>
       			<td align="right">
       				Code : 
       			</td>
       			<td align="center">
       				<input type="text" id="id_dialog_code" name="dialog_code" size="20" style="width: 140px;"/> 
       			</td>
       		</tr>  
            <tr>
                <td colspan="2">
                	<input type="submit" value="Search" id="btnSubmit" style="float: right; display: block; width: 100px; height: 26px; margin-top: 10px; margin-right:10px; padding-top: 4px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(../images/templatemo_btn.png) no-repeat;"/>                    
                </td>
            </tr>            
        </table>
        </form>
    </div>
	<div id="id_maindiv_sussessMessageDialog" class="web_dialog">
		<form action="#" method="post" id="mymsg" name="mymsg">
        <table style="width: 100%; border: 0px;" cellpadding="3" cellspacing="0">
            <tr>
                <td class="web_dialog_title" >
                	<div id="id_title_successMessageDialog" class="web_dialog_title">
                		J.S.I Message
                	</div>
                </td>
                
                <td class="web_dialog_title align_right">
                    <a href="#" id="id_close_successMessageDialog" style="color: #FFFFFF;">Close</a>
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
       				<div id="id_msg_successMessageDialog">
       					<h4>
       						Invalid username or password
       					</h4>
       				</div>       				 
       			</td>       			
       		</tr>
       		<tr>
       			<td width="1000%" align="center">
       				&nbsp;
       			</td>       			
       		</tr>
       		
            <tr>            	
                <td align="center" width="50%">
               		<table width="100%">
            			<tr>
            				<td width="45%" align="right">
            					<input type="submit" value="&nbsp;&nbsp;&nbsp;Ok&nbsp;&nbsp;&nbsp;" id="id_ok_successMessageDialog"/>	
            				</td>
            				<td width="10%">
            					&nbsp;
            				</td>
            				<td align="left" width="45%">
                				<div id="id_div_to_add_printButton">
                			
                				</div>
                			</td>
            			</tr>
            		</table>               		       	                    
                </td>                
            </tr>            
        </table>
        </form>
    </div>
		
	<div id="id_maindiv_errorMessageDialog" class="web_dialog">
		<form action="#" method="post" id="mymsg" name="mymsg">
        <table style="width: 100%; border: 0px;" cellpadding="3" cellspacing="0">
            <tr>
                <td class="web_dialog_title">
                	<div id="id_title_errorMessageDialog" class="web_dialog_title">
                		J.S.I Message
                	</div>                	
                </td>
                <td class="web_dialog_title align_right">
                    <a href="#" id="id_close_errorMessageDialog" style="color: #FFFFFF;">Close</a>
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
       				<div id="id_msg_errorMessageDialog">
       					<h4 style="color: #ff0000;">
       						Invalid username or password
       					</h4> 
       				</div>       				
       			</td>       			
       		</tr>
       		<tr>
       			<td width="1000%" align="center">
       				&nbsp;
       			</td>       			
       		</tr>
       		
            <tr>
                <td align="center">
                	<input type="submit" value="&nbsp;&nbsp;&nbsp;Ok&nbsp;&nbsp;&nbsp;" id="id_ok_errorMessageDialog"/>                    
                	
                </td>                
            </tr>            
        </table>
        </form>
    </div>
    
    <div id=id_div_paymentSlip class="web_dialog">
    	
    	
    	<style type="text/css">
<!--
.style1 {
	font-family: "Times New Roman", Times, serif;
	font-size: 2cm;
	font-weight: bold;
}
.style2 {
	font-size: 16px;
	font-weight: bold;
}
.style3 {font-size: 24px}
.style6 {
	font-size: 18px;
	font-weight: bold;
	font-family: "Times New Roman", Times, serif;
}
.style7 {font-size: 12px}
-->
        </style>
    	
    	<%
    		String pageAccessMessage=(String)request.getSession(false).getAttribute("PAGEACCESSMESSAGE");
    		if(pageAccessMessage!=null){
      	%>    			   			
    			<script type="text/javascript">
                	$(function() {
                    	ShowErrorMessageDialog("Permission Message","ACCESS DENIED");		
		  			});
                </script> 			
    		<%
    			request.getSession(false).removeAttribute("PAGEACCESSMESSAGE");
    		}
    	
    	%>
    	
    <table width="600" border="2" align="center" bordercolor="#000000">
      <tr>
        <td height="451" align="center" valign="top"><table width="100%" border="0">
          <tr>
            <td width="31%" rowspan="3"><p><img src="../images/logo.PNG" alt="" width="172" height="67"></p>            </td>
            <td width="69%" valign="top"><div align="right" class="style1 style3">J S Informatics </div></td>
          </tr>
          <tr>
            <td valign="top"><div align="right" class="style7"><strong>Address :</strong> 131-B Trade Center, 18 South Tukogang,Indore 452001 </div></td>
          </tr>
          <tr>
            <td valign="top"><div align="right"><span class="style7"><strong>Phone No:</strong> 0731 - 4263751 <strong>Web:</strong> www.jsinformatics.com</span> </div></td>
          </tr>
          <tr>
            <td colspan="2"><img src="../images/line.PNG" width="600" height="4"></td>
          </tr>
        </table>
         
          <table width="100%" border="0">
            <tr>
              <td width="50%"> <div id="id_c_slip_date"><strong>Date :</strong>27/01/2013</div></td>
              <td width="50%"><div align="right"><div id="id_c_slip_time"><strong>Time : </strong>13:11:12</div> </div></td>
            </tr>
            <tr>
              <td><div id="id_c_slip_candidateid" style="font-size:12px;"><strong>Candidate Id :</strong> 12345 </div></td>
              <td><div align="right"><div id="id_c_slip_paymentid" style="font-size:12px;"><strong>Payment Id : </strong>34567 </div></div></td>
            </tr>
          </table>
          <br/>
          <table width="70%" border="1" align="center">
            <tr>
              <td colspan="2"><div align="center" class="style6">Cash Receipt Boucher </div></td>
            </tr>
            <tr>
              <td width="50%"><div align="right"><strong>Account Title : </strong></div></td>
              <td width="50%"><div id="id_c_slip_source">Training</div></td>
            </tr>
            <tr>
              <td><div align="right"><strong>Detail:</strong></div></td>
              <td><div id="id_c_slip_paymentfor">PHP</div></td>
            </tr>
            <tr>
              <td><div align="right"><strong>Payment Mode : </strong></div></td>
              <td><div id="id_c_slip_paymentmode">Cash</div></td>
            </tr>
            <tr>
              <td><div align="right"><strong>Paying Person : </strong></div></td>
              <td><div id="id_c_slip_candidatename">abc</div></td>
            </tr>
            <tr>
              <td><div align="right"><strong>Receiving Person : </strong></div></td>
              <td><div id="id_c_slip_receivedby">Pras</div></td>
            </tr>
            <tr>
              <td><div align="right"><strong>Amount : </strong></div></td>
              <td><div id="id_c_slip_amount">1000</div></td>
            </tr>
          </table>
          <br/>
          <table width="100%" border="0">
          	<tr>
            	<td width="91%" align="center">
					This is system generated, Signature is not required. Thanks!
            	</td>            
          	</tr>
        </table>      
		  <table width="100%" border="0">
          	<tr>
            	<td width="100%" align="center">
					<img src="../images/android.png" width="62px" height="50px" border="0">
					<img src="../images/iphone.png" width="62px" height="50px" border="0">
					<img src="../images/load.png" width="62px" height="50px" border="0">
					<img src="../images/quality.png" width="62px" height="50px" border="0">
					<img src="../images/test.png" width="62px" height="50px" border="0">
					<img src="../images/Csharp.png" width="62px" height="50px" border="0">
					<img src="../images/java.png" width="62px" height="50px" border="0">
					<img src="../images/mysql.png" width="62px" height="50px" border="0">
					<img src="../images/se.png" width="62px" height="50px" border="0">
            	</td>            
          	</tr>
        </table>      
		</td>
      </tr>
    </table>
		
		<p>&nbsp;</p>
		<br/>
		<table width="600" border="2" align="center" bordercolor="#000000">
      <tr>
        <td height="350" align="center" valign="top"><table width="100%" border="0">
          <tr>
            <td width="31%" rowspan="3"><p><img src="../images/logo.PNG" alt="" width="150" height="50"></p>            </td>
            <td width="69%" valign="top"><div align="right" class="style1 style3">J S Informatics </div></td>
          </tr>
          <tr>
            <td valign="top"><div align="right" class="style2">Passion to Excel </div></td>
          </tr>
          <tr>
            <td valign="top">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="2"><img src="../images/line.PNG" width="600" height="4"></td>
          </tr>
        </table>
         
          <table width="100%" border="0">
            <tr>
              <td width="50%"> <div id="id_b_slip_date"><strong>Date :</strong>27/01/2013</div></td>
              <td width="50%"><div align="right"><div id="id_b_slip_time"><strong>Time : </strong>13:11:12</div> </div></td>
            </tr>
            
            
          </table>
          <br/>
          <table width="85%" border="1" align="center">
            <tr>
              <td colspan="2"><div align="center" class="style6">Cash Receipt Boucher </div></td>
            </tr>
            <tr>
              <td><div id="id_b_slip_candidateid" align="right" style="font-size:12px;"><strong>Candidate Id :</strong> 12345 </div></td>              
              <td><div id="id_b_slip_candidateid_val" style="font-size:12px;"><strong>Candidate Id :</strong> 12345 </div></td>
            </tr>
            <tr>
              <td width="50%"><div align="right" style="font-size:12px;"><strong>Account Title : </strong></div></td>
              <td width="50%"><div id="id_b_slip_source" style="font-size:12px;">Training</div></td>
            </tr>
            <tr>
              <td><div align="right" style="font-size:12px;"><strong>Detail:</strong></div></td>
              <td><div id="id_b_slip_paymentfor" style="font-size:12px;">PHP</div></td>
            </tr>
            <tr>
              <td><div align="right" style="font-size:12px;"><strong>Payment Mode : </strong></div></td>
              <td><div id="id_b_slip_paymentmode" style="font-size:12px;">Cash</div></td>
            </tr>
            <tr>
              <td><div align="right" style="font-size:12px;"><strong>Paying Person : </strong></div></td>
              <td><div id="id_b_slip_candidatename" style="font-size:12px;">abc</div></td>
            </tr>
            <tr>
              <td><div align="right" style="font-size:12px;"><strong>Receiving Person : </strong></div></td>
              <td><div id="id_b_slip_receivedby" style="font-size:12px;">Pras</div></td>
            </tr>
            <tr>
              <td><div align="right" style="font-size:12px;"><strong>Amount : </strong></div></td>
              <td><div id="id_b_slip_amount" style="font-size:12px;">1000</div></td>
            </tr>
          </table>
           <br/>     
		</td>
      </tr>
    </table>	
    
    </div>
    <iframe name=print_frame width=0 height=0 frameborder=0 src=about:blank></iframe>
	</body>
</html>





