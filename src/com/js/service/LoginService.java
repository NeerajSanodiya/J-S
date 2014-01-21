package com.js.service;

import com.js.dao.LoginDAO;
import com.js.dto.ChangePassword;
import com.js.dto.Login;

public class LoginService {
	public Login loginVarify(Login login) throws Exception{
		return new LoginDAO().loginVarify(login);
	}
	public String changePassword(ChangePassword changePassword) throws Exception{
		return new com.js.dao.LoginDAO().changePassword(changePassword);
	}
}
