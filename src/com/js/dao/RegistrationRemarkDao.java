package com.js.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.js.dto.EnquiryRemark;
import com.js.dto.NewEnquiry;
import com.js.dto.Remark;

public class RegistrationRemarkDao {
	public String saveNewRemark(Remark remark) throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();

			String remarkalert = remark.getRemark_alert();
			remarkalert = remarkalert.replaceAll("/", "-");
			StringTokenizer stringTokenizer = new StringTokenizer(remarkalert,
					"-");
			String yy = stringTokenizer.nextToken();
			String mm = stringTokenizer.nextToken();
			String dd = stringTokenizer.nextToken();
			remarkalert = yy + "-" + mm + "-" + dd;
			remark.setRemark_alert(remarkalert);
			con.setAutoCommit(false);

			Statement st = con.createStatement();
			st.executeUpdate("insert into tbl_registration_remark (registration_id,remark_date,remark,remark_alert,employee_id) values ('"+ remark.getEnquiry_id()+ "','"+ remark.getRemark_date()+ "','"+ remark.getRemark()
					+ "','"
					+ remark.getRemark_alert()
					+ "','"
					+ remark.getEmployee_id() + "')");
			st.close();

			con.commit();
		} finally {
			con.close();
		}
		return ret;
	}

	public List<Remark> getAllRemarkForAnRegistration(String registrationId)
			throws Exception {
		List<Remark> remarkList = new ArrayList<Remark>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st
					.executeQuery("select * from tbl_registration_remark where registration_id ='"
							+ registrationId + "' order by remark_date DESC");
			if (rs.next()) {
				String councillor = "";
				Statement st1 = con.createStatement();
				ResultSet rs1 = st1
						.executeQuery("select * from tbl_employee where employee_id='"
								+ rs.getString("employee_id") + "'");
				if (rs1.next()) {
					councillor = rs1.getString("full_name");
				}
				rs1.close();
				st1.close();
				rs.beforeFirst();
				while (rs.next()) {
					Remark enquiryRemark = new Remark();
					enquiryRemark
							.setEnquiry_id(rs.getString("registration_id"));
					enquiryRemark.setRemark_date(rs.getString("remark_date"));
					enquiryRemark.setRemark(rs.getString("remark"));
					enquiryRemark.setRemark_alert(rs.getString("remark_alert"));
					enquiryRemark.setEmployee_id(rs.getString("employee_id"));
					enquiryRemark.setCouncillor(councillor);
					remarkList.add(enquiryRemark);
				}
				rs.close();
				st.close();
			}
		} finally {
			con.close();
		}

		return remarkList;
	}
}
