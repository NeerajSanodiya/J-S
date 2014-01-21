package com.js.dto;

public class NewEnquiry {
	
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
	private String preferredtime_start;
	private String preferredtime_end;
	private String joining_date;	
	private String enquiry_status;
	private String enquiry_date;
	
	private String referenceId;
	private String reference_name;
	private String reference_contact_no;
	private String reference_note;
	
	private String purpose;
	private String project_name;
	private String delivery_date;
	private String project_description;
	
	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}

	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public NewEnquiry(String employee_id, String enquiry_id, String fullname,
			String father_name, String qualification,
			String qualification_other, String college, String college_other,
			String semester, String contact_no, String email_id,
			String[] course, String preferredtime_start,
			String preferredtime_end, String joining_date,
			String enquiry_status, String enquiry_date, String reference_name,
			String reference_contact_no, String reference_note) {
		super();
		this.employee_id = employee_id;
		this.enquiry_id = enquiry_id;
		this.fullname = fullname;
		this.father_name = father_name;
		this.qualification = qualification;
		this.qualification_other = qualification_other;
		this.college = college;
		this.college_other = college_other;
		this.semester = semester;
		this.contact_no = contact_no;
		this.email_id = email_id;
		this.course = course;
		this.preferredtime_start = preferredtime_start;
		this.preferredtime_end = preferredtime_end;
		this.joining_date = joining_date;
		this.enquiry_status = enquiry_status;
		this.enquiry_date = enquiry_date;
		this.reference_name = reference_name;
		this.reference_contact_no = reference_contact_no;
		this.reference_note = reference_note;
	}

	public NewEnquiry() {
		super();
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

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
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

	public String getQualification_other() {
		return qualification_other;
	}

	public void setQualification_other(String qualification_other) {
		this.qualification_other = qualification_other;
	}

	public String getCollege_other() {
		return college_other;
	}

	public void setCollege_other(String college_other) {
		this.college_other = college_other;
	}

	public String getEnquiry_id() {
		return enquiry_id;
	}

	public void setEnquiry_id(String enquiry_id) {
		this.enquiry_id = enquiry_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
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
	
}
