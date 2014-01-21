<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="../css/datepicker.css" type="text/css" />    
	<script type="text/javascript" src="../js/datepicker/datepicker.js"></script>
    <script type="text/javascript" src="../js/datepicker/eye.js"></script>
    <script type="text/javascript" src="../js/datepicker/utils.js"></script>
    <script type="text/javascript" src="../js/datepicker/layout.js?ver=1.0.2"></script>

<title>Insert title here</title>
</head>
<body>
<input type="text" name="training_enquiry_joining_date" value="06/11/2008" id="id_training_enquiry_joining_date" size="21" />
<script>
						$('#id_training_enquiry_joining_date').DatePicker({
		                    	format:'m/d/Y',
		                    	date: $('#id_training_enquiry_joining_date').val(),
		                    	current: $('#id_training_enquiry_joining_date').val(),
		                    	starts: 1,
		                    	position: 'r',
		                    	onBeforeShow: function(){
		                    		$('#id_training_enquiry_joining_date').DatePickerSetDate($('#id_training_enquiry_joining_date').val(), true);
		                    	},
		                    	onChange: function(formated, dates){
		                    		$('#id_training_enquiry_joining_date').val(formated);
		                    			$('#id_training_enquiry_joining_date').DatePickerHide();
		                    	}
		                    });
						</script>
</body>
</html>