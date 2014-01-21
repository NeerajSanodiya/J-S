package com.js.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.js.dto.*;

public class LoginDAO {
	public Login loginVarify(Login login) throws Exception {
		Login tlogin = null;
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select * from tbl_login where username ='"
							+ login.getUnm() + "' and password='"
							+ login.getUp() + "'");
			if (rs.next()) {
				login.setUl(rs.getString("userlevel"));
				tlogin = login;
			}
			rs.close();
			st.close();
		} finally {
			con.close();
		}
		return tlogin;
	}

	public String changePassword(ChangePassword changePassword)
			throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			Login login = new Login();
			login.setUnm(changePassword.getUsername());
			login.setUp(changePassword.getDialog_current_password());
			Login tlogin = loginVarify(login);
			if (tlogin != null) {
				st.executeUpdate("update tbl_login set password='"
						+ changePassword.getDialog_new_password()
						+ "' where username = '" + changePassword.getUsername()
						+ "'");
				st.close();
				ret = "Password successfully chnaged";
			} else {
				ret = "Please enter correct password";
			}
		} finally {
			con.close();
		}
		return ret;
	}
}
