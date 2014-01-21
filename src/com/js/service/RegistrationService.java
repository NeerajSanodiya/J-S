package com.js.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

import com.js.dto.NewEnquiry;
import com.js.dto.TrainingRegistrationDTO;

public class RegistrationService {

	public String saveRegistration(TrainingRegistrationDTO registration,HttpServletRequest request,FileItem fileItem,String path) throws Exception{
		String ret=new com.js.dao.TrainingRegistrationDAO().saveTraningRegistration(registration, request, fileItem,path);
		return ret;
	}
	public List<List<String>> getTrainningRegistationAllFollowUp(String request) throws Exception{		
		return new com.js.dao.TrainingRegistrationDAO().getTrainningRegistationAllFollowUp(request);
	}
}
