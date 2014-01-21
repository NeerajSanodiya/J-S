<%@include file="../common/chk.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.js.controller.EnquiryController"%>
<%@page import="java.util.*"%>
<%@page import="com.js.dto.*"%>
<%@page import="com.js.msg.*"%>
<%@include file="operatortopheader.jsp"%>
<%@include file="../common/header.jsp"%>

<link href="../templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="../css/jquery.ennui.contentslider.css" rel="stylesheet"
	type="text/css" media="screen,projection" />
<script type="text/javascript" src="../js/enquiry.js"></script>
<script type="text/javascript" src="../js/datepickr.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="../js/searchinq.js"></script>
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
List <String>statusList=enquiryService.getAllEnquiredStatus((String)request.getSession(false).getAttribute("BRANCHID"));
%>
<div id="templatemo_content_wrapper">
	<div id="content">
		<div class="latestEvent">
		<form name="myForm" action="searchenquiry.jsp" method="post"
				onsubmit="return mySearchFormValidation();" id="myForm">
			<table>
				<td width="20%" style="border: none; color: white; font-size: 18px;"><strong>Enquiry
						For :</strong></td>
				<td width="80%" style="border: none;"><select
					name="search_purpose" id="id_serch_purpose"
					onchange="showSearchForm(this)">
						<option value='Training'>Training</option>
						<option value='Academic Project'>Academic Project</option>
						<option value='Visitor' selected='selected'>Visitor</option>
						<option value='Live Project'>Live Project</option>
						<option value='Certificate'>Certificate</option>
						<option value='Experience'>Experience</option>
				</select></td>
			</table>
			</br>
			
				<table width="100%" border="1" align="left">
					<tr>
						<td width="15%" style="border: none;"><B
							style="font-size: 18px; color: #59aaff;">Search</B></td>
						<td width="19%" style="border: none;"></td>

						<td width="30%" style="border: none;"></td>
						<td width="12%" style="border: none;" align="right">Time :</td>
						<td width="18%" style="border: none;"><input type="text"
							id="id_search_enquiry_common_start_time"
							name="search_enquiry_common_start_time" size="5" /> <script>
								$(function() {
									$('#id_search_enquiry_common_start_time')
											.timepicker({
												'timeFormat' : 'H:i:s'
											});
								});
							</script> <b>-</b> <input type="text"
							id="id_search_enquiry_common_end_time"
							name="search_enquiry_common_end_time" size="5" /> <script>
								$(function() {
									$('#id_search_enquiry_common_end_time')
											.timepicker({
												'timeFormat' : 'H:i:s'
											});
								});
							</script></td>
					</tr>
				</table>

				<table width="100%" border="1" align="left"
					id="search_visitor_enquiry">
					<tr>
						<td width="15%">Full Name :</td>
						<td width="18%"><input type="text"
							name="search_visitor_enquiry_fullname"
							id="id_search_visitor_enquiry_fullname" style="width: 140px;" />
						</td>
						<td width="14%">Contact No :</td>
						<td width="18%"><input type="text"
							name="search_visitor_enquiry_contactno"
							id="id_search_visitor_enquiry_contactno" style="width: 140px;" />
						</td>
						<td width="13%">Enquiry Date :</td>
						<td width="18%"><input type="text"
							name="search_visitor_enquiry_start_date"
							id="id_search_visitor_enquiry_start_date" size="5" /> <b>-</b>&nbsp;<input
							type="text" name="search_visitor_enquiry_end_date"
							id="id_search_visitor_enquiry_end_date" size="5" /> <script
								type="text/javascript">
								new datepickr(
										'id_search_visitor_enquiry_start_date',
										{
											'dateFormat' : 'm/d/y'
										});
							</script> <script type="text/javascript">
								new datepickr(
										'id_search_visitor_enquiry_end_date', {
											'dateFormat' : 'm/d/y'
										});
							</script></td>
					</tr>
					<tr>
						<td>Reference Name :</td>
						<td><input type="text"
							name="search_visitor_enquiry_reference_name"
							id="id_search_visitor_enquiry_reference_name"
							style="width: 140px;" /></td>
						<td>Ref-Contact No :</td>
						<td><input type="text"
							name="search_visitor_enquiry_reference_no"
							id="id_search_visitor_enquiry_reference_no" style="width: 140px;" />
						</td>
						<td>Address :</td>
						<td><input type="text" name="search_visitor_enquiry_address"
							id="id_search_visitor_enquiry_reference_no" style="width: 140px;" />
						</td>
					</tr>
					<tr>
						<td>Appointment With :</td>
						<td><input type="text"
							name="search_visitor_enquiry_appointment_with"
							id="id_search_visitor_enquiry_appointment_with"
							style="width: 140px;" /></td>
						<td>Visiting Purpose :</td>
						<td><input type="text"
							name="search_visitor_enquiry_visiting_purpose"
							id="id_search_visitor_enquiry_visiting_purpose"
							style="width: 140px;" /></td>
						<td>Status :</td>
						<td><select name="search_visitor_enquiry_status"
							id="id_search_visitor_enquiry_status">
								<option value="Select">Select</option>
								<%
										for(String status:statusList){
											out.println("<option value='"+status+"'>"+status+"</option>");	
										}
									%>
						</select></td>
					</tr>
				</table>
				</table>
				<input type="submit" value="Search"
					style="float: right; display: block; width: 100px; height: 25px; margin: 2px; padding-top: 1px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;" />

			</form>


		</div>
		<div class="hr_divider"></div>
		<%
                	
		List <NewVisitorEnquiryDTO>visitorEnquiryDTOs  =(List <NewVisitorEnquiryDTO>)request.getAttribute("VISITORENQUIRYSEARCHRESULT");
               	%>
		<script type="text/javascript" language="javascript">
			function changeColor(count) {
				var mytr = document.getElementById("tr" + count);
				mytr.style = '{color:#aabbcc;}';
			}
			function showFeedBackAndEnquiryDetail(count) {
				document.getElementById("id_visitor_enquiry_enquiry_id").value = document
						.getElementById("h_id_visitor_enquiry_enquiry_id"
								+ count).value;
				document.getElementById("id_visitor_enquiry_fullname").value = document
						.getElementById("h_id_visitor_enquiry_fullname" + count).value;
				document.getElementById("id_visitor_enquiry_contact_no").value = document
						.getElementById("h_id_visitor_enquiry_contact_no"
								+ count).value;
				document.getElementById("id_visitor_enquiry_email_id").value = document
						.getElementById("h_id_visitor_enquiry_email_id" + count).value;
				document.getElementById("id_visitor_enquiry_address").value = document
						.getElementById("h_id_visitor_enquiry_address" + count).value;
				document.getElementById("id_visitor_enquiry_purpose").value = document
						.getElementById("h_id_visitor_enquiry_purpose" + count).value;
				document.getElementById("id_visitor_enquiry_appointment_with").value = document
						.getElementById("h_id_visitor_enquiry_appointment_with"
								+ count).value;
				document.getElementById("id_visitor_enquiry_note").value = document
						.getElementById("h_id_visitor_enquiry_note" + count).value;
				document.getElementById("id_visitor_enquiry_enquiry_status").value = document
						.getElementById("h_id_visitor_enquiry_enquiry_status"
								+ count).value;

				document.getElementById("id_visitor_enquiry_reference_name").value = document
						.getElementById("h_id_visitor_enquiry_reference_name"
								+ count).value;
				document.getElementById("id_visitor_enquiry_referenceId").value = document
						.getElementById("h_id_visitor_enquiry_referenceId"
								+ count).value;
				document
						.getElementById("id_visitor_enquiry_reference_contact_no").value = document
						.getElementById("h_id_visitor_enquiry_reference_contact_no"
								+ count).value;
				document.getElementById("id_visitor_enquiry_reference_note").value = document
						.getElementById("h_id_visitor_enquiry_reference_note"
								+ count).value;
				document.getElementById("id_button_table").style.display = "none";
			}
			function closeRemark(max) {
				for ( var i = 1; i <= max; i++) {
					if ($("#" + i).is(":visible")) {
						$("#" + i).hide();
					}
				}
			}
		</script>


		<div class="leftContent">
			<%
			
                		if(visitorEnquiryDTOs==null){
                			//visitorEnquiryDTOs =new ArrayList<NewVisitorEnquiryDTO>();                			
							
							List <List<NewVisitorEnquiryDTO>>allVisitorList=new EnquiryController().getAllVisitorFollowUp(request);
                			List <NewVisitorEnquiryDTO>activeVisitoryList=allVisitorList.get(0);
                			List <NewVisitorEnquiryDTO>passiveVisitoryList=allVisitorList.get(1);               			
							
                			visitorEnquiryDTOs=activeVisitoryList;
                			
                		%>
			<h4 style="font-size: 18px; font-style: normal; float: left;">Today's
				Follow Up</h4>

			<h4 style="font-size: 18px; font-style: normal; float: right;">Active
				List</h4>

			<div id="academic_enquiry_active_list_div"
				style="height: 310px; width: 520px; border: solid 2px #222222; overflow: scroll; overflow-x: scroll; overflow-y: scroll;">
				<table border="4" cellpadding="0" cellspacing="0" width="1024px">
					<thead>
						<tr>
							<th width="4%"><a href="#">S.no</a></th>
							<th width="13%"><a href="#">Full Name</a></th>
							<th width="11%"><a href="#">Contact No</a></th>
							<th width="11%"><a href="#">Visit Perpose</a></th>
							<th width="12%"><a href="#">Date Of Visit</a></th>
							<th width="14%"><a href="#">Address</a></th>
							<th width="11%"><a href="#">Meet with</a></th>
							<th width="12%"><a href="#">Reference Name</a></th>
							<th width="12%"><a href="#">Councillor</a></th>
						</tr>
					</thead>
				</table>
				<%
								int count=1;
								int mycount=0;
								int mysno=0;
								
								for(mycount=0;mycount<visitorEnquiryDTOs.size();mycount++){
									mysno++;
									
									NewVisitorEnquiryDTO dto=visitorEnquiryDTOs.get(mycount);
									
									String maindivid="maindiv"+count;
									String subdivid="subdiv"+count;
									out.println("<div id='"+maindivid+"'>");
									out.println("<table border='1' cellpadding='0' cellspacing='0' width='1024px' ><tr bgcolor='#333333' onmousedown='showFeedBackAndEnquiryDetail("+count+")' onmouseup='createDiv("+count+","+(activeVisitoryList.size()+passiveVisitoryList.size())+")' onmouseover=\"this.style.backgroundColor='#666666';\" onmouseout=\"this.style.backgroundColor='#333333';\">");
																	
									out.println("<input type='hidden' id='h_id_employee_id"+count+"' value='"+dto.getEmployee_id()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_enquiry_id"+count+"' value='"+dto.getVisitor_enquiry_enquiry_id()+"'/>");
									out.println("<input type='hidden' id='h_id_enquiry_purpose"+count+"' value='"+dto.getEnquiry_purpose()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_fullname"+count+"' value='"+dto.getVisitor_enquiry_fullname()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_contact_no"+count+"' value='"+dto.getVisitor_enquiry_contact_no()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_email_id"+count+"' value='"+dto.getVisitor_enquiry_email_id()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_address"+count+"' value='"+dto.getVisitor_enquiry_address()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_purpose"+count+"' value='"+dto.getVisitor_enquiry_purpose()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_appointment_with"+count+"' value='"+dto.getVisitor_enquiry_appointment_with()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_note"+count+"' value='"+dto.getVisitor_enquiry_note()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_date"+count+"' value='"+dto.getVisitor_enquiry_date()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_visiting_time_start"+count+"' value='"+dto.getVisitor_enquiry_visiting_time_start()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_visit_time_end"+count+"' value='"+dto.getVisitor_enquiry_visit_time_end()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_referenceId"+count+"' value='"+dto.getVisitor_enquiry_referenceId()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_reference_name"+count+"' value='"+dto.getVisitor_enquiry_reference_name()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_reference_contact_no"+count+"' value='"+dto.getVisitor_enquiry_reference_contact_no()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_reference_note"+count+"' value='"+dto.getVisitor_enquiry_reference_note()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_enquiry_status"+count+"' value='"+dto.getVisitor_enquiry_enquiry_status()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_entry_time"+count+"' value='"+dto.getVisitor_enquiry_entry_time()+"'/>");
									
									out.println("<td width='4%'>"+mysno+"</td>");
									out.println("<td width='13%'>"+dto.getVisitor_enquiry_fullname()+"</td>");
									out.println("<td width='11%'>"+dto.getVisitor_enquiry_contact_no()+"</td>");
									out.println("<td width='11%'>"+dto.getVisitor_enquiry_purpose()+"</td>");
									out.println("<td width='12%'>"+dto.getVisitor_enquiry_date()+"</td>");
									out.println("<td width='14%'>"+dto.getVisitor_enquiry_address()+"</td>");
									out.println("<td width='11%'>"+dto.getVisitor_enquiry_appointment_with()+"</td>");
									out.println("<td width='12%'>"+dto.getVisitor_enquiry_reference_name()+"</td>");
									out.println("<td width='12%'>"+dto.getEmployee_id()+"</td>");
									out.println("</tr></table>");									
									out.println("</div>");
									count++;
								}
							 %>
			</div>

			<br />
			<h4 style="font-size: 18px; font-style: normal; float: left;">Today's
				Follow Up</h4>
			<h4 style="font-size: 18px; font-style: normal; float: right;">Passive
				List</h4>

			<div id="academic_enquiry_passive_list_div"
				style="height: 310px;  width: 520px; border: solid 2px #222222; overflow: scroll; overflow-x: scroll; overflow-y: scroll;">
				<table border="4" cellpadding="0" cellspacing="0" width="1024px">
					<thead>
						<tr>
							<th width="4%"><a href="#">S.no</a></th>
							<th width="13%"><a href="#">Full Name</a></th>
							<th width="11%"><a href="#">Contact No</a></th>
							<th width="11%"><a href="#">Visit Perpose</a></th>
							<th width="12%"><a href="#">Date Of Visit</a></th>
							<th width="14%"><a href="#">Address</a></th>
							<th width="11%"><a href="#">Meet with</a></th>
							<th width="12%"><a href="#">Reference Name</a></th>
							<th width="12%"><a href="#">Councillor</a></th>
						</tr>
					</thead>
				</table>
				<%
								count=1;
								//mycount=0;
								mysno=0;
								visitorEnquiryDTOs=passiveVisitoryList;
								for(mycount=0;mycount<visitorEnquiryDTOs.size();mycount++){
									mysno++;
									
									NewVisitorEnquiryDTO dto=visitorEnquiryDTOs.get(mycount);
									
									String maindivid="maindiv"+count;
									String subdivid="subdiv"+count;
									out.println("<div id='"+maindivid+"'>");
									out.println("<table border='1' cellpadding='0' cellspacing='0' width='1024px' ><tr bgcolor='#333333' onmousedown='showFeedBackAndEnquiryDetail("+count+")' onmouseup='createDiv("+count+","+(activeVisitoryList.size()+passiveVisitoryList.size())+")' onmouseover=\"this.style.backgroundColor='#666666';\" onmouseout=\"this.style.backgroundColor='#333333';\">");
																	
									out.println("<input type='hidden' id='h_id_employee_id"+count+"' value='"+dto.getEmployee_id()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_enquiry_id"+count+"' value='"+dto.getVisitor_enquiry_enquiry_id()+"'/>");
									out.println("<input type='hidden' id='h_id_enquiry_purpose"+count+"' value='"+dto.getEnquiry_purpose()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_fullname"+count+"' value='"+dto.getVisitor_enquiry_fullname()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_contact_no"+count+"' value='"+dto.getVisitor_enquiry_contact_no()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_email_id"+count+"' value='"+dto.getVisitor_enquiry_email_id()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_address"+count+"' value='"+dto.getVisitor_enquiry_address()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_purpose"+count+"' value='"+dto.getVisitor_enquiry_purpose()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_appointment_with"+count+"' value='"+dto.getVisitor_enquiry_appointment_with()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_note"+count+"' value='"+dto.getVisitor_enquiry_note()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_date"+count+"' value='"+dto.getVisitor_enquiry_date()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_visiting_time_start"+count+"' value='"+dto.getVisitor_enquiry_visiting_time_start()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_visit_time_end"+count+"' value='"+dto.getVisitor_enquiry_visit_time_end()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_referenceId"+count+"' value='"+dto.getVisitor_enquiry_referenceId()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_reference_name"+count+"' value='"+dto.getVisitor_enquiry_reference_name()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_reference_contact_no"+count+"' value='"+dto.getVisitor_enquiry_reference_contact_no()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_reference_note"+count+"' value='"+dto.getVisitor_enquiry_reference_note()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_enquiry_status"+count+"' value='"+dto.getVisitor_enquiry_enquiry_status()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_entry_time"+count+"' value='"+dto.getVisitor_enquiry_entry_time()+"'/>");
									
									out.println("<td width='4%'>"+mysno+"</td>");
									out.println("<td width='13%'>"+dto.getVisitor_enquiry_fullname()+"</td>");
									out.println("<td width='11%'>"+dto.getVisitor_enquiry_contact_no()+"</td>");
									out.println("<td width='11%'>"+dto.getVisitor_enquiry_purpose()+"</td>");
									out.println("<td width='12%'>"+dto.getVisitor_enquiry_date()+"</td>");
									out.println("<td width='14%'>"+dto.getVisitor_enquiry_address()+"</td>");
									out.println("<td width='11%'>"+dto.getVisitor_enquiry_appointment_with()+"</td>");
									out.println("<td width='12%'>"+dto.getVisitor_enquiry_reference_name()+"</td>");
									out.println("<td width='12%'>"+dto.getEmployee_id()+"</td>");
									out.println("</tr></table>");									
									out.println("</div>");
									count++;
								}
							 %>
			</div>




			<%}
                		else if(visitorEnquiryDTOs!=null){%>
			<h4 style="font-size: 18px; font-style: normal;">Search Result</h4>
			<%
                			if(visitorEnquiryDTOs.size()>0){ 
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
								int mycount=0;
								int mysno=0;
								
								for(mycount=0;mycount<visitorEnquiryDTOs.size();mycount++){
									mysno++;
									
									NewVisitorEnquiryDTO dto=visitorEnquiryDTOs.get(mycount);
									
									String maindivid="maindiv"+count;
									String subdivid="subdiv"+count;
									out.println("<div id='"+maindivid+"'>");
									out.println("<table border='1' cellpadding='0' cellspacing='0' width='1024px' ><tr bgcolor='#333333' onmousedown='showFeedBackAndEnquiryDetail("+count+")' onmouseup='createDiv("+count+","+(visitorEnquiryDTOs.size())+")' onmouseover=\"this.style.backgroundColor='#666666';\" onmouseout=\"this.style.backgroundColor='#333333';\">");
																	
									out.println("<input type='hidden' id='h_id_employee_id"+count+"' value='"+dto.getEmployee_id()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_enquiry_id"+count+"' value='"+dto.getVisitor_enquiry_enquiry_id()+"'/>");
									out.println("<input type='hidden' id='h_id_enquiry_purpose"+count+"' value='"+dto.getEnquiry_purpose()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_fullname"+count+"' value='"+dto.getVisitor_enquiry_fullname()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_contact_no"+count+"' value='"+dto.getVisitor_enquiry_contact_no()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_email_id"+count+"' value='"+dto.getVisitor_enquiry_email_id()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_address"+count+"' value='"+dto.getVisitor_enquiry_address()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_purpose"+count+"' value='"+dto.getVisitor_enquiry_purpose()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_appointment_with"+count+"' value='"+dto.getVisitor_enquiry_appointment_with()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_note"+count+"' value='"+dto.getVisitor_enquiry_note()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_date"+count+"' value='"+dto.getVisitor_enquiry_date()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_visiting_time_start"+count+"' value='"+dto.getVisitor_enquiry_visiting_time_start()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_visit_time_end"+count+"' value='"+dto.getVisitor_enquiry_visit_time_end()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_referenceId"+count+"' value='"+dto.getVisitor_enquiry_referenceId()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_reference_name"+count+"' value='"+dto.getVisitor_enquiry_reference_name()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_reference_contact_no"+count+"' value='"+dto.getVisitor_enquiry_reference_contact_no()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_reference_note"+count+"' value='"+dto.getVisitor_enquiry_reference_note()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_enquiry_status"+count+"' value='"+dto.getVisitor_enquiry_enquiry_status()+"'/>");
									out.println("<input type='hidden' id='h_id_visitor_enquiry_entry_time"+count+"' value='"+dto.getVisitor_enquiry_entry_time()+"'/>");
									
									out.println("<td width='4%'>"+mysno+"</td>");
									out.println("<td width='13%'>"+dto.getVisitor_enquiry_fullname()+"</td>");
									out.println("<td width='11%'>"+dto.getVisitor_enquiry_contact_no()+"</td>");
									out.println("<td width='11%'>"+dto.getVisitor_enquiry_purpose()+"</td>");
									out.println("<td width='12%'>"+dto.getVisitor_enquiry_date()+"</td>");
									out.println("<td width='14%'>"+dto.getVisitor_enquiry_address()+"</td>");
									out.println("<td width='11%'>"+dto.getVisitor_enquiry_appointment_with()+"</td>");
									out.println("<td width='12%'>"+dto.getVisitor_enquiry_reference_name()+"</td>");
									out.println("<td width='12%'>"+dto.getEmployee_id()+"</td>");
									out.println("</tr></table>");									
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
		<script type="text/javascript">
			function showEnquiryForm(select) {
				if (select.value == 'Academic Project') {
					$("#training_enquiry_div").hide();
					$("#visitor_enquiry_div").hide();
					$("#academic_project_enquiry_div").show();
				}
				if (select.value == "Training") {
					$("#academic_project_enquiry_div").hide();
					$("#visitor_enquiry_div").hide();
					$("#training_enquiry_div").show();
				}
				if (select.value == "Visitor") {
					$("#academic_project_enquiry_div").hide();
					$("#training_enquiry_div").hide();
					$("#visitor_enquiry_div").show();
				}
			}
		</script>
		<form action="#" id="savenewenquiryForm">
			<div class="rightContent">
				<table width="100%" border="0" align="right">
					<tr>
						<td align="center">
							<div id="id_enquirymsg">
								<h4>New Enquiry</h4>
							</div>
						</td>
					</tr>
				</table>

				<table width="100%" align="right" border="1">
					<tr>
						<td width="40%" align="right">Enquiry Purpose :</td>
						<td width="60%"><select name="enquiry_purpose"
							disabled="disabled" id="id_enquiry_purpose" style="width: 160px;"
							onchange="showEnquiryForm(this)">
								<option selected="selected" value="Visitor">Visitor</option>
								<option value="Training">Training</option>
								<option value="Academic Project">Academic Project</option>
								<option value="Certificate">Certificate</option>
								<option value="Experience">Experience</option>
								<option value="Live Project">Live Project</option>
						</select></td>
					</tr>
				</table>

				<div id="visitor_enquiry_div">
					<table width="100%" align="right" border="1">
						<tr>
							<td width="40%" align="right">Full Name :</td>
							<td width="60%"><input type="hidden"
								name="visitor_enquiry_enquiry_id"
								id="id_visitor_enquiry_enquiry_id" size="20" /> <input
								type="text" name="visitor_enquiry_fullname"
								id="id_visitor_enquiry_fullname" size="21" /></td>
						</tr>
						<tr>
							<td width="40%" align="right">Contact No :</td>
							<td width="60%"><input type="text"
								name="visitor_enquiry_contact_no"
								id="id_visitor_enquiry_contact_no" size="21" /></td>
						</tr>
						<tr>
							<td width="40%" align="right">Email-Id :</td>
							<td width="60%"><input type="text"
								name="visitor_enquiry_email_id" id="id_visitor_enquiry_email_id"
								size="21" /></td>
						</tr>
						<tr>
							<td width="40%" align="right">Address :</td>
							<td width="60%"><textarea name="visitor_enquiry_address"
									id="id_visitor_enquiry_address" rows="3" style="width: 157px;"></textarea>
							</td>
						</tr>
						<tr>
							<td width="40%" align="right">Purpose to Visite :</td>
							<td width="60%"><input type="text"
								name="visitor_enquiry_purpose" id="id_visitor_enquiry_purpose"
								size="21" /></td>
						</tr>
						<tr>
							<td width="40%" align="right">Appointment with :</td>
							<td width="60%"><input type="text"
								name="visitor_enquiry_appointment_with"
								id="id_visitor_enquiry_appointment_with" size="21" /></td>
						</tr>
						<tr>
							<td width="40%" align="right">Note :</td>
							<td width="60%"><textarea name="visitor_enquiry_note"
									id="id_visitor_enquiry_note" rows="3" style="width: 157px;"></textarea>
							</td>
						</tr>
						<tr>
							<td width="40%" align="right">Status :</td>
							<td width="60%"><select
								name="visitor_enquiry_enquiry_status"
								id="id_visitor_enquiry_enquiry_status" disabled="disabled"
								style="width: 160px;">
									<option value="Fresh">Fresh</option>
									<option value="Under Process">Under Process</option>
									<option value="Closed">Closed</option>
							</select></td>
						</tr>
					</table>

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
							<td width="40%" align="right">Full Name :</td>
							<td width="60%"><input type="text"
								name="visitor_enquiry_reference_name"
								id="id_visitor_enquiry_reference_name" value="Not Applicable"
								size="21" /> <input type="hidden"
								name="visitor_enquiry_referenceId"
								id="id_visitor_enquiry_referenceId" value="" size="20" /></td>
						</tr>
						<tr>
							<td width="40%" align="right">Contact No :</td>
							<td width="60%"><input type="text"
								name="visitor_enquiry_reference_contact_no"
								id="id_visitor_enquiry_reference_contact_no" value="0000000000"
								size="21" /></td>
						</tr>
						<tr>
							<td width="40%" align="right">Note :</td>
							<td width="60%"><textarea rows="3" cols="17"
									name="visitor_enquiry_reference_note"
									id="id_visitor_enquiry_reference_note">self</textarea></td>
						</tr>
					</table>
				</div>
				<table id="id_button_table" width="100%" border="0" align="right">
					<tr>
						<td width="40%" align="left"><input type="reset"
							value="Clear" id="clearnewenquiryBtn"
							style="float: left; display: block; width: 100px; height: 26px; margin-top: 10px; padding-top: 4px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(images/templatemo_btn.png) no-repeat;" />
						</td>
						<td width="60%" align="right"><input type="button"
							value="Save" id="savenewenquiryBtn"
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
</div>

</body>
</html>