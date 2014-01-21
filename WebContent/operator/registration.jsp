<%@page import="com.js.service.EmployeeService"%>
<%@page import="com.js.service.CollegeService"%>
<%@include file="../common/chk.jsp"%>
<%@page import="java.util.*"%>
<%@page import="com.js.dto.*"%>
<%@page import="com.js.controller.*"%>
<%@include file="operatortopheader.jsp"%>
<%@include file="../common/header.jsp"%>


<link href="../templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="../css/jquery.ennui.contentslider.css" rel="stylesheet"
	type="text/css" media="screen,projection" />
<script type="text/javascript" src="../js/enquiry.js"></script>
<script type="text/javascript" src="../js/datepickr.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="../js/jquery-1.9.0.js"></script>
<script src="../js/registration.js"></script>
<script type="text/javascript" src="../js/jquery.timepicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="../js/jquery.timepicker.css" />
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#myForm")
								.submit(
										function() {

											var search_enquiry_fullname = document
													.getElementById('id_search_enquiry_fullname');
											var search_enquiry_college = document
													.getElementById('id_search_enquiry_college');
											var search_enquiry_course = document
													.getElementById('id_search_enquiry_course');
											var search_enquiry_qualification = document
													.getElementById('id_search_enquiry_qualification');
											var search_enquiry_contactno = document
													.getElementById('id_search_enquiry_contactno');
											var search_start_date_doj = document
													.getElementById('id_search_start_date_doj');
											var search_end_date_doj = document
													.getElementById('id_search_end_date_doj');
											var search_enquiry_reference_name = document
													.getElementById('id_search_enquiry_reference_name');
											var search_start_date = document
													.getElementById('id_search_start_date');
											var search_end_date = document
													.getElementById('id_search_end_date');
											var search_semester = document
													.getElementById('id_search_semester');
											var search_enquiry_reference_no = document
													.getElementById('id_search_enquiry_reference_no');
											var search_enquiry_preferredtime_start = document
													.getElementById('id_search_enquiry_preferredtime_start');
											var search_enquiry_preferredtime_end = document
													.getElementById('id_search_enquiry_preferredtime_end');
											var search_enquiry_status = document
													.getElementById('id_search_enquiry_status');

											var val_search_enquiry_fullname = search_enquiry_fullname.value;
											var val_search_enquiry_college = search_enquiry_college.value;
											var val_search_enquiry_course = search_enquiry_course.value;
											var val_search_enquiry_qualification = search_enquiry_qualification.value;
											var val_search_enquiry_contactno = search_enquiry_contactno.value;
											var val_search_start_date_doj = search_start_date_doj.value;
											var val_search_end_date_doj = search_end_date_doj.value;
											var val_search_enquiry_reference_name = search_enquiry_reference_name.value;
											var val_search_start_date = search_start_date.value;
											var val_search_end_date = search_end_date.value;
											var val_search_semester = search_semester.value;
											var val_search_enquiry_reference_no = search_enquiry_reference_no.value;
											var val_search_enquiry_preferredtime_start = search_enquiry_preferredtime_start.value;
											var val_search_enquiry_preferredtime_end = search_enquiry_preferredtime_end.value;
											var val_search_enquiry_status = search_enquiry_status.value;

											if ((val_search_enquiry_fullname == "")
													&& (val_search_enquiry_college == "Select")
													&& (val_search_enquiry_course == "Select")
													&& (val_search_enquiry_qualification == 'Select')
													&& (val_search_enquiry_contactno == "")
													&& (val_search_start_date_doj == "")
													&& (val_search_end_date_doj == "")
													&& (val_search_enquiry_reference_name == "")
													&& (val_search_start_date == "")
													&& (val_search_end_date == "")
													&& (val_search_semester == 'Select')
													&& (val_search_enquiry_reference_no == "")
													&& (val_search_enquiry_preferredtime_start == "")
													&& (val_search_enquiry_preferredtime_end == "")
													&& (val_search_enquiry_status == 'Select')) {
												alert("Please specify search option");
												return false;
											}
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

.calendar .prev-month,.calendar .next-month {
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

.calendar .months .prev-month,.calendar .months .next-month {
	color: #FFF;
	text-decoration: none;
	padding: 0 0.4em;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border-radius: 4px;
	cursor: pointer;
}

.calendar .months .prev-month:hover,.calendar .months .next-month:hover
	{
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

<br />

<jsp:useBean id="courseService" class="com.js.service.CourseService"></jsp:useBean>
<jsp:useBean id="collegeService" class="com.js.service.CollegeService"></jsp:useBean>
<jsp:useBean id="enquiryService" class="com.js.service.EnquiryService"></jsp:useBean>
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
			<table>
				<td width="40%" style="border: none; color: white; font-size: 18px;"><strong>Registration
						For :</strong>
				</td>
				<td width="60%" style="border: none;"><select
					name="search_purpose" id="id_serch_purpose"
					onchange="showSearchForm(this)">
						<option value='Training' selected='selected'>Training</option>
						<option value='Academic Project'>Academic Project</option>						
				</select>
				</td>
			</table>
			</br>
			<form name="myForm" action="searchregistration.jsp" method="post"
				id="myForm">
				<table width="100%" border="1" align="left"
					id="search_training_enquiry">
					<tr style="height: 25px;">
					<td width="14%" colspan="6" style="border: none;"><B
							style="font-size: 18px; color: #59aaff;">Search</B>
						</td>
						</tr>
					<tr>
						<td width="14%">Full Name :</td>
						<td width="18%"><input type="text"
							name="search_training_enquiry_fullname"
							id="id_search_training_enquiry_fullname" style="width: 140px;" />
						</td>
						<td width="14%">Contact No :</td>
						<td width="18%"><input type="text"
							name="search_training_enquiry_contactno"
							id="id_search_training_enquiry_contactno" style="width: 140px;" />
						</td>
						<td width="13%">Enquiry Date :</td>
						<td width="18%"><input type="text"
							name="search_training_enquiry_start_date"
							id="id_search_training_enquiry_start_date" size="5" /> <b>-</b>&nbsp;<input
							type="text" name="search_training_enquiry_end_date"
							id="id_search_training_enquiry_end_date" size="5" /> <script
								type="text/javascript">
											new datepickr(
													'id_search_training_enquiry_start_date',
													{
														'dateFormat' : 'm/d/y'
													});
										</script> <script type="text/javascript">
											new datepickr(
													'id_search_training_enquiry_end_date',
													{
														'dateFormat' : 'm/d/y'
													});
										</script></td>
					</tr>
					<tr>
						<td>Reference Name :</td>
						<td><input type="text"
							name="search_training_enquiry_reference_name"
							id="id_search_training_enquiry_reference_name"
							style="width: 140px;" /></td>
						<td>Ref-Contact No :</td>
						<td><input type="text"
							name="search_training_enquiry_reference_no"
							id="id_search_training_enquiry_reference_no"
							style="width: 140px;" /></td>
						<td>Date Of Join :</td>
						<td><input type="text"
							name="search_training_enquiry_start_date_doj"
							id="id_search_training_enquiry_start_date_doj" size="5" /> <b>-</b>&nbsp;<input
							type="text" name="search_training_enquiry_end_date_doj"
							id="id_search_training_enquiry_end_date_doj" size="5" /> <script
								type="text/javascript">
											new datepickr(
													'id_search_training_enquiry_start_date_doj',
													{
														'dateFormat' : 'm/d/y'
													});
										</script> <script type="text/javascript">
											new datepickr(
													'id_search_training_enquiry_end_date_doj',
													{
														'dateFormat' : 'm/d/y'
													});
										</script></td>
					</tr>
					<tr>
						<td>Qualification :</td>
						<td><select name="search_training_enquiry_qualification"
							id="id_search_training_enquiry_qualification">
								<option value="Select">Select</option>
								<%
										for(String qualification:qualificationList){
											out.println("<option value='"+qualification+"'>"+qualification+"</option>");		
										}
									%>
						</select></td>
						<td>College :</td>
						<td><select name="search_training_enquiry_college"
							id="id_search_training_enquiry_college" style="width: 140px;">
								<option value="Select">Select</option>
								<%
										for(College c:collegeList){
											out.println("<option value='"+c.getCollegeCode()+"'>"+c.getCollegeName()+"</option>");		
										}
									%>
						</select></td>
						<td>Semester :</td>
						<td><select name="search_training_enquiry_semester"
							id="id_search_training_enquiry_semester">
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
						</select></td>
					</tr>
					<tr>
						<td>Preferred Time :</td>
						<td><input type="text"
							id="id_search_training_enquiry_preferredtime_start"
							name="search_training_enquiry_preferredtime_start" size="5" /> <script>
											$(function() {
												$(
														'#id_search_training_enquiry_preferredtime_start')
														.timepicker(
																{
																	'timeFormat' : 'H:i:s'
																});
											});
										</script> <b>-</b> <input type="text"
							id="id_search_training_enquiry_preferredtime_end"
							name="search_training_enquiry_preferredtime_end" size="5" /> <script>
											$(function() {
												$(
														'#id_search_training_enquiry_preferredtime_end')
														.timepicker(
																{
																	'timeFormat' : 'H:i:s'
																});
											});
										</script></td>
						<td>Course :</td>
						<td><select name="search_training_enquiry_course"
							id="id_search_training_enquiry_course">
								<option value="Select">Select</option>
								<%
										for(Course c:cList){
											out.println("<option value='"+c.getCourse_Id()+"'>"+c.getCourse_Name()+"</option>");		
										}
									%>
						</select></td>
						<td>Status :</td>
						<td><select name="search_training_enquiry_status"
							id="id_search_training_enquiry_status">
								<option value="Select">Select</option>
								<%
										for(String status:statusList){
											out.println("<option value='"+status+"'>"+status+"</option>");		
										}
									%>
						</select></td>
					</tr>
				</table>
				<input type="submit" value="Search"
					style="float: right; display: block; width: 100px; height: 25px; margin: 2px; padding-top: 1px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;" />

			</form>

		</div>
		<div class="hr_divider"></div>
		<%
                	List <NewTrainingEnquiryDTO>enquiryList = (List <NewTrainingEnquiryDTO>)request.getAttribute("REGISTRATIONSEARCHRESULT");
               	%>

		<div class="leftContent">
			<jsp:useBean id="controller"
				class="com.js.controller.RegistrationController"></jsp:useBean>

			<%
                		
                		if(enquiryList==null){                			
							enquiryList=null;
							List<List<String>>todayFollowUp=controller.getTrainningRegistationAllFollowUp(request);
							List<String>alist=todayFollowUp.get(0);
							List<String>plist=todayFollowUp.get(1);
                		%>
			<h4 style="font-size: 18px; font-style: normal; float: left;">Today's
				Follow Up</h4>
			<h4 style="font-size: 18px; font-style: normal; float: right;">Active
				List</h4>
			<div
				style="height: 310px; width: 520px; border: solid 2px #222222; overflow: scroll; overflow-x: scroll; overflow-y: scroll;">
				<table border="4" cellpadding="0" cellspacing="0" width="1024px">
					<thead>
						<tr>
							<th width="4%"><a href="#">S.no</a></th>
							<th width="13%"><a href="#">Full Name</a></th>
							<th width="11%"><a href="#">Contact No</a></th>
							<th width="11%"><a href="#">Course</a></th>
							<th width="12%"><a href="#">Date Of Registration</a></th>
							<th width="14%"><a href="#">Preferred Time</a></th>
							<th width="11%"><a href="#">fee</a></th>
							<th width="12%"><a href="#">Reference Name</a></th>
							<th width="12%"><a href="#">Councillor</a></th>
						</tr>
					</thead>
				</table>
				<%
							int count =0;
							for(String registrationId:alist){
								count++;
								TrainingRegistrationDTO dto=controller.getRegistration(registrationId);
								String maindivid="maindiv"+count;
								String subdivid="subdiv"+count;
							
									
									out.println("<div id='"+maindivid+"'>");
									out.println("<table border='1' cellpadding='0' cellspacing='0' width='1024px' ><tr bgcolor='#333333' onmousedown='showFeedBackAndRegistrationDetail("+count+")' onmouseup='createDiv("+count+","+(alist.size()+plist.size())+")' onmouseover=\"this.style.backgroundColor='#666666';\" onmouseout=\"this.style.backgroundColor='#333333';\">");
									out.println("<td width='4%'>"+count+"</td>");
									out.println("<td width='13%'>"+dto.getFullname()+"</td>");
									out.println("<td width='11%'>"+dto.getContact_no()+"</td>");
									out.println("<td width='11'%'>"+dto.getRegisterForCourse()+"</td>");
									out.println("<td width='12%'>"+dto.getReg_date()+"</td>");
									out.println("<td width='14%'>"+dto.getPreferredtime_start()+"-"+dto.getPreferredtime_end()+"</td>");
									out.println("<td width='11%'></td>");
									out.println("<td width='12%'>"+dto.getReference_name()+"</td>");
									out.println("<td width='12%'>"+dto.getReg_employee_id()+"</td>");
									out.println("</tr></table>");
									out.println("</div>");
									
									out.println("<input type='hidden' id='h_id_Address"+count+"' value='"+dto.getAddress()+"'/>");
									out.println("<input type='hidden' id='h_id_Batch_time_end"+count+"' value='"+dto.getBatch_time_end()+"'/>");
									out.println("<input type='hidden' id='h_id_Batch_time_start"+count+"' value='"+dto.getBatch_time_start()+"'/>");
									out.println("<input type='hidden' id='h_id_College"+count+"' value='"+dto.getCollege()+"'/>");
									out.println("<input type='hidden' id='h_id_Contact_no"+count+"' value='"+dto.getContact_no()+"'/>");
									out.println("<input type='hidden' id='h_id_Date_of_birth"+count+"' value='"+dto.getDate_of_birth()+"'/>");
									out.println("<input type='hidden' id='h_id_Discount_detail"+count+"' value='"+dto.getDiscount_detail()+"'/>");
									out.println("<input type='hidden' id='h_id_Email_id"+count+"' value='"+dto.getEmail_id()+"'/>");
									out.println("<input type='hidden' id='h_id_Enrollment_no"+count+"' value='"+dto.getEnrollment_no()+"'/>");
									out.println("<input type='hidden' id='h_id_Father_name"+count+"' value='"+dto.getFather_name()+"'/>");
									out.println("<input type='hidden' id='h_id_Fullname"+count+"' value='"+dto.getFullname()+"'/>");
									out.println("<input type='hidden' id='h_id_Photo_path"+count+"' value='../studentimage/"+dto.getPhoto_path()+"'/>");
									out.println("<input type='hidden' id='h_id_Qualification"+count+"' value='"+dto.getQualification()+"'/>");
									out.println("<input type='hidden' id='h_id_Reference_contact_no"+count+"' value='"+dto.getReference_contact_no()+"'/>");
									out.println("<input type='hidden' id='h_id_Reference_name"+count+"' value='"+dto.getReference_name()+"'/>");
									out.println("<input type='hidden' id='h_id_Reference_note"+count+"' value='"+dto.getReference_note()+"'/>");
									out.println("<input type='hidden' id='h_id_Reg_date"+count+"' value='"+dto.getReg_date()+"'/>");
									out.println("<input type='hidden' id='h_id_Reg_employee_id"+count+"' value='"+dto.getReg_employee_id()+"'/>");
									out.println("<input type='hidden' id='h_id_RegisterForCourse"+count+"' value='"+dto.getRegisterForCourse()+"'/>");
									out.println("<input type='hidden' id='h_id_Registration_id"+count+"' value='"+dto.getRegistration_id()+"'/>");
									out.println("<input type='hidden' id='h_id_Discount_amount"+count+"' value='"+dto.getDiscount_amount()+"'/>");
									out.println("<input type='hidden' id='h_id_Total_amount"+count+"' value='"+dto.getTotal_amount()+"'/>");									
									out.println("<input type='hidden' id='h_id_Semester"+count+"' value='"+dto.getSemester()+"'/>");
									
									out.println("<div id='"+count+"' style='display:none' >");
									out.println("<form action='#saveregremark.jsp' id='subForm_"+count+"' method='post'>");
										out.println("<table border='1' width='924px' style='margin-left:50px; padding:3px'>");									
											out.println("<tr bgcolor='#aa1122'><td align='center'><b>Remark</b></td><td align='center'><b>Remarked Date</b></td><td align='center'><b>Alert Date</b></td><td align='center'><b>Councillor</b></td></tr>");
											
											List<Remark>listRemark=new RegistrationRemarkController().getAllRemarkForAnRegistration(dto.getRegistration_id());
											for(Remark remark:listRemark){
											out.println("<tr bgcolor='#330066'>");
												out.println("<td width='40%'>");
													out.println(remark.getRemark());
												out.println("</td>");
												out.println("<td width='20%'>");
													out.println(remark.getRemark_date());
												out.println("</td>");
												out.println("<td width='20%'>");
													out.println(remark.getRemark_alert());
												out.println("</td>");
												out.println("<td width='20%'>");
													out.println(remark.getCouncillor());
												out.println("</td>");
											out.println("</tr>");
											}
											out.println("<tr bgcolor='#999999'>");
												out.println("<td width='40%'>");
													out.println("<input type='hidden' name='enquiryid' value='"+dto.getRegistration_id()+"' size='52'/>");
													out.println("<input type='text' name='remark' id='my_id_remark"+count+"' value='' size='52'/>");
												out.println("</td>");
												out.println("<td width='20%'>");	
												Date date=new Date();
												String c_date=(1900+date.getYear())+"-"+(1+date.getMonth())+"-"+date.getDate();
													out.println("<input type='text' name='remarkdate' value='"+c_date+"' size='25' readonly='readonly'/>");
												out.println("</td>");
												out.println("<td width='20%'>");
													out.println("<input type='date' name='alertdate' id='id_alertdate_"+count+"' size='25' onclick='abc("+count+");'/>");														
												out.println("</td>");
												out.println("<td width='20%' bgcolor='#333333'>");
													//out.println("<input type='hidden' value='"+alist.size()+"' id='maxvalue"+count+"'/>");
													out.println("<input type='button' onclick='closeRemark("+alist.size()+")' value='Close' style='float: left; display: block; width: 75px; height: 25px; margin:2px; padding-top: 1px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;'/>");
													out.println("<input onclick='regRemarkSubSubmitBtn(\""+count+"\");' type='button' value='Save' style='float: right; display: block; width: 75px; height: 25px; margin:2px; padding-top: 1px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;'/>");
													
												out.println("</td>");
											out.println("</tr>");
											
										out.println("</table>");											
									out.println("</form>");									
							 	out.println("</div>");	
								
							}
							%>
			</div>
			<br />
			<h4 style="font-size: 18px; font-style: normal; float: left;">Today's
				Follow Up</h4>
			<h4 style="font-size: 18px; font-style: normal; float: right;">Passive
				List</h4>
			<div
				style="height: 310px; width: 520px; border: solid 2px #222222; overflow: scroll; overflow-x: scroll; overflow-y: scroll;">
				<table border="4" cellpadding="0" cellspacing="0" width="1024px">
					<thead>
						<tr>
							<th width="4%"><a href="#">S.no</a></th>
							<th width="13%"><a href="#">Full Name</a></th>
							<th width="11%"><a href="#">Contact No</a></th>
							<th width="11%"><a href="#">Course</a></th>
							<th width="12%"><a href="#">Date Of Joining</a></th>
							<th width="14%"><a href="#">Preferred Time</a></th>
							<th width="11%"><a href="#">Enquiry Date</a></th>
							<th width="12%"><a href="#">Reference Name</a></th>
							<th width="12%"><a href="#">Councillor</a></th>
						</tr>
					</thead>
				</table>
				<%
							for(String registrationId:plist){
								count++;
								TrainingRegistrationDTO dto=controller.getRegistration(registrationId);
								String maindivid="maindiv"+count;
								String subdivid="subdiv"+count;
							
								
									out.println("<div id='"+maindivid+"'>");
									out.println("<table border='1' cellpadding='0' cellspacing='0' width='1024px' ><tr bgcolor='#333333' onmousedown='showFeedBackAndRegistrationDetail("+count+")' onmouseup='createDiv("+count+","+(alist.size()+plist.size())+")' onmouseover=\"this.style.backgroundColor='#666666';\" onmouseout=\"this.style.backgroundColor='#333333';\">");
									out.println("<td width='4%'>"+count+"</td>");
									out.println("<td width='13%'>"+dto.getFullname()+"</td>");
									out.println("<td width='11%'>"+dto.getContact_no()+"</td>");
									out.println("<td width='11%'>"+dto.getRegisterForCourse()+"</td>");
									out.println("<td width='12%'>"+dto.getReg_date()+"</td>");
									out.println("<td width='14%'>"+dto.getPreferredtime_start()+"-"+dto.getPreferredtime_end()+"</td>");
									out.println("<td width='11%'></td>");
									out.println("<td width='12%'>"+dto.getReference_name()+"</td>");
									out.println("<td width='12%'>"+dto.getReg_employee_id()+"</td>");
									out.println("</tr></table>");
									out.println("</div>");
									
									
									out.println("<input type='hidden' id='h_id_Address"+count+"' value='"+dto.getAddress()+"'/>");
									out.println("<input type='hidden' id='h_id_Batch_time_end"+count+"' value='"+dto.getBatch_time_end()+"'/>");
									out.println("<input type='hidden' id='h_id_Batch_time_start"+count+"' value='"+dto.getBatch_time_start()+"'/>");
									out.println("<input type='hidden' id='h_id_College"+count+"' value='"+dto.getCollege()+"'/>");
									out.println("<input type='hidden' id='h_id_Contact_no"+count+"' value='"+dto.getContact_no()+"'/>");
									out.println("<input type='hidden' id='h_id_Date_of_birth"+count+"' value='"+dto.getDate_of_birth()+"'/>");
									out.println("<input type='hidden' id='h_id_Discount_detail"+count+"' value='"+dto.getDiscount_detail()+"'/>");
									out.println("<input type='hidden' id='h_id_Email_id"+count+"' value='"+dto.getEmail_id()+"'/>");
									out.println("<input type='hidden' id='h_id_Enrollment_no"+count+"' value='"+dto.getEnrollment_no()+"'/>");
									out.println("<input type='hidden' id='h_id_Father_name"+count+"' value='"+dto.getFather_name()+"'/>");
									out.println("<input type='hidden' id='h_id_Fullname"+count+"' value='"+dto.getFullname()+"'/>");
									out.println("<input type='hidden' id='h_id_Photo_path"+count+"' value='../studentimage/"+dto.getPhoto_path()+"'/>");
									out.println("<input type='hidden' id='h_id_Qualification"+count+"' value='"+dto.getQualification()+"'/>");
									out.println("<input type='hidden' id='h_id_Reference_contact_no"+count+"' value='"+dto.getReference_contact_no()+"'/>");
									out.println("<input type='hidden' id='h_id_Reference_name"+count+"' value='"+dto.getReference_name()+"'/>");
									out.println("<input type='hidden' id='h_id_Reference_note"+count+"' value='"+dto.getReference_note()+"'/>");
									out.println("<input type='hidden' id='h_id_Reg_date"+count+"' value='"+dto.getReg_date()+"'/>");
									out.println("<input type='hidden' id='h_id_Reg_employee_id"+count+"' value='"+dto.getReg_employee_id()+"'/>");
									out.println("<input type='hidden' id='h_id_RegisterForCourse"+count+"' value='"+dto.getRegisterForCourse()+"'/>");
									out.println("<input type='hidden' id='h_id_Registration_id"+count+"' value='"+dto.getRegistration_id()+"'/>");
									out.println("<input type='hidden' id='h_id_Discount_amount"+count+"' value='"+dto.getDiscount_amount()+"'/>");
									out.println("<input type='hidden' id='h_id_Total_amount"+count+"' value='"+dto.getTotal_amount()+"'/>");									
									out.println("<input type='hidden' id='h_id_Semester"+count+"' value='"+dto.getSemester()+"'/>");
									
									out.println("<div id='"+count+"' style='display:none' >");
									out.println("<form action='#saveregremark.jsp' id='subForm_"+count+"' method='post'>");
										out.println("<table border='1' width='924px' style='margin-left:50px; padding:3px'>");									
											out.println("<tr bgcolor='#aa1122'><td align='center'><b>Remark</b></td><td align='center'><b>Remarked Date</b></td><td align='center'><b>Alert Date</b></td><td align='center'><b>Councillor</b></td></tr>");
											
											List<Remark>listRemark=new RegistrationRemarkController().getAllRemarkForAnRegistration(dto.getRegistration_id());
											for(Remark remark:listRemark){
											out.println("<tr bgcolor='#330066'>");
												out.println("<td width='40%'>");
													out.println(remark.getRemark());
												out.println("</td>");
												out.println("<td width='20%'>");
													out.println(remark.getRemark_date());
												out.println("</td>");
												out.println("<td width='20%'>");
													out.println(remark.getRemark_alert());
												out.println("</td>");
												out.println("<td width='20%'>");
													out.println(remark.getCouncillor());
												out.println("</td>");
											out.println("</tr>");
											}
											out.println("<tr bgcolor='#999999'>");
												out.println("<td width='40%'>");
													out.println("<input type='hidden' name='enquiryid' value='"+dto.getRegistration_id()+"' size='52'/>");
													out.println("<input type='text' name='remark' id='my_id_remark"+count+"' value='' size='52'/>");
												out.println("</td>");
												out.println("<td width='20%'>");	
												Date date=new Date();
												String c_date=(1900+date.getYear())+"-"+(1+date.getMonth())+"-"+date.getDate();
													out.println("<input type='text' name='remarkdate' value='"+c_date+"' size='25' readonly='readonly'/>");
												out.println("</td>");
												out.println("<td width='20%'>");
													out.println("<input type='date' name='alertdate' id='id_alertdate_"+count+"' size='25' onclick='abc("+count+");'/>");														
												out.println("</td>");
												out.println("<td width='20%' bgcolor='#333333'>");
													out.println("<input type='hidden' value='"+(plist.size()+alist.size())+"' id='maxvalue"+count+"'/>");
													out.println("<input type='button' onclick='closeRemark("+count+")' value='Close' style='float: left; display: block; width: 75px; height: 25px; margin:2px; padding-top: 1px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;'/>");
													out.println("<input onclick='regRemarkSubSubmitBtn(\""+count+"\");' type='button' value='Save' style='float: right; display: block; width: 75px; height: 25px; margin:2px; padding-top: 1px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;'/>");
													
												out.println("</td>");
											out.println("</tr>");
											
										out.println("</table>");											
									out.println("</form>");									
							 	out.println("</div>");
							}
							%>
			</div>
			<%}
                		else if(enquiryList!=null){%>
			<h4 style="font-size: 18px; font-style: normal;">Search Result</h4>
			<%
                			if(enquiryList.size()>0){ 
                	%>

			<div
				style="height: 670px; width: 520px; border: solid 2px #222222; overflow: scroll; overflow-x: scroll; overflow-y: scroll;">
				<table border="4" cellpadding="0" cellspacing="0" width="1024px">
					<thead>
						<tr>
							<th width="4%"><a href="#">S.no</a></th>
							<th width="13%"><a href="#">Full Name</a></th>
							<th width="11%"><a href="#">Contact No</a></th>
							<th width="11%"><a href="#">Course</a></th>
							<th width="12%"><a href="#">Date Of Joining</a></th>
							<th width="14%"><a href="#">Preferred Time</a></th>
							<th width="11%"><a href="#">Enquiry Date</a></th>
							<th width="12%"><a href="#">Reference Name</a></th>
							<th width="12%"><a href="#">Councillor</a></th>
						</tr>
					</thead>
				</table>

				<%
								int count=1;
								int sno=0;
								for(NewTrainingEnquiryDTO newTrainingEnquiryDTO:enquiryList){
									String maindivid="maindiv"+count;
									String subdivid="subdiv"+count;
									out.println("<div id='"+maindivid+"'>");
									sno++;
									
									out.println("<input type='hidden' name='h_purpose' id='h_id_purpose"+count+"' value='"+newTrainingEnquiryDTO.getEnquiry_purpose()+"'/>");
									out.println("<input type='hidden' name='h_enquiryid' id='h_id_enquiryid"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_enquiry_id()+"'/>");
									out.println("<input type='hidden' name='h_fullname' id='h_id_fullname"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_fullname()+"'/>");
									out.println("<input type='hidden' name='h_father_name' id='h_id_father_name"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_father_name()+"'/>");
									out.println("<input type='hidden' name='h_qualification' id='h_id_qualification"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_qualification()+"'/>");
									out.println("<input type='hidden' name='h_college' id='h_id_college"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_college()+"'/>");
									out.println("<input type='hidden' name='h_semester' id='h_id_semester"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_semester()+"'/>");
									out.println("<input type='hidden' name='h_contact_no' id='h_id_contact_no"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_contact_no()+"'/>");
									out.println("<input type='hidden' name='h_email_id' id='h_id_email_id"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_email_id()+"'/>");
									String course_val="";
									for(int i=0;i<newTrainingEnquiryDTO.getTraining_enquiry_course().length;i++){
										course_val=course_val+newTrainingEnquiryDTO.getTraining_enquiry_course()[i]+",";
									}
									out.println("<input type='hidden' name='h_course' id='h_id_course"+count+"' value='"+course_val+"'/>");
									
									out.println("<input type='hidden' name='h_preferredtime_start' id='h_id_preferredtime_start"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_preferredtime_start()+"'/>");
									out.println("<input type='hidden' name='h_preferredtime_end' id='h_id_preferredtime_end"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_preferredtime_end()+"'/>");
									out.println("<input type='hidden' name='h_joining_date' id='h_id_joining_date"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_joining_date()+"'/>");
									out.println("<input type='hidden' name='h_reference_id' id='h_id_reference_id"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_referenceId()+"'/>");
									out.println("<input type='hidden' name='h_reference_name' id='h_id_reference_name"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_reference_name()+"'/>");
									out.println("<input type='hidden' name='h_reference_contact_no' id='h_id_reference_contact_no"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_reference_contact_no()+"'/>");
									out.println("<input type='hidden' name='h_reference_note' id='h_id_reference_note"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_reference_note()+"'/>");
									out.println("<input type='hidden' name='h_status' id='h_id_status"+count+"' value='"+newTrainingEnquiryDTO.getTraining_enquiry_enquiry_status()+"'/>");
									//System.out.println("Pref Start : "+newEnquiry.getPreferredtime_start());
									//System.out.println("Pref End : "+newEnquiry.getPreferredtime_end());
									
									out.println("<table border='1' cellpadding='0' cellspacing='0' width='1024px' ><tr bgcolor='#333333' onmousedown='showFeedBackAndEnquiryDetail("+count+")' onmouseup='createDiv("+count+","+enquiryList.size()+")' onmouseover=\"this.style.backgroundColor='#666666';\" onmouseout=\"this.style.backgroundColor='#333333';\">");
									out.println("<td width='4%'>"+sno+"</td>");
									out.println("<td width='13%'>"+newTrainingEnquiryDTO.getTraining_enquiry_fullname()+"</td>");
									out.println("<td width='11%'>"+newTrainingEnquiryDTO.getTraining_enquiry_contact_no()+"</td>");
									out.println("<td width='11%'>");
									String ces[]=newTrainingEnquiryDTO.getTraining_enquiry_course();
									for(String c:ces){
										out.println(c+", ");
									}
									out.println("</td>");
									out.println("<td width='12%'>"+newTrainingEnquiryDTO.getTraining_enquiry_joining_date()+"</td>");
									out.println("<td width='14%'>"+newTrainingEnquiryDTO.getTraining_enquiry_preferredtime_start()+" - "+newTrainingEnquiryDTO.getTraining_enquiry_preferredtime_end()+"</td>");
									out.println("<td width='11%'>"+newTrainingEnquiryDTO.getTraining_enquiry_date()+"</td>");
									out.println("<td width='12%'>"+newTrainingEnquiryDTO.getTraining_enquiry_reference_name()+"</td>");
									out.println("<td width='12%'>"+newTrainingEnquiryDTO.getEmployee_id()+"</td>");
									out.println("</tr></table>");
									
									out.println("<div id='"+count+"' style='display:none' >");
										out.println("<form action='#saveremark.jsp' id='subForm_"+count+"' method='post'>");
											out.println("<table border='1' width='924px' style='margin-left:50px; padding:3px'>");									
												out.println("<tr bgcolor='#aa1122'><td align='center'><b>Remark</b></td><td align='center'><b>Remarked Date</b></td><td align='center'><b>Alert Date</b></td><td align='center'><b>Councillor</b></td></tr>");
												List <EnquiryRemark>remarkList=enquiryService.getAllRemarkForAnTrainingEnquiry(newTrainingEnquiryDTO);
												for(EnquiryRemark enquiryRemark:remarkList){
												out.println("<tr bgcolor='#330066'>");
													out.println("<td width='40%'>");
														out.println(enquiryRemark.getRemark());
													out.println("</td>");
													out.println("<td width='20%'>");
														out.println(enquiryRemark.getRemark_date());
													out.println("</td>");
													out.println("<td width='20%'>");
														out.println(enquiryRemark.getRemark_alert());
													out.println("</td>");
													out.println("<td width='20%'>");
														out.println(enquiryRemark.getCouncillor());
													out.println("</td>");
												out.println("</tr>");
												}
												/*out.println("<tr bgcolor='#999999'>");
													out.println("<td width='40%'>");
														out.println("<input type='hidden' name='enquiryid' value='"+newTrainingEnquiryDTO.getTraining_enquiry_enquiry_id()+"' size='52'/>");
														out.println("<input type='text' name='remark' id='my_id_remark"+count+"' value='' size='52'/>");
													out.println("</td>");
													out.println("<td width='20%'>");	
													Date date=new Date();
													String c_date=(1900+date.getYear())+"-"+(1+date.getMonth())+"-"+date.getDate();
														out.println("<input type='text' name='remarkdate' value='"+c_date+"' size='25' readonly='readonly'/>");
													out.println("</td>");
													out.println("<td width='20%'>");
														out.println("<input type='date' name='alertdate' id='id_alertdate_"+count+"' size='25' onclick='abc("+count+");'/>");														
													out.println("</td>");
													out.println("<td width='20%' bgcolor='#333333'>");
														out.println("<input type='hidden' value='"+enquiryList.size()+"' id='maxvalue"+count+"'/>");
														out.println("<input type='button' onclick='closeRemark("+enquiryList.size()+")' value='Close' style='float: left; display: block; width: 75px; height: 25px; margin:2px; padding-top: 1px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;'/>");
														out.println("<input onclick='subSubmitBtn(\""+count+"\");' type='button' value='Save' style='float: right; display: block; width: 75px; height: 25px; margin:2px; padding-top: 1px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;'/>");
														
													out.println("</td>");
												out.println("</tr>");
												*/
											out.println("</table>");											
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
			<table width="100%">
				<tr>
					<td align="center">
						<h4 style="font-size: 14px; font-style: normal; color: #ffaabb;">Record
							not found</h4>
					</td>
				</tr>
			</table>
			<%}
                	} %>
		</div>
		<%
					String msg=(String)request.getAttribute("REGMSG");
					if(msg!=null){					
						%>
		<input type="hidden" id="msg_id" value="<%=msg %>" />
		<script>
						var retMsg = document.getElementById("msg_id").value;

						if (retMsg.isPrototypeOf("not") == false) {
							var no_use = new Array();
							ShowSuccessMessageDialog("Enquiry Message", retMsg,
									no_use);
						} else {
							ShowErrorMessageDialog("Enquiry Message", retMsg);
						}
						//alert(document.getElementById("msg_id").value);
					</script>
		<%
					}
					%>

		<form enctype="multipart/form-data" action="savenewregistration.jsp"
			method="post" onsubmit="return newInquiryFormValidation();">
			<!--<form id="savenewregistrationform" method="post" enctype="multipart/form-data" action="#" >-->
			<div class="rightContent">

				<table width="100%" border="0" align="right">
					<tr>
						<td align="center">
							<h4 id="id_enquirymsg">New Registration</h4>
						</td>
					</tr>
				</table>
				<table width="100%" align="right" border="1">
					<tr>
						<td rowspan="5" width="40%" align="center"><img
							id="id_images" alt="uplaod image" src="../images/photo.png" /></td>
						<td width="60%"><input type="text" readonly="readonly"
							name="registration_id" value="registration_id"
							id="id_training_registration_id" size="20" /> <input
							type="hidden" name="enquiry_id" id="id_training_enquiry_id" /></td>
					</tr>

					<tr>

						<td width="60%"><input type="text" name="fullname"
							id="id_training_fullname" size="20" /></td>
					</tr>
					<tr>
						<td width="60%"><input type="text" name="father_name"
							id="id_training_father_name" size="20" /></td>
					</tr>
					<tr>

						<td width="60%"><input type="text" name="contact_no"
							id="id_training_contact_no" size="20" /></td>
					</tr>
					<tr>
						<td width="60%"><input type="text" name="email_id"
							id="id_training_email_id" size="20" /></td>
					</tr>

					<tr>
						<td width="40%" align="right"><input type="file"
							name="photofile" size="20" style="width: 120px;"
							id="id_training_photofile" /></td>
						<td width="60%"><textarea rows="3" cols="17" name="address"
								id="id_training_address">Address</textarea></td>
					</tr>

					<tr>
						<td width="40%" align="right">Enrollment No:</td>
						<td width="60%"><input type="text" name="enrollment_no"
							id="id_training_enrollment_no" size="20" /></td>
					</tr>
					<tr>
						<td width="40%" align="right">Qualification :</td>
						<td width="60%"><select name="qualification"
							id="id_training_qualification">
								<option>B.E</option>
								<option>M.E</option>
								<option>M.Tech</option>
								<option>B.C.A</option>
								<option>M.C.A</option>
								<option>Other</option>
						</select></td>
					</tr>
					<tr>
						<td width="40%" align="right">College :</td>

						<td width="60%"><select name="college"
							id="id_training_college" style="width: 150px">
								<option value="Select">Select</option>
								<%
											for(College c:allCollegeList){
												out.println("<option value='"+c.getCollegeCode()+"'>"+c.getCollegeName()+"</option>");		
											}
										%>
						</select></td>
					</tr>
					<tr>
						<td width="40%" align="right">Semester :</td>
						<td width="60%"><select name="semester"
							id="id_training_semester">
								<option>First</option>
								<option>Second</option>
								<option>Third</option>
								<option>Four</option>
								<option>Five</option>
								<option>Six</option>
								<option>Seven</option>
								<option>Eight</option>
								<option>Pass Out</option>
								<option>Not Applicable</option>
						</select></td>
					</tr>

					<tr>
						<td width="40%" align="right">Date of Birth:</td>
						<td width="60%"><input type="text" name="date_of_birth"
							id="id_training_date_of_birth" size="20" /></td>
					</tr>
					<script type="text/javascript">
									new datepickr('id_training_date_of_birth',
											{
												'dateFormat' : 'm/d/y'
											});
								</script>
					<tr>
						<td width="40%" align="right">Course :</td>
						<td width="60%"><select name="course" id="id_training_course">
								<%
										for(Course c:allCourseList){
											out.println("<option value='"+c.getCourse_Id()+"'>"+c.getCourse_Name()+"</option>");		
										}
									%>
						</select></td>
					</tr>
					<tr>
						<td width="40%" align="right">Batch Time :</td>
						<td width="60%"><input type="text"
							id="id_training_batch_time_start" name="batch_time_start"
							size="5" /> <script>
											$(function() {
												$(
														'#id_training_batch_time_start')
														.timepicker(
																{
																	'timeFormat' : 'H:i:s'
																});
											});
										</script> <b>-</b> <input type="text" id="id_training_batch_time_end"
							name="batch_time_end" size="5" /> <script>
											$(function() {
												$('#id_training_batch_time_end')
														.timepicker(
																{
																	'timeFormat' : 'H:i:s'
																});
											});
										</script></td>
					</tr>
					<tr>
						<td width="40%" align="right">Course Fees :</td>
						<td width="60%"><input type="text" name="total_amount"
							id="id_training_total_amount" size="20" /></td>
					</tr>
					<tr>
						<td width="40%" align="right">Discount Amount :</td>
						<td width="60%"><input type="text" name="discount_amount"
							id="id_training_discount_amount" size="20" /></td>
					</tr>
					<tr>
						<td width="40%" align="right">Discount Detail's :</td>
						<td width="60%"><input type="text" name="discount_detail"
							id="id_training_discount_detail" size="20" /></td>
					</tr>
				</table>
				<table width="60%" border="0" align="center">
					<tr>
						<td align="center">
							<h4>Reference</h4>
						</td>
					</tr>
				</table>
				<table width="100%" border="1" align="right">
					<tr>
						<td width="40%" align="right">Full Name :</td>
						<td width="60%"><input type="text" name="reference_name"
							id="id_training_reference_name" size="20" /></td>
					</tr>
					<tr>
						<td width="40%" align="right">Contact No :</td>
						<td width="60%"><input type="text"
							name="reference_contact_no" id="id_training_reference_contact_no"
							size="20" /></td>
					</tr>
					<tr>
						<td width="40%" align="right">Note :</td>
						<td width="60%"><textarea rows="3" cols="17"
								name="reference_note" id="id_training_reference_note"></textarea>
						</td>
					</tr>
				</table>
				<table id="id_reg_tbl_button" width="100%" border="0" align="right">
					<tr>
						<td width="40%" align="left"><input type="reset"
							value="Clear"
							style="float: left; display: block; width: 100px; height: 26px; margin-top: 10px; padding-top: 4px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;" />
						</td>
						<td width="60%" align="right"><input type="submit"
							id="savenewregistrationbutton" value="Save"
							style="float: right; display: block; width: 100px; height: 26px; margin-top: 10px; padding-top: 4px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;" />
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
	<%@include file="../footer.jsp"%>
</div>

</div>
<!-- end of wrapper -->
</div>
<!-- end of wrapper_outer -->

</body>
</html>