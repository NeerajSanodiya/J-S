<%@page import="com.js.tracker.ws.controller.TimeLogController"%>
<%@page import="com.js.tracker.ws.dao.TimeLogDAO"%>
<%@include file="chk.jsp"%>
<%@page import="com.js.tracker.ws.util.TrackerDate"%>
<%@page import="com.js.tracker.ws.dto.UserDateWiseDTO"%>
<%@page import="com.js.tracker.ws.dto.SearchResultDTO"%>
<%@page import="com.js.tracker.ws.dto.TimeLogDTO"%>
<%@page import="com.js.tracker.ws.controller.LoginController"%>
<%@page import="com.js.tracker.ws.dto.LoginDTO"%>
<%@page import="java.util.List"%>
<%@include file="supervisorheader.jsp"%>
<br />



<div id="templatemo_content_wrapper">
	<div id="content">
		<div class="latestEvent">
			<div>
				<form action="viewlog.jsp" method="post">
					<script>
						function logTypeOnchange(obj) {
							var todate = document.getElementById("id_toDate");
							var fromdate = document.getElementById("id_fromDate");
							var id_viewType = document
									.getElementById("id_viewType");
							if (obj.value == "Date") {
								todate.disabled = false;
								fromdate.disabled = false;
							} else {
								todate.disabled = true;
								fromdate.disabled = true;
							}
						}
					</script>
					<table width="95%" border="1">
						<tr style="vertical-align: middle;">
							<td><B>Select Employee : </B></td>
							<td> <select name="username"
								id="id_username" style="width: 120px;">
									<option value="all">All</option>
									<%
										LoginController loginController = new LoginController();

										List<LoginDTO> list = loginController.getAllUser(request);
										for (LoginDTO dto : list) {
									%>
									<option value="<%=dto.getUnm()%>"><%=dto.getUnm()%></option>
									<%
										}
									%>
							</select></td>
							<td><B>Log Type : </B></td>
							<td><select name="logType"
								onchange="logTypeOnchange(this);" style="width: 120px;">

									<option value="Today">Today</option>
									<option value="Week">Week</option>
									<option value="Month">Month</option>
									<option value="Date">Date</option>

								</select>
							</td>
							<td><B>Date : </B></td>
							<td width="34%">
								<input style="width: 120px;" disabled="disabled" type="text" id="id_fromDate" name="fromDate" /><b>-</b>
								<input style="width: 120px;" disabled="disabled" type="text" id="id_toDate" name="toDate" />
							</td>
						</tr>
						<tr>
							<td>
								<B>Time Log : </B>
							</td>
							
							<td colspan="2">
								<input type="radio" name="log_type" value="auto" checked="checked"><B>Auto</B>
								<input type="radio" name="log_type" value="manual"><B>Manual Request</B>
								<% 
									List<TimeLogDTO>logDTOs= new TimeLogController().userManualTimeLog(request);
									if(logDTOs!=null){
										if(logDTOs.size()>0){
											%>											
											<div class="manualcount" style="width: 12px;margin-right: 10px;margin-top: -2px;float: right;"> <B>(<B style="color: red;"><%=logDTOs.size() %></B></B>)
    											<div class="scrollbar" id="manualitem">
    												<%for(TimeLogDTO dto:logDTOs){ %>
      												<div class="force-overflow">
														<%=dto.getUsername() %>
													</div>
													<%} %>
    											</div> 
											</div> 	
											<%
										}
									}
								%>
							</td>
							<td colspan="6" align="right"><input type="submit"
								value="View" style="float: right; display: block; width: 100px; height: 25px; margin: 2px; padding-top: 1px; font-size: 12px; font-weight: bold; color: #a9a9a9; text-align: center; background: url(../../images/templatemo_btn.png) no-repeat;"/></td>
								
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
				</form>
			</div>
		</div>
		<div class="hr_divider_enquiry"></div>
		<script type="text/javascript">
			function showMainDiv(divid){
				var mainMaxDiv=document.getElementById("mainMaxDiv").value;
				var max=parseInt(""+mainMaxDiv);
				
				for(var i=0;i<=max;i++){
					if(divid!=i){
						var appBanners = document.getElementsByClassName('class_'+i);
						for (var j = 0; j < appBanners.length; j ++) {
					    	appBanners[j].style.display = 'none';						    
						}
					}
				}
				var appBanners = document.getElementsByClassName('class_'+divid);
				for (var j = 0; j < appBanners.length; j ++) {					
					if(isVisible(appBanners[j])){
						appBanners[j].style.display = 'none';	
					}else{
						appBanners[j].style.display = 'block';
					}			    
				}				
			}
			function isVisible(elem) {
			  return elem.offsetWidth > 0 || elem.offsetHeight > 0;
			}
			function showSubDiv(divclass,subdivclass){
				
				var subMaxDiv=document.getElementById("subMaxDiv_"+divclass).value;
				var max=parseInt(""+subMaxDiv);
				
				for(var i=0;i<=max;i++){
					if(subdivclass!=i){
						var appBanners = document.getElementsByClassName('class_'+divclass+'_'+i);
						for (var j = 0; j < appBanners.length; j ++) {
					    	appBanners[j].style.display = 'none';					    
						}
					}				
				}
				
				var appBanners = document.getElementsByClassName('class_'+divclass+'_'+subdivclass);
				for (var j = 0; j < appBanners.length; j ++) {
					if(isVisible(appBanners[j])){
						appBanners[j].style.display = 'none';	
					}else{
						appBanners[j].style.display = 'block';
					}				    
				}
			}
			function loadImageData(username,date){
				$("#imagedata_id").after().load("photodiv.jsp?username="+username+"&date="+date);
				event.preventDefault();
			}
		</script>
		<%
			List<SearchResultDTO> searchResultDTOs = (List<SearchResultDTO>) request
					.getAttribute("LOGRESULT");
			
		%>
		
	
	
		<div style="float:left;width:520px;height:552;">
			<h4>Search Result</h4>
			<div width="100%"  style="height: 552px;overflow: scroll;">
			<div width="100%" style="border-radius:5px;color: #298BFF; font-size: 14px;">
				<B><table border="2" width="100%" style="color:#ffffff;">
					<tr align="center">
						<td style="background-color: #AA8FAA;" width="12%">S.No</td>
						<td style="background-color: #AA8FAA;" width="50%">User Name</td>
						<td style="background-color: #AA8FAA;" width="20%">No of days</td>
						<td style="background-color: #AA8FAA;" width="18%" align="center">Hours</td>
					</tr>
				</table></B>
			</div>
			<%
			if(searchResultDTOs!=null){
			int count=1;
				for(SearchResultDTO searchResultDTO:searchResultDTOs){
					long mainTotalTime=Long.parseLong(searchResultDTO.getTotalhours());
			%>
			<div width="100%">
				<table border="1" width="100%" onclick="showMainDiv(<%=count %>);">
					<tr>
						<td width="12%"><%=count %></td>
						<td width="50%"><%=searchResultDTO.getUsername() %></td>
						<td width="20%"><%=searchResultDTO.getNoDays() %></td>
						<td width="18%" align="right"><%=TrackerDate.getInstance().formatTimeInHours(mainTotalTime) %></td>
					</tr>
				</table>
				<div width="100%" align="center" class="class_<%=count %>" style="display: none;color: #298BFF; font-size: 14px">
					<B><table border="1" width="90%" style="color:#ffffff;">
						<tr align="center">
							<td style="background-color: #CD853F;"  width="18%">Date</td>
							<td style="background-color: #CD853F;"  width="10%">Day</td>
							<td style="background-color: #CD853F;"  width="16%">Slot</td>
							<td style="background-color: #CD853F;"  width="18%">Sing In</td>
							<td style="background-color: #CD853F;"  width="18%">Sing out</td>
							<td style="background-color: #CD853F;"  width="18%" align="center">Hours</td>							
						</tr>
					</table></B>
				</div>
				<% 
					List<UserDateWiseDTO> dateWiseDTOs=searchResultDTO.getList();
					int inerCount=1;
					for(UserDateWiseDTO userDateWiseDTO:dateWiseDTOs){
						
						long dateTotalTime=Long.parseLong(userDateWiseDTO.getTotalhours());
						long dateStartTime=Long.parseLong(userDateWiseDTO.getStime());
						long dateEndTime=Long.parseLong(userDateWiseDTO.getEtime());
				%>
				<div width="100%" align="center" onclick="showSubDiv(<%=count %>,<%=inerCount %>);" align="right" style="display: none;" class="class_<%=count %>">
					<table border="1" width="90%">
						<tr>
							<td width="18%"><%=TrackerDate.getInstance().changeDateFormate_df1_df(userDateWiseDTO.getDate())%></td>
							<td width="10%"><%=userDateWiseDTO.getDay() %></td>
							<td width="16%"><%=userDateWiseDTO.getSlote() %></td>
							<td width="18%"><%=TrackerDate.getInstance().getTimeFormat(dateStartTime) %></td>
							<td width="18%"><%=TrackerDate.getInstance().getTimeFormat(dateEndTime) %></td>
							<td onclick="loadImageData('<%=searchResultDTO.getUsername() %>','<%=userDateWiseDTO.getDate() %>')" width="18%" align="right"><%=TrackerDate.getInstance().formatTimeInHours(dateTotalTime) %></td>							
						</tr>
					</table>
					<div width="100%" align="center" style="display: none;color: #FFFFFF; font-size: 14px" class="class_<%=count %>_<%=inerCount%>">
						<B><table border="1" width="80%">
							<tr align="center">
								<td style="background-color: #BC8F8F;" width="38.5%">Timer Start</td>
								<td style="background-color: #BC8F8F;" width="39%">Timer End</td>
								<td style="background-color: #BC8F8F;" width="22.5%" align="center">Hours</td>
							</tr>
						</table></B>
					</div>
					<% 
						List<TimeLogDTO>timeLogDTOs =userDateWiseDTO.getList();
						for(TimeLogDTO timeLogDTO:timeLogDTOs){
							long startTime=Long.parseLong(timeLogDTO.getStart_time());
							long endTime=Long.parseLong(timeLogDTO.getEnd_time());
					%>
					<div width="100%" align="center" style="display: none;" class="class_<%=count %>_<%=inerCount%>">
						<table border="1" width="80%">
							<tr>
								<td width="38.5%"><%=TrackerDate.getInstance().getTimeFormat(startTime) %></td>
								<td width="39%"><%=TrackerDate.getInstance().getTimeFormat(endTime) %></td>
								<td width="22.5%" align="right"><%=TrackerDate.getInstance().formatTimeInHours(endTime-startTime) %></td>															
							</tr>
							<%
								String status=timeLogDTO.getM_entry_status();
								if(status.equalsIgnoreCase("fresh")){
							%>
								<tr id="table_row_id<%=count%>">
									<td colspan="3" align="right">
										<form action="manualstatus.jsp" method="post">
											<input type="hidden" name="username" value="<%=timeLogDTO.getUsername()%>"/>
											<input type="hidden" name="c_date" value="<%=timeLogDTO.getC_date()%>"/>
											<input type="hidden" name="start_time" value="<%=timeLogDTO.getStart_time()%>"/>
											<input type="hidden" name="end_time" value="<%=timeLogDTO.getEnd_time()%>"/>
											<input type="submit" name="mysubmit" value="Approve"/>
											<input type="submit" name="mysubmit" value="Reject"/>
										</form>
									</td>
								</tr>
							<%
								}
							%>
						</table>
					</div>
					<%} %>
				</div>
				<%inerCount++;} %>
			</div>			
			<%
					out.println("<input type='hidden' id='subMaxDiv_"+count+"' value='"+(inerCount-1)+"'/>");
					count++;
				}out.println("<input type='hidden' id='mainMaxDiv' value='"+(count-1)+"'/>"); 
			}
			%>
		</div>
		</div>
		<div class="rightContent">
			
			<div id="imagedata_id" width="100%" style="height: 552px;"></div>
			
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