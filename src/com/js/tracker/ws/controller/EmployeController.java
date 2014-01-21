package com.js.tracker.ws.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.tracker.ws.dao.EmployeDAO;
import com.js.tracker.ws.dto.EmployeDTO;
import com.js.tracker.ws.dto.LoginDTO;
import com.js.tracker.ws.util.JsonResponse;
import com.js.tracker.ws.util.TrackerDate;

public class EmployeController {
	public void employeActiveStatusChange(EmployeDTO dto,HttpServletResponse response) throws Exception{
		LoginDTO loginDTO=new LoginDTO();
		loginDTO.setUnm(dto.getId());
		loginDTO.setActive_staatus(dto.getActive_statis());
		new EmployeDAO().employeActiveStatusChange(loginDTO);
		response.sendRedirect("employee.jsp");
	}
	public void resetMac(LoginDTO dto,HttpServletResponse response) throws Exception {		
		new EmployeDAO().changeMac(dto);
		response.sendRedirect("employee.jsp");
	}
	public String getEmploeeById(EmployeDTO dto){
		String ret = new JsonResponse(false, "error.", "").getJson();
		if(dto.getId()==null||dto.getId().equalsIgnoreCase("")){
			ret = new JsonResponse(false, "Required all field(id)", "").getJson();
			return ret;
		}
		try{
			EmployeDTO employeDTO=new EmployeDAO().getEmploeeById(dto.getId());
			if(employeDTO!=null){
				String dob=TrackerDate.getInstance().changeDateFormate_df1_df(employeDTO.getDob());
				String dofrom=TrackerDate.getInstance().changeDateFormate_df1_df(employeDTO.getFromDate());
				String doto=TrackerDate.getInstance().changeDateFormate_df1_df(employeDTO.getToDate());
				employeDTO.setDob(dob);
				employeDTO.setFromDate(dofrom);
				employeDTO.setToDate(doto);
				ret = new JsonResponse(true, "", employeDTO).getJson();
			}else{
				ret = new JsonResponse(false, "Record not found.", "").getJson();
			}
		}catch (Exception e) {
			ret = new JsonResponse(false, "Database error.", "").getJson();
		}	
		return ret;
	}
	public String getUpdateEmploye(EmployeDTO employeDTO){
		String ret = new JsonResponse(false, "error.", "").getJson();
		try{
			String dob=TrackerDate.getInstance().changeDateFormate_df_df1(employeDTO.getDob());
			String dofrom=TrackerDate.getInstance().changeDateFormate_df_df1(employeDTO.getFromDate());
			String doto=TrackerDate.getInstance().changeDateFormate_df_df1(employeDTO.getToDate());
			employeDTO.setDob(dob);
			employeDTO.setFromDate(dofrom);
			employeDTO.setToDate(doto);
			String res=new EmployeDAO().employeUpdate(employeDTO);
			if(res.equalsIgnoreCase("success")){				
				ret = new JsonResponse(true, "", "Record successfully updated.").getJson();
			}else{
				ret = new JsonResponse(false, "Record not saved.", "").getJson();
			}
		}catch (Exception e) {
			ret = new JsonResponse(false, "Database error.", "").getJson();
		}
		return ret;
	}
	
	public void updateEmploye(HttpServletRequest request,
			HttpServletResponse response, EmployeDTO dto) {
		
		String ret = "error";
		try {
			String employeeId = (String) request.getSession(false)
					.getAttribute("USERNAME");
			String toDate = TrackerDate.getInstance().changeDateFormate_df_df2(dto.getToDate());
			String fromDate = TrackerDate.getInstance().changeDateFormate_df_df2(dto.getFromDate());
			String dobDate = TrackerDate.getInstance().changeDateFormate_df_df2(dto.getDob());
			dto.setFromDate(fromDate);
			dto.setToDate(toDate);
			dto.setDob(dobDate);
			dto.setSupId(employeeId);
			ret = new EmployeDAO().employeUpdate(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (ret.equalsIgnoreCase("success")) {
				response.getWriter().println("Employe data successfully updated");
			}else {
				response.getWriter().println("Employe not updated");
			}
		} catch (Exception e) {

		}
	}
	public void saveEmploye(HttpServletRequest request,
			HttpServletResponse response, EmployeDTO dto) {
		
		String ret = "error";
		try {
			String employeeId = (String) request.getSession(false)
					.getAttribute("USERNAME");
			dto.setSupId(employeeId);
			ret = new EmployeDAO().employeRegistration(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (ret.equalsIgnoreCase("success")) {
				response.getWriter().println("Employe data successfully saved");
			}else {
				response.getWriter().println("Employe not saved");
			}
		} catch (Exception e) {

		}
	}
	public List<EmployeDTO> getSupervisorEmploee(HttpServletRequest request){
		try{
			String employeeId = (String) request.getSession(false)
					.getAttribute("USERNAME");
			return new EmployeDAO().getSupervisorEmploee(employeeId);
		}catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<EmployeDTO>();
		}		
	}
}
