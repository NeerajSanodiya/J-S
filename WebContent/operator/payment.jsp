<%@include file="../common/chk.jsp" %>
<%@page import="com.js.controller.EnquiryController"%>
<%@page import="java.util.*" %>
<%@page import="com.js.dto.*" %>
<%@page import="com.js.service.*" %>
<%@page import="com.js.msg.*" %>
<%@include file="operatortopheader.jsp" %>
<%@include file="../common/header.jsp" %>


<link href="../templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="../css/jquery.ennui.contentslider.css" rel="stylesheet" type="text/css" media="screen,projection" />
<script type="text/javascript" src="../js/enquiry.js"></script>
<script type="text/javascript" src="../js/datepickr.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="../js/searchinq.js"></script>
<script type="text/javascript" src="../js/jquery.timepicker.js"></script>
<link rel="stylesheet" type="text/css" href="../js/jquery.timepicker.css" />
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>



<script type="text/javascript">
$(document).ready(function(){
	$("#myForm").submit(function(){

		var search_enquiry_fullname=document.getElementById('id_search_enquiry_fullname');
		var search_enquiry_college=document.getElementById('id_search_enquiry_college');
		var search_enquiry_course=document.getElementById('id_search_enquiry_course');
		var search_enquiry_qualification=document.getElementById('id_search_enquiry_qualification');
		var search_enquiry_contactno=document.getElementById('id_search_enquiry_contactno');
		var search_start_date_doj=document.getElementById('id_search_start_date_doj');
		var search_end_date_doj=document.getElementById('id_search_end_date_doj');
		var search_enquiry_reference_name=document.getElementById('id_search_enquiry_reference_name');
		var search_start_date=document.getElementById('id_search_start_date');
		var search_end_date=document.getElementById('id_search_end_date');
		var search_semester=document.getElementById('id_search_semester');
		var search_enquiry_reference_no=document.getElementById('id_search_enquiry_reference_no');
		var search_enquiry_preferredtime_start=document.getElementById('id_search_enquiry_preferredtime_start');
		var search_enquiry_preferredtime_end=document.getElementById('id_search_enquiry_preferredtime_end');
		var search_enquiry_status=document.getElementById('id_search_enquiry_status');

		var val_search_enquiry_fullname=search_enquiry_fullname.value;
		var val_search_enquiry_college=search_enquiry_college.value;
		var val_search_enquiry_course=search_enquiry_course.value;
		var val_search_enquiry_qualification=search_enquiry_qualification.value;
		var val_search_enquiry_contactno=search_enquiry_contactno.value;
		var val_search_start_date_doj=search_start_date_doj.value;
		var val_search_end_date_doj=search_end_date_doj.value;
		var val_search_enquiry_reference_name=search_enquiry_reference_name.value;
		var val_search_start_date=search_start_date.value;
		var val_search_end_date=search_end_date.value;
		var val_search_semester=search_semester.value;
		var val_search_enquiry_reference_no=search_enquiry_reference_no.value;
		var val_search_enquiry_preferredtime_start=search_enquiry_preferredtime_start.value;
		var val_search_enquiry_preferredtime_end=search_enquiry_preferredtime_end.value;
		var val_search_enquiry_status=search_enquiry_status.value;
		
		if((val_search_enquiry_fullname=="") && (val_search_enquiry_college=="Select") && (val_search_enquiry_course=="Select") && (val_search_enquiry_qualification=='Select') && (val_search_enquiry_contactno=="") && (val_search_start_date_doj=="") && (val_search_end_date_doj=="") && (val_search_enquiry_reference_name=="") && (val_search_start_date=="") && (val_search_end_date=="") && (val_search_semester=='Select') && (val_search_enquiry_reference_no=="") && (val_search_enquiry_preferredtime_start=="") && (val_search_enquiry_preferredtime_end=="") && (val_search_enquiry_status=='Select')){
			alert("Please specify search option");
			return false;
		}
		//if((val_search_enquiry_fullname=="")){
		//	alert("Please specify search option");
		//	return false;
		//}
		return true;
		//alert("Search");    
        return true;
    });	
});
</script>

<style type="text/css">
			.calendar {
				font-family: 'Trebuchet MS', Tahoma, Verdana, Arial, sans-serif;
				font-size: 0.9em;
				background-color: #EEE;
				color: #333;
				border: 1px solid #DDD;
				-moz-border-radius: 4px;
				-webkit-border-radius: 4px;
				border-radius: 4px;
				padding: 0.2em;
				width: 14em;
			}
			
			.calendar .months {
				background-color: #F6AF3A;
				border: 1px solid #E78F08;
				-moz-border-radius: 4px;
				-webkit-border-radius: 4px;
				border-radius: 4px;
				color: #FFF;
				padding: 0.2em;
				text-align: center;
			}
			
			.calendar .prev-month,
			.calendar .next-month {
				padding: 0;
			}
			
			.calendar .prev-month {
				float: left;
			}
			
			.calendar .next-month {
				float: right;
			}
			
			.calendar .current-month {
				margin: 0 auto;
			}
			
			.calendar .months .prev-month,
			.calendar .months .next-month {
				color: #FFF;
				text-decoration: none;
				padding: 0 0.4em;
				-moz-border-radius: 4px;
				-webkit-border-radius: 4px;
				border-radius: 4px;
				cursor: pointer;
			}
			
			.calendar .months .prev-month:hover,
			.calendar .months .next-month:hover {
				background-color: #FDF5CE;
				color: #C77405;
			}
			
			.calendar table {
				border-collapse: collapse;
				padding: 0;
				font-size: 0.8em;
				width: 100%;
			}
			
			.calendar th {
				text-align: center;
			}
			
			.calendar td {
				text-align: right;
				padding: 1px;
				width: 14.3%;
			}
			
			.calendar td span {
				display: block;
				color: #1C94C4;
				background-color: #F6F6F6;
				border: 1px solid #CCC;
				text-decoration: none;
				padding: 0.2em;
				cursor: pointer;
			}
			
			.calendar td span:hover {
				color: #C77405;
				background-color: #FDF5CE;
				border: 1px solid #FBCB09;
			}
			
			.calendar td.today span {
				background-color: #FFF0A5;
				border: 1px solid #FED22F;
				color: #363636;
			}
		</style>
	

<script type="text/javascript" src="../js/datepickr.js"></script>

        
        <br/>
        <jsp:useBean id="courseService" class="com.js.service.CourseService"></jsp:useBean>   
        <jsp:useBean id="collegeService" class="com.js.service.CollegeService"></jsp:useBean>
        <jsp:useBean id="enquiryService" class="com.js.service.EnquiryService"></jsp:useBean>
        <jsp:useBean id="paymentService" class="com.js.service.PaymentService"></jsp:useBean>
        <%
        	List <Course>allCourseList=courseService.getAllCourse((String)request.getSession(false).getAttribute("BRANCHID"));
        	List <Course>cList=courseService.getAllEnquiredCourse((String)request.getSession(false).getAttribute("BRANCHID"));
        	List <College>collegeList=collegeService.getAllEnquiryedCollege((String)request.getSession(false).getAttribute("BRANCHID"));
        	List <College>allCollegeList=collegeService.getAllCollege();
        	List <String>qualificationList=enquiryService.getAllEnquiredQualification((String)request.getSession(false).getAttribute("BRANCHID"));
        	List <String>statusList=enquiryService.getAllEnquiredStatus((String)request.getSession(false).getAttribute("BRANCHID"));
        %>                                   
        
        <div id="templatemo_content_wrapper">
			<div id="content">   
				<div class="latestEvent">				
					<h4>Search</h4>
					<form name="myForm" action="searchenquiry.jsp" method="post" id="myForm" >
					<table width="100%" border="1" align="left">
						<tr>
							<td width="15%">
								Full Name : 
							</td>
							<td width="15%">
								<input type="text" name="search_enquiry_fullname" id="id_search_enquiry_fullname" size="20"/> 
							</td>
							<td width="12%">
								College : 
							</td>
							<td width="18%">
								<select name="search_enquiry_college" id="id_search_enquiry_college" style="width:150px;">
									<option value="Select">Select</option>
								<%
									for(College c:collegeList){
										out.println("<option value='"+c.getCollegeCode()+"'>"+c.getCollegeName()+"</option>");		
									}
								%>
								</select>		
							</td>
							<td width="12%">
								Course : 
							</td>
							<td width="18%">
								<select name="search_enquiry_course" id="id_search_enquiry_course">
									<option value="Select">Select</option>
								<%
									for(Course c:cList){
										out.println("<option value='"+c.getCourse_Id()+"'>"+c.getCourse_Name()+"</option>");		
									}
								%>
								</select>																 
							</td>							
						</tr>
						<tr>
							<td width="15%">
								Qualification : 
							</td>
							<td width="15%">
								<select name="search_enquiry_qualification" id="id_search_enquiry_qualification">
									<option value="Select">Select</option>
								<%
									for(String qualification:qualificationList){
										out.println("<option value='"+qualification+"'>"+qualification+"</option>");		
									}
								%>
								</select>							
							</td>
							<td width="12%">
								Contact No : 
							</td>
							<td width="18%">
								<input type="text" name="search_enquiry_contactno" id="id_search_enquiry_contactno" size="20"/> 
							</td>
							<td width="12%">
								Date Of Joining : 
							</td>
							<td width="18%">
								<input type="text" name="search_start_date_doj" id="id_search_start_date_doj" size="5"/> 
								<b>-</b>&nbsp;<input type="text" name="search_end_date_doj" id="id_search_end_date_doj" size="5"/> 
								<script type="text/javascript">
									new datepickr('id_search_start_date_doj', {
										'dateFormat': 'm/d/y'
									});			
								</script>
								<script type="text/javascript">
									new datepickr('id_search_end_date_doj', {
										'dateFormat': 'm/d/y'
									});			
								</script>
							</td>							
						</tr>
						<tr>
							<td width="15%">
								Reference Name : 
							</td>
							<td width="15%">
								<input type="text" name="search_enquiry_reference_name" id="id_search_enquiry_reference_name" size="20"/> 
							</td>
							<td width="12%">
								Enquiry Date : 
							</td>
							<td width="18%">
								<input type="text" name="search_enquiry_start_date" id="id_search_start_date" size="5"/> 
								<b>-</b>&nbsp;<input type="text" name="search_enquiry_end_date" id="id_search_end_date" size="5"/>																
								<script type="text/javascript">
									new datepickr('id_search_start_date', {
										'dateFormat': 'm/d/y'
									});			
								</script>
								<script type="text/javascript">
									new datepickr('id_search_end_date', {
										'dateFormat': 'm/d/y'
									});			
								</script>
							</td>							
							<td width="12%">
								Semester : 
							</td>
							<td width="18%">							
								<select name="search_enquiry_semester" id="id_search_semester">
                    				<option value="Select">Select</option>
                    				<option value="First">First</option>
                    				<option value="Second">Second</option>
                    				<option value="Third">Third</option>
                    				<option value="Four">Four</option>
                    				<option value="Five">Five</option>
                    				<option value="Six">Six</option>
                    				<option value="Seven">Seven</option>
                    				<option value="Eight">Eight</option>
                    				<option value="Pass Out">Pass Out</option>
                    				<option value="Not Applicable">Not Applicable</option>				
                    			</select> 								 
							</td>							
						</tr>	
						<tr>
							<td width="15%">
								Ref-Contact No : 
							</td>
							<td width="15%">
								<input type="text" name="search_enquiry_reference_no" id="id_search_enquiry_reference_no" size="20"/> 
							</td>
							<td width="12%">
								Preferred Time :
							</td>
							<td width="18%">
								<input type="text" id="id_search_enquiry_preferredtime_start" name="search_enquiry_preferredtime_start" size="5"/>
                    				
                    				<script>
		  								$(function() {
											$('#id_search_enquiry_preferredtime_start').timepicker({ 'timeFormat': 'H:i:s' });			
		  								});
									</script>
                    				
                    				<b>-</b> 
									<input type="text" id="id_search_enquiry_preferredtime_end" name="search_enquiry_preferredtime_end" size="5"/>
                    				
                    				<script>
		  								$(function() {
											$('#id_search_enquiry_preferredtime_end').timepicker({ 'timeFormat': 'H:i:s' });			
		  								});
									</script>
                    				
							</td>
							<td width="12%">
								Status : 
							</td>
							<td width="18%">
								<select name="search_enquiry_status" id="id_search_enquiry_status">
									<option value="Select">Select</option>
								<%
									for(String status:statusList){
										out.println("<option value='"+status+"'>"+status+"</option>");		
									}
								%>
								</select>													 
							</td>							
						</tr>					
						</table>
						<input type="" value="Search"   style="float: right; display: block; width: 100px; height: 25px; margin:2px; padding-top: 1px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;" />
					</form>					
					
                </div>
                <div class="hr_divider"></div>
                
         <div class="leftContent">
         
                <%
                	MyMessage myMessage=(MyMessage)request.getAttribute("CANDIDATEFOUNDIN");
                	if(myMessage!=null){
                	String candidateListFrom=myMessage.getPaymentMessage();
                	if(candidateListFrom.equalsIgnoreCase("Training")){
                		List <TrainingRegistrationDTO>searchResultListForPayment = (List <TrainingRegistrationDTO>)request.getAttribute("SEARCHFORPAYMENTCANDIDATELIST");	
                	
               	%>
                <script type="text/javascript" language="javascript">
                	function changeColor(count){
                		var mytr=document.getElementById("tr"+count);
                		mytr.style='{color:#aabbcc;}';                			
                   	}               	
                   	function closeRemark(max){
                   		for(var i=1;i<=max;i++){
							if($("#"+i).is(":visible")){
								$("#"+i).hide();
							}							
						}
                   	}
					function showFeedBackAndEnquiryDetail(count){
						document.getElementById("id_enquiry_id").value=document.getElementById("h_id_enquiryid"+count).value;
						document.getElementById("id_fullname").value=document.getElementById("h_id_fullname"+count).value;
						document.getElementById("id_father_name").value=document.getElementById("h_id_father_name"+count).value;
						var desiredValue = document.getElementById("h_id_qualification"+count).value;						
						var el = document.getElementById("id_qualification");
						var ii=0;
						for(var i=0; i<el.options.length; i++) {
							if ( el.options[i].text == desiredValue ) {
								el.selectedIndex = i;
								ii=1;
								break;
							}
						}
						if(ii==0){						
							el.options.add(new Option(desiredValue,desiredValue));
							for(var i=0; i<el.options.length; i++) {
								if ( el.options[i].text == desiredValue ) {
									el.selectedIndex = i;
									ii=1;
									break;
								}
							}
						}

						var desiredValue1 = document.getElementById("h_id_college"+count).value;						
						var el1 = document.getElementById("id_college");
						var ii1=0;
						for(var i=0; i<el1.options.length; i++) {
							if ( el1.options[i].text == desiredValue1 ) {
								el1.selectedIndex = i;
								ii1=1;
								break;
							}
						}
						if(ii1==0){						
							el1.options.add(new Option(desiredValue1,desiredValue1));
							for(var i=0; i<el1.options.length; i++) {
								if ( el1.options[i].text == desiredValue1 ) {
									el1.selectedIndex = i;
									ii1=1;
									break;
								}
							}
						}

						var desiredValue2 = document.getElementById("h_id_semester"+count).value;						
						var el2 = document.getElementById("id_semester");						
						for(var i=0; i<el2.options.length; i++) {
							if ( el2.options[i].text == desiredValue2 ) {
								el2.selectedIndex = i;								
								break;
							}
						}

						
						var desiredValue3 = document.getElementById("h_id_course"+count).value;
						var n=desiredValue3.split(",");
						var el3 = document.getElementById("id_course");
						for(var i=0; i<el3.options.length; i++) {							
							el3.options[i].selected = false;				
						}
						for(var i=0;i<n.length-1;i++){
							var val=n[i];
							var el4 = document.getElementById("id_course");
							for(var j=0; j<el3.options.length; j++) {
								if ( el4.options[j].text == val ) {
									el4.options[j].selected = true;  									
									break;
								}
							}													
						}
												
						var mydiv = document.getElementById('id_enquirymsg');
						mydiv.innerHTML = '<h4>Basic Detail</h4>';

						document.getElementById('id_status').removeAttribute('disabled');

						var desiredValue5 = document.getElementById("h_id_status"+count).value;						
						var el5 = document.getElementById("id_status");						
						for(var i=0; i<el5.options.length; i++) {
							if ( el5.options[i].text == desiredValue5 ) {
								el5.selectedIndex = i;								
								break;
							}
						}
						
						document.getElementById("id_contact_no").value=document.getElementById("h_id_contact_no"+count).value;
						document.getElementById("id_email_id").value=document.getElementById("h_id_email_id"+count).value;						
						document.getElementById("id_preferredtime_start").value=document.getElementById("h_id_preferredtime_start"+count).value;
						document.getElementById("id_preferredtime_end").value=document.getElementById("h_id_preferredtime_end"+count).value;
						document.getElementById("id_joining_date").value=document.getElementById("h_id_joining_date"+count).value;
						document.getElementById("id_reference_name").value=document.getElementById("h_id_reference_name"+count).value;
						document.getElementById("id_reference_contact_no").value=document.getElementById("h_id_reference_contact_no"+count).value;
						document.getElementById("id_reference_note").value=document.getElementById("h_id_reference_note"+count).value;
						document.getElementById("id_referenceid").value=document.getElementById("h_id_reference_id"+count).value;
						document.getElementById("savenewenquiryBtn").value="Update";
						document.getElementById("clearnewenquiryBtn").disabled = true;
						document.getElementById("id_joining_date").disabled = true;	
					
					}
					function createDiv(item,max){						
						for(var i=1;i<=max;i++){
							if($("#"+i).is(":visible")){
								$("#"+i).hide();
							}							
						}
						$("#"+item).show();
					}
					function checkfordisablity(val){
						var mode=document.getElementById("id_payment_mode"+val).value;
						if(mode=="Cash"){
							document.getElementById("id_transfer_code"+val).disabled = true;
							document.getElementById("id_transfer_bank_name"+val).disabled = true;								
							document.getElementById("id_transfer_code_msg"+val).disabled = true;
						}else{
							document.getElementById("id_transfer_code"+val).disabled = false;
							document.getElementById("id_transfer_bank_name"+val).disabled = false;
							document.getElementById("id_transfer_code_msg"+val).disabled = true;
							if(mode=="Cheque"){
								document.getElementById("id_transfer_code_msg"+val).value = "Cheque No : ";
							}
							if(mode=="Draft"){
								document.getElementById("id_transfer_code_msg"+val).value = "Draft No : ";
							}
							if(mode=="Online Transfer"){
								document.getElementById("id_transfer_code_msg"+val).value = "Tranx Id : ";
							}
						}
					}
				</script>
       
                     
                	<%
                		if(searchResultListForPayment!=null){%> 
                			<h4 style="font-size: 18px; font-style: normal;">Search Result</h4>  
                	<%
                			if(searchResultListForPayment.size()>0){ 
                	%>
                	 
                	<div style="height:670px; width:520px; border:solid 2px #222222; overflow:scroll; overflow-x:scroll; overflow-y:scroll; ">
                		<table border="4" cellpadding="0" cellspacing="0" width="1024px" >
							<thead>
								<tr>
									<th width="4%"><a href="#">S.no</a></th>
									<th width="13%"><a href="#">Full Name</a></th>
									<th width="11%"><a href="#">Contact No</a></th>
									<th width="11%"><a href="#">Course</a></th>
									<th width="12%"><a href="#">Date Of Joining</a></th>
									<th width="14%"><a href="#">Total Amount</a></th>
									<th width="11%"><a href="#">Due Amount</a></th>
									<th width="12%"><a href="#">Reference Name</a></th>
									<th width="12%"><a href="#">Councillor</a></th>									
								</tr>
							</thead>
							</table> 
														
							<%
								int count=1;
								int sno=0;
								for(TrainingRegistrationDTO trainingRegistrationDTO:searchResultListForPayment){
									int dueAmount=paymentService.getDueAmount(trainingRegistrationDTO.getRegistration_id());
									//out.println(trainingRegistrationDTO.getRegistration_id());
									String maindivid="maindiv"+count;
									String subdivid="subdiv"+count;
									out.println("<div id='"+maindivid+"'>");
									sno++;
									out.println("<input type='hidden' name='h_enquiryid' id='h_id_enquiryid"+count+"' value='"+trainingRegistrationDTO.getEnquiry_id()+"'/>");
									out.println("<input type='hidden' name='h_fullname' id='h_id_fullname"+count+"' value='"+trainingRegistrationDTO.getFullname()+"'/>");
									out.println("<input type='hidden' name='h_father_name' id='h_id_father_name"+count+"' value='"+trainingRegistrationDTO.getFather_name()+"'/>");
									out.println("<input type='hidden' name='h_qualification' id='h_id_qualification"+count+"' value='"+trainingRegistrationDTO.getQualification()+"'/>");
									out.println("<input type='hidden' name='h_college' id='h_id_college"+count+"' value='"+trainingRegistrationDTO.getCollege()+"'/>");
									out.println("<input type='hidden' name='h_semester' id='h_id_semester"+count+"' value='"+trainingRegistrationDTO.getSemester()+"'/>");
									out.println("<input type='hidden' name='h_contact_no' id='h_id_contact_no"+count+"' value='"+trainingRegistrationDTO.getContact_no()+"'/>");
									out.println("<input type='hidden' name='h_email_id' id='h_id_email_id"+count+"' value='"+trainingRegistrationDTO.getEmail_id()+"'/>");
									String course_val="";
									for(int i=0;i<trainingRegistrationDTO.getCourse().length;i++){
										course_val=course_val+trainingRegistrationDTO.getCourse()[i]+",";
									}
									out.println("<input type='hidden' name='h_course' id='h_id_course"+count+"' value='"+course_val+"'/>");
									
									out.println("<input type='hidden' name='h_preferredtime_start' id='h_id_preferredtime_start"+count+"' value='"+trainingRegistrationDTO.getPreferredtime_start()+"'/>");
									out.println("<input type='hidden' name='h_preferredtime_end' id='h_id_preferredtime_end"+count+"' value='"+trainingRegistrationDTO.getPreferredtime_end()+"'/>");
									out.println("<input type='hidden' name='h_joining_date' id='h_id_joining_date"+count+"' value='"+trainingRegistrationDTO.getJoining_date()+"'/>");
									out.println("<input type='hidden' name='h_reference_id' id='h_id_reference_id"+count+"' value='"+trainingRegistrationDTO.getReferenceId()+"'/>");
									out.println("<input type='hidden' name='h_reference_name' id='h_id_reference_name"+count+"' value='"+trainingRegistrationDTO.getReference_name()+"'/>");
									out.println("<input type='hidden' name='h_reference_contact_no' id='h_id_reference_contact_no"+count+"' value='"+trainingRegistrationDTO.getReference_contact_no()+"'/>");
									out.println("<input type='hidden' name='h_reference_note' id='h_id_reference_note"+count+"' value='"+trainingRegistrationDTO.getReference_note()+"'/>");
									out.println("<input type='hidden' name='h_status' id='h_id_status"+count+"' value='"+trainingRegistrationDTO.getEnquiry_status()+"'/>");
									
									out.println("<table border='1' cellpadding='0' cellspacing='0' width='1024px' ><tr bgcolor='#333333' onmousedown='showFeedBackAndEnquiryDetail("+count+")' onmouseup='createDiv("+count+","+searchResultListForPayment.size()+")' onmouseover=\"this.style.backgroundColor='#666666';\" onmouseout=\"this.style.backgroundColor='#333333';\">");
									out.println("<td width='4%'>"+sno+"</td>");
									out.println("<td width='13%'>"+trainingRegistrationDTO.getFullname()+"</td>");
									out.println("<td width='11%'>"+trainingRegistrationDTO.getContact_no()+"</td>");
									out.println("<td width='11%'>");
										out.println(trainingRegistrationDTO.getCoursename());
									out.println("</td>");
									out.println("<td width='12%'>"+trainingRegistrationDTO.getJoining_date()+"</td>");
									out.println("<td width='14%'>"+0+"</td>");
									out.println("<td width='11%'>"+dueAmount+"</td>");
									out.println("<td width='12%'>"+trainingRegistrationDTO.getReference_name()+"</td>");
									out.println("<td width='12%'>"+trainingRegistrationDTO.getEmployee_id()+"</td>");
									out.println("</tr></table>");
																	
									out.println("<div id='"+count+"' style='display:none' >");
										out.println("<form action='#savepayment.jsp' id='makePaymentForm_"+count+"' method='post'>");
											out.println("<table border='1' width='800px' style='margin-left:50px; padding:3px'>");									
												out.println("<tr bgcolor='#aa1122'><td align='center' width='10%'><b>S.no</b></td><td align='center' width='15'><b>Amount</b></td><td align='center' width='10'><b>Mode</b></td><td align='center' width='20%'><b>Payment Date</b></td><td align='center' width='23%'><b>Received By</b></td><td align='center' width='12%'><b>Status</b></td><td align='center' width='10%'><b>Operation</b></td></tr>");
												Payment pay=new Payment();
												pay.setMyid(trainingRegistrationDTO.getRegistration_id());																								
												List <Payment>paymentDetailList=paymentService.getAllPaymentDetailById(pay,(String)request.getSession(false).getAttribute("BRANCHID"));
												
												int pdCount=0;
												for(Payment payment:paymentDetailList){
													
													pdCount++;
													out.println("<tr bgcolor='#330066'>");
														Date pdate=new Date();
		                    							String fdate=pdate.getDate()+"/"+(1+pdate.getMonth())+"/"+(1900+pdate.getYear());
														out.println("<input type='hidden' value='"+payment.getPayment_id()+"' id='previous_paymentid"+(count+pdCount)+"'>");
														out.println("<input type='hidden' value='"+payment.getPayment_date()+"' id='previous_paymentdate"+(count+pdCount)+"'>");
														out.println("<input type='hidden' value='"+fdate+"' id='previous_paymenttime"+(count+pdCount)+"'>");
														out.println("<input type='hidden' value='"+payment.getMyid()+"' id='previous_myid"+(count+pdCount)+"'>");
														out.println("<input type='hidden' value='"+payment.getSource()+"' id='previous_source"+(count+pdCount)+"'>");
														out.println("<input type='hidden' value='"+trainingRegistrationDTO.getCoursename()+"' id='previous_cdetail"+(count+pdCount)+"'>");
														out.println("<input type='hidden' value='"+payment.getPayment_mode()+"' id='previous_id_payment_mode"+(count+pdCount)+"'>");
														out.println("<input type='hidden' value='"+trainingRegistrationDTO.getFullname()+"' id='previous_id_candidateName"+(count+pdCount)+"'>");
														out.println("<input type='hidden' value='"+new EmployeeService().getEmployeeDetailByEmployeeId(new Employee(payment.getReceived_by())).getFull_name()+"' id='previous_id_receiverName"+(count+pdCount)+"'>");
														out.println("<input type='hidden' value='"+payment.getAmount()+"' id='previous_my_id_amount"+(count+pdCount)+"'>");
														out.println("<input type='hidden' value='"+dueAmount+"' id='dueAmount_id"+(count+pdCount)+"'>");
														out.println("<td width='10%'>");
															out.println(pdCount);													
														out.println("</td>");
														out.println("<td width='15%'>");
															out.println(payment.getAmount());														
														out.println("</td>");
														out.println("<td width='10%'>");
															out.println(payment.getPayment_mode());														
														out.println("</td>");
														out.println("<td width='20%'>");
															out.println(payment.getPayment_date());														
														out.println("</td>");													
														out.println("<td width='23%'>");
															out.println(payment.getReceived_by());														
														out.println("</td>");
														out.println("<td width='12%' align='center'>");
															out.println(payment.getPayment_status());														
														out.println("</td>");
														out.println("<td width='10%' align='center'>");
															out.println("<a href='#' onclick='printPreviousSlip(\""+(count+pdCount)+"\");'>Print</a>");														
														out.println("</td>");
													out.println("</tr>");
												}
												
												out.println("</table>");
												if(dueAmount>0){												
													out.println("<table border='1' width='800px' style='margin-left:50px; padding:3px'>");
														out.println("<tr bgcolor='#999999'>");
															out.println("<td  bgcolor='#333333'>");
																out.println("<div style='float: left;'>");
																out.println("Mode: <select name='payment_mode' id='id_payment_mode"+count+"' onchange='checkfordisablity("+count+");'>");
					                    						out.println("<option value='Select'>Select</option>");
					                    						out.println("<option value='Cash'>Cash</option>");
					                    						out.println("<option value='Cheque'>Cheque</option>");
					                    						out.println("<option value='Draft'>Draft</option>");
					                    						out.println("<option value='Online Transfer'>Online Transfer</option>");
					                    						out.println("</select>");
					                    						out.println("<input type='text' name='transfer_code_msg' id='id_transfer_code_msg"+count+"' size='8' value='Detail : ' disabled='disabled' style='border: 0px solid; background-color:#333333; color:#FFFFFF;'>");
					                    						out.println("<input type='text' name='transfer_code' id='id_transfer_code"+count+"' size='5'>");
					                    						out.println("Bank : <input type='text' name='transfer_bank_name' id='id_transfer_bank_name"+count+"' size='5'>");
					                    						Date pdate=new Date();
					                    						String fdate=pdate.getDate()+"/"+(1+pdate.getMonth())+"/"+(1900+pdate.getYear());
					                    						String ftime=pdate.getHours()+":"+pdate.getMinutes()+":"+pdate.getSeconds();
					                    						out.println("<input type='hidden' name='paymentdate' value='"+fdate+"' id='paymentdate"+count+"' size='30'/>");
					                    						out.println("<input type='hidden' name='cdetail' value='"+trainingRegistrationDTO.getCoursename()+"' id='cdetail"+count+"' size='30'/>");
					                    						out.println("<input type='hidden' name='paymenttime' value='"+ftime+"' id='paymenttime"+count+"' size='30'/>");
					                    						out.println("<input type='hidden' name='source' value='"+candidateListFrom+"' id='source"+count+"' size='30'/>");
																out.println("<input type='hidden' name='candidateName' id='id_candidateName"+count+"' value='"+trainingRegistrationDTO.getFullname()+"' size='30'/>");
																out.println("<input type='hidden' name='receiverName' id='id_receiverName"+count+"' value='"+(String)request.getSession(false).getAttribute("USERFULLNAME")+"' size='30'/>");
																out.println("<input type='hidden' name='myid' value='"+trainingRegistrationDTO.getRegistration_id()+"' id='myid"+count+"' size='30'/>");
																out.println("Amount : <input type='text' name='amount' id='my_id_amount"+count+"' value='"+dueAmount+"' size='5' />");
																out.println("<input type='hidden' value='"+searchResultListForPayment.size()+"' id='maxvalue"+count+"'/>");
															out.println("</td>");
															out.println("<td bgcolor='#333333' >");															
																out.println("<input type='button' onclick='closeRemark("+searchResultListForPayment.size()+")' value='Close' style='float: left; display: block; width: 75px; height: 25px; margin:2px; padding-top: 1px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(../images/templatemo_btn.png) no-repeat;'/>");
																out.println("<input onclick='makePaymentBtn(\""+count+"\");' type='button' value='Save' style='float: right; display: block; width: 75px; height: 25px; margin:2px; padding-top: 1px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(../images/templatemo_btn.png) no-repeat;'/>");
																//out.println("</div>");
															out.println("</td>");
														out.println("</tr>");												
													out.println("</table>");
												}
										out.println("</form>");									
								 	out.println("</div>");									
									
								out.println("</div>");
									count++;
							}
						 %>                		   					
                		</div>	 
                	
                	<%
                		}
                		else{
                	%>
                			<table width="100%" >
                				<tr>
                					
                					<td align="center" >
                						<h4 style="font-size: 14px; font-style: normal; color: #ffaabb;" >Record not found</h4>
                					</td>
                				</tr>
                			</table>   
                <%
                		}// end of if which used for list empty check
                	}//end of if which used for list null check
                }
            }//end of if which used for null check
           %>
           </div>
                <form action="#" id="savenewenquiryForm" >
                <div class="rightContent">
                	
                	<table width="100%" border="0" align="right">
                		<tr>
                			<td align="center">
                				<div id="id_enquirymsg">
                					<h4>Basic Detail</h4>
                				</div>                				               					
                			</td>
                		</tr>
                	</table>
                	
                	
                    <table width="100%" align="right" border="1">
                    	<tr>
                    		
                    		<td width="40%" align="right">
                    			Full Name : 
                    		</td>
                    		<td width="60%">
                    			<input type="hidden" name="enquiry_id" id="id_enquiry_id" size="20"/>
                    			<input type="text" name="fullname" id="id_fullname" size="20"/>
                    		</td>
                    	</tr>                    	
                    	<tr>
                    		<td width="40%" align="right">
                    			Father Name : 
                    		</td>
                    		<td width="60%">
                    			<input type="text" name="father_name" id="id_father_name"  size="20"/>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td width="40%" align="right">
                    			Qualification : 
                    		</td>
                    		<td width="60%">
                    			<select name="qualification" id="id_qualification" onchange="check_for_qualification_other()">                    				
                    				<option value='B.E'>B.E</option>
                    				<option value='B.Tech'>B.Tech</option>
                    				<option value='M.E'>M.E</option>
                    				<option value='M.Tech'>M.Tech</option>
                    				<option value='B.C.A'>B.C.A</option>
                    				<option value='M.C.A'>M.C.A</option>
                    				<option value='Other'>Other</option>
                    			</select>
                    			<div id="id_qualification_div">
                    			
                    			</div>                    			
                    		</td>
                    	</tr>
                    	<tr>
                    		<td width="40%" align="right">
                    			College : 
                    		</td>
                    		<td width="60%">
                    			
                    			<select name="college" id="id_college" onchange="check_for_college_other()" style="width:150px;">
								<%
									for(College c:allCollegeList){
										out.println("<option value='"+c.getCollegeCode()+"'>"+c.getCollegeName()+"</option>");		
									}
								%>
								<option value="Other">Other</option>
								</select>                    			                    	
                    			<div id="id_college_div">
                    			
                    			</div>		
                    		</td>
                    	</tr>
                    	<tr>
                    		<td width="40%" align="right">
                    			Semester : 
                    		</td>
                    		<td width="60%">
                    			<select name="semester" id="id_semester">
                    				<option value="First">First</option>
                    				<option value="Second">Second</option>
                    				<option value="Third">Third</option>
                    				<option value="Four">Four</option>
                    				<option value="Five">Five</option>
                    				<option value="Six">Six</option>
                    				<option value="Seven">Seven</option>
                    				<option value="Eight">Eight</option>
                    				<option value="Pass Out">Pass Out</option>
                    				<option value="Not Applicable">Not Applicable</option>				
                    			</select>                    			
                    		</td>
                    	</tr>
                    	<tr>
                    		<td width="40%" align="right">
                    			Contact No : 
                    		</td>
                    		<td width="60%">
                    			<input type="text" name="contact_no" id="id_contact_no" size="20"/>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td width="40%" align="right">
                    			Email-Id : 
                    		</td>
                    		<td width="60%">
                    			<input type="text" name="email_id" id="id_email_id" size="20"/>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td width="40%" align="right">
                    			Course : 
                    		</td>
                    		<td width="60%">        
                    			<select name="course" id="id_course" style="width: 120px;">
								<%
									for(Course c:allCourseList){
										out.println("<option value='"+c.getCourse_Id()+"'>"+c.getCourse_Name()+"</option>");		
									}
								%>
								</select>             			
                    		</td>
                    	</tr>
                    	<tr>
                    		<td width="40%" align="right">
                    			Preferred Time : 
                    		</td>
                    		<td width="60%">                    			
                    			<input type="text" id="id_preferredtime_start" name="preferredtime_start" size="5"/>
                    			
                    			<script>
		  							$(function() {
										$('#id_preferredtime_start').timepicker({ 'timeFormat': 'H:i:s' });			
		  							});
								</script>                    			
                    			
								<b>-</b>
								<input type="text" id="id_preferredtime_end" name="preferredtime_end" size="5"/>
                    			
                    			<script>
		  							$(function() {
										$('#id_preferredtime_end').timepicker({ 'timeFormat': 'H:i:s' });			
		  							});
								</script>
                    			
                    		</td>
                    	</tr>
                    	<tr>
                    		<td width="40%" align="right">
                    			Joining Date : 
                    		</td>
                    		<td width="60%">
                    			<input type="text" name="joining_date" id="id_joining_date" size="20" />	                    			
                    		</td>
                    	</tr>
                    	<tr>
                    		<td width="40%" align="right">
                    			Status :  
                    		</td>
                    		<td width="60%">
                    			<select name="enquiry_status" id="id_status" disabled="disabled">
                    				<option value="Fresh">Fresh</option>
                    				<option value="Under Process">Under Process</option>
                    				<option value="Joined">Joined</option>
                    				<option value="Not Intrested">Not Intrested</option>                    								
                    			</select>             				                    			
                    		</td>
                    	</tr>
                    </table>
                    
					<script type="text/javascript">
						new datepickr('id_joining_date', {
							'dateFormat': 'm/d/y'
						});			
					</script>
					
					<p>&nbsp;</p>					
                    <table width="60%" border="0" align="center">
                		<tr>
                			<td align="center">
                				<h4>Reference</h4>		
                			</td>
                		</tr>
                	</table>
                	<p>&nbsp;</p>
                    <table width="100%" border="1" align="right">
                    
                		<tr>
                    		<td width="40%" align="right">
                    			Full Name : 
                    		</td>
                    		<td width="60%">
                    			<input type="text" name="reference_name" id="id_reference_name" value="Not Applicable" size="20"/>
                    			<input type="hidden" name="referenceId" id="id_referenceid" value="" size="20"/>
                    			
                    		</td>
                    	</tr>
                    	<tr>
                    		<td width="40%" align="right">
                    			Contact No : 
                    		</td>
                    		<td width="60%">
                    			<input type="text" name="reference_contact_no" id="id_reference_contact_no" value="0000000000" size="20"/>
                    		</td>
                    	</tr>
                    	<tr>
                    		<td width="40%" align="right">
                    			Note : 
                    		</td>
                    		<td width="60%">
                    			<textarea rows="3" cols="21" name="reference_note" id="id_reference_note">self</textarea>
                    		</td>
                    	</tr>
                	</table>
                	<table width="100%" border="0" align="right">
                		<tr>
                    		<td width="40%" align="left">
                    			<input type="reset" value="Clear" id="clearnewenquiryBtn" style="float: left; display: block; width: 100px; height: 26px; margin-top: 10px; padding-top: 4px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;"/>
                    		</td>
                    		<td width="60%" align="right">            			
                    			<input type="button" value="Save" id="savenewenquiryBtn" style="float: right; display: block; width: 100px; height: 26px; margin-top: 10px; padding-top: 4px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;"/>              				
                    		</td>
                    	</tr>
                	</table>
                	
                </div>
                </form>
                <div class="cleaner"></div>                
            </div>			
            <div class="cleaner"></div>        
		</div>
		
		<div id="templatemo_content_wrapper_bottm"></div>
		
		<div id="templatemo_footer">
			<%@include file="../footer.jsp" %>
       </div>
        
	</div> <!-- end of wrapper -->
</div> <!-- end of wrapper_outer -->

</body>
</html>