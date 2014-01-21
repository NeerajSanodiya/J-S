package com.js.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dto.AcademicProjectDTO;
import com.js.dto.AcademicProjectRemark;
import com.js.dto.EnquiryRemark;
import com.js.dto.NewAcademicProjectEnquiryDTO;
import com.js.dto.NewEnquiry;
import com.js.dto.NewTrainingEnquiryDTO;
import com.js.dto.NewVisitorEnquiryDTO;
import com.js.dto.Remark;
import com.js.dto.SearchEnquiry;
import com.js.msg.MyMessage;
import com.js.service.EnquiryService;

public class EnquiryController {
	public void saveNewVisitorEnquiry(
			NewVisitorEnquiryDTO newVisitorEnquiryDTO,
			HttpServletRequest request) throws Exception {
		String employeeId = (String) request.getSession(false).getAttribute(
				"USERNAME");
		newVisitorEnquiryDTO.setEmployee_id(employeeId);
		newVisitorEnquiryDTO.setVisitor_enquiry_enquiry_status("Fresh");
		new com.js.service.EnquiryService()
				.saveNewVisitorEnquiry(newVisitorEnquiryDTO);
	}

	public String saveNewTrainingEnquiry(
			NewTrainingEnquiryDTO newTrainingEnquiryDTO,
			HttpServletRequest request) throws Exception {
		String employeeId = (String) request.getSession(false).getAttribute(
				"USERNAME");
		newTrainingEnquiryDTO.setEmployee_id(employeeId);
		newTrainingEnquiryDTO.setTraining_enquiry_enquiry_status("Fresh");
		return new com.js.service.EnquiryService()
				.saveNewTrainingEnquiry(newTrainingEnquiryDTO);
	}

	public void saveNewAcademicProjectEnquiry(
			NewAcademicProjectEnquiryDTO newAcademicProjectEnquiryDTO,
			HttpServletRequest request) throws Exception {

		String employeeId = (String) request.getSession(false).getAttribute(
				"USERNAME");
		newAcademicProjectEnquiryDTO.setEmployee_id(employeeId);
		newAcademicProjectEnquiryDTO
				.setAcademic_project_enquiry_enquiry_status("Fresh");
		new com.js.service.EnquiryService()
				.saveNewAcademicProjectEnquiry(newAcademicProjectEnquiryDTO);
	}

	public void saveNewEnquiry(NewEnquiry newEnquiry,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String employeeId = (String) request.getSession(false).getAttribute(
				"USERNAME");
		newEnquiry.setEmployee_id(employeeId);
		newEnquiry.setEnquiry_status("Fresh");
		Date date = new Date();
		String c_date = (1900 + date.getYear()) + "-" + (1 + date.getMonth())
				+ "-" + date.getDate();
		newEnquiry.setEnquiry_date(c_date);
		new com.js.service.EnquiryService().saveNewEnquiry(newEnquiry);
	}

	/*
	 * public void updateEnquiry(NewEnquiry newEnquiry,HttpServletRequest
	 * request,HttpServletResponse response) throws Exception{ String
	 * employeeId=(String)request.getSession(false).getAttribute("USERNAME");
	 * newEnquiry.setEmployee_id(employeeId); new
	 * com.js.service.EnquiryService().updateEnquiry(newEnquiry); }
	 */
	public void updateTrainingEnquiry(NewTrainingEnquiryDTO newEnquiry,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String employeeId = (String) request.getSession(false).getAttribute(
				"USERNAME");
		newEnquiry.setEmployee_id(employeeId);
		new com.js.service.EnquiryService().updateTrainingEnquiry(newEnquiry);
	}

	public void updateAcademicProjectEnquiry(
			NewAcademicProjectEnquiryDTO newEnquiry,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String employeeId = (String) request.getSession(false).getAttribute(
				"USERNAME");
		newEnquiry.setEmployee_id(employeeId);
		new com.js.service.EnquiryService()
				.updateAcademicProjectEnquiry(newEnquiry);
	}

	/*
	 * public void searchEnquiryBranchWise(SearchEnquiry
	 * searchEnquiry,HttpServletRequest request,HttpServletResponse
	 * response,String branchid) throws Exception{ try{ List
	 * <NewEnquiry>enquiryList=new
	 * com.js.service.EnquiryService().searchEnquiryBranchWise
	 * (searchEnquiry,(String
	 * )request.getSession(false).getAttribute("BRANCHID"));
	 * request.setAttribute("ENQUIRYSEARCHRESULT",enquiryList);
	 * request.getRequestDispatcher("enquiry.jsp").forward(request,response);
	 * }catch(Exception ex){ ex.printStackTrace(); } }
	 */
	/*
	 * public List<EnquiryRemark> getAllRemarkForAnEnquiry(NewEnquiry
	 * newEnquiry) throws Exception{ return new
	 * EnquiryService().getAllRemarkForAnEnquiry(newEnquiry); }
	 */
	public String saveNewRemark(HttpServletRequest request) throws Exception {
		Remark remark = new Remark();
		String employeeId = (String) request.getSession(false).getAttribute(
				"USERNAME");
		Date date = new Date();
		String c_date = (1900 + date.getYear()) + "-" + (1 + date.getMonth())
				+ "-" + date.getDate();
		remark.setEmployee_id(employeeId);
		remark.setRemark(request.getParameter("remark"));
		remark.setRemark_alert(request.getParameter("alertdate"));
		remark.setRemark_date(c_date);
		remark.setEnquiry_id(request.getParameter("enquiryid"));
		return new EnquiryService().saveNewRemark(remark);
	}

	public String saveNewAcademicProjectRemark(HttpServletRequest request)
			throws Exception {
		AcademicProjectRemark remark = new AcademicProjectRemark();
		String employeeId = (String) request.getSession(false).getAttribute(
				"USERNAME");
		Date date = new Date();
		String c_date = (1900 + date.getYear()) + "-" + (1 + date.getMonth())
				+ "-" + date.getDate();
		remark.setEmployee_id(employeeId);
		remark.setRemark(request.getParameter("remark"));
		remark.setNext_meeting_date((request.getParameter("next_meeting_date")));
		remark.setRemark_date(c_date);
		remark.setEnquiry_id(request.getParameter("enquiryid"));

		remark.setProject_id(request.getParameter("project_id"));
		remark.setNext_meeting_time_start(request
				.getParameter("next_meeting_time_start"));
		remark.setNext_meeting_time_end(request
				.getParameter("next_meeting_time_end"));
		System.out.println(21);
		return new EnquiryService().saveNewAcademicProjectRemark(remark);
	}

	public List<List<NewEnquiry>> getAllFollowUp(HttpServletRequest request)
			throws Exception {
		return new com.js.service.EnquiryService()
				.getAllFollowUp((String) request.getSession(false)
						.getAttribute("BRANCHID"));
	}

	public List<List<NewTrainingEnquiryDTO>> getAllTrainingFollowUp(
			HttpServletRequest request) throws Exception {
		return new com.js.service.EnquiryService()
				.getAllTrainingFollowUp((String) request.getSession(false)
						.getAttribute("BRANCHID"));
	}

	public void searchTraningEnquiryBranchWise(SearchEnquiry searchEnquiry,
			HttpServletRequest request, HttpServletResponse response,
			String branchid) throws Exception {
		try {
			List<NewTrainingEnquiryDTO> enquiryList = new com.js.service.EnquiryService()
					.searchTrainingEnquiryBranchWise(
							searchEnquiry,
							(String) request.getSession(false).getAttribute(
									"BRANCHID"));
			String searchIn = (String) request.getParameter("search_purpose");
			request.setAttribute("TRAININGENQUIRYSEARCHRESULT", enquiryList);
			request.setAttribute("SEARCHIN", searchIn);
			request.getRequestDispatcher("enquiry.jsp").forward(request,
					response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void searchAcadenicEnquiryBranchWise(SearchEnquiry searchEnquiry,
			HttpServletRequest request, HttpServletResponse response,
			String branchid) throws Exception {
		try {
			List<NewAcademicProjectEnquiryDTO> enquiryList = new com.js.service.EnquiryService()
					.searchAcademicEnquiryBranchWise(
							searchEnquiry,
							(String) request.getSession(false).getAttribute(
									"BRANCHID"));
			String searchIn = (String) request.getParameter("search_purpose");
			request.setAttribute("ACADEMICENQUIRYSEARCHRESULT", enquiryList);
			request.setAttribute("SEARCHIN", searchIn);
			request.getRequestDispatcher("enq_aca_project.jsp").forward(request,
					response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void searchVisitorEnquiryBranchWise(SearchEnquiry searchEnquiry,
			HttpServletRequest request, HttpServletResponse response,
			String branchid) throws Exception {
		try {
			List<NewVisitorEnquiryDTO> enquiryList = new com.js.service.EnquiryService()
					.searchVisitorEnquiryBranchWise(searchEnquiry,
							(String) request.getSession(false).getAttribute(
									"BRANCHID"));
			String searchIn = (String) request.getParameter("search_purpose");
			request.setAttribute("VISITORENQUIRYSEARCHRESULT", enquiryList);
			request.setAttribute("SEARCHIN", searchIn);
			request.getRequestDispatcher("enquiry_visitor.jsp").forward(request,
					response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<List<NewAcademicProjectEnquiryDTO>> getAllAcademicProjectFollowUp(
			HttpServletRequest request) throws Exception {
		return new com.js.service.EnquiryService()
				.getAllAcademicProjectFollowUp((String) request.getSession(
						false).getAttribute("BRANCHID"));
	}
	public List<List<NewVisitorEnquiryDTO>> getAllVisitorFollowUp(
			HttpServletRequest request) throws Exception {
		return new com.js.service.EnquiryService()
				.getAllVisitorFollowUp((String) request.getSession(
						false).getAttribute("BRANCHID"));
	}
}
