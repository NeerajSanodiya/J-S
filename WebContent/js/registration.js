var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
var IndNum = /^[\d\.\-]+$/;
function showSearchForm(select) {	
	
	if (select.value == 'Academic Project') {
		window.location.assign("registration_aca_project.jsp");
	}
	if (select.value == 'Training') {
		window.location.assign("registration.jsp");
	}	
}
function newInquiryFormValidation() {
	var training_fullname = document.getElementById("id_training_fullname");
	var training_father_name = document
			.getElementById("id_training_father_name");
	var training_contact_no = document.getElementById("id_training_contact_no");
	var training_email_id = document.getElementById("id_training_email_id");
	var training_photofile = document.getElementById("id_training_photofile");
	var training_address = document.getElementById("id_training_address");
	var training_enrollment_no = document
			.getElementById("id_training_enrollment_no");
	var training_qualification = document
			.getElementById("id_training_qualification");
	var training_college = document.getElementById("id_training_college");
	var training_semester = document.getElementById("id_training_semester");
	var training_date_of_birth = document
			.getElementById("id_training_date_of_birth");
	var training_course = document.getElementById("id_training_course");
	var training_batch_time_start = document
			.getElementById("id_training_batch_time_start");
	var training_batch_time_end = document
			.getElementById("id_training_batch_time_end");
	var training_total_amount = document
			.getElementById("id_training_total_amount");
	var training_discount_amount = document
			.getElementById("id_training_discount_amount");
	var training_discount_detail = document
			.getElementById("id_training_discount_detail");
	var training_reference_name = document
			.getElementById("id_training_reference_name");
	var training_reference_contact_no = document
			.getElementById("id_training_reference_contact_no");
	var training_reference_note = document
			.getElementById("id_training_reference_note");

	if (training_photofile.value == "") {
		alert("please select photo");
		training_photofile.focus();
		return false;
	}
	if (isBlank(training_fullname, "fullname") == true) {
		return false;
	}
	if (isBlank(training_father_name, "father name") == true) {
		return false;
	}
	if (isBlank(training_contact_no, "contact no") == true) {
		return false;
	}
	if (!IndNum.test(training_contact_no.value)) {
		alert("Please enter valid contact number");
		training_contact_no.focus();
		return false;
	}
	if (isBlank(training_email_id, "email id") == true) {
		return false;
	}
	if (!filter.test(training_email_id.value)) {
		alert('Please provide a valid email address');
		EmailId.focus;
		return false;
	}
	if (isBlank(training_address, "address") == true) {
		return false;
	}
	
	if (isBlank(training_enrollment_no, "enrollment no") == true) {
		return false;
	}
	if (isSelectad(training_qualification, "qualification") == true) {
		return false;
	}
	if (isSelectad(training_college, "college") == true) {
		return false;
	}
	if (isSelectad(training_semester, "semester") == true) {
		return false;
	}
	if (isBlank(training_date_of_birth, "date of birth") == true) {
		return false;
	}
	if (isSelectad(training_course, "course") == true) {
		return false;
	}
	if (isBlank(training_batch_time_start, "batch time start") == true) {
		return false;
	}
	if (isBlank(training_batch_time_end, "batch time end") == true) {
		return false;
	}
	if (isBlank(training_total_amount, "total amount") == true) {
		return false;
	}
	if (isBlank(training_discount_amount, "discount amount") == true) {
		return false;
	}
	if (isBlank(training_discount_detail, "discount detail") == true) {
		return false;
	}
	if (isBlank(training_reference_name, "reference name") == true) {
		return false;
	}
	if (isBlank(training_reference_contact_no, "reference contact no") == true) {
		return false;
	}
	if (!IndNum.test(training_reference_contact_no.value)) {
		alert("Please enter valid contact number");
		training_reference_contact_no.focus();
		return false;
	}
	if (isBlank(training_reference_note, "reference note") == true) {
		return false;
	}
	return true;
}
function isBlank(input, msg) {
	var data = input.value;
	if (data.length == 0) {
		input.style.borderColor = 'red';
		alert("Please fill " + msg + " field");
		input.focus();
		return true;
	}
	return false;
}
function isSelectad(input, msg) {
	var data = input.value;
	if (data == "Select") {
		input.style.borderColor = 'red';
		alert("Please select " + msg + " field");
		input.focus();
		return true;
	}
	return false;
}
function showFeedBackAndEnquiryDetail(count) {

	document.getElementById("id_training_enquiry_id").value = document
			.getElementById("h_id_enquiryid" + count).value;
	document.getElementById("id_training_fullname").value = document
			.getElementById("h_id_fullname" + count).value;
	document.getElementById("id_training_father_name").value = document
			.getElementById("h_id_father_name" + count).value;
	var desiredValue = document.getElementById("h_id_qualification" + count).value;
	var el = document.getElementById("id_training_qualification");
	var ii = 0;
	for ( var i = 0; i < el.options.length; i++) {
		if (el.options[i].text == desiredValue) {
			el.selectedIndex = i;
			ii = 1;
			break;
		}
	}
	if (ii == 0) {
		el.options.add(new Option(desiredValue, desiredValue));
		for ( var i = 0; i < el.options.length; i++) {
			if (el.options[i].text == desiredValue) {
				el.selectedIndex = i;
				ii = 1;
				break;
			}
		}
	}

	var desiredValue1 = document.getElementById("h_id_college" + count).value;
	var el1 = document.getElementById("id_training_college");
	var ii1 = 0;
	for ( var i = 0; i < el1.options.length; i++) {
		if (el1.options[i].text == desiredValue1) {
			el1.selectedIndex = i;
			ii1 = 1;
			break;
		}
	}
	if (ii1 == 0) {
		el1.options.add(new Option(desiredValue1, desiredValue1));
		for ( var i = 0; i < el1.options.length; i++) {
			if (el1.options[i].text == desiredValue1) {
				el1.selectedIndex = i;
				ii1 = 1;
				break;
			}
		}
	}

	var desiredValue2 = document.getElementById("h_id_semester" + count).value;
	var el2 = document.getElementById("id_training_semester");
	for ( var i = 0; i < el2.options.length; i++) {
		if (el2.options[i].text == desiredValue2) {
			el2.selectedIndex = i;
			break;
		}
	}

	var desiredValue3 = document.getElementById("h_id_course" + count).value;
	var n = desiredValue3.split(",");
	var el3 = document.getElementById("id_training_course");
	for ( var i = 0; i < el3.options.length; i++) {
		el3.options[i].selected = false;
	}
	for ( var i = 0; i < n.length - 1; i++) {
		var val = n[i];
		var el4 = document.getElementById("id_training_course");
		for ( var j = 0; j < el3.options.length; j++) {
			if (el4.options[j].text == val) {
				el4.options[j].selected = true;
				break;
			}
		}
	}

	var mydiv = document.getElementById('id_enquirymsg');
	mydiv.innerHTML = '<h4>Basic Detail</h4>';

	document.getElementById("id_training_reference_name").value = document
			.getElementById("h_id_reference_name" + count).value;
	document.getElementById("id_training_reference_contact_no").value = document
			.getElementById("h_id_reference_contact_no" + count).value;
	document.getElementById("id_training_reference_note").value = document
			.getElementById("h_id_reference_note" + count).value;

	document.getElementById("id_training_contact_no").value = document
			.getElementById("h_id_contact_no" + count).value;
	document.getElementById("id_training_email_id").value = document
			.getElementById("h_id_email_id" + count).value;

}
function showFeedBackAndRegistrationDetail(count) {
	document.getElementById("id_training_registration_id").value = document
			.getElementById("h_id_Registration_id" + count).value;
	document.getElementById("id_training_fullname").value = document
			.getElementById("h_id_Fullname" + count).value;
	document.getElementById("id_training_father_name").value = document
			.getElementById("h_id_Father_name" + count).value;
	document.getElementById("id_training_contact_no").value = document
			.getElementById("h_id_Contact_no" + count).value;
	document.getElementById("id_training_email_id").value = document
			.getElementById("h_id_Email_id" + count).value;
	document.getElementById("id_training_address").value = document
			.getElementById("h_id_Address" + count).value;
	document.getElementById("id_training_enrollment_no").value = document
			.getElementById("h_id_Enrollment_no" + count).value;
	document.getElementById("id_training_date_of_birth").value = document
			.getElementById("h_id_Date_of_birth" + count).value;
	document.getElementById("id_training_batch_time_start").value = document
			.getElementById("h_id_Batch_time_start" + count).value;
	document.getElementById("id_training_batch_time_end").value = document
			.getElementById("h_id_Batch_time_end" + count).value;
	document.getElementById("id_training_total_amount").value = document
			.getElementById("h_id_Total_amount" + count).value;
	document.getElementById("id_training_discount_amount").value = document
			.getElementById("h_id_Discount_amount" + count).value;
	document.getElementById("id_training_discount_detail").value = document
			.getElementById("h_id_Discount_detail" + count).value;

	document.getElementById("id_training_reference_name").value = document
			.getElementById("h_id_Reference_name" + count).value;
	document.getElementById("id_training_reference_contact_no").value = document
			.getElementById("h_id_Reference_contact_no" + count).value;
	document.getElementById("id_training_reference_note").value = document
			.getElementById("h_id_Reference_note" + count).value;
	document.getElementById("id_reg_tbl_button").style.display = "none";
	var photo_id_path=document.getElementById("h_id_Photo_path" + count).value;
	//alert(photo_id_path.indexOf("null")!=-1);
	if(photo_id_path.indexOf("null")==-1){
		document.getElementById("id_images").src =photo_id_path;
	}else{
		document.getElementById("id_images").src ="../images/photo.png";
	}
	 

	var desiredValue = document.getElementById("h_id_Qualification" + count).value;
	var el = document.getElementById("id_training_qualification");
	var ii = 0;
	for ( var i = 0; i < el.options.length; i++) {
		if (el.options[i].text == desiredValue) {
			el.selectedIndex = i;
			ii = 1;
			break;
		}
	}
	if (ii == 0) {
		el.options.add(new Option(desiredValue, desiredValue));
		for ( var i = 0; i < el.options.length; i++) {
			if (el.options[i].text == desiredValue) {
				el.selectedIndex = i;
				ii = 1;
				break;
			}
		}
	}

	var desiredValue1 = document.getElementById("h_id_College" + count).value;
	var el1 = document.getElementById("id_training_college");
	var ii1 = 0;
	for ( var i = 0; i < el1.options.length; i++) {
		if (el1.options[i].text == desiredValue1) {
			el1.selectedIndex = i;
			ii1 = 1;
			break;
		}
	}
	if (ii1 == 0) {
		el1.options.add(new Option(desiredValue1, desiredValue1));
		for ( var i = 0; i < el1.options.length; i++) {
			if (el1.options[i].text == desiredValue1) {
				el1.selectedIndex = i;
				ii1 = 1;
				break;
			}
		}
	}

	var desiredValue2 = document.getElementById("h_id_Semester" + count).value;
	var el2 = document.getElementById("id_training_semester");
	for ( var i = 0; i < el2.options.length; i++) {
		if (el2.options[i].text == desiredValue2) {
			el2.selectedIndex = i;
			break;
		}
	}

	var desiredValue3 = document.getElementById("h_id_RegisterForCourse"
			+ count).value;
	var el3 = document.getElementById("id_training_course");
	for ( var i = 0; i < el3.options.length; i++) {
		el3.options[i].selected = false;
	}
	var el4 = document.getElementById("id_training_course");
	for ( var j = 0; j < el3.options.length; j++) {
		if (el4.options[j].text == desiredValue3) {
			el4.options[j].selected = true;
			break;
		}
	}

}
function createDiv(item, max) {
	for ( var i = 1; i <= max; i++) {
		if ($("#" + i).is(":visible")) {
			$("#" + i).hide();
		}
	}
	$("#" + item).show();
}
function regRemarkSubSubmitBtn(id) {

	var remark = document.getElementById("my_id_remark" + id);
	var alertdate = document.getElementById("id_alertdate_" + id);
	if (isBlank(remark, "remark")) {
		return false;
	}
	if (isBlank(alertdate, "alert date")) {
		return false;
	} else {
		$
				.post('saveregremark.jsp?id=' + id,
						$('#subForm_' + id).serialize())
				.success(
						function(response) {
							var res = trimExtraSpaces(response);
							// alert(res);
							if (res.indexOf('NOT') == -1) {
								var no_use = new Array();
								ShowSuccessMessageDialog("Remark Message", res,
										no_use);
							} else {
								ShowErrorMessageDialog("Remark Message", res);
							}
							var max = document.getElementById("maxvalue" + id).value;
							closeRemark(max);
						}).error(function(e) {
					alert(e);
				});
	}
}
