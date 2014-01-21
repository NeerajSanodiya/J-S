
<%@include file="../../../common/chk.jsp"%>
<%@page import="com.js.tracker.ws.dto.EmployeDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.js.tracker.ws.controller.EmployeController"%>
<%@include file="supervisorheader.jsp"%>



<script src="js/employe.js"></script>
<br />
<div id="templatemo_content_wrapper">
	<div id="content">
		<div class="latestEvent">
			<h4></h4>
		</div>
		<div class="hr_divider_enquiry"></div>
		<div style="float: left; width: 570px; height: 552px;">
			<h4>Employee List</h4>
			<div width="100%" style="overflow: scroll; height: 450px;">
				<div style="width: 800px; color: #59AAFF;">
					<B>
						<table border="1" width="100%">
							<tr align="center">
								<td width="5%">SNo.</td>
								<td width="25%">Id</td>
								<td width="20%">Name</td>
								<td width="10%">Mobile No</td>
								<td width="20%">Operations</td>
							</tr>
						</table> </B>
				</div>
				<%
			 		List<EmployeDTO> employeList= new EmployeController().getSupervisorEmploee(request);
				int count=1;
					for(EmployeDTO employeDTO:employeList){
						out.println("<input type='hidden' id='id"+count+"' value='"+employeDTO.getId()+"'/>");
						out.println("<input type='hidden' id='name"+count+"' value='"+employeDTO.getName()+"'/>");
						out.println("<input type='hidden' id='fatherName"+count+"' value='"+employeDTO.getFatherName()+"'/>");
						out.println("<input type='hidden' id='email"+count+"' value='"+employeDTO.getEmail()+"'/>");
						out.println("<input type='hidden' id='address"+count+"' value='"+employeDTO.getAddress()+"'/>");
						out.println("<input type='hidden' id='mno"+count+"' value='"+employeDTO.getMno()+"'/>");
						out.println("<input type='hidden' id='salery"+count+"' value='"+employeDTO.getSalery()+"'/>");
						out.println("<input type='hidden' id='fromDate"+count+"' value='"+employeDTO.getFromDate()+"'/>");
						out.println("<input type='hidden' id='toDate"+count+"' value='"+employeDTO.getToDate()+"'/>");
						out.println("<input type='hidden' id='dob"+count+"' value='"+employeDTO.getDob()+"'/>");
						out.println("<input type='hidden' id='gender"+count+"' value='"+employeDTO.getGender()+"'/>");
						String statusStyle="";
						if(employeDTO.getActive_statis().equalsIgnoreCase("inactive")){
							statusStyle="style='background-color : #585858'";
						}
				%>

				<div style="width: 800px; color: #FFFFFF;">
					<table border="1" width="100%"
						onclick="showEmployeData(<%=count%>);" <%=statusStyle %>>
						<tr align="center">
							<td width="5%"><%=count %></td>
							<td width="25%"><%=employeDTO.getId() %></td>
							<td width="20%"><%=employeDTO.getName() %></td>
							<td width="10%"><%=employeDTO.getMno() %></td>
							<td width="20%"><a class="ankartag"
								href="employeservice.jsp?type=macreset&id=<%=employeDTO.getId() %>">Reset
									Mac</a> <%if(employeDTO.getActive_statis().equalsIgnoreCase("active")){ %>
								<a class="ankartag" 
								href="employeservice.jsp?type=active&id=<%=employeDTO.getId() %>&active_statis=inactive">In
									Activate</a> <% }else{%> <a class="ankartag" 
								href="employeservice.jsp?type=active&id=<%=employeDTO.getId() %>&active_statis=active">Activate</a>
								<%} %>
							</td>
						</tr>
					</table>
				</div>
				<%count++;} %>
			</div>
		</div>

		<div style="float: right; width: 260px; height: 552;">
			<h4>Employee Registration</h4>
			<form id="saveemployeForm" action="employeservice.jsp?type=save"
				method="post">
				<table width="100%" border="1" style="color: #ffffff;">
					<input type="hidden" name="id" />
					<tr id="row_id">
						<td>Id :</td>
						<td width="10%"><input style="width: 150px;"
							value=" Auto Generated" disabled="disabled" type="text"
							name="id1" /></td>
					</tr>
					<tr>
						<td>Full Name :</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>Father Name :</td>
						<td><input type="text" name="fatherName" /></td>
					</tr>
					<tr>
						<td>Gender :</td>
						<td><input id="id_male" type="radio" name="gender"
							value="male">Male <input id="id_female" type="radio"
							name="gender" value="female">Female</td>
					</tr>
					<tr>
						<td>Date of birth :</td>
						<td><input id="id_dob" type="text" name="dob" />
						</td>
						<script>
						  $(function() {
						    $( "#id_dob" ).datepicker({
						      changeMonth: true,
						      changeYear: true
						    });
						  });
						  </script>
					</tr>
					<tr>
						<td>Email :</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td>Address :</td>
						<td><input type="text" name="address" /></td>
					</tr>
					<tr>
						<td>Mobile No. :</td>
						<td><input type="text" name="mno" /></td>
					</tr>
					<tr>
						<td>Salary :</td>
						<td><input type="text" name="salery" /></td>
					</tr>
					<tr>
						<td>Salary Between :</td>
						<td align="center"><input id="id_fromDate" type="text"
							name="fromDate" style="width: 65px;" /><B> -</B> <input
							id="id_toDate" type="text" name="toDate" style="width: 65px;" />
						</td>
					</tr>
					<script>
							
							$(function() {
							    $( "#id_fromDate" ).datepicker({
							      defaultDate: "+1w",
							      changeMonth: true,
							      numberOfMonths: 1	,
							      onClose: function( selectedDate ) {
							        $( "#id_toDate" ).datepicker( "option", "minDate", selectedDate );
							      }
							    });
							    $( "#id_toDate" ).datepicker({
							      defaultDate: "+1w",
							      changeMonth: true,
							      numberOfMonths: 1,
							      onClose: function( selectedDate ) {
							        $( "#id_fromDate" ).datepicker( "option", "maxDate", selectedDate );
							      }
							    });
							  });
						</script>
				</table>
				</br>
				<table width="100%" border="0" style="color: #ffffff;">
					<tr align="center">
						<td width="50%"><input type="reset" value="Clear" /></td>
						<td width="50%"><input id="saveemployeBtn" type="submit"
							value="save" /></td>
					</tr>
				</table>
			</form>

		</div>
		<div class="cleaner"></div>
	</div>
	<div class="cleaner"></div>
</div>
<div id="templatemo_content_wrapper_bottm"></div>
<div id="templatemo_footer">
	<%@include file="../../footer.jsp"%>
</div>
</div>
<!-- end of wrapper -->
</div>
<!-- end of wrapper_outer -->
</body>
</html>