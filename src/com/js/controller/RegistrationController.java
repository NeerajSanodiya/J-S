package com.js.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.jasper.tagplugins.jstl.core.Out;

import java.util.Iterator;
import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.TrainingRegistrationDAO;
import com.js.dto.NewEnquiry;
import com.js.dto.NewTrainingEnquiryDTO;
import com.js.dto.SearchEnquiry;
import com.js.dto.TrainingRegistrationDTO;

public class RegistrationController {
	public void searchTranningRegistration(SearchEnquiry searchEnquiry,
			HttpServletRequest request, HttpServletResponse response,
			String branchid) throws Exception {
		try {
			searchEnquiry.setSearch_training_enquiry_status("Joined");
			searchEnquiry.setSearch_purpose("training");
			List<NewTrainingEnquiryDTO> enquiryList = new com.js.service.EnquiryService()
					.searchTrainingEnquiryBranchWise(
							searchEnquiry,
							(String) request.getSession(false).getAttribute(
									"BRANCHID"));
			request.setAttribute("REGISTRATIONSEARCHRESULT", enquiryList);
			request.getRequestDispatcher("registration.jsp").forward(request,
					response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<List<String>> getTrainningRegistationAllFollowUp(
			HttpServletRequest request) throws Exception {
		return new com.js.service.RegistrationService()
				.getTrainningRegistationAllFollowUp((String) request
						.getSession(false).getAttribute("BRANCHID"));
	}

	public TrainingRegistrationDTO getRegistration(String regId)
			throws Exception {
		return new TrainingRegistrationDAO().getRegistration(regId);
	}

	public String saveTrainingRegistration(HttpServletRequest request,
			HttpServletResponse response, String path) throws Exception {
		String ret = "error";
		TrainingRegistrationDTO trainingRegistrationDTO = new TrainingRegistrationDTO();
		String val = request.getRealPath("\\");
		System.out.println(val);
		File filepath = new File(val + "studentimage");
		filepath.mkdirs();
		String filePath = filepath.getAbsolutePath();
		File file = null;
		FileItem fileFrom = null;
		int maxFileSize = 5000 * 1024;
		int maxMemSize = maxFileSize;
		String contentType = request.getContentType();
		if (contentType != null && (contentType.indexOf("multipart/form-data") >= 0)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(maxMemSize);
			factory.setRepository(new File("/tmp"));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(maxFileSize);
			String photoName = null;
			try {
				List fileItems = upload.parseRequest(request);
				Iterator i = fileItems.iterator();
				while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();
					if (fi.isFormField()) {
						String fieldName = fi.getFieldName();
						String fileName = fi.getString();
						if (fieldName.equals("registration_id")) {
							trainingRegistrationDTO
									.setRegistration_id(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("fullname")) {
							trainingRegistrationDTO.setFullname(fileName);
							System.out.println(fileName);

						}
						if (fieldName.equals("father_name")) {
							trainingRegistrationDTO.setFather_name(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("contact_no")) {
							trainingRegistrationDTO.setContact_no(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("email_id")) {
							trainingRegistrationDTO.setEmail_id(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("address")) {
							trainingRegistrationDTO.setAddress(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("enrollment_no")) {
							trainingRegistrationDTO.setEnrollment_no(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("qualification")) {
							trainingRegistrationDTO.setQualification(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("college")) {
							trainingRegistrationDTO.setCollege(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("semester")) {
							trainingRegistrationDTO.setSemester(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("date_of_birth")) {
							trainingRegistrationDTO.setDate_of_birth(fileName);
							System.out.println(fileName);
						}

						if (fieldName.equals("course")) {
							trainingRegistrationDTO
									.setRegisterForCourse(fileName);
							System.out.println(fileName);
							// trainingRegistrationDTO.setCourse(fileName);
						}

						if (fieldName.equals("batch_time_start")) {
							trainingRegistrationDTO
									.setBatch_time_start(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("batch_time_end")) {
							trainingRegistrationDTO.setBatch_time_end(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("total_amount")) {
							trainingRegistrationDTO.setTotal_amount(Integer
									.parseInt(fileName));
							System.out.println(fileName);
						}
						if (fieldName.equals("discount_amount")) {
							trainingRegistrationDTO.setDiscount_amount(Integer
									.parseInt(fileName));
							System.out.println(fileName);
						}
						if (fieldName.equals("discount_detail")) {
							trainingRegistrationDTO
									.setDiscount_detail(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("reference_name")) {
							trainingRegistrationDTO.setReference_name(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("reference_contact_no")) {
							trainingRegistrationDTO
									.setReference_contact_no(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("reference_note")) {
							trainingRegistrationDTO.setReference_note(fileName);
							System.out.println(fileName);
						}
						if (fieldName.equals("enquiry_id")) {
							trainingRegistrationDTO.setEnquiry_id(fileName);
							System.out.println(fileName);
						}

					} else {
						String fieldName = fi.getFieldName();
						String fileName = fi.getName();
						if (fileName == "") {
						} // out.println("You forgot to choose a file. <a href=''>Try again</a>");
						fileFrom = fi;
						file = new File(filePath,new Date().getTime()+fileName.substring(
								fileName.lastIndexOf("."), fileName.length()));
						fi.write(file);
						trainingRegistrationDTO.setPhoto_path(file
								.getName());
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				ret = "Registration not saved";
				return ret;
			}

		}

		Date date = new Date();
		String c_date = (1900 + date.getYear()) + "-" + (1 + date.getMonth())
				+ "-" + date.getDate();
		trainingRegistrationDTO.setReg_date(c_date);

		String employeeId = (String) request.getSession(false).getAttribute(
				"USERNAME");
		trainingRegistrationDTO.setEmployee_id(employeeId);
		ret = new com.js.service.RegistrationService().saveRegistration(
				trainingRegistrationDTO, request, fileFrom, path);
		if (ret.equalsIgnoreCase("error")) {
			ret = "Registration not saved";
		} else {
			if (ret.equalsIgnoreCase("Data error")) {
				ret = "Data error";
			} else {
				ret = "Registration succesfully saved";
			}
		}

		return ret;
	}
}
