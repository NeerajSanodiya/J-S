var lettersUnm = /^[A-Za-z' 'A-Za-z]+$/;
var num = /^[0-9]+$/;
var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

$(document).ready(function() {
	$('#saveemployeBtn').click(function() {
		$('#saveemployeForm').submit();
		return false;
	});
	$('#saveemployeForm').submit(function() {		
		
		manualStatusSave();
			
		return false;
	});
});
function manualStatusSave(myform,tblrow) {
	$.post('manualstatus.jsp', $('#'+myform).serialize())
			.success(function(response) {
				var res = trimExtraSpaces(response);
				if (res.indexOf('success') == -1) {
					tblrow.style.display='none';
				} else {
					
				}				
			}).error(function(e) {
				alert(e);
			});
	return false;
}

function showEmployeData(count) {
	document.forms["saveemployeForm"]["id"].value = document
			.getElementById("id" + count).value;
	document.forms["saveemployeForm"]["id1"].value = document
			.getElementById("id" + count).value;
	document.forms["saveemployeForm"]["name"].value = document
			.getElementById("name" + count).value;
	document.forms["saveemployeForm"]["fatherName"].value = document
			.getElementById("fatherName" + count).value;
	document.forms["saveemployeForm"]["email"].value = document
			.getElementById("email" + count).value;
	document.forms["saveemployeForm"]["address"].value = document
			.getElementById("address" + count).value;
	document.forms["saveemployeForm"]["mno"].value = document
			.getElementById("mno" + count).value;
	document.forms["saveemployeForm"]["salery"].value = document
			.getElementById("salery" + count).value;
	document.forms["saveemployeForm"]["fromDate"].value = document
			.getElementById("fromDate" + count).value;
	document.forms["saveemployeForm"]["toDate"].value = document
			.getElementById("toDate" + count).value;
	document.forms["saveemployeForm"]["dob"].value = document
			.getElementById("dob" + count).value;
	var gender = document.getElementById("gender" + count).value;
	if (gender == "male") {
		document.getElementById("id_male").checked = true;
	} else {
		document.getElementById("id_female").checked = true;
	}
	// document.getElementById("row_id").style.display='block';
	document.getElementById("saveemployeBtn").value = "Update"
}

$(document).ready(function() {
	$('#saveemployeBtn').click(function() {
		$('#saveemployeForm').submit();
		return false;
	});
	$('#saveemployeForm').submit(function() {
		var btnLabel = document.getElementById('saveemployeBtn').value;
		if (btnLabel == 'save') {

			if (validateEmploye() == false) {
				return false;
			} else {
				saveEmployeFormSubmit();
			}
		}
		if (btnLabel == 'Update') {

			if (validateEmploye() == false) {
				return false;
			} else {
				updateEmployeFormSubmit();
			}
		}
		return false;
	});
});
function saveEmployeFormSubmit() {
	$.post('employeservice.jsp?type=save', $('#saveemployeForm').serialize())
			.success(function(response) {
				var res = trimExtraSpaces(response);
				if (res.indexOf('not') == -1) {
					var no_use = new Array();

					popup(res);
				} else {
					popup(res);
				}
				if (res.indexOf("success") != -1) {
					$('#saveemployeForm')[0].reset();
				}
			}).error(function(e) {
				alert(e);
			});
}
function updateEmployeFormSubmit() {
	$.post('employeservice.jsp?type=update', $('#saveemployeForm').serialize())
			.success(function(response) {
				var res = trimExtraSpaces(response);
				if (res.indexOf('not') == -1) {
					var no_use = new Array();

					popup(res);
				} else {
					popup(res);
				}
				if (res.indexOf("success") != -1) {
					$('#saveemployeForm')[0].reset();
				}
			}).error(function(e) {
				alert(e);
			});
}
function trimExtraSpaces(theField) {
	var trimValue = "";
	trimValue = theField.toUpperCase();
	trimValue = trimValue.replace(/\s+/g, " ");
	trimValue = trimValue.replace(/^\s+|\s+$/g, "");
	return trimValue;
}
function validateEmploye() {
	var name = document.forms["saveemployeForm"]["name"];
	var fatherName = document.forms["saveemployeForm"]["fatherName"];
	var email = document.forms["saveemployeForm"]["email"];
	var address = document.forms["saveemployeForm"]["address"];
	var mno = document.forms["saveemployeForm"]["mno"];
	var salery = document.forms["saveemployeForm"]["salery"];
	var fromDate = document.forms["saveemployeForm"]["fromDate"];
	var toDate = document.forms["saveemployeForm"]["toDate"];
	var dob = document.forms["saveemployeForm"]["dob"];

	if (isBlank(name, "name") == true) {
		return false;
	}
	if (isBlank(fatherName, "fatherName") == true) {
		return false;
	}
	if ((document.forms["saveemployeForm"]["gender"][0].checked == false)
			&& (document.forms["saveemployeForm"]["gender"][1].checked == false)) {
		alert("Please choose your Gender: Male or Female");
		return false;
	}
	if (isBlank(dob, "date of birth") == true) {
		return false;
	}
	if (isBlank(email, "email") == true) {
		return false;
	}
	if (isBlank(address, "address") == true) {
		return false;
	}
	if (isBlank(mno, "mobile no") == true) {
		return false;
	}
	if (isBlank(salery, "salery") == true) {
		return false;
	}
	if (isBlank(fromDate, "salery fromDate") == true) {
		return false;
	}
	if (isBlank(toDate, "salery toDate") == true) {
		return false;
	}
	if (isAlphabet(name, "Please enter full name") == false) {
		return false;
	}
	if (isAlphabet(fatherName, "Please enter full father name") == false) {
		return false;
	}

	if (reg.test(email.value) == false) {
		email.style.borderColor = 'red';
		email.focus();
		alert('Invalid Email Address');
		return false;
	}
	if (!mno.value.match(num)) {
		mno.style.borderColor = 'red';
		mno.focus();
		alert("Please enter valid mobile number");
		return false;
	}
	if (mno.value.length != 10) {
		mno.style.borderColor = 'red';
		alert("Please enter valid mobile number");
		mno.focus();
		return false;
	}
	if (!salery.value.match(num)) {
		salery.style.borderColor = 'red';
		salery.focus();
		alert("Please enter number");
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
$(document).ready(function() {

	$('a.btn-ok,#dialog-box').click(function() {
		$('#dialog-overlay, #dialog-box').hide();
		return false;
	});

	$(window).resize(function() {
		if (!$('#dialog-box').is(':hidden'))
			popup();
	});

});

function popup(message) {

	var maskHeight = $(document).height();
	var maskWidth = $(window).width();

	var dialogTop = (maskHeight / 3) - ($('#dialog-box').height());
	var dialogLeft = (maskWidth / 2) - ($('#dialog-box').width() / 2);

	$('#dialog-overlay').css({
		height : maskHeight,
		width : maskWidth
	}).show();
	$('#dialog-box').css({
		top : dialogTop,
		left : dialogLeft
	}).show();

	$('#dialog-message').html(message);

}
