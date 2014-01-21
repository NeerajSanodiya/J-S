	function validateSearchForm(){
		alert("Search Validation");
		return false;
	}
	function enquiryValidate(){
		alert("New Enquiry Validation");
		return false;		
	}
	function check_for_qualification_other(){
		var qualification=document.getElementById("id_qualification");
		var foo = document.getElementById("id_qualification_div");		
		if(qualification.value=="Other"){
			var element = document.createElement("input");			 
		    //Assign different attributes to the element.
			
		    element.setAttribute("type","text");
			element.setAttribute("name","qualification_other");
		    element.setAttribute("id","id_qualification_text");
		    //Append the element in page (in span).
		    try{
		    	var ele=document.getElementById("id_qualification_text");
		    	foo.removeChild(ele);
		    }catch(e){}		    
		    foo.appendChild(element);			
		}else{
			try{				
				var ele=document.getElementById("id_qualification_text");
		    	foo.removeChild(ele);
		    }catch(e){
		    	
		    }	
		}				
	}
	function check_for_college_other(){
		var college=document.getElementById("id_college");
		var foo = document.getElementById("id_college_div");		
		if(college.value=="Other"){
			var element = document.createElement("input");			 
		    //Assign different attributes to the element.
		    element.setAttribute("type","text");	
		    element.setAttribute("name","college_other");
		    element.setAttribute("id","id_college_text");
		    //Append the element in page (in span).
		    try{
		    	var ele=document.getElementById("id_college_text");
		    	foo.removeChild(ele);
		    }catch(e){}		    
		    foo.appendChild(element);			
		}else{
			try{				
				var ele=document.getElementById("id_college_text");
		    	foo.removeChild(ele);
		    }catch(e){
		    	
		    }	
		}				
	}
	function check_for_training_college_other(){
		var college=document.getElementById("id_training_enquiry_college");
		var foo = document.getElementById("id_training_enquiry_college_div");		
		if(college.value=="Other"){
			var element = document.createElement("input");			 
		    //Assign different attributes to the element.
		    element.setAttribute("type","text");	
		    element.setAttribute("name","training_enquiry_college_other");
		    element.setAttribute("id","id_training_enquiry_college_other");
		    //Append the element in page (in span).
		    try{
		    	var ele=document.getElementById("id_training_enquiry_college_other");
		    	foo.removeChild(ele);
		    }catch(e){}		    
		    foo.appendChild(element);			
		}else{
			try{				
				var ele=document.getElementById("id_training_enquiry_college_other");
		    	foo.removeChild(ele);
		    }catch(e){
		    	
		    }	
		}				
	}
	function check_training_enquiry_qualification_other(){
		var qualification=document.getElementById("id_training_enquiry_qualification");
		var foo = document.getElementById("id_training_enquiry_qualification_other_div");		
		if(qualification.value=="Other"){
			var element = document.createElement("input");			 
		    //Assign different attributes to the element.
			
		    element.setAttribute("type","text");
			element.setAttribute("name","training_enquiry_qualification_other");
		    element.setAttribute("id","id_training_enquiry_qualification_other");
		    //Append the element in page (in span).
		    try{
		    	var ele=document.getElementById("id_training_enquiry_qualification_other");
		    	foo.removeChild(ele);
		    }catch(e){}		    
		    foo.appendChild(element);			
		}else{
			try{				
				var ele=document.getElementById("id_training_enquiry_qualification_other");
		    	foo.removeChild(ele);
		    }catch(e){
		    	
		    }	
		}				
	}
	function academic_project_enquiry_college_other1(){
		var college=document.getElementById("id_academic_project_enquiry_college");
		var foo = document.getElementById("id_academic_project_enquiry_college_other_div");		
		if(college.value=="Other"){
			var element = document.createElement("input");			 
		    //Assign different attributes to the element.
		    element.setAttribute("type","text");	
		    element.setAttribute("name","academic_project_enquiry_college_other");
		    element.setAttribute("id","id_academic_project_enquiry_college_other");
		    //Append the element in page (in span).
		    try{
		    	var ele=document.getElementById("id_academic_project_enquiry_college_other");
		    	foo.removeChild(ele);
		    }catch(e){}		    
		    foo.appendChild(element);			
		}else{
			try{				
				var ele=document.getElementById("id_academic_project_enquiry_college_other");
		    	foo.removeChild(ele);
		    }catch(e){
		    	
		    }	
		}				
	}
	function academic_project_enquiry_qualification_other1(){
		alert("sdfsdf");
		var qualification=document.getElementById("id_academic_project_enquiry_qualification");
		var foo = document.getElementById("id_academic_project_enquiry_qualification_other_div");		
		if(qualification.value=="Other"){
			var element = document.createElement("input");			 
		    //Assign different attributes to the element.
			
		    element.setAttribute("type","text");
			element.setAttribute("name","academic_project_enquiry_qualification_other");
		    element.setAttribute("id","id_academic_project_enquiry_qualification_other");
		    //Append the element in page (in span).
		    try{
		    	var ele=document.getElementById("id_academic_project_enquiry_qualification_other");
		    	foo.removeChild(ele);
		    }catch(e){}		    
		    foo.appendChild(element);			
		}else{
			try{				
				var ele=document.getElementById("id_academic_project_enquiry_qualification_other");
		    	foo.removeChild(ele);
		    }catch(e){
		    	
		    }	
		}				
	}
	