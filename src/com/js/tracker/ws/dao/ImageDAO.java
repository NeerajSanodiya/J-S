package com.js.tracker.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.db.MyConnection;
import com.js.tracker.ws.dto.ImageDTO;
import com.js.tracker.ws.dto.TimeLogDTO;

public class ImageDAO {
	public String deleteImages( List<String> ids) throws Exception{
		String ret="error";
		Connection con = null;
		try {
			con = new MyConnection().getConnection();
			String query = "delete from tbl_tracker_image where id=?";
			for(String id:ids){
				try{
					PreparedStatement ps = con.prepareStatement(query);	
					ps.setString(1, id);
					ps.executeUpdate();
					ps.close();
				}catch (Exception e) {}
			}
			ret="success";
		} catch (Exception e) {
			e.printStackTrace();			
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return ret;
	}

	public int saveImageData(ImageDTO dto) throws Exception {
		Connection con = null;
		int ret;
		try {
			con = new MyConnection().getConnection();
			String query = "insert into tbl_tracker_image(username,c_date,c_time,fpath) values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getUsername());
			ps.setString(2, dto.getC_date());
			ps.setString(3, dto.getC_time());
			ps.setString(4, dto.getFpath());
			ret = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			ret = 0;
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return ret;
	}

	public List<ImageDTO> getAllImageDataByDateAndUser(String date,
			String username) throws Exception {
		Connection con = null;
		List<ImageDTO> list = new ArrayList<ImageDTO>();
		try {
			con = new MyConnection().getConnection();
			String query = "select * from tbl_tracker_image where username=? and c_date=? order by c_time";
			System.out.println("query : " + query + " : " + username + " : "
					+ date);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ImageDTO dto = new ImageDTO();
				dto.setC_date(rs.getString("c_date"));
				dto.setId(rs.getString("id"));
				dto.setC_time(rs.getString("c_time"));
				dto.setFpath(rs.getString("fpath"));
				dto.setUsername(rs.getString("username"));
				list.add(dto);
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.println(list.size());
		return list;
	}
}
