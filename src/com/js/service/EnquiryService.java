package com.js.service;

import java.util.List;

import com.js.dao.EnquiryDAO;
import com.js.dto.AcademicProjectDTO;
import com.js.dto.AcademicProjectRemark;
import com.js.dto.EnquiryRemark;
import com.js.dto.NewAcademicProjectEnquiryDTO;
import com.js.dto.NewEnquiry;
import com.js.dto.NewTrainingEnquiryDTO;
import com.js.dto.NewVisitorEnquiryDTO;
import com.js.dto.Remark;
import com.js.dto.SearchEnquiry;

public class EnquiryService {
	public String saveNewVisitorEnquiry(NewVisitorEnquiryDTO newEnquiry) throws Exception{
		String ret=new com.js.dao.EnquiryDAO().saveNewVistorEnquiry(newEnquiry);
		return ret;
	}
	public String saveNewTrainingEnquiry(NewTrainingEnquiryDTO newTrainingEnquiryDTO) throws Exception{
		String ret=new com.js.dao.EnquiryDAO().saveNewTrainingEnquiry(newTrainingEnquiryDTO);
		return ret;
	}
	public String saveNewAcademicProjectEnquiry(NewAcademicProjectEnquiryDTO newAcademicProjectEnquiryDTO) throws Exception{
		String ret=new com.js.dao.EnquiryDAO().saveNewAcademicProjectEnquiry(newAcademicProjectEnquiryDTO);
		return ret;
	}
	public String saveNewEnquiry(NewEnquiry newEnquiry) throws Exception{
		String ret=new com.js.dao.EnquiryDAO().saveNewEnquiry(newEnquiry);
		return ret;
	}	
	public List<String> getAllEnquiredQualification(String branchid) throws Exception{
		return new com.js.dao.EnquiryDAO().getAllEnquiredQualification(branchid);
	}
	/*public List<NewEnquiry> searchEnquiryBranchWise(SearchEnquiry searchEnquiry,String branchid) throws Exception{
		return new com.js.dao.EnquiryDAO().searchEnquiryBranchWise(searchEnquiry,branchid);
	}*/
	public List<String> getAllEnquiredStatus(String branchid) throws Exception{
		return new com.js.dao.EnquiryDAO().getAllEnquiredStatus(branchid);
	}
	public List<EnquiryRemark> getAllRemarkForAnEnquiry(NewEnquiry newEnquiry) throws Exception{
		return new EnquiryDAO().getAllRemarkForAnEnquiry(newEnquiry);
	}
	public String saveNewRemark(Remark remark) throws Exception{
		return new EnquiryDAO().saveNewRemark(remark);
	}
	public String saveNewAcademicProjectRemark(AcademicProjectRemark academicProjectRemark) throws Exception{
	
		return new EnquiryDAO().saveNewAcademicProjectRemark(academicProjectRemark);
	}
	//************
	
	public List<List<NewEnquiry>> getAllFollowUp(String branchid) throws Exception{
		return new com.js.dao.EnquiryDAO().getAllFollowUp(branchid);
	}
	/*public String updateEnquiry(NewEnquiry newEnquiry) throws Exception{
		return new EnquiryDAO().updateEnquiry(newEnquiry);
	}*/
	public String updateTrainingEnquiry(NewTrainingEnquiryDTO newEnquiry) throws Exception{
		return new EnquiryDAO().updateTrainingEnquiry(newEnquiry);
	}
	public String updateAcademicProjectEnquiry(NewAcademicProjectEnquiryDTO newEnquiry) throws Exception{
		return new EnquiryDAO().updateAcademicProjectEnquiry(newEnquiry);
	}
	
	public List<List<NewTrainingEnquiryDTO>> getAllTrainingFollowUp(String branchid) throws Exception{
		return new com.js.dao.EnquiryDAO().getTrainingAllFollowUp(branchid);
	}
	public List<List<NewAcademicProjectEnquiryDTO>> getAllAcademicProjectFollowUp(String branchid) throws Exception{
		return new com.js.dao.EnquiryDAO().getAllAcademicProjectFollowUp(branchid);
	}
	public List<List<NewVisitorEnquiryDTO>> getAllVisitorFollowUp(String branchid) throws Exception{
		return new com.js.dao.EnquiryDAO().getAllVisitorFollowUp(branchid);
	}
	public List<EnquiryRemark> getAllRemarkForAnTrainingEnquiry(NewTrainingEnquiryDTO newEnquiry) throws Exception{
		return new EnquiryDAO().getAllRemarkForAnTrainingEnquiry(newEnquiry);
	}
	public List<NewAcademicProjectEnquiryDTO> searchAcademicEnquiryBranchWise(SearchEnquiry searchEnquiry,String branchid) throws Exception{
		return new com.js.dao.EnquiryDAO().searchAcademicEnquiryBranchWise(searchEnquiry,branchid);
	}
	public List<NewVisitorEnquiryDTO> searchVisitorEnquiryBranchWise(SearchEnquiry searchEnquiry,String branchid) throws Exception{
		return new com.js.dao.EnquiryDAO().searchVisitorEnquiryBranchWise(searchEnquiry,branchid);
	}
	public List<NewTrainingEnquiryDTO> searchTrainingEnquiryBranchWise(SearchEnquiry searchEnquiry,String branchid) throws Exception{
		return new com.js.dao.EnquiryDAO().searchTraininEnquiryBranchWise(searchEnquiry,branchid);
	}
	public List<AcademicProjectRemark> getAllRemarkForAnAcademicProjectEnquiry(NewAcademicProjectEnquiryDTO newAcademicProjectEnquiryDTO) throws Exception{
		
		return new EnquiryDAO().getAllRemarkForAnAcademicProjectEnquiry(newAcademicProjectEnquiryDTO);
	}
	//saveNewAcademicProjectRemark(remark);
}
