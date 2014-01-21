package com.js.tracker.ws.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.js.tracker.ws.dao.TimeLogDAO;
import com.js.tracker.ws.dto.LoginDTO;
import com.js.tracker.ws.dto.SearchDTO;
import com.js.tracker.ws.dto.SearchResultDTO;
import com.js.tracker.ws.dto.TimeLogDTO;
import com.js.tracker.ws.dto.UserDateWiseDTO;
import com.js.tracker.ws.util.JsonResponse;

public class TimeLogController {
	
	//Web Service 
	
	public String updateTimeLog(HttpServletRequest request){
		String ret=new JsonResponse(false,"error" , "").getJson();
		String username=request.getParameter("username");
		String timelog=request.getParameter("timelog");
				
		Gson gson=new Gson();
		TimeLogDTO[]list= gson.fromJson(timelog, TimeLogDTO[].class);
		TimeLogDAO dao=new TimeLogDAO();
		try{
			List<TimeLogDTO>retList= dao.addUserTimeLogs(list);
			ret=new JsonResponse(true,"" , retList).getJson();
			
		}catch (Exception e) {
			ret=new JsonResponse(false,"Database error." , "").getJson();
			e.printStackTrace();
		}
		return ret;
	}
	public String getUserTimeLog(LoginDTO dto){
		String ret=new JsonResponse(false,"error" , "").getJson();
		if(dto.getUnm()==null||dto.getUnm().equalsIgnoreCase("")){
			ret = new JsonResponse(false,"Required all field(unm)" , "").getJson();
			return ret;
		}
		TimeLogDAO dao=new TimeLogDAO();
		try{
			List<TimeLogDTO>list= dao.getUserTimeLog(dto);
			ret = new JsonResponse(true,"",list).getJson();
		}catch (Exception e) {
			e.printStackTrace();			
			ret=new JsonResponse(false,"Database error." , "").getJson();
		}		
		return ret;
	}	
	
	//Web site
	public void searchTimeLog(SearchDTO dto,HttpServletRequest request,HttpServletResponse response)throws Exception{
		String employeeId = (String) request.getSession(false).getAttribute("USERNAME");
		dto.setSupId(employeeId);
		TimeLogDAO dao=new TimeLogDAO();
		List<SearchResultDTO>list= dao.searchUserTimeLog(dto);		
		request.setAttribute("LOGRESULT", list);
		request.getRequestDispatcher("logs.jsp").forward(request, response);
		
	}
	public List<TimeLogDTO> userManualTimeLog(HttpServletRequest request) throws Exception {
		String employeeId = (String) request.getSession(false).getAttribute("USERNAME");
		return new TimeLogDAO().userManualTimeLog(employeeId);
	}
	public String approveManualRequest(TimeLogDTO dto){
		String ret="error";
		try{
			dto.setM_entry_status("approve");
			ret=new TimeLogDAO().changeManualstatus(dto);
		}catch (Exception e) {
			
		}
		return ret;
	}
	public String rejectManualRequest(TimeLogDTO dto){
		String ret="error";
		try{
			dto.setM_entry_status("reject");
			ret=new TimeLogDAO().changeManualstatus(dto);
		}catch (Exception e) {
			
		}
		return ret;
	}
	
}
