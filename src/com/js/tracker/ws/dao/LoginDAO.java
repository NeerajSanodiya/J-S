package com.js.tracker.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.js.tracker.ws.dto.LoginDTO;

public class LoginDAO {
	public LoginDTO LoginVarify(LoginDTO dto) throws Exception {
		LoginDTO tlogin = null;
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			String query = "select * from tbl_tracker_login where username =? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getUnm());
			ps.setString(2, dto.getUp());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tlogin = new LoginDTO();
				tlogin.setUnm(rs.getString("username"));
				tlogin.setMac(rs.getString("mac"));
				tlogin.setUp(rs.getString("password"));
				tlogin.setLevel(rs.getString("userlevel"));
				tlogin.setActive_staatus(rs.getString("active_sataus"));
			}
			rs.close();
			ps.close();
		} finally {
			con.close();
		}
		return tlogin;
	}

	public String updateLogin(LoginDTO dto) throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			String query = "update tbl_tracker_login set mac=? where username =?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getMac());
			ps.setString(2, dto.getUnm());
			int result = ps.executeUpdate();
			if (result == 1) {
				ret = "success";
			}
			ps.close();
		} finally {
			con.close();
		}
		return ret;
	}

	public String updatePassword(LoginDTO dto) throws Exception {
		String ret = "error";
		Connection con = null;
		LoginDTO temp = LoginVarify(dto);
		if (temp != null) {
			try {
				con = new com.js.db.MyConnection().getConnection();
				String query = "update tbl_tracker_login set password=? where username =? and mac=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, dto.getNewpassword());
				ps.setString(2, dto.getUnm());
				ps.setString(3, dto.getMac());
				int result = ps.executeUpdate();
				if (result == 1) {
					ret = "success";
				}
				ps.close();
			} finally {
				con.close();
			}
		}
		return ret;
	}

	public List<LoginDTO> getAllUser(String supId) throws Exception {
		List<LoginDTO> list = new ArrayList<LoginDTO>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			String query = "select * from tbl_tracker_login where userlevel=? and username in (select employee_id from tbl_tracker_supervisor where supervisor_id=?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "Programmer");
			ps.setString(2, supId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LoginDTO tlogin = new LoginDTO();
				tlogin.setUnm(rs.getString("username"));
				tlogin.setMac(rs.getString("mac"));
				tlogin.setLevel(rs.getString("userlevel"));
				tlogin.setActive_staatus(rs.getString("active_sataus"));
				list.add(tlogin);
			}
			rs.close();
			ps.close();
		} finally {
			con.close();
		}
		return list;
	}

	public String getUserActiveStatus(String username, Connection con) {
		String ret = "error";
		try {
			String query = "select * from tbl_tracker_login where username=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ret = rs.getString("active_sataus");
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			
		}
		return ret;
	}
}
