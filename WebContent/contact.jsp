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
								<img src="images/slider/contactus.jpg"
									alt="Mauris quis eros arcu" />
							</div>

							<div class="slider_content">
								<h3>Contact us</h3>
								<p style="text-align: justify;">Your questions and opinions
									are important to us, and will be directed to appropriate
									function within JS Informatics Group for answering. In order
									for us to give you an efficient response please begin by
									specifying your area of interest in the form below.</p>

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



		<div class="reasons" style="width: 650px;">
			<h4>Call Me Back</h4>
			<p style="text-align: justify;">Thank you for your interest in JS
				Informatics and our services. Please fill out the form below, or
				e-mail us at contact@jsinformatics.com and we will get back to you
				promptly regarding your request.</p>
		</div>

		<div class="reasons"></div>

		<div class="reasons"></div>

		<div class="hr_divider"></div>

		<div class="col_w560" style="width: 250px;">

			<div class="image_wrapper image_fl" style="height: 250px;">
				<img src="images/templatemo_image_01.jpg" alt="TemplatemoImage01"
					height="250px;" />
			</div>

		</div>

		<div class="col_w280" style="width: 450px; float: right;">
			<h4>Contact Us</h4>
		<%String message=(String)request.getAttribute("message"); if(message!=null){
			out.print("<input type='hidden' value='"+message+"' id='id_message'/>");
		%>
		<script type="text/javascript">
		var msg=document.getElementById("id_message").value;
			alert(msg);
		</script>
		<%} %>
			<form name="contact" action="contactsave.jsp" method="post">

				<div class="contactform">
					<fieldset>
						<table border="0">
						<tr><td>
							<label for="contact_title" class="left">Title:<font
								color="#FF0000">*</font></label></td><td> <select style="width: 159px;" name="contact_title"
								id="contact_title" class="combo" value="" tabindex="1">
								<option value="choose">Select...</option>
								<option value="Mrs.">Mrs.</option>
								<option value="Mrs.">Ms.</option>
								<option value="Mr. ">Mr.</option>
								<option value="Dr. ">Dr.</option>
							</select></td>
						</tr>
						<tr><td>
							<label for="contact_firstname" class="left">Full name:<font
								color="#FF0000">*</font></label> </td><td><input style="width: 155px;" type="text"
								name="contact_firstname" id="contact_firstname" class="field"
								value="" tabindex="1" /></td>
						</tr>
						<tr><td>
							<label for="contact_familyname" class="left">Company:<font
								color="#FF0000">*</font></label> </td><td><input style="width: 155px;" type="text"
								name="contact_familyname" id="contact_familyname" class="field"
								value="" tabindex="2" /></td>
						</tr>
						<tr><td>
							<label for="contact_city" class="left">City:<font
								color="#FF0000">*</font></label> </td><td><input style="width: 155px;" type="text" name="contact_city"
								id="contact_city" class="field" value="" tabindex="3" /></td>
						</tr>
						<tr><td>
							<label for="contact_country" class="left">Country:<font
								color="#FF0000">*</font></label></td><td> <select style="width: 159px;" name="contact_country"
								id="contact_country" value="">
								<option selected="selected" value="">Select Country</option>
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
								<option value="United Arab Emirate">United Arab Emirate</option>
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
						<tr><td>
							<label for="contact_phone" class="left">Phone:<font
								color="#FF0000">*</font></label> </td><td><input style="width: 155px;" type="text" name="contact_phone"
								id="contact_phone" class="field" value="" tabindex="5" /></td>
						</tr>
						<tr>
							<td><label for="contact_email" class="left">Email:<font
								color="#FF0000">*</font></label> </td><td><input style="width: 155px;" type="text" name="contact_email"
								id="contact_email" class="field" value="" tabindex="6" /></td>
						</tr>
						</table>
					</fieldset>

				</div>

				<div class="column1-unit">
					<div class="contactform">

						<fieldset>
							<legend>
								<b style="color: white;">Please describe your requirements:</b><font
									color="#FF0000">*</font>
							</legend>
							
								<label for="contact_email" class="left">Describe:</label></br>
								<textarea id="contact_description" name="contact_description"
									cols="28" rows="4" class="textarea-308"></textarea>
							

							<p>
								<input type="submit" name="submitted" id="submit" class="button"
									value="Submit" tabindex="6" />
							</p>
						</fieldset>
					</div>
				</div>
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