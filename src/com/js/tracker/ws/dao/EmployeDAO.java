package com.js.tracker.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.js.tracker.ws.dto.EmployeDTO;
import com.js.tracker.ws.dto.LoginDTO;
import com.js.tracker.ws.dto.TimeLogDTO;
import com.js.tracker.ws.util.TrackerDate;

public class EmployeDAO {
	public String employeActiveStatusChange(LoginDTO dto) throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			String query = "update tbl_tracker_login set active_sataus='"
					+ dto.getActive_staatus() + "' where username='"
					+ dto.getUnm() + "'";
			PreparedStatement ps = con.prepareStatement(query);
			int qi = ps.executeUpdate();
			ps.close();
			if (qi == 1) {
				ret = "success";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			ret = "error";
		} finally {
			if (con != null) {
				con.close();
			}
		}

		return ret;
	}

	public String changeMac(LoginDTO dto) throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			String query = "update tbl_tracker_login set mac='" + dto.getMac()
					+ "' where username='" + dto.getUnm() + "'";
			PreparedStatement ps = con.prepareStatement(query);
			int qi = ps.executeUpdate();
			ps.close();
			if (qi == 1) {
				ret = "success";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			ret = "error";
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return ret;
	}

	public List<EmployeDTO> getSupervisorEmploee(String supId) throws Exception {
		List<EmployeDTO> list = new ArrayList<EmployeDTO>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			String query = "select * from tbl_tracker_employe where id in (select employee_id from tbl_tracker_supervisor where supervisor_id=?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, supId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmployeDTO dto = new EmployeDTO();
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
				dto.setFatherName(rs.getString("fatherName"));
				dto.setId(rs.getString("id"));
				dto.setMno(rs.getString("mno"));
				dto.setName(rs.getString("name"));
				dto.setSalery(rs.getString("salery"));
				dto.setGender(rs.getString("gender"));
				dto.setSupId(supId);

				TrackerDate date = TrackerDate.getInstance();
				dto.setFromDate(date.changeDateFormate_df2_df(rs
						.getString("fromDate")));
				dto.setToDate(date.changeDateFormate_df2_df(rs
						.getString("toDate")));
				dto.setDob(date.changeDateFormate_df2_df(rs.getString("dob")));

				String status = new LoginDAO().getUserActiveStatus(dto.getId(),
						con);
				dto.setActive_statis(status);

				list.add(dto);
			}
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return list;
	}

	public String employeUpdate(EmployeDTO dto) throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();

			String query = "update tbl_tracker_employe set name='"
					+ dto.getName() + "',fatherName='" + dto.getFatherName()
					+ "',email='" + dto.getEmail() + "',address='"
					+ dto.getAddress() + "',mno='" + dto.getMno()
					+ "',salery='" + dto.getSalery() + "',fromDate='"
					+ dto.getFromDate() + "',toDate='" + dto.getToDate()
					+ "',gender='" + dto.getGender() + "',dob='" + dto.getDob()
					+ "' where id='" + dto.getId() + "'";

			PreparedStatement ps = con.prepareStatement(query);

			int qi = ps.executeUpdate();
			ps.close();

			if (qi == 1) {
				ret = "success";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			ret = "error";
		} finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.println("Response : " + ret);
		return ret;
	}

	public String employeRegistration(EmployeDTO dto) throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			con.setAutoCommit(false);
			String id = getEmployeId(con, dto.getSupId());

			String toDate = TrackerDate.getInstance().changeDateFormate_df_df2(
					dto.getToDate());
			String fromDate = TrackerDate.getInstance()
					.changeDateFormate_df_df2(dto.getFromDate());
			String dobDate = TrackerDate.getInstance()
					.changeDateFormate_df_df2(dto.getDob());
			String query = "insert into tbl_tracker_employe(id,name,fatherName,email,address,mno,salery,fromDate,toDate,gender,dob) values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getFatherName());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getAddress());
			ps.setString(6, dto.getMno());
			ps.setString(7, dto.getSalery());
			ps.setString(8, fromDate);
			ps.setString(9, toDate);
			ps.setString(10, dto.getGender());
			ps.setString(11, dobDate);
			int qi = ps.executeUpdate();
			ps.close();

			query = "insert into tbl_tracker_supervisor(supervisor_id,employee_id) values (?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, dto.getSupId());
			ps.setString(2, id);
			ps.executeUpdate();
			ps.close();

			query = "insert into tbl_tracker_login(username,password,userlevel,mac) values (?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, "abc");
			ps.setString(3, "Programmer");
			ps.setString(4, "");
			ps.executeUpdate();
			ps.close();

			con.commit();
			if (qi == 1) {
				ret = "success";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			ret = "error";
		} finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.println("Response : " + ret);
		return ret;
	}

	private String getEmployeId(Connection con, String supId) throws Exception {
		long employe_id_long = 0;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from tbl_tracker_counter");
		if (rs.next()) {
			employe_id_long = rs.getLong("employe_id");
			System.out.println(employe_id_long);
		}
		rs.close();
		st.close();
		String base = supId.substring(0, 12);

		String counter = "0000";
		String enq_id = "" + employe_id_long;
		counter = counter.substring(0, (counter.length() - enq_id.length()));
		counter = counter + enq_id;

		Date date = new Date();

		base = base + (date.getYear() + 1900 - 2000) + "EMP";
		String enquiry_id = base + counter;

		employe_id_long++;
		st = con.createStatement();
		String query = "update tbl_tracker_counter set employe_id="
				+ employe_id_long + " where myid=1";
		int i = st.executeUpdate(query);
		st.close();

		return enquiry_id;
	}

	public EmployeDTO getEmploeeById(String empId) throws Exception {
		EmployeDTO dto = null;
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			String query = "select * from tbl_tracker_employe where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, empId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new EmployeDTO();
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
				dto.setFatherName(rs.getString("fatherName"));
				dto.setFromDate(rs.getString("fromDate"));
				dto.setId(rs.getString("id"));
				dto.setMno(rs.getString("mno"));
				dto.setName(rs.getString("name"));
				dto.setSalery(rs.getString("salery"));
				dto.setGender(rs.getString("gender"));
				dto.setToDate(rs.getString("toDate"));
				dto.setDob(rs.getString("dob"));

				PreparedStatement ps1 = con
						.prepareStatement("select name from tbl_tracker_supervisor s,tbl_tracker_employe e where s.supervisor_id=e.id and s.employee_id='"
								+ dto.getId() + "'");
				ResultSet rs1 = ps1.executeQuery();
				if (rs1.next()) {
					dto.setSupId(rs1.getString("name"));
				}
				ps1.close();
				rs1.close();

			}
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return dto;
	}
}
