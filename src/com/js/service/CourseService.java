package com.js.service;

import java.util.List;

import com.js.dao.CourseDAO;
import com.js.dto.Course;

public class CourseService {
	public List<Course> getAllCourse(String branchid) throws Exception{
		return new CourseDAO().getAllCourse(branchid);
	}
	public List<Course> getAllEnquiredCourse(String branchid) throws Exception{
		return new CourseDAO().getAllEnquiredCourse(branchid);
	}
}
