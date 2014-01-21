<%@page import="com.js.msg.MyMessage"%>
<%@include file="header.jsp"%>
<%@include file="visitorheader.jsp"%>

<div id="templatemo_slider_wrapper">
	<div id="templatemo_slider">
		<div id="one" class="contentslider">
			<div class="cs_wrapper">
				<div class="cs_slider">

					<div class="cs_article">
						<div class="slider_content_wrapper">

							<div class="slider_image">
								<img src="images/slider/career.jpg" alt="Mauris quis eros arcu" />
							</div>

							<div class="slider_content">
								<h3>Why You Should Choose Us</h3>

								<p style="text-align: justify;">We are a panel of competent
									and resourceful professionals. In keeping with the current
									industry requirement, Career With Us Consultancy Services has
									developed a mix of professionals with domain and functional
									experience, who act as a like -minded sounding board to the
									customer-who could be an organization or a candidate. The
									professional approach provides a platform for the customer to
									identify the necessary competitive edge.</p>



							</div>

						</div>
					</div>
					<!-- End cs_article -->

				</div>
				<!-- End cs_slider -->
			</div>
			<!-- End cs_wrapper -->
		</div>
		<!-- End contentslider -->

		<!-- Site JavaScript -->
		<script type="text/javascript" src="js/jquery-1.3.1.min.js"></script>
		<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
		<script type="text/javascript" src="js/jquery.ennui.contentslider.js"></script>
		<script type="text/javascript">
			$(function() {
				$('#one').ContentSlider({
					width : '940px',
					height : '240px',
					speed : 400,
					easing : 'easeOutSine'
				});
			});
		</script>
		<script src="js/jquery.chili-2.2.js" type="text/javascript"></script>
		<script src="js/chili/recipes.js" type="text/javascript"></script>
		<div class="cleaner"></div>

	</div>

</div>

<div id="templatemo_content_wrapper">
	<div id="content">

		<h4>Current Opening</h4>

		<div class="reasons" style="width: 800px;">
			<p style="text-align: justify;">
				We are undergoing a rapid growth not only in terms of an exponential
				increase in our customer base but also in the adoption of new
				technologies. <br /> <br /> Apart from building upon our core
				proficiency in PHP, web services, and XML we also want to make a
				strong push into the sphere of .NET and Java. We are broadening our
				horizons and are set to explore new avenues of growth. For this
				reason we require dedicated professionals who can aid the company's
				endeavor with their expertise. <br /> <br /> Here at JS
				Informatics we are allways looking for talent. If you think you are
				talented enough Post your resume
			</p>

		</div>

		<div class="reasons"></div>

		<div class="reasons"></div>

		<div class="hr_divider"></div>

		<div class="col_w560" style="width: 270px;">

			<div class="image_wrapper image_fl" style="width: 250px;">
				<img src="images/templatemo_image_01.jpg" alt="TemplatemoImage01"
					height="250px;" />
			</div>

		</div>

		<div class="col_w280" style="width: 450px;">
			<h4>Post Resume</h4>
			<%
				String message = (String) request.getAttribute("message");
				if (message != null) {
					out.print("<input type='hidden' value='" + message
							+ "' id='id_message'/>");
			%>
			<script type="text/javascript">
				var msg = document.getElementById("id_message").value;
				alert(msg);
			</script>
			<%
				}
			%>
			<form method="POST" enctype="multipart/form-data"
				action="careerssave.jsp" >
				<table>
					<tbody>
						<tr>
							<td colspan="2"><strong style="color: white;">Personal</strong></td>
						</tr>
						<tr>
							<td>Name<font color="red">*</font></td>
							<td><input name="pr_name" size="20" maxlength="30"></td>
						</tr>
						<tr>
							<td>Contact Number<font color="red">*</font></td>
							<td><input name="pr_mobno" size="20" maxlength="30"></td>
						</tr>
						<tr>
							<td>Country<font color="red">*</font></td>
							<td><select name="pr_country" style="width: 155px">
									<option selected value="">Select Country</option>
									<option value="Afghanistan">Afghanistan</option>
									<option value="Albania">Albania</option>
									<option value="Algeria">Algeria</option>
									<option value="American Samoa">American Samoa</option>
									<option value="Andorra">Andorra</option>
									<option value="Angola">Angola</option>
									<option value="Anguilla">Anguilla</option>
									<option value="Antarctica">Antarctica</option>
									<option value="Argentina">Argentina</option>
									<option value="Armenia">Armenia</option>
									<option value="Aruba">Aruba</option>
									<option value="Austria">Austria</option>
									<option value="Australia">Australia</option>
									<option value="Azerbaijan">Azerbaijan</option>
									<option value="Bahamas">Bahamas</option>
									<option value="Bahrain">Bahrain</option>
									<option value="Bangladesh">Bangladesh</option>
									<option value="Barbados">Barbados</option>
									<option value="Belarus">Belarus</option>
									<option value="Belgium">Belgium</option>
									<option value="Belize">Belize</option>
									<option value="Benin">Benin</option>
									<option value="Bermuda">Bermuda</option>
									<option value="Bhutan">Bhutan</option>
									<option value="Bolivia">Bolivia</option>
									<option value="Botswana">Botswana</option>
									<option value="Bouver Island">Bouver Island</option>
									<option value="Brazil">Brazil</option>
									<option value="Brunei">Brunei</option>
									<option value="Bulgaria">Bulgaria</option>
									<option value="Burkina Faso">Burkina Faso</option>
									<option value="Burundi">Burundi</option>
									<option value="Cambodia">Cambodia</option>
									<option value="Cameroon">Cameroon</option>
									<option value="Canada">Canada</option>
									<option value="Cape Verde">Cape Verde</option>
									<option value="Cayman Islands">Cayman Islands</option>
									<option value="Chad">Chad</option>
									<option value="Chile">Chile</option>
									<option value="China">China</option>
									<option value="Colombia">Colombia</option>
									<option value="Comoros">Comoros</option>
									<option value="Congo">Congo</option>
									<option value="Cook Islands">Cook Islands</option>
									<option value="Costa Rica">Costa Rica</option>
									<option value="Croatia">Croatia</option>
									<option value="Cuba">Cuba</option>
									<option value="Cyprus">Cyprus</option>
									<option value="Czech Republic">Czech Republic</option>
									<option value="Denmark">Denmark</option>
									<option value="Djibouti">Djibouti</option>
									<option value="Dominica">Dominica</option>
									<option value="East Timor">East Timor</option>
									<option value="Ecuador">Ecuador</option>
									<option value="Egypt">Egypt</option>
									<option value="El Salvador">El Salvador</option>
									<option value="Eritrea">Eritrea</option>
									<option value="Estonia">Estonia</option>
									<option value="Ethiopia">Ethiopia</option>
									<option value="Faroe Islands">Faroe Islands</option>
									<option value="Fiji">Fiji</option>
									<option value="Finland">Finland</option>
									<option value="France">France</option>
									<option value="French Guiana">French Guiana</option>
									<option value="Gabon">Gabon</option>
									<option value="Gambia">Gambia</option>
									<option value="Georgia">Georgia</option>
									<option value="Germany">Germany</option>
									<option value="Ghana">Ghana</option>
									<option value="Gibraltar">Gibraltar</option>
									<option value="Greece">Greece</option>
									<option value="Greenland">Greenland</option>
									<option value="Grenada">Grenada</option>
									<option value="Guadeloupe">Guadeloupe</option>
									<option value="Guam">Guam</option>
									<option value="Guatemala">Guatemala</option>
									<option value="Guinea">Guinea</option>
									<option value="Guinea-Bissau">Guinea-Bissau</option>
									<option value="Guyana">Guyana</option>
									<option value="Haiti">Haiti</option>
									<option value="Honduras">Honduras</option>
									<option value="Hong Kong">Hong Kong</option>
									<option value="Hungary">Hungary</option>
									<option value="Iceland">Iceland</option>
									<option value="India">India</option>
									<option value="Indonesia">Indonesia</option>
									<option value="Iran">Iran</option>
									<option value="Iraq">Iraq</option>
									<option value="Ireland">Ireland</option>
									<option value="Israel">Israel</option>
									<option value="Italy&quot;">Italy</option>
									<option value="Jamaica">Jamaica</option>
									<option value="Japan">Japan</option>
									<option value="Jordan">Jordan</option>
									<option value="Kazakhstan">Kazakhstan</option>
									<option value="Kenya">Kenya</option>
									<option value="Kiribati">Kiribati</option>
									<option value="Korea">Korea</option>
									<option value="Kuwait">Kuwait</option>
									<option value="Kyrgyzstan">Kyrgyzstan</option>
									<option value="Laos">Laos</option>
									<option value="Latvia">Latvia</option>
									<option value="Lebanon">Lebanon</option>
									<option value="Lesotho">Lesotho</option>
									<option value="Liberia">Liberia</option>
									<option value="Libya">Libya</option>
									<option value="Lithuania">Lithuania</option>
									<option value="Luxembourg">Luxembourg</option>
									<option value="Macau">Macau</option>
									<option value="Macedonia">Macedonia</option>
									<option value="Madagascar">Madagascar</option>
									<option value="Malawi">Malawi</option>
									<option value="Malaysia">Malaysia</option>
									<option value="Maldives">Maldives</option>
									<option value="Mali">Mali</option>
									<option value="Malta">Malta</option>
									<option value="Martinique">Martinique</option>
									<option value="Mauritania">Mauritania</option>
									<option value="Mauritius">Mauritius</option>
									<option value="Mayotee">Mayotee</option>
									<option value="Mexico">Mexico</option>
									<option value="Micronesia">Micronesia</option>
									<option value="Moldova">Moldova</option>
									<option value="Monaco">Monaco</option>
									<option value="Mongolia">Mongolia</option>
									<option value="Montserrat">Montserrat</option>
									<option value="Morocco">Morocco</option>
									<option value="Mozambique">Mozambique</option>
									<option value="Myanmar">Myanmar</option>
									<option value="Namibia">Namibia</option>
									<option value="Nauru">Nauru</option>
									<option value="Nepal">Nepal</option>
									<option value="Netherlands">Netherlands</option>
									<option value="Neutral Zone">Neutral Zone</option>
									<option value="New Caledonia">New Caledonia</option>
									<option value="New Zealand">New Zealand</option>
									<option value="Nicaraqua">Nicaraqua</option>
									<option value="Niger">Niger</option>
									<option value="Nigeria">Nigeria</option>
									<option value="Niue">Niue</option>
									<option value="Norfolk Island">Norfolk Island</option>
									<option value="Norway">Norway</option>
									<option value="Oman">Oman</option>
									<option value="Pakistan">Pakistan</option>
									<option value="Palau">Palau</option>
									<option value="Panama">Panama</option>
									<option value="Papua New Guinea">Papua New Guinea</option>
									<option value="Paraguay">Paraguay</option>
									<option value="Peru">Peru</option>
									<option value="Philippines">Philippines</option>
									<option value="Pitcairn">Pitcairn</option>
									<option value="Poland">Poland</option>
									<option value="Portugal">Portugal</option>
									<option value="Puerto Rico">Puerto Rico</option>
									<option value="Qatar">Qatar</option>
									<option value="Reunion">Reunion</option>
									<option value="Romania">Romania</option>
									<option value="Rwanda">Rwanda</option>
									<option value="Saint Lucia">Saint Lucia</option>
									<option value="Samoa">Samoa</option>
									<option value="San Marino">San Marino</option>
									<option value="Saudi Arabia">Saudi Arabia</option>
									<option value="Senegal">Senegal</option>
									<option value="Seychelles">Seychelles</option>
									<option value="Sierra Leone">Sierra Leone</option>
									<option value="Singapore">Singapore</option>
									<option value="Solomon Islands">Solomon Islands</option>
									<option value="Somalia">Somalia</option>
									<option value="South Africa">South Africa</option>
									<option value="Slovak Republic">Slovak Republic</option>
									<option value="Slovenia">Slovenia</option>
									<option value="Spain">Spain</option>
									<option value="Sri Lanka">Sri Lanka</option>
									<option value="St. Helena">St. Helena</option>
									<option value="Sudan">Sudan</option>
									<option value="Suriname">Suriname</option>
									<option value="Swaziland">Swaziland</option>
									<option value="Sweden">Sweden</option>
									<option value="Switzerland">Switzerland</option>
									<option value="Syria">Syria</option>
									<option value="Taiwan">Taiwan</option>
									<option value="Tajikistan">Tajikistan</option>
									<option value="Tanzania">Tanzania</option>
									<option value="Thailand">Thailand</option>
									<option value="Togo">Togo</option>
									<option value="Tokelau">Tokelau</option>
									<option value="Tonga">Tonga</option>
									<option value="Tunisia">Tunisia</option>
									<option value="Turkey">Turkey</option>
									<option value="Turkmenistan">Turkmenistan</option>
									<option value="Tuvalu">Tuvalu</option>
									<option value="Uganda">Uganda</option>
									<option value="Ukraine">Ukraine</option>
									<option value="United Arab Emirate">United Arab
										Emirate</option>
									<option value="United States">United States</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Uruguay">Uruguay</option>
									<option value="USSR(former)">USSR(former)</option>
									<option value="Uzbekistan">Uzbekistan</option>
									<option value="Vanuatu">Vanuatu</option>
									<option value="Venezuela">Venezuela</option>
									<option value="Viet Nam">Viet Nam</option>
									<option value="Western Sahara">Western Sahara</option>
									<option value="Yemen">Yemen</option>
									<option value="Yugoslavia">Yugoslavia</option>
									<option value="Zaire">Zaire</option>
									<option value="Zambia">Zambia</option>
									<option value="Zimbabwe">Zimbabwe</option>
							</select></td>
						</tr>
						<tr>
							<td>Email Address<font color="red">*</font></td>
							<td colspan="1"><input name="pr_email" size="20"
								maxlength="30"></td>
						</tr>
						<tr>
							<td colspan="2"><strong style="color: white;">Qualifications</strong></td>
						</tr>
						<tr>
							<td>Highest degree held<font color="red">*</font></td>
							<td><select name="pr_qualification" style="width: 155px">
									<option value="" selected>Select</option>
									<option>A Level</option>
									<option>A Level / Higher</option>
									<option>B Com</option>
									<option>B Sc</option>
									<option>B.Arch</option>
									<option>B.Des</option>
									<option>B.S</option>
									<option>BA</option>
									<option>BBA</option>
									<option>BBM</option>
									<option>BCA</option>
									<option>BCM</option>
									<option>BCS</option>
									<option>BE / BTech</option>
									<option>Bachelors Degree</option>
									<option>CA</option>
									<option>CS</option>
									<option>Diploma</option>
									<option>Doctorate</option>
									<option>GCSE</option>
									<option>LLB</option>
									<option>M Com</option>
									<option>M Sc</option>
									<option>M.S</option>
									<option>MA</option>
									<option>MBA</option>
									<option>MBBS</option>
									<option>MCA</option>
									<option>MCM</option>
									<option>MD</option>
									<option>ME</option>
									<option>MHA</option>
									<option>MTech</option>
									<option>Masters Degree</option>
									<option>O Level</option>
									<option>Others</option>
									<option>PGD</option>
									<option>Phd</option>
							</select></td>
						</tr>
						<tr>
							<td>Technology/Function<font color="red">*</font></td>
							<td><select name="pr_tecnology" style="width: 155px">
									<option value="" selected>Select</option>
									<option>C#</option>
									<option>C/C++</option>
									<option>VC++</option>
									<option>Dot Net</option>
									<option>Java</option>
									<option>QA</option>
									<option>Testing</option>
									<option>Networking</option>
									<option>Mobile</option>
									<option>Non Technical</option>
									<option>Others</option>
							</select></td>
						</tr>
						<tr>
							<td>Primary Skills<font color="red">*</font></td>
							<td><select name="pr_skills" style="width: 155px">
									<option value="" selected>Select</option>
									<option>.Net</option>
									<option>VB.Net</option>
									<option>C Sharp</option>
									<option>Core Java</option>
									<option>J2EE</option>
									<option>J2ME</option>
									<option>VB</option>
									<option>Php</option>
									<option>VCPP</option>
									<option>CPP</option>
									<option>Data Analysis</option>
									<option>DBA</option>
									<option>UI Designing</option>
									<option>Web Designing</option>
									<option>Graphic Designing</option>
									<option>Manual Testing</option>
									<option>White Box Testing</option>
									<option>Black Box Testing</option>
									<option>Regression Testing</option>
									<option>Performance Testing</option>
									<option>Test Automation</option>
									<option>Deployment</option>
									<option>Release Engineering</option>
									<option>Report Designing</option>
									<option>Networking</option>
									<option>Project Management</option>
									<option>Market Research</option>
									<option>Mass Communication</option>
									<option>Technical Writing</option>
									<option>Sales &amp; Marketing</option>
									<option>General Administration</option>
									<option>Internal HR</option>
									<option>Recruitment</option>
									<option>Others</option>
							</select></td>
						</tr>
						<tr>
							<td>Others</td>
							<td colspan="1"><input name="pr_others" size="20"
								maxlength="30"></td>
						</tr>
						<tr>
							<td colspan="2"><strong style="color: white;">Experience</strong></td>
						</tr>
						<tr>
							<td>Position Applying for</td>
							<td><input name="pr_position" size="20" maxlength="30"></td>
						</tr>
						<tr>
							<td>Current Company</td>
							<td><input name="pr_currentcompany" size="20" maxlength="30"></td>
						</tr>
						<tr>
							<td>Total Experience<font color="red">*</font></td>
							<td><select name="pr_totalexp" style="width: 155px">
									<option value="">Select</option>
									<option selected>Less than 12 months</option>
									<option>12-36 Months</option>
									<option>36-60 Months</option>
									<option>Above 60 Months</option>
							</select></td>
						</tr>
						<tr>
							<td>Relevant Experience</td>
							<td><select name="pr_relexp" style="width: 155px">
									<option value="">Select</option>
									<option selected>Less than 12 months</option>
									<option>12-36 Months</option>
									<option>36-60 Months</option>
									<option>Above 60 Months</option>
							</select></td>
						</tr>
						<tr>
							<td>Current Location<font color="red">*</font></td>
							<td><input name="pr_currentlocation" size="20"
								maxlength="30"></td>
						</tr>
						<tr>
							<td>Comments :</td>
							<td colspan="1"><textarea cols="17" name="strcomments"></textarea></td>
						</tr>
						<tr>
							<td colspan="2">Resume <input type="file" name="strresume"></td>
						</tr>
						<tr>
							<td><input type="submit" value="Send" name="submit"></td>
							<td><input name="button" type="button" value="Reset"
								text="Reset"></td>
						</tr>
					</tbody>
				</table>
				<p>
					Fields marked with <font color="red">*</font> are mandatory
				</p>
			</form>










		</div>

		<div class="cleaner"></div>

	</div>

	<div class="cleaner"></div>

</div>

<div id="templatemo_content_wrapper_bottm"></div>

<%@include file="footer.jsp"%>

</div>
<!-- end of wrapper -->
</div>
<!-- end of wrapper_outer -->

</body>
</html>