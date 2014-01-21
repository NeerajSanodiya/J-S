var lettersUnm = /^[A-Za-z' 'A-Za-z]+$/;
var num = /^[0-9]+$/;

function showSearchForm(select) {	
	
	if (select.value == 'Academic Project') {
		window.location.assign("enq_aca_project.jsp");
	}
	if (select.value == 'Training') {
		window.location.assign("enquiry.jsp");
	}
	if (select.value == 'Visitor') {
		window.location.assign("enquiry_visitor.jsp");
	}
}
$(document).ready(function() {
	$('#savenewenquiryBtn').click(function() {
		$('#savenewenquiryForm').submit();
		return false;
	});
	$('#savenewenquiryForm').submit(function() {
		var enquiry_purpose = document.getElementById("id_enquiry_purpose");
		var btnLabel = document.getElementById('savenewenquiryBtn').value;
		if (btnLabel == 'Save') {
			if (enquiry_purpose.value == 'Select') {
				enquiry_purpose.style.borderColor = 'red';
				alert("Please Enquiry Select Purpose");
				input.focus();
				return false;
			}
			if (enquiry_purpose.value == 'Training') {
				if (validateNewTrainingEnquiry() == false) {
					return false;
				} else {
					saveNewTrainingEnquiryFormSubmit();
				}
			}
			if (enquiry_purpose.value == 'Academic Project') {
				if (validateNewAcademicProjectEnquiry() == false) {
					return false;
				} else {
					saveNewAcademicProjectEnquiryFormSubmit();
				}
			}
			if (enquiry_purpose.value == 'Visitor') {
				if (validateVisitorEnquiryForm() == false) {
					return false;
				} else {
					saveNewVisitorEnquiryFormSubmit();
				}
			}
		} else if (btnLabel == 'Update') {
			if (enquiry_purpose.value == 'Training') {
				if (validateNewTrainingEnquiry() == false) {
					return false;
				} else {
					updateTrainingEnquiryFormUpdate();
				}
			}
			if (enquiry_purpose.value == 'Academic Project') {
				if (validateNewAcademicProjectEnquiry() == false) {
					return false;
				} else {
					updateAcademicProjectEnquiryFormUpdate();
				}
			}
			if (enquiry_purpose.value == 'Visitor') {
				if (validateVisitorEnquiryForm() == false) {
					return false;
				} else {

				}
			}
		}
		/*
		 * var btnLabel=document.getElementById('savenewenquiryBtn').value;
		 * if(btnLabel=='Save'){
		 * 
		 * 
		 * if(validateEnquiryForm()==false){
		 * 
		 * }else{ //alert("chack"); savenewenquiryFormSubmit(); clearForm(); } }
		 * else if(btnLabel=='Update'){ updateenquiryFormSubmit(); }
		 */
		return false;
	});
});

function savenewenquiryFormSubmit() {
	$.post('savenewenquiry.jsp', $('#savenewenquiryForm').serialize()).success(
			function(response) {
				var res = trimExtraSpaces(response);
				if (res.indexOf('NOT') == -1) {
					var no_use = new Array();
					ShowSuccessMessageDialog("Enquiry Message", res, no_use);
				} else {
					ShowErrorMessageDialog("Enquiry Message", res);
				}
			}).error(function(e) {
		alert(e);
	});
}
function saveNewVisitorEnquiryFormSubmit() {
	$.post('savevisitorenquiry.jsp', $('#savenewenquiryForm').serialize())
			.success(function(response) {
				var res = trimExtraSpaces(response);
				if (res.indexOf('NOT') == -1) {
					var no_use = new Array();
					ShowSuccessMessageDialog("Enquiry Message", res, no_use);
				} else {
					ShowErrorMessageDialog("Enquiry Message", res);
				}
			}).error(function(e) {
				alert(e);
			});
}
function saveNewTrainingEnquiryFormSubmit() {
	$.post('savenewenquirytraining.jsp', $('#savenewenquiryForm').serialize())
			.success(function(response) {
				var res = trimExtraSpaces(response);
				if (res.indexOf('NOT') == -1) {
					var no_use = new Array();
					ShowSuccessMessageDialog("Enquiry Message", res, no_use);
				} else {
					ShowErrorMessageDialog("Enquiry Message", res);
				}
				if (res.indexOf("ENQUIRY SUCCESSFULLY SAVED") != -1) {

					$('#savenewenquiryForm')[0].reset();

				}

			}).error(function(e) {

			});
}
function saveNewAcademicProjectEnquiryFormSubmit() {
	$.post('newacademicprojectenquiry.jsp',
			$('#savenewenquiryForm').serialize()).success(function(response) {
		var res = trimExtraSpaces(response);
		if (res.indexOf('NOT') == -1) {
			var no_use = new Array();
			ShowSuccessMessageDialog("Enquiry Message", res, no_use);
		} else {
			ShowErrorMessageDialog("Enquiry Message", res);
		}
		if (res == 'Enquiry successfully saved') {
			$('#savenewenquiryForm')[0].reset();
		}
	}).error(function(e) {
		alert(e);
	});
}
function updateTrainingEnquiryFormUpdate() {
	$.post('updatetrainingenquiry.jsp', $('#savenewenquiryForm').serialize())
			.success(function(response) {
				var res = trimExtraSpaces(response);
				if (res.indexOf('NOT') == -1) {
					var no_use = new Array();
					ShowSuccessMessageDialog("Enquiry Message", res, no_use);
				} else {
					ShowErrorMessageDialog("Enquiry Message", res);
				}
			}).error(function(e) {
				alert(e);
			});
}
function updateAcademicProjectEnquiryFormUpdate() {
	$.post('updateacademicproject.jsp', $('#savenewenquiryForm').serialize())
			.success(function(response) {
				var res = trimExtraSpaces(response);
				if (res.indexOf('NOT') == -1) {
					var no_use = new Array();
					ShowSuccessMessageDialog("Enquiry Message", res, no_use);
				} else {
					ShowErrorMessageDialog("Enquiry Message", res);
				}
			}).error(function(e) {
				alert(e);
			});
}
/*
 * function updateenquiryFormSubmit() { $.post('updatetrainingenquiry.jsp',
 * $('#savenewenquiryForm').serialize()).success( function(response) { var
 * res=trimExtraSpaces(response); if(res.indexOf('NOT')==-1){ var no_use=new
 * Array(); ShowSuccessMessageDialog("Enquiry Message",res,no_use); }else{
 * ShowErrorMessageDialog("Enquiry Message",res); } }).error(function(e) {
 * alert(e); }); }
 */
function trimExtraSpaces(theField) {
	var trimValue = "";
	trimValue = theField.toUpperCase();
	trimValue = trimValue.replace(/\s+/g, " ");
	trimValue = trimValue.replace(/^\s+|\s+$/g, "");
	return trimValue;
}
function subSubmitBtn(id) {

	var remark = document.getElementById("my_id_remark" + id);
	var alertdate = document.getElementById("id_alertdate_" + id);
	if (isBlank(remark, "remark")) {
		return false;
	}
	if (isBlank(alertdate, "alert date")) {
		return false;
	} else {
		$
				.post('saveremark.jsp?id=' + id,
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
function subSubmitBtnAPR(id) {
	var remark = document.getElementById("id_remark" + id);
	var alertdate = document.getElementById("id_next_meeting_date" + id);
	if (isBlank(remark, "remark")) {
		return false;
	} else {
		$.post('saveremarkAcademic.jsp?id=' + id,
				$('#subFormAPR_' + id).serialize()).success(function(response) {
			var res = trimExtraSpaces(response);
			// alert(res);
			if (res.indexOf('NOT') == -1) {
				var no_use = new Array();
				ShowSuccessMessageDialog("Remark Message", res, no_use);
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
function makePaymentBtn(id) {
	var amount = document.getElementById("my_id_amount" + id);
	var transfer_code = document.getElementById("id_transfer_code" + id);
	var mode = document.getElementById("id_payment_mode" + id);

	if (mode.value == "Select") {
		mode.style.borderColor = 'red';
		alert("Please select payment mode");
		mode.focus();
		return false;
	}
	if (mode.value != "Cash") {
		if (transfer_code.value.length == 0) {
			transfer_code.style.borderColor = 'red';
			alert("Please enter transfer code");
			transfer_code.focus();
			return false;
		}
	}
	if (isBlank(amount, "amount")) {
		return false;
	}
	if (isNumber(amount.value) == false) {
		amount.style.borderColor = 'red';
		alert("Please enter valid amount");
		amount.focus();
		return false;
	}

	else {
		$
				.post('savepayment.jsp?id=' + id,
						$('#makePaymentForm_' + id).serialize())
				.success(
						function(response) {
							var res = trimExtraSpaces(response);
							// alert(res);
							if (res.indexOf('NOT') == -1) {
								var s_index = res.indexOf('$');
								var paymentid = res.substring(0, s_index);

								var slipDetail = new Array();
								slipDetail[0] = document
										.getElementById("paymentdate" + id).value;
								slipDetail[1] = document
										.getElementById("paymenttime" + id).value;
								;
								slipDetail[2] = document.getElementById("myid"
										+ id).value;
								slipDetail[3] = paymentid;
								slipDetail[4] = document
										.getElementById("source" + id).value;
								slipDetail[5] = document
										.getElementById("cdetail" + id).value;
								slipDetail[6] = document
										.getElementById("id_payment_mode" + id).value;
								slipDetail[7] = document
										.getElementById("id_candidateName" + id).value;
								slipDetail[8] = document
										.getElementById("id_receiverName" + id).value;
								slipDetail[9] = document
										.getElementById("my_id_amount" + id).value;

								var fmessage = res.substring(s_index + 1,
										res.length);
								ShowSuccessMessageDialog("Payment Message",
										fmessage, slipDetail);

							} else {
								ShowErrorMessageDialog("Payment Message", res);
							}
							var max = document.getElementById("maxvalue" + id).value;
							closeRemark(max);
						}).error(function(e) {
					alert(e);
				});
	}
}
function closeRemark(max) {
	for ( var i = 1; i <= max; i++) {
		if ($("#" + i).is(":visible")) {
			$("#" + i).hide();
		}
	}
}
var auto_refresh = setInterval(function() {
	$('#load_data').load('todaysenquiryfollowup.jsp').fadeIn("slow");
}, (1000 * 1000));
function validateEnquiryForm() {
	var fullname = document.getElementById("id_fullname");
	var fathername = document.getElementById("id_father_name");
	var college = document.getElementById("id_qualification");
	var qualification = document.getElementById("id_college");
	var contact_no = document.getElementById("id_contact_no");
	var email_id = document.getElementById("id_email_id");
	var course = document.getElementById("id_course");
	var reference_name = document.getElementById("id_reference_name");
	var reference_contact_no = document
			.getElementById("id_reference_contact_no");
	var preferredtime_start = document.getElementById("id_preferredtime_start");
	var preferredtime_end = document.getElementById("id_preferredtime_end");
	var joining_date = document.getElementById("id_joining_date");
	var enquiry_purpose = document.getElementById("id_enquiry_purpose");
	var project_discription = document.getElementById("id_project_discription");
	var project_name = document.getElementById("id_project_name");
	var delivery_date = document.getElementById("id_delivery_date");
	// purpose
	if (enquiry_purpose.value == 'Select') {
		enquiry_purpose.style.borderColor = 'red';
		alert("Please Enquiry Select Purpose");
		input.focus();
		return false;
	}
	if (enquiry_purpose.value == 'Academic Project') {
		if (isBlank(project_discription, "Project Discription") == true) {
			return false;
		}
		if (isBlank(project_name, "Project Name") == true) {
			return false;
		}
	}
	if (enquiry_purpose.value == "Training") {
		if (course.value.length == 0) {
			course.style.borderColor = 'red';
			alert("Please select atleast one course");
			course.focus();
			return false;
		}
		if (isBlank(preferredtime_start, "preffered time") == true) {
			return false;
		}
		if (isBlank(preferredtime_end, "preffered time") == true) {
			return false;
		}
		if (isBlank(joining_date, "joining date") == true) {
			return false;
		}
	}

	if (isBlank(fullname, "full name") == true) {
		return false;
	}
	if (isAlphabet(fullname, "Please enter valid full name") == false) {
		return false;
	}
	if (fullname.value.indexOf(' ') == -1) {
		fullname.style.borderColor = 'red';
		fullname.focus();
		alert("Please enter full name");
		return false;
	}
	if (isBlank(fathername, "father name") == true) {
		return false;
	}
	if (isAlphabet(fathername, "Please enter valid father name") == false) {
		return false;
	}
	if (fathername.value.indexOf(' ') == -1) {
		fathername.style.borderColor = 'red';
		fathername.focus();
		alert("Please enter father name");
		return false;
	}
	if (isBlank(contact_no, "contact number") == true) {
		return false;
	}
	if (!contact_no.value.match(num)) {
		contact_no.style.borderColor = 'red';
		contact_no.focus();
		alert("Please enter valid contact number");
		return false;
	}
	if (contact_no.value.length != 10) {
		contact_no.style.borderColor = 'red';
		alert("Please enter valid contact number");
		contact_no.focus();
		return false;
	}
	if (isBlank(email_id, "email id field") == true) {
		return false;
	}

	if (isBlank(reference_name, "reference name") == true) {
		return false;
	}
	if (isAlphabet(reference_name, "Please enter valid reference name") == false) {
		return false;
	}
	if (isBlank(reference_contact_no, "contact number field") == true) {
		return false;
	}
	if (!reference_contact_no.value.match(num)) {
		reference_contact_no.style.borderColor = 'red';
		reference_contact_no.focus();
		alert("Please enter valid contact number");
		return false;
	}
	if (reference_contact_no.value.length != 10) {
		reference_contact_no.style.borderColor = 'red';
		alert("Please enter valid contact number");
		reference_contact_no.focus();
		return false;
	}

	/*
	 * if(qualification.value=='Other'){ var
	 * qualification_other=document.getElementById("id_qualification_text");
	 * if(isBlank(qualification_other,"father name field")==true){ return false; }
	 * if(isAlphabet(qualification_other,"Please enter valid father
	 * name")==false){ return false; } } if(college.value=='Other'){ var
	 * college_text=document.getElementById("id_college_text");
	 * if(isBlank(college_text,"college name field")==true){ return false; }
	 * if(isAlphabet(college_text,"Please enter valid college name")==false){
	 * return false; } }
	 */
	return true;

}
function name() {

}
function validateVisitorEnquiryForm() {
	var visitor_enquiry_fullname = document
			.getElementById("id_visitor_enquiry_fullname");
	var visitor_enquiry_contact_no = document
			.getElementById("id_visitor_enquiry_contact_no");
	var visitor_enquiry_email_id = document
			.getElementById("id_visitor_enquiry_email_id");
	var visitor_enquiry_address = document
			.getElementById("id_visitor_enquiry_address");
	var visitor_enquiry_purpose = document
			.getElementById("id_visitor_enquiry_purpose");
	var visitor_enquiry_appointment_with = document
			.getElementById("id_visitor_enquiry_appointment_with");
	var visitor_enquiry_note = document
			.getElementById("id_visitor_enquiry_note");
	var visitor_enquiry_reference_name = document
			.getElementById("id_visitor_enquiry_reference_name");
	var visitor_enquiry_reference_contact_no = document
			.getElementById("id_visitor_enquiry_reference_contact_no");
	var visitor_enquiry_reference_note = document
			.getElementById("id_visitor_enquiry_reference_note");

	if (isBlank(visitor_enquiry_fullname, "full name") == true) {
		return false;
	}
	if (isAlphabet(visitor_enquiry_fullname, "Please enter valid full name") == false) {
		return false;
	}
	if (visitor_enquiry_fullname.value.indexOf(' ') == -1) {
		visitor_enquiry_fullname.style.borderColor = 'red';
		visitor_enquiry_fullname.focus();
		alert("Please enter full name");
		return false;
	}
	if (isBlank(visitor_enquiry_contact_no, "contact number") == true) {
		return false;
	}
	if (!visitor_enquiry_contact_no.value.match(num)) {
		visitor_enquiry_contact_no.style.borderColor = 'red';
		visitor_enquiry_contact_no.focus();
		alert("Please enter valid contact number");
		return false;
	}
	if (visitor_enquiry_contact_no.value.length != 10) {
		visitor_enquiry_contact_no.style.borderColor = 'red';
		alert("Please enter valid contact number");
		visitor_enquiry_contact_no.focus();
		return false;
	}
	if (isBlank(visitor_enquiry_email_id, "email id field") == true) {
		return false;
	}
	if (isBlank(visitor_enquiry_address, "Address") == true) {
		return false;
	}
	if (isBlank(visitor_enquiry_purpose, "Purpose") == true) {
		return false;
	}
	if (isAlphabet(visitor_enquiry_purpose, "Please enter Purpose") == false) {
		return false;
	}
	if (isBlank(visitor_enquiry_appointment_with, "appointment with") == true) {
		return false;
	}
	if (visitor_enquiry_appointment_with.value.indexOf(' ') == -1) {
		visitor_enquiry_appointment_with.style.borderColor = 'red';
		visitor_enquiry_appointment_with.focus();
		alert("Please enter full name");
		return false;
	}
	if (isAlphabet(visitor_enquiry_note, "Please enter note") == false) {
		return false;
	}
	if (isBlank(visitor_enquiry_reference_name, "full name of reference") == true) {
		return false;
	}
	if (isAlphabet(visitor_enquiry_reference_name,
			"Please enter valid full name") == false) {
		return false;
	}
	if (visitor_enquiry_reference_name.value.indexOf(' ') == -1) {
		visitor_enquiry_reference_name.style.borderColor = 'red';
		visitor_enquiry_reference_name.focus();
		alert("Please enter full name");
		return false;
	}
	if (isBlank(visitor_enquiry_reference_contact_no, "contact number") == true) {
		return false;
	}
	if (!visitor_enquiry_reference_contact_no.value.match(num)) {
		visitor_enquiry_reference_contact_no.style.borderColor = 'red';
		visitor_enquiry_reference_contact_no.focus();
		alert("Please enter valid contact number");
		return false;
	}
	if (visitor_enquiry_reference_contact_no.value.length != 10) {
		visitor_enquiry_reference_contact_no.style.borderColor = 'red';
		alert("Please enter valid contact number");
		visitor_enquiry_reference_contact_no.focus();
		return false;
	}
	if (isBlank(visitor_enquiry_reference_note, "full name") == true) {
		return false;
	}

	return true;
}

function validateNewTrainingEnquiry() {

	var training_enquiry_fullname = document
			.getElementById("id_training_enquiry_fullname");
	var training_enquiry_father_name = document
			.getElementById("id_training_enquiry_father_name");
	var training_enquiry_qualification = document
			.getElementById("id_training_enquiry_qualification");
	var training_enquiry_college = document
			.getElementById("id_training_enquiry_college");
	var training_enquiry_semester = document
			.getElementById("id_training_enquiry_semester");
	var training_enquiry_contact_no = document
			.getElementById("id_training_enquiry_contact_no");
	var training_enquiry_email_id = document
			.getElementById("id_training_enquiry_email_id");
	var training_enquiry_course = document
			.getElementById("id_training_enquiry_course");
	var training_enquiry_preferredtime_start = document
			.getElementById("id_training_enquiry_preferredtime_start");
	var training_enquiry_preferredtime_end = document
			.getElementById("id_training_enquiry_preferredtime_end");
	var training_enquiry_joining_date = document
			.getElementById("id_training_enquiry_joining_date");
	var training_enquiry_reference_name = document
			.getElementById("id_training_enquiry_reference_name");
	var training_enquiry_reference_contact_no = document
			.getElementById("id_training_enquiry_reference_contact_no");

	if (isBlank(training_enquiry_fullname, "full name") == true) {
		return false;
	}
	if (isAlphabet(training_enquiry_fullname, "Please enter valid full name") == false) {
		return false;
	}
	if (training_enquiry_fullname.value.indexOf(' ') == -1) {
		training_enquiry_fullname.style.borderColor = 'red';
		training_enquiry_fullname.focus();
		alert("Please enter full name");
		return false;
	}
	if (isBlank(training_enquiry_father_name, "father name") == true) {
		return false;
	}
	if (isAlphabet(training_enquiry_father_name,
			"Please enter valid father name") == false) {
		return false;
	}
	if (training_enquiry_father_name.value.indexOf(' ') == -1) {
		training_enquiry_father_name.style.borderColor = 'red';
		training_enquiry_father_name.focus();
		alert("Please enter father name");
		return false;
	}
	if (training_enquiry_qualification.value == 'Select') {
		training_enquiry_qualification.style.borderColor = 'red';
		alert("Please Select Qualification");
		training_enquiry_qualification.focus();
	}
	if (training_enquiry_college.value == 'Select') {
		training_enquiry_college.style.borderColor = 'red';
		alert("Please Select College");
		training_enquiry_college.focus();
	}
	if (training_enquiry_semester.value == 'Select') {
		training_enquiry_semester.style.borderColor = 'red';
		alert("Please Select semester");
		training_enquiry_semester.focus();
	}

	if (isBlank(training_enquiry_contact_no, "contact number") == true) {
		return false;
	}
	if (!training_enquiry_contact_no.value.match(num)) {
		training_enquiry_contact_no.style.borderColor = 'red';
		training_enquiry_contact_no.focus();
		alert("Please enter valid contact number");
		return false;
	}
	if (training_enquiry_contact_no.value.length != 10) {
		training_enquiry_contact_no.style.borderColor = 'red';
		alert("Please enter valid contact number");
		training_enquiry_contact_no.focus();
		return false;
	}
	if (isBlank(training_enquiry_email_id, "email id field") == true) {
		return false;
	}
	if (training_enquiry_course.value.length == 0) {
		training_enquiry_course.style.borderColor = 'red';
		alert("Please select atleast one course");
		training_enquiry_course.focus();
		return false;
	}
	if (isBlank(training_enquiry_preferredtime_start, "preffered time") == true) {
		return false;
	}
	if (isBlank(training_enquiry_preferredtime_end, "preffered time") == true) {
		return false;
	}
	if (isBlank(training_enquiry_joining_date, "joining date") == true) {
		return false;
	}

	if (isBlank(training_enquiry_reference_name, "reference name") == true) {
		return false;
	}
	if (isAlphabet(training_enquiry_reference_name,
			"Please enter valid reference name") == false) {
		return false;
	}
	if (isBlank(training_enquiry_reference_contact_no, "contact number field") == true) {
		return false;
	}
	if (!training_enquiry_reference_contact_no.value.match(num)) {
		training_enquiry_reference_contact_no.style.borderColor = 'red';
		training_enquiry_reference_contact_no.focus();
		alert("Please enter valid contact number");
		return false;
	}
	if (training_enquiry_reference_contact_no.value.length != 10) {
		training_enquiry_reference_contact_no.style.borderColor = 'red';
		alert("Please enter valid contact number");
		training_enquiry_reference_contact_no.focus();
		return false;
	}
	return true;

}
function validateNewAcademicProjectEnquiry() {
	var academic_project_enquiry_fullname = document
			.getElementById("id_academic_project_enquiry_fullname");
	var academic_project_enquiry_father_name = document
			.getElementById("id_academic_project_enquiry_father_name");
	var academic_project_enquiry_qualification = document
			.getElementById("id_academic_project_enquiry_qualification");
	var academic_project_enquiry_college = document
			.getElementById("id_academic_project_enquiry_college");
	var academic_project_enquiry_semester = document
			.getElementById("id_academic_project_enquiry_semester");
	var academic_project_enquiry_contact_no = document
			.getElementById("id_academic_project_enquiry_contact_no");
	var academic_project_enquiry_email_id = document
			.getElementById("id_academic_project_enquiry_email_id");
	var academic_project_enquiry_description = document
			.getElementById("id_academic_project_enquiry_description");
	var academic_project_enquiry_project_name = document
			.getElementById("id_academic_project_enquiry_project_name");
	var academic_project_enquiry_delivery_date = document
			.getElementById("id_academic_project_enquiry_delivery_date");
	var academic_project_enquiry_reference_name = document
			.getElementById("id_academic_project_enquiry_reference_name");
	var academic_project_enquiry_reference_contact_no = document
			.getElementById("id_academic_project_enquiry_reference_contact_no");

	if (isBlank(academic_project_enquiry_description, "Project Description") == true) {
		return false;
	}
	if (isBlank(academic_project_enquiry_project_name, "Project Name") == true) {
		return false;
	}
	if (academic_project_enquiry_qualification.value == 'Select') {
		academic_project_enquiry_qualification.style.borderColor = 'red';
		alert("Please Select Qualification");
		academic_project_enquiry_qualification.focus();
	}
	if (academic_project_enquiry_college.value == 'Select') {
		academic_project_enquiry_college.style.borderColor = 'red';
		alert("Please Select College");
		academic_project_enquiry_college.focus();
	}
	if (academic_project_enquiry_semester.value == 'Select') {
		academic_project_enquiry_semester.style.borderColor = 'red';
		alert("Please Select semester");
		academic_project_enquiry_semester.focus();
	}

	if (isBlank(academic_project_enquiry_delivery_date, "joining date") == true) {
		return false;
	}
	if (isBlank(academic_project_enquiry_fullname, "full name") == true) {
		return false;
	}
	if (isAlphabet(academic_project_enquiry_fullname,
			"Please enter valid full name") == false) {
		return false;
	}
	if (academic_project_enquiry_fullname.value.indexOf(' ') == -1) {
		academic_project_enquiry_fullname.style.borderColor = 'red';
		academic_project_enquiry_fullname.focus();
		alert("Please enter full name");
		return false;
	}
	if (isBlank(academic_project_enquiry_father_name, "father name") == true) {
		return false;
	}
	if (isAlphabet(academic_project_enquiry_father_name,
			"Please enter valid father name") == false) {
		return false;
	}
	if (academic_project_enquiry_father_name.value.indexOf(' ') == -1) {
		academic_project_enquiry_father_name.style.borderColor = 'red';
		academic_project_enquiry_father_name.focus();
		alert("Please enter father name");
		return false;
	}
	if (isBlank(academic_project_enquiry_contact_no, "contact number") == true) {
		return false;
	}
	if (!academic_project_enquiry_contact_no.value.match(num)) {
		academic_project_enquiry_contact_no.style.borderColor = 'red';
		academic_project_enquiry_contact_no.focus();
		alert("Please enter valid contact number");
		return false;
	}
	if (academic_project_enquiry_contact_no.value.length != 10) {
		academic_project_enquiry_contact_no.style.borderColor = 'red';
		alert("Please enter valid contact number");
		academic_project_enquiry_contact_no.focus();
		return false;
	}
	if (isBlank(academic_project_enquiry_email_id, "email id field") == true) {
		return false;
	}

	if (isBlank(academic_project_enquiry_reference_name, "reference name") == true) {
		return false;
	}
	if (isAlphabet(academic_project_enquiry_reference_name,
			"Please enter valid reference name") == false) {
		return false;
	}
	if (isBlank(academic_project_enquiry_reference_contact_no,
			"contact number field") == true) {
		return false;
	}
	if (!academic_project_enquiry_reference_contact_no.value.match(num)) {
		academic_project_enquiry_reference_contact_no.style.borderColor = 'red';
		academic_project_enquiry_reference_contact_no.focus();
		alert("Please enter valid contact number");
		return false;
	}
	if (academic_project_enquiry_reference_contact_no.value.length != 10) {
		academic_project_enquiry_reference_contact_no.style.borderColor = 'red';
		alert("Please enter valid contact number");
		academic_project_enquiry_reference_contact_no.focus();
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
function isAlphabet(input, msg) {
	var data = input.value;
	if (!data.match(lettersUnm)) {
		input.style.borderColor = 'red';
		alert(msg);
		input.focus();
		return false;
	}

}
function isNumber(myNumber) {
	if (myNumber.match(num)) {

	} else {
		return false;
	}
}
function clearForm() {
	document.getElementById("id_fullname").value = "";
	document.getElementById('id_father_name').value = "";
	document.getElementById('id_contact_no').value = "";
	document.getElementById('id_email_id').value = "";
	document.getElementById('id_joining_date').value = "";
	document.getElementById('id_preferredtime_start').value = "";
	document.getElementById('id_preferredtime_end').value = "";
	document.getElementById('id_joining_date').value = "";
	document.getElementById('id_reference_name').value = "";
	document.getElementById('id_reference_contact_no').value = "";
	document.getElementById('id_reference_note').value = "";
}
function mySearchFormValidation() {
	var vT1 = document.getElementById("id_search_enquiry_common_start_time").value;
	var vT2 = document.getElementById("id_search_enquiry_common_end_time").value;
	var vT3 = document.getElementById("id_search_training_enquiry_fullname").value;
	var vT4 = document.getElementById("id_search_training_enquiry_contactno").value;
	var vT5 = document.getElementById("id_search_training_enquiry_start_date").value;
	var vT6 = document.getElementById("id_search_training_enquiry_end_date").value;
	var vT7 = document
			.getElementById("id_search_training_enquiry_reference_name").value;
	var vT8 = document
			.getElementById("id_search_training_enquiry_reference_no").value;
	var vT9 = document
			.getElementById("id_search_training_enquiry_start_date_doj").value;
	var vT10 = document
			.getElementById("id_search_training_enquiry_end_date_doj").value;
	var vT11 = document
			.getElementById("id_search_training_enquiry_qualification").value;
	var vT12 = document.getElementById("id_search_training_enquiry_college").value;
	var vT13 = document.getElementById("id_search_training_enquiry_semester").value;
	var vT14 = document
			.getElementById("id_search_training_enquiry_preferredtime_start").value;
	var vT15 = document
			.getElementById("id_search_training_enquiry_preferredtime_end").value;
	var vT16 = document.getElementById("id_search_training_enquiry_course").value;
	var vT17 = document.getElementById("id_search_training_enquiry_status").value;

	var perpose = document.getElementById("id_serch_purpose");
	if (perpose.value == "Select") {
		alert("Please Select ")
		perpose.style.borderColor = 'red';
		return false;
	}
	if (perpose.value == "Trainning") {
		if (vT1 == "" && vT2 == "" && vT3 == "" && vT4 == "" && vT5 == ""
				&& vT6 == "" && vT7 == "" && vT8 == "" && vT9 == ""
				&& vT10 == "" && vT11 == "Select" && vT12 == "Select"
				&& vT13 == "Select" && vT14 == "" && vT15 == ""
				&& vT16 == "Select" && vT17 == "Select") {
			alert("Please Fill atleast one field");
			return false;
		}
	}
	return true;
}
