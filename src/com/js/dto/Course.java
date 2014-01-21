package com.js.dto;

public class Course {
	private String Course_Id;
	private String course_Name;
	private String prerequisite_Knowledge;
	private String course_Duration;
	private String course_File_Path;
	
	public Course(String course_Id, String course_Name,
			String prerequisite_Knowledge, String course_Duration,
			String course_File_Path) {
		super();
		Course_Id = course_Id;
		this.course_Name = course_Name;
		this.prerequisite_Knowledge = prerequisite_Knowledge;
		this.course_Duration = course_Duration;
		this.course_File_Path = course_File_Path;
	}

	public Course() {
		super();
	}

	public String getCourse_Id() {
		return Course_Id;
	}

	public void setCourse_Id(String course_Id) {
		Course_Id = course_Id;
	}

	public String getCourse_Name() {
		return course_Name;
	}

	public void setCourse_Name(String course_Name) {
		this.course_Name = course_Name;
	}

	public String getPrerequisite_Knowledge() {
		return prerequisite_Knowledge;
	}

	public void setPrerequisite_Knowledge(String prerequisite_Knowledge) {
		this.prerequisite_Knowledge = prerequisite_Knowledge;
	}

	public String getCourse_Duration() {
		return course_Duration;
	}

	public void setCourse_Duration(String course_Duration) {
		this.course_Duration = course_Duration;
	}

	public String getCourse_File_Path() {
		return course_File_Path;
	}

	public void setCourse_File_Path(String course_File_Path) {
		this.course_File_Path = course_File_Path;
	}	
	
}
