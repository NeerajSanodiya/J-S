package com.js.tracker.ws.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.js.tracker.ws.dao.LoginDAO;
import com.js.tracker.ws.dto.LoginDTO;
import com.js.tracker.ws.util.JsonResponse;

public class LoginController {
	//Web Service
	public String loginVarify(LoginDTO dto) {
		String ret = new JsonResponse(false, "error.", "").getJson();
		if (dto.getUnm() == null || dto.getUp() == null || dto.getMac() == null
				|| dto.getUnm().equalsIgnoreCase("")
				|| dto.getUp().equalsIgnoreCase("")
				|| dto.getMac().equalsIgnoreCase("")) {
			ret = new JsonResponse(false, "Required all field(unm,up,mac)", "")
					.getJson();
			return ret;
		}
		LoginDAO dao = new LoginDAO();
		try {
			LoginDTO newLogin = dao.LoginVarify(dto);
			if (newLogin == null) {
				ret = new JsonResponse(false, "Invalid username or password.",
						"").getJson();
			} else {
				if(newLogin.getActive_staatus().equalsIgnoreCase("active")){					
				
					if (newLogin.getMac() == null
							|| newLogin.getMac().equalsIgnoreCase("")) {
						String ret1 = dao.updateLogin(dto);
						if (ret1.equalsIgnoreCase("success")) {
							newLogin.setMac(dto.getMac());
							if (!newLogin.getMac().equalsIgnoreCase(dto.getMac())) {
								ret = new JsonResponse(false, "Mac address changed.", "")
										.getJson();
							} else {
								ret = new JsonResponse(true, "", newLogin)
										.getJson();
							}
						} else {
							ret = new JsonResponse(false, "Mac not saved", "")
									.getJson();
						}
					} else {
						if (!newLogin.getMac().equalsIgnoreCase(dto.getMac())) {
							ret = new JsonResponse(false, "Mac address changed.",
									"").getJson();
						} else {
							ret = new JsonResponse(true, "", newLogin).getJson();
						}
					}
				}else {
					ret = new JsonResponse(false, "Your acount has been blocked.",
							"").getJson();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			ret = new JsonResponse(false, "Database error.", "").getJson();
		}
		return ret;
	}

	public String updatePassword(LoginDTO dto) {
		String ret = new JsonResponse(false, "error.", "").getJson();
		if (dto.getUnm() == null || dto.getUp() == null || dto.getMac() == null
				|| dto.getNewpassword() == null
				|| dto.getUnm().equalsIgnoreCase("")
				|| dto.getUp().equalsIgnoreCase("")
				|| dto.getMac().equalsIgnoreCase("")
				|| dto.getNewpassword().equalsIgnoreCase("")) {
			ret = new JsonResponse(false, "Required all field(unm,up,mac,newpassword)", "")
					.getJson();
			return ret;
		}
		LoginDAO dao = new LoginDAO();
		try {
			String uRet = dao.updatePassword(dto);
			if (uRet.equalsIgnoreCase("success")) {
				dto.setUp(dto.getNewpassword());
				ret = loginVarify(dto);
			} else {
				ret = new JsonResponse(false, "Please enter correct password.", "").getJson();
			}
		} catch (Exception e) {
			e.printStackTrace();
			ret = new JsonResponse(false, "Database error.", "").getJson();
		}
		return ret;
	}
	// Web site
	public List<LoginDTO> getAllUser(HttpServletRequest request) throws Exception{
		String employeeId = (String) request.getSession(false)
				.getAttribute("USERNAME");
		LoginDAO dao=new LoginDAO();
		return dao.getAllUser(employeeId);
	}

}
