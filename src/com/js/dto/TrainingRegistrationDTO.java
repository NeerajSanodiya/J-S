package com.js.dto;

public class TrainingRegistrationDTO {
	private String employee_id;
	private String enquiry_id;
	private String fullname;
	private String father_name;
	
	private String qualification;
	private String qualification_other;
	
	private String college;
	private String college_other;	
	
	private String semester;
	private String contact_no;
	private String email_id;
	private String course[];
	private String registerForCourse;
	private String preferredtime_start;
	private String preferredtime_end;
	private String joining_date;	
	private String enquiry_status;
	private String enquiry_date;
	
	private String referenceId;
	private String reference_name;
	private String reference_contact_no;
	private String reference_note;
	
	private String registration_id;
	private String reg_date;
	private String address;
	private String date_of_birth;
	private String enrollment_no;
	private String batch_time_start;
	private String batch_time_end;
	private String photo_path;
	private String reg_employee_id;
	private Integer total_amount;
	private Integer discount_amount;
	private String discount_detail;
	private String coursename;	
	
	
	public TrainingRegistrationDTO() {
		super();
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getEnquiry_id() {
		return enquiry_id;
	}
	public void setEnquiry_id(String enquiry_id) {
		this.enquiry_id = enquiry_id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getQualification_other() {
		return qualification_other;
	}
	public void setQualification_other(String qualification_other) {
		this.qualification_other = qualification_other;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCollege_other() {
		return college_other;
	}
	public void setCollege_other(String college_other) {
		this.college_other = college_other;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String[] getCourse() {
		return course;
	}
	public void setCourse(String[] course) {
		this.course = course;
	}
	public String getPreferredtime_start() {
		return preferredtime_start;
	}
	public void setPreferredtime_start(String preferredtime_start) {
		this.preferredtime_start = preferredtime_start;
	}
	public String getPreferredtime_end() {
		return preferredtime_end;
	}
	public void setPreferredtime_end(String preferredtime_end) {
		this.preferredtime_end = preferredtime_end;
	}
	public String getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}
	public String getEnquiry_status() {
		return enquiry_status;
	}
	public void setEnquiry_status(String enquiry_status) {
		this.enquiry_status = enquiry_status;
	}
	public String getEnquiry_date() {
		return enquiry_date;
	}
	public void setEnquiry_date(String enquiry_date) {
		this.enquiry_date = enquiry_date;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getReference_name() {
		return reference_name;
	}
	public void setReference_name(String reference_name) {
		this.reference_name = reference_name;
	}
	public String getReference_contact_no() {
		return reference_contact_no;
	}
	public void setReference_contact_no(String reference_contact_no) {
		this.reference_contact_no = reference_contact_no;
	}
	public String getReference_note() {
		return reference_note;
	}
	public void setReference_note(String reference_note) {
		this.reference_note = reference_note;
	}
	public String getRegistration_id() {
		return registration_id;
	}
	public void setRegistration_id(String registration_id) {
		this.registration_id = registration_id;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getEnrollment_no() {
		return enrollment_no;
	}
	public void setEnrollment_no(String enrollment_no) {
		this.enrollment_no = enrollment_no;
	}
	public String getBatch_time_start() {
		return batch_time_start;
	}
	public void setBatch_time_start(String batch_time_start) {
		this.batch_time_start = batch_time_start;
	}
	public String getBatch_time_end() {
		return batch_time_end;
	}
	public void setBatch_time_end(String batch_time_end) {
		this.batch_time_end = batch_time_end;
	}
	public String getPhoto_path() {
		return photo_path;
	}
	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
	public String getReg_employee_id() {
		return reg_employee_id;
	}
	public void setReg_employee_id(String reg_employee_id) {
		this.reg_employee_id = reg_employee_id;
	}
	public Integer getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}
	public Integer getDiscount_amount() {
		return discount_amount;
	}
	public void setDiscount_amount(Integer discount_amount) {
		this.discount_amount = discount_amount;
	}
	public String getDiscount_detail() {
		return discount_detail;
	}
	public void setDiscount_detail(String discount_detail) {
		this.discount_detail = discount_detail;
	}
	public String getRegisterForCourse() {
		return registerForCourse;
	}
	public void setRegisterForCourse(String registerForCourse) {
		this.registerForCourse = registerForCourse;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}	
	
}
