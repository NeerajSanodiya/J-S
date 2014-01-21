package com.js.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

import com.js.dao.EnquiryDAO;
import com.js.dao.RegistrationRemarkDao;
import com.js.dto.EnquiryRemark;
import com.js.dto.NewEnquiry;
import com.js.dto.Remark;
import com.js.dto.TrainingRegistrationDTO;

public class RegistrationRemarkService {
	public String saveNewRemark(Remark remark) throws Exception{
		return new RegistrationRemarkDao().saveNewRemark(remark);
	}
	public List<Remark> getAllRemarkForAnRegistration(String registrationId) throws Exception{
		return new RegistrationRemarkDao().getAllRemarkForAnRegistration(registrationId);
	}
}
