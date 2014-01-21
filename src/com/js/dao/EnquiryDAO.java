package com.js.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.js.dto.AcademicProjectDTO;
import com.js.dto.AcademicProjectRemark;
import com.js.dto.EnquiryRemark;
import com.js.dto.NewAcademicProjectEnquiryDTO;
import com.js.dto.NewEnquiry;
import com.js.dto.NewTrainingEnquiryDTO;
import com.js.dto.NewVisitorEnquiryDTO;
import com.js.dto.Remark;
import com.js.dto.SearchEnquiry;

public class EnquiryDAO {
	public String saveNewVistorEnquiry(NewVisitorEnquiryDTO newVisitorEnquiryDTO)
			throws Exception {
		String ret = "error";

		long enquiry_id_long = 0;
		long reference_id_long = 0;
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();

			// get next enquiry_id
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from tbl_counter");
			if (rs.next()) {
				enquiry_id_long = rs.getLong("enquiry_id");
				reference_id_long = rs.getLong("reference_id");
			}
			rs.close();
			st.close();

			newVisitorEnquiryDTO.setVisitor_enquiry_enquiry_id(""
					+ enquiry_id_long);

			String base = newVisitorEnquiryDTO.getEmployee_id()
					.substring(0, 12);
			Date date = new Date();
			String tdate = "" + date.getDate();
			String tmonth = "" + (1 + date.getMonth());
			String tyear = "" + (1900 + date.getYear());

			String fdate = "00";
			String fmonth = "00";
			String fyear = "0000";

			fdate = fdate.substring(0, (fdate.length() - tdate.length()));
			fdate = fdate + tdate;

			fmonth = fmonth.substring(0, (fmonth.length() - tmonth.length()));
			fmonth = fmonth + tmonth;

			fyear = fyear.substring(0, (fyear.length() - tyear.length()));
			fyear = fyear + tyear;

			String counter = "0000";
			String enq_id = "" + enquiry_id_long;
			counter = counter
					.substring(0, (counter.length() - enq_id.length()));
			counter = counter + enq_id;

			base = base + "VIS" + fdate + fmonth + fyear;
			String enquiry_id = base + counter;

			newVisitorEnquiryDTO.setVisitor_enquiry_enquiry_id(enquiry_id);
			Date cdate = new Date();
			String c_time = (cdate.getHours()) + ":" + (cdate.getMinutes())
					+ ":" + (cdate.getSeconds());
			newVisitorEnquiryDTO.setVisitor_enquiry_visiting_time_start(c_time);

			String c_date = (1900 + cdate.getYear()) + "-"
					+ (1 + cdate.getMonth()) + "-" + cdate.getDate();
			newVisitorEnquiryDTO.setVisitor_enquiry_date(c_date);

			con.setAutoCommit(false);
			newVisitorEnquiryDTO.setVisitor_enquiry_visit_time_end("00:00:00");

			// save new enquiry
			st = con.createStatement();
			st.executeUpdate("insert into tbl_visitor (visitor_id,full_name,purpose_to_visit,date_of_visit,meet_with,visiting_time_start,visit_time_end,note,employee_id,address,status,reference_id) values ('"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_enquiry_id()
					+ "','"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_fullname()
					+ "','"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_purpose()
					+ "','"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_date()
					+ "','"
					+ newVisitorEnquiryDTO
							.getVisitor_enquiry_appointment_with()
					+ "','"
					+ newVisitorEnquiryDTO
							.getVisitor_enquiry_visiting_time_start()
					+ "','"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_visit_time_end()
					+ "','"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_note()
					+ "','"
					+ newVisitorEnquiryDTO.getEmployee_id()
					+ "','"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_address()
					+ "','"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_enquiry_status()
					+ "','"
					+ reference_id_long
					+ "')");
			st.close();

			// save contact no
			st = con.createStatement();
			st.executeUpdate("insert into tbl_contact (my_id,contact_no) values ('"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_enquiry_id()
					+ "','"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_contact_no()
					+ "')");
			st.close();

			// save email id
			st = con.createStatement();
			st.executeUpdate("insert into tbl_email (my_id,email_id) values ('"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_enquiry_id()
					+ "','"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_email_id() + "')");
			st.close();

			// save reference
			st = con.createStatement();
			st.executeUpdate("insert into tbl_reference (reference_id,full_name,contact_no) values ('"
					+ reference_id_long
					+ "','"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_reference_name()
					+ "','"
					+ newVisitorEnquiryDTO
							.getVisitor_enquiry_reference_contact_no() + "')");
			st.close();

			st = con.createStatement();
			st.executeUpdate("insert into relation_with_reference (myid,note,reference_id) values ('"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_enquiry_id()
					+ "','"
					+ newVisitorEnquiryDTO.getVisitor_enquiry_reference_note()
					+ "','" + reference_id_long + "')");
			st.close();
			
			enquiry_id_long++;
			reference_id_long++;
			st = con.createStatement();

			st.executeUpdate("update tbl_counter set enquiry_id="
					+ enquiry_id_long + ", reference_id =" + reference_id_long
					+ " where myid=1");
			st.close();

			con.commit();

		} finally {
			con.close();
		}

		return ret;
	}

	public String saveNewTrainingEnquiry(
			NewTrainingEnquiryDTO newTrainingEnquiryDTO) throws Exception {
		String ret = "error";

		long enquiry_id_long = 0;
		long reference_id_long = 0;
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();

			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select * from tbl_enquiry where full_name='"
							+ newTrainingEnquiryDTO
									.getTraining_enquiry_fullname()
							+ "' and father_name='"
							+ newTrainingEnquiryDTO
									.getTraining_enquiry_father_name()
							+ "' and qualification='"
							+ newTrainingEnquiryDTO
									.getTraining_enquiry_qualification()
							+ "' and college='"
							+ newTrainingEnquiryDTO
									.getTraining_enquiry_college()
							+ "' and semester='"
							+ newTrainingEnquiryDTO
									.getTraining_enquiry_semester()
							+ "' and purpose='"
							+ newTrainingEnquiryDTO.getEnquiry_purpose() + "'");
			if (rs.next()) {
				return "Record already saved";
			}
			rs.close();
			st.close();

			// get next enquiry_id
			st = con.createStatement();
			rs = st.executeQuery("select * from tbl_counter");
			if (rs.next()) {
				enquiry_id_long = rs.getLong("enquiry_id");
				reference_id_long = rs.getLong("reference_id");
			}
			rs.close();
			st.close();

			newTrainingEnquiryDTO.setTraining_enquiry_enquiry_id(""
					+ enquiry_id_long);
			

			if (newTrainingEnquiryDTO.getTraining_enquiry_qualification()
					.equalsIgnoreCase("other")) {
				newTrainingEnquiryDTO
						.setTraining_enquiry_qualification(newTrainingEnquiryDTO
								.getTraining_enquiry_qualification_other());
			}
			if (newTrainingEnquiryDTO.getTraining_enquiry_college()
					.equalsIgnoreCase("other")) {
				newTrainingEnquiryDTO
						.setTraining_enquiry_college(newTrainingEnquiryDTO
								.getTraining_enquiry_college_other());
			}

			String base = newTrainingEnquiryDTO.getEmployee_id().substring(0,
					12);
			Date date = new Date();
			String tdate = "" + date.getDate();
			String tmonth = "" + (1 + date.getMonth());
			String tyear = "" + (1900 + date.getYear());

			String fdate = "00";
			String fmonth = "00";
			String fyear = "0000";

			fdate = fdate.substring(0, (fdate.length() - tdate.length()));
			fdate = fdate + tdate;

			fmonth = fmonth.substring(0, (fmonth.length() - tmonth.length()));
			fmonth = fmonth + tmonth;

			fyear = fyear.substring(0, (fyear.length() - tyear.length()));
			fyear = fyear + tyear;

			String counter = "0000";
			String enq_id = "" + enquiry_id_long;
			counter = counter
					.substring(0, (counter.length() - enq_id.length()));
			counter = counter + enq_id;

			base = base + "ENQ" + fdate + fmonth + fyear;
			String enquiry_id = base + counter;

			newTrainingEnquiryDTO.setTraining_enquiry_enquiry_id(enquiry_id);
			Date cdate = new Date();

			String c_date = (1900 + cdate.getYear()) + "-"
					+ (1 + cdate.getMonth()) + "-" + cdate.getDate();
			newTrainingEnquiryDTO.setTraining_enquiry_date(c_date);
			String c_time = (cdate.getHours()) + ":" + (cdate.getMinutes())
					+ ":" + (cdate.getSeconds());
			newTrainingEnquiryDTO.setTraining_enquiry_entry_time(c_time);

			con.setAutoCommit(false);

			// save new enquiry
			st = con.createStatement();
			st.executeUpdate("insert into tbl_enquiry (enquiry_id,full_name,father_name,qualification,college,semester,preferred_time_start,joining_date,reference_id,employee_id,enquiry_status,preferred_time_end,enquiry_date,purpose,entry_time) values ('"
					+ newTrainingEnquiryDTO.getTraining_enquiry_enquiry_id()
					+ "','"
					+ newTrainingEnquiryDTO.getTraining_enquiry_fullname()
					+ "','"
					+ newTrainingEnquiryDTO.getTraining_enquiry_father_name()
					+ "','"
					+ newTrainingEnquiryDTO.getTraining_enquiry_qualification()
					+ "','"
					+ newTrainingEnquiryDTO.getTraining_enquiry_college()
					+ "','"
					+ newTrainingEnquiryDTO.getTraining_enquiry_semester()
					+ "','"
					+ newTrainingEnquiryDTO
							.getTraining_enquiry_preferredtime_start()
					+ "','"
					+ newTrainingEnquiryDTO.getTraining_enquiry_joining_date()
					+ "','"
					+ reference_id_long
					+ "','"
					+ newTrainingEnquiryDTO.getEmployee_id()
					+ "','"
					+ newTrainingEnquiryDTO
							.getTraining_enquiry_enquiry_status()
					+ "','"
					+ newTrainingEnquiryDTO
							.getTraining_enquiry_preferredtime_start()
					+ "','"
					+ newTrainingEnquiryDTO.getTraining_enquiry_date()
					+ "','"
					+ newTrainingEnquiryDTO.getEnquiry_purpose()
					+ "','"
					+ newTrainingEnquiryDTO.getTraining_enquiry_entry_time()
					+ "')");
			st.close();

			// save contact no
			st = con.createStatement();
			st.executeUpdate("insert into tbl_contact (my_id,contact_no) values ('"
					+ newTrainingEnquiryDTO.getTraining_enquiry_enquiry_id()
					+ "','"
					+ newTrainingEnquiryDTO.getTraining_enquiry_contact_no()
					+ "')");
			st.close();

			// save email id
			st = con.createStatement();
			st.executeUpdate("insert into tbl_email (my_id,email_id) values ('"
					+ newTrainingEnquiryDTO.getTraining_enquiry_enquiry_id()
					+ "','"
					+ newTrainingEnquiryDTO.getTraining_enquiry_email_id()
					+ "')");
			st.close();
			// save course id
			String[] couse = newTrainingEnquiryDTO.getTraining_enquiry_course();
			for (int i = 0; i < couse.length; i++) {
				st = con.createStatement();
				st.executeUpdate("insert into tbl_intrested_course (enquiry_id,course_id) values ('"
						+ newTrainingEnquiryDTO
								.getTraining_enquiry_enquiry_id()
						+ "','"
						+ couse[i] + "')");
				st.close();

			}

			// save reference
			st = con.createStatement();
			st.executeUpdate("insert into tbl_reference (reference_id,full_name,contact_no) values ('"
					+ reference_id_long
					+ "','"
					+ newTrainingEnquiryDTO
							.getTraining_enquiry_reference_name()
					+ "','"
					+ newTrainingEnquiryDTO
							.getTraining_enquiry_reference_contact_no() + "')");
			st.close();

			st = con.createStatement();
			st.executeUpdate("insert into relation_with_reference (myid,note,reference_id) values ('"
					+ newTrainingEnquiryDTO.getTraining_enquiry_enquiry_id()
					+ "','"
					+ newTrainingEnquiryDTO
							.getTraining_enquiry_reference_note()
					+ "','"
					+ reference_id_long + "')");
			st.close();
			// chack purpose
			// insert new enquiry_id
			enquiry_id_long++;
			reference_id_long++;
			st = con.createStatement();

			st.executeUpdate("update tbl_counter set enquiry_id="
					+ enquiry_id_long + ", reference_id =" + reference_id_long
					+ " where myid=1");
			st.close();

			con.commit();
			ret = "Enquiry successfully saved";
		} catch (Exception e) {
			e.printStackTrace();
			ret = "server side error";
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				ret = "server side connection error";
			}
		}

		return ret;
	}

	public String saveNewAcademicProjectEnquiry(
			NewAcademicProjectEnquiryDTO newAcademicProjectEnquiryDTO)
			throws Exception {
		long enquiry_id_long = 0;
		long reference_id_long = 0;
		long acp_id_long = 0;

		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();

			// get next enquiry_id
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from tbl_counter");
			if (rs.next()) {
				enquiry_id_long = rs.getLong("enquiry_id");
				reference_id_long = rs.getLong("reference_id");
				acp_id_long = rs.getLong("acp_id");
			}
			rs.close();
			st.close();

			if (newAcademicProjectEnquiryDTO
					.getAcademic_project_enquiry_qualification()
					.equalsIgnoreCase("other")) {
				newAcademicProjectEnquiryDTO
						.setAcademic_project_enquiry_qualification(newAcademicProjectEnquiryDTO
								.getAcademic_project_enquiry_qualification_other());
			}
			if (newAcademicProjectEnquiryDTO
					.getAcademic_project_enquiry_college().equalsIgnoreCase(
							"other")) {
				newAcademicProjectEnquiryDTO
						.setAcademic_project_enquiry_college(newAcademicProjectEnquiryDTO
								.getAcademic_project_enquiry_college_other());
			}

			newAcademicProjectEnquiryDTO
					.setAcademic_project_enquiry_enquiry_id(""
							+ enquiry_id_long);

			String base = newAcademicProjectEnquiryDTO.getEmployee_id()
					.substring(0, 12);
			Date date = new Date();
			String tdate = "" + date.getDate();
			String tmonth = "" + (1 + date.getMonth());
			String tyear = "" + (1900 + date.getYear());

			String fdate = "00";
			String fmonth = "00";
			String fyear = "0000";

			fdate = fdate.substring(0, (fdate.length() - tdate.length()));
			fdate = fdate + tdate;

			fmonth = fmonth.substring(0, (fmonth.length() - tmonth.length()));
			fmonth = fmonth + tmonth;

			fyear = fyear.substring(0, (fyear.length() - tyear.length()));
			fyear = fyear + tyear;

			String counter = "0000";
			String enq_id = "" + enquiry_id_long;
			counter = counter
					.substring(0, (counter.length() - enq_id.length()));
			counter = counter + enq_id;

			base = base + "ENQ" + fdate + fmonth + fyear;
			String enquiry_id = base + counter;

			newAcademicProjectEnquiryDTO
					.setAcademic_project_enquiry_enquiry_id(enquiry_id);
			Date cdate = new Date();

			String c_date = (1900 + cdate.getYear()) + "-"
					+ (1 + cdate.getMonth()) + "-" + cdate.getDate();
			newAcademicProjectEnquiryDTO
					.setAcademic_project_enquiry_date(c_date);
			String c_time = (cdate.getHours()) + ":" + (cdate.getMinutes())
					+ ":" + (cdate.getSeconds());
			newAcademicProjectEnquiryDTO
					.setAcademic_project_enquiry_entry_time(c_time);

			// Acadmic Project Id

			con.setAutoCommit(false);

			// save new enquiry
			st = con.createStatement();
			st.executeUpdate("insert into tbl_enquiry (enquiry_id,full_name,father_name,qualification,college,semester,preferred_time_start,joining_date,reference_id,employee_id,enquiry_status,preferred_time_end,enquiry_date,purpose,entry_time) values ('"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_enquiry_id()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_fullname()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_father_name()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_qualification()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_college()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_semester()
					+ "','"
					+ "00:00:00"
					+ "','"
					+ "0000-00-00"
					+ "','"
					+ reference_id_long
					+ "','"
					+ newAcademicProjectEnquiryDTO.getEmployee_id()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_enquiry_status()
					+ "','"
					+ "00:00:00"
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_date()
					+ "','"
					+ newAcademicProjectEnquiryDTO.getEnquiry_purpose()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_entry_time() + "')");
			st.close();

			// save contact no
			st = con.createStatement();
			st.executeUpdate("insert into tbl_contact (my_id,contact_no) values ('"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_enquiry_id()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_contact_no() + "')");
			st.close();

			// save email id
			st = con.createStatement();
			st.executeUpdate("insert into tbl_email (my_id,email_id) values ('"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_enquiry_id()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_email_id() + "')");
			st.close();

			// save reference
			st = con.createStatement();
			st.executeUpdate("insert into tbl_reference (reference_id,full_name,contact_no) values ('"
					+ reference_id_long
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_reference_name()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_reference_contact_no()
					+ "')");
			st.close();

			// save new academic project Enquiry

			newAcademicProjectEnquiryDTO
					.setAcademic_project_enquiry_delivery_date(getDateFormate(newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_delivery_date()));

			String base1 = newAcademicProjectEnquiryDTO.getEmployee_id()
					.substring(0, 12);
			Date date1 = new Date();
			String tdate1 = "" + date1.getDate();
			String tmonth1 = "" + (1 + date1.getMonth());
			String tyear1 = "" + (1900 + date1.getYear());

			String fdate1 = "00";
			String fmonth1 = "00";
			String fyear1 = "0000";

			fdate1 = fdate1.substring(0, (fdate1.length() - tdate1.length()));
			fdate1 = fdate1 + tdate1;

			fmonth1 = fmonth1.substring(0,
					(fmonth1.length() - tmonth1.length()));
			fmonth1 = fmonth1 + tmonth1;

			fyear1 = fyear1.substring(0, (fyear1.length() - tyear1.length()));
			fyear1 = fyear1 + tyear1;

			String counter1 = "0000";
			String enq_id1 = "" + acp_id_long;
			counter1 = counter1.substring(0,
					(counter1.length() - enq_id1.length()));
			counter1 = counter1 + enq_id1;

			base1 = base1 + "ACP" + fdate1 + fmonth1 + fyear1;
			String project_id = base1 + counter1;

			st = con.createStatement();
			st.executeUpdate("insert into tbl_academic_project (project_id,project_name,enquiry_id,delivery_date,project_description) values ('"
					+ project_id
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_project_name()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_enquiry_id()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_delivery_date()
					+ "','"
					+ newAcademicProjectEnquiryDTO
							.getAcademic_project_enquiry_description() + "')");
			st.close();
			// ************************************************************

			// insert new enquiry_id
			enquiry_id_long++;
			reference_id_long++;
			acp_id_long++;
			st = con.createStatement();

			st.executeUpdate("update tbl_counter set enquiry_id="
					+ enquiry_id_long + ", reference_id =" + reference_id_long
					+ ", acp_id='" + acp_id_long + "' where myid=1");
			st.close();

			con.commit();

			ret = "success";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return ret;
	}

	String getDateFormate(String date) {
		String newFormateDate = date;
		newFormateDate = newFormateDate.replaceAll("/", "-");
		StringTokenizer stringTokenizer = new StringTokenizer(newFormateDate,
				"-");
		String mm = stringTokenizer.nextToken();
		String dd = stringTokenizer.nextToken();
		String yy = stringTokenizer.nextToken();
		newFormateDate = yy + "-" + mm + "-" + dd;
		return newFormateDate;
	}

	public String saveNewEnquiry(NewEnquiry newEnquiry) throws Exception {
		long enquiry_id_long = 0;
		long reference_id_long = 0;
		long acp_id_long = 0;

		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();

			// get next enquiry_id
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from tbl_counter");
			if (rs.next()) {
				enquiry_id_long = rs.getLong("enquiry_id");
				reference_id_long = rs.getLong("reference_id");
				acp_id_long = rs.getLong("acp_id");
			}
			rs.close();
			st.close();

			if (newEnquiry.getQualification().equalsIgnoreCase("other")) {
				newEnquiry
						.setQualification(newEnquiry.getQualification_other());
			}
			if (newEnquiry.getCollege().equalsIgnoreCase("other")) {
				newEnquiry.setCollege(newEnquiry.getCollege_other());
			}
			if (newEnquiry.getPurpose().equalsIgnoreCase("Training")) {
				newEnquiry.setEnquiry_id("" + enquiry_id_long);
				String joining_date = newEnquiry.getJoining_date();
				joining_date = joining_date.replaceAll("/", "-");
				StringTokenizer stringTokenizer = new StringTokenizer(
						joining_date, "-");
				String mm = stringTokenizer.nextToken();
				String dd = stringTokenizer.nextToken();
				String yy = stringTokenizer.nextToken();
				joining_date = yy + "-" + mm + "-" + dd;
				newEnquiry.setJoining_date(joining_date);
			}

			String base = newEnquiry.getEmployee_id().substring(0, 12);
			Date date = new Date();
			String tdate = "" + date.getDate();
			String tmonth = "" + (1 + date.getMonth());
			String tyear = "" + (1900 + date.getYear());

			String fdate = "00";
			String fmonth = "00";
			String fyear = "0000";

			fdate = fdate.substring(0, (fdate.length() - tdate.length()));
			fdate = fdate + tdate;

			fmonth = fmonth.substring(0, (fmonth.length() - tmonth.length()));
			fmonth = fmonth + tmonth;

			fyear = fyear.substring(0, (fyear.length() - tyear.length()));
			fyear = fyear + tyear;

			String counter = "0000";
			String enq_id = "" + enquiry_id_long;
			counter = counter
					.substring(0, (counter.length() - enq_id.length()));
			counter = counter + enq_id;

			base = base + "ENQ" + fdate + fmonth + fyear;
			String enquiry_id = base + counter;

			newEnquiry.setEnquiry_id(enquiry_id);

			// Acadmic Project Id

			con.setAutoCommit(false);
			if (newEnquiry.getPurpose().equalsIgnoreCase("Academic Project")) {
				newEnquiry.setPreferredtime_end("00:00:00");
				newEnquiry.setPreferredtime_start("00:00:00");
				newEnquiry.setJoining_date("0000-00-00");
			}
			// save new enquiry
			st = con.createStatement();

			st.executeUpdate("insert into tbl_enquiry (enquiry_id,full_name,father_name,qualification,college,semester,preferred_time_start,joining_date,reference_id,employee_id,enquiry_status,preferred_time_end,enquiry_date,purpose) values ('"
					+ newEnquiry.getEnquiry_id()
					+ "','"
					+ newEnquiry.getFullname()
					+ "','"
					+ newEnquiry.getFather_name()
					+ "','"
					+ newEnquiry.getQualification()
					+ "','"
					+ newEnquiry.getCollege()
					+ "','"
					+ newEnquiry.getSemester()
					+ "','"
					+ newEnquiry.getPreferredtime_start()
					+ "','"
					+ newEnquiry.getJoining_date()
					+ "','"
					+ reference_id_long
					+ "','"
					+ newEnquiry.getEmployee_id()
					+ "','"
					+ newEnquiry.getEnquiry_status()
					+ "','"
					+ newEnquiry.getPreferredtime_end()
					+ "','"
					+ newEnquiry.getEnquiry_date()
					+ "','"
					+ newEnquiry.getPurpose() + "')");
			st.close();

			// save contact no
			st = con.createStatement();
			st.executeUpdate("insert into tbl_contact (my_id,contact_no) values ('"
					+ newEnquiry.getEnquiry_id()
					+ "','"
					+ newEnquiry.getContact_no() + "')");
			st.close();

			// save email id
			st = con.createStatement();
			st.executeUpdate("insert into tbl_email (my_id,email_id) values ('"
					+ newEnquiry.getEnquiry_id() + "','"
					+ newEnquiry.getEmail_id() + "')");
			st.close();

			// save reference
			st = con.createStatement();
			st.executeUpdate("insert into tbl_reference (reference_id,full_name,some_note,contact_no) values ('"
					+ reference_id_long
					+ "','"
					+ newEnquiry.getReference_name()
					+ "','"
					+ newEnquiry.getReference_note()
					+ "','"
					+ newEnquiry.getReference_contact_no() + "')");
			st.close();

			// chack purpose
			if (newEnquiry.getPurpose().equals("Training")) {
				// save interested course
				String cources[] = newEnquiry.getCourse();
				for (String c : cources) {
					st = con.createStatement();
					st.executeUpdate("insert into tbl_intrested_course (enquiry_id,course_id) values ('"
							+ newEnquiry.getEnquiry_id() + "','" + c + "')");
					st.close();
				}
			} else if (newEnquiry.getPurpose().equals("Academic Project")) {
				// save new academic project Enquiry

				String deliverydate = newEnquiry.getDelivery_date();
				deliverydate = deliverydate.replaceAll("/", "-");
				StringTokenizer stringTokenizer = new StringTokenizer(
						deliverydate, "-");
				String yy = stringTokenizer.nextToken();
				String mm = stringTokenizer.nextToken();
				String dd = stringTokenizer.nextToken();
				deliverydate = yy + "-" + mm + "-" + dd;
				newEnquiry.setDelivery_date(deliverydate);

				String base1 = newEnquiry.getEmployee_id().substring(0, 12);
				Date date1 = new Date();
				String tdate1 = "" + date1.getDate();
				String tmonth1 = "" + (1 + date1.getMonth());
				String tyear1 = "" + (1900 + date1.getYear());

				String fdate1 = "00";
				String fmonth1 = "00";
				String fyear1 = "0000";

				fdate1 = fdate1.substring(0,
						(fdate1.length() - tdate1.length()));
				fdate1 = fdate1 + tdate1;

				fmonth1 = fmonth1.substring(0,
						(fmonth1.length() - tmonth1.length()));
				fmonth1 = fmonth1 + tmonth1;

				fyear1 = fyear1.substring(0,
						(fyear1.length() - tyear1.length()));
				fyear1 = fyear1 + tyear1;

				String counter1 = "0000";
				String enq_id1 = "" + acp_id_long;
				counter1 = counter1.substring(0,
						(counter1.length() - enq_id1.length()));
				counter1 = counter1 + enq_id1;

				base1 = base1 + "ACP" + fdate1 + fmonth1 + fyear1;
				String project_id = base1 + counter1;

				st = con.createStatement();
				st.executeUpdate("insert into tbl_academic_project (project_id,project_name,enquiry_id,delivery_date,project_description) values ('"
						+ project_id
						+ "','"
						+ newEnquiry.getProject_name()
						+ "','"
						+ newEnquiry.getEnquiry_id()
						+ "','"
						+ newEnquiry.getDelivery_date()
						+ "','"
						+ newEnquiry.getProject_description() + "')");
				st.close();
			}

			// insert new enquiry_id
			enquiry_id_long++;
			reference_id_long++;
			acp_id_long++;
			st = con.createStatement();

			st.executeUpdate("update tbl_counter set enquiry_id="
					+ enquiry_id_long + ", reference_id =" + reference_id_long
					+ ", acp_id='" + acp_id_long + "' where myid=1");
			st.close();

			con.commit();

			ret = "success";
		} finally {
			con.close();
		}
		return ret;
	}

	/*
	 * public String updateEnquiry(NewEnquiry newEnquiry) throws Exception{ //
	 * String ret="error"; Connection con=null; try{ con=new
	 * com.js.db.MyConnection().getConnection();
	 * 
	 * Statement st=con.createStatement();
	 * 
	 * if(newEnquiry.getQualification().equalsIgnoreCase("other")){
	 * newEnquiry.setQualification(newEnquiry.getQualification_other()); }
	 * if(newEnquiry.getCollege().equalsIgnoreCase("other")){
	 * newEnquiry.setCollege(newEnquiry.getCollege_other()); }
	 * 
	 * con.setAutoCommit(false);
	 * 
	 * String c_no=newEnquiry.getContact_no(); String
	 * e_id=newEnquiry.getEmail_id(); int cno_i=c_no.lastIndexOf(","); int
	 * cmail_i=e_id.lastIndexOf(","); if(cno_i!=-1){
	 * newEnquiry.setContact_no(newEnquiry.getContact_no().substring(0,cno_i));
	 * } if(cmail_i!=-1){
	 * newEnquiry.setEmail_id(newEnquiry.getEmail_id().substring(0,cmail_i)); }
	 * //save new enquiry st=con.createStatement();
	 * st.executeUpdate("update tbl_enquiry set full_name ='"
	 * +newEnquiry.getFullname
	 * ()+"', father_name='"+newEnquiry.getFather_name()+"', qualification='"
	 * +newEnquiry
	 * .getQualification()+"', college='"+newEnquiry.getCollege()+"', semester='"
	 * +newEnquiry.getSemester()+"', preferred_time_start='"+newEnquiry.
	 * getPreferredtime_start
	 * ()+"', enquiry_status='"+newEnquiry.getEnquiry_status
	 * ()+"' , preferred_time_end='"
	 * +newEnquiry.getPreferredtime_end()+"' where enquiry_id='"
	 * +newEnquiry.getEnquiry_id()+"'"); st.close();
	 * 
	 * //save contact no
	 * 
	 * Statement tst=con.createStatement();
	 * tst.executeUpdate("delete from tbl_contact where my_id='"
	 * +newEnquiry.getEnquiry_id()+"'"); tst.close();
	 * 
	 * st=con.createStatement();
	 * st.executeUpdate("insert into tbl_contact (my_id,contact_no) values ('"
	 * +newEnquiry.getEnquiry_id()+"','"+newEnquiry.getContact_no()+"')");
	 * st.close();
	 * 
	 * //save email id tst=con.createStatement();
	 * tst.executeUpdate("delete from tbl_email where my_id='"
	 * +newEnquiry.getEnquiry_id()+"'"); tst.close();
	 * 
	 * st=con.createStatement();
	 * st.executeUpdate("insert into tbl_email (my_id,email_id) values ('"
	 * +newEnquiry.getEnquiry_id()+"','"+newEnquiry.getEmail_id()+"')");
	 * st.close();
	 * 
	 * //save reference
	 * 
	 * 
	 * st=con.createStatement();
	 * st.executeUpdate("update tbl_reference set full_name='"
	 * +newEnquiry.getReference_name
	 * ()+"', some_note='"+newEnquiry.getReference_note
	 * ()+"' , contact_no='"+newEnquiry
	 * .getReference_contact_no()+"' where reference_id = '"
	 * +newEnquiry.getReferenceId()+"'"); st.close();
	 * 
	 * //save interested course tst=con.createStatement();
	 * tst.executeUpdate("delete from tbl_intrested_course where enquiry_id='"
	 * +newEnquiry.getEnquiry_id()+"'"); tst.close();
	 * 
	 * String cources[]=newEnquiry.getCourse(); for(String c:cources){
	 * st=con.createStatement(); st.executeUpdate(
	 * "insert into tbl_intrested_course (enquiry_id,course_id) values ('"
	 * +newEnquiry.getEnquiry_id()+"','"+c+"')"); st.close(); }
	 * 
	 * con.commit();
	 * 
	 * ret="success"; }finally{ con.close(); } return ret; }
	 */
	public String updateTrainingEnquiry(NewTrainingEnquiryDTO newEnquiry)
			throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();

			Statement st = con.createStatement();

			if (newEnquiry.getTraining_enquiry_qualification()
					.equalsIgnoreCase("other")) {
				newEnquiry.setTraining_enquiry_qualification(newEnquiry
						.getTraining_enquiry_qualification_other());
			}
			if (newEnquiry.getTraining_enquiry_college().equalsIgnoreCase(
					"other")) {
				newEnquiry.setTraining_enquiry_college(newEnquiry
						.getTraining_enquiry_college_other());
			}

			con.setAutoCommit(false);

			String c_no = newEnquiry.getTraining_enquiry_contact_no();
			String e_id = newEnquiry.getTraining_enquiry_email_id();
			int cno_i = c_no.lastIndexOf(",");
			int cmail_i = e_id.lastIndexOf(",");
			if (cno_i != -1) {
				newEnquiry.setTraining_enquiry_contact_no(newEnquiry
						.getTraining_enquiry_contact_no().substring(0, cno_i));
			}
			if (cmail_i != -1) {
				newEnquiry.setTraining_enquiry_email_id(newEnquiry
						.getTraining_enquiry_email_id().substring(0, cmail_i));
			}
			// save new enquiry
			st = con.createStatement();
			st.executeUpdate("update tbl_enquiry set full_name ='"
					+ newEnquiry.getTraining_enquiry_fullname()
					+ "', father_name='"
					+ newEnquiry.getTraining_enquiry_father_name()
					+ "', qualification='"
					+ newEnquiry.getTraining_enquiry_qualification()
					+ "', college='" + newEnquiry.getTraining_enquiry_college()
					+ "', semester='"
					+ newEnquiry.getTraining_enquiry_semester()
					+ "', preferred_time_start='"
					+ newEnquiry.getTraining_enquiry_preferredtime_start()
					+ "', enquiry_status='"
					+ newEnquiry.getTraining_enquiry_enquiry_status()
					+ "' , preferred_time_end='"
					+ newEnquiry.getTraining_enquiry_preferredtime_end()
					+ "' where enquiry_id='"
					+ newEnquiry.getTraining_enquiry_enquiry_id() + "'");
			st.close();

			// save contact no

			Statement tst = con.createStatement();
			tst.executeUpdate("delete from tbl_contact where my_id='"
					+ newEnquiry.getTraining_enquiry_enquiry_id() + "'");
			tst.close();

			st = con.createStatement();
			st.executeUpdate("insert into tbl_contact (my_id,contact_no) values ('"
					+ newEnquiry.getTraining_enquiry_enquiry_id()
					+ "','"
					+ newEnquiry.getTraining_enquiry_contact_no() + "')");
			st.close();

			// save email id
			tst = con.createStatement();
			tst.executeUpdate("delete from tbl_email where my_id='"
					+ newEnquiry.getTraining_enquiry_enquiry_id() + "'");
			tst.close();

			st = con.createStatement();
			st.executeUpdate("insert into tbl_email (my_id,email_id) values ('"
					+ newEnquiry.getTraining_enquiry_enquiry_id() + "','"
					+ newEnquiry.getTraining_enquiry_email_id() + "')");
			st.close();

			// save reference note
			tst = con.createStatement();
			tst.executeUpdate("delete from relation_with_reference where myid='"
					+ newEnquiry.getTraining_enquiry_enquiry_id()
					+ "' and reference_id='"
					+ newEnquiry.getTraining_enquiry_referenceId() + "'");
			tst.close();

			st = con.createStatement();
			st.executeUpdate("insert into relation_with_reference (myid,note,reference_id) values ('"
					+ newEnquiry.getTraining_enquiry_enquiry_id()
					+ "','"
					+ newEnquiry.getTraining_enquiry_reference_note()
					+ "','"
					+ newEnquiry.getTraining_enquiry_referenceId() + "')");
			st.close();

			// save reference

			st = con.createStatement();
			st.executeUpdate("update tbl_reference set full_name='"
					+ newEnquiry.getTraining_enquiry_reference_name()
					+ "', contact_no='"
					+ newEnquiry.getTraining_enquiry_reference_contact_no()
					+ "' where reference_id = '"
					+ newEnquiry.getTraining_enquiry_referenceId() + "'");
			st.close();

			// save interested course
			tst = con.createStatement();
			tst.executeUpdate("delete from tbl_intrested_course where enquiry_id='"
					+ newEnquiry.getTraining_enquiry_enquiry_id() + "'");
			tst.close();

			String cources[] = newEnquiry.getTraining_enquiry_course();
			for (String c : cources) {
				st = con.createStatement();
				st.executeUpdate("insert into tbl_intrested_course (enquiry_id,course_id) values ('"
						+ newEnquiry.getTraining_enquiry_enquiry_id()
						+ "','"
						+ c + "')");
				st.close();
			}

			con.commit();

			ret = "success";
		} finally {
			con.close();
		}
		return ret;
	}

	public String updateAcademicProjectEnquiry(
			NewAcademicProjectEnquiryDTO newEnquiry) throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();

			Statement st = con.createStatement();

			if (newEnquiry.getAcademic_project_enquiry_qualification()
					.equalsIgnoreCase("other")) {
				newEnquiry.setAcademic_project_enquiry_qualification(newEnquiry
						.getAcademic_project_enquiry_qualification_other());
			}
			if (newEnquiry.getAcademic_project_enquiry_college()
					.equalsIgnoreCase("other")) {
				newEnquiry.setAcademic_project_enquiry_college(newEnquiry
						.getAcademic_project_enquiry_college_other());
			}

			con.setAutoCommit(false);

			String c_no = newEnquiry.getAcademic_project_enquiry_contact_no();
			String e_id = newEnquiry.getAcademic_project_enquiry_email_id();
			int cno_i = c_no.lastIndexOf(",");
			int cmail_i = e_id.lastIndexOf(",");
			if (cno_i != -1) {
				newEnquiry.setAcademic_project_enquiry_contact_no(newEnquiry
						.getAcademic_project_enquiry_contact_no().substring(0,
								cno_i));
			}
			if (cmail_i != -1) {
				newEnquiry.setAcademic_project_enquiry_email_id(newEnquiry
						.getAcademic_project_enquiry_email_id().substring(0,
								cmail_i));
			}
			// save new enquiry
			st = con.createStatement();
			st.executeUpdate("update tbl_enquiry set full_name ='"
					+ newEnquiry.getAcademic_project_enquiry_fullname()
					+ "', father_name='"
					+ newEnquiry.getAcademic_project_enquiry_father_name()
					+ "', qualification='"
					+ newEnquiry.getAcademic_project_enquiry_qualification()
					+ "', college='"
					+ newEnquiry.getAcademic_project_enquiry_college()
					+ "', semester='"
					+ newEnquiry.getAcademic_project_enquiry_semester()
					+ "', enquiry_status='"
					+ newEnquiry.getAcademic_project_enquiry_enquiry_status()
					+ "' where enquiry_id='"
					+ newEnquiry.getAcademic_project_enquiry_enquiry_id() + "'");
			st.close();

			// save contact no

			Statement tst = con.createStatement();
			tst.executeUpdate("delete from tbl_contact where my_id='"
					+ newEnquiry.getAcademic_project_enquiry_enquiry_id() + "'");
			tst.close();

			st = con.createStatement();
			st.executeUpdate("insert into tbl_contact (my_id,contact_no) values ('"
					+ newEnquiry.getAcademic_project_enquiry_enquiry_id()
					+ "','"
					+ newEnquiry.getAcademic_project_enquiry_contact_no()
					+ "')");
			st.close();

			// save email id
			tst = con.createStatement();
			tst.executeUpdate("delete from tbl_email where my_id='"
					+ newEnquiry.getAcademic_project_enquiry_enquiry_id() + "'");
			tst.close();

			st = con.createStatement();
			st.executeUpdate("insert into tbl_email (my_id,email_id) values ('"
					+ newEnquiry.getAcademic_project_enquiry_enquiry_id()
					+ "','" + newEnquiry.getAcademic_project_enquiry_email_id()
					+ "')");
			st.close();

			// save reference note

			tst = con.createStatement();
			tst.executeUpdate("delete from relation_with_reference where myid='"
					+ newEnquiry.getAcademic_project_enquiry_enquiry_id()
					+ "' and reference_id='"
					+ newEnquiry.getAcademic_project_enquiry_referenceId()
					+ "'");
			tst.close();

			st = con.createStatement();
			st.executeUpdate("insert into relation_with_reference (myid,note,reference_id) values ('"
					+ newEnquiry.getAcademic_project_enquiry_enquiry_id()
					+ "','"
					+ newEnquiry.getAcademic_project_enquiry_reference_note()
					+ "','"
					+ newEnquiry.getAcademic_project_enquiry_referenceId()
					+ "')");
			st.close();
			// save project
			tst = con.createStatement();
			tst.executeUpdate("delete from tbl_academic_project where enquiry_id='"
					+ newEnquiry.getAcademic_project_enquiry_enquiry_id() + "'");
			tst.close();

			st = con.createStatement();
			st.executeUpdate("insert into tbl_academic_project (enquiry_id,project_name,delivery_date,project_description) values ('"
					+ newEnquiry.getAcademic_project_enquiry_enquiry_id()
					+ "','"
					+ newEnquiry.getAcademic_project_enquiry_project_name()
					+ "','"
					+ newEnquiry.getAcademic_project_enquiry_delivery_date()
					+ "','"
					+ newEnquiry.getAcademic_project_enquiry_description()
					+ "')");
			st.close();
			// save reference

			st = con.createStatement();
			st.executeUpdate("update tbl_reference set full_name='"
					+ newEnquiry.getAcademic_project_enquiry_reference_name()
					+ "', contact_no='"
					+ newEnquiry
							.getAcademic_project_enquiry_reference_contact_no()
					+ "' where reference_id = '"
					+ newEnquiry.getAcademic_project_enquiry_referenceId()
					+ "'");
			st.close();

			// save interested course
			tst = con.createStatement();
			tst.executeUpdate("delete from tbl_intrested_course where enquiry_id='"
					+ newEnquiry.getAcademic_project_enquiry_enquiry_id() + "'");
			tst.close();

			con.commit();

			ret = "success";
		} finally {
			con.close();
		}
		return ret;
	}

	/*
	 * public List<NewEnquiry> searchEnquiryBranchWise(SearchEnquiry
	 * searchEnquiry,String branchid) throws Exception{ List
	 * <NewEnquiry>enquiryList=new ArrayList<NewEnquiry>(); Connection con=null;
	 * try{ con=new com.js.db.MyConnection().getConnection(); Statement
	 * st=con.createStatement(); String
	 * query="select * from tbl_enquiry where enquiry_id like '"+branchid+"%' ";
	 * 
	 * String fullName=searchEnquiry.getSearch_enquiry_fullname();
	 * if(fullName!=null){ fullName=fullName.trim(); if(fullName.length()>0){
	 * query=query+" and full_name like '%"+fullName+"%'"; } }
	 * 
	 * String college=searchEnquiry.getSearch_enquiry_college();
	 * if(!college.equalsIgnoreCase("Select")){
	 * query=query+" and college = '"+college+"'"; }
	 * 
	 * String course=searchEnquiry.getSearch_enquiry_course();
	 * if(!course.equalsIgnoreCase("Select")){
	 * 
	 * }
	 * 
	 * String qualification=searchEnquiry.getSearch_enquiry_qualification();
	 * if(!qualification.equalsIgnoreCase("Select")){
	 * query=query+" and qualification = '"+qualification+"'"; }
	 * 
	 * String contact_no=searchEnquiry.getSearch_enquiry_contactno();
	 * if(contact_no!=null){ query=query+
	 * " and enquiry_id in (select my_id from tbl_contact where contact_no like '%"
	 * +contact_no+"%')"; }
	 * 
	 * String doj_start=searchEnquiry.getSearch_start_date_doj(); String
	 * doj_end=searchEnquiry.getSearch_end_date_doj(); if(doj_start!=null &&
	 * doj_end!=null){ doj_start=doj_start.replaceAll("/","-"); StringTokenizer
	 * stringTokenizer=new StringTokenizer(doj_start,"-"); String
	 * mm=stringTokenizer.nextToken(); String dd=stringTokenizer.nextToken();
	 * String yy=stringTokenizer.nextToken(); doj_start=yy+"-"+mm+"-"+dd;
	 * 
	 * doj_end=doj_end.replaceAll("/","-"); StringTokenizer tstringTokenizer=new
	 * StringTokenizer(doj_end,"-"); String tmm=tstringTokenizer.nextToken();
	 * String tdd=tstringTokenizer.nextToken(); String
	 * tyy=tstringTokenizer.nextToken(); doj_end=tyy+"-"+tmm+"-"+tdd;
	 * query=query
	 * +" and joining_date between '"+doj_start+"' and '"+doj_end+"' "; }
	 * 
	 * String
	 * referenceFullName=searchEnquiry.getSearch_enquiry_reference_name();
	 * if(referenceFullName!=null){ referenceFullName=referenceFullName.trim();
	 * if(referenceFullName.length()>0){ query=query+
	 * " and reference_id in (select reference_id from tbl_reference where full_name like '%"
	 * +referenceFullName+"%')"; } }
	 * 
	 * String enquiry_date_start=searchEnquiry.getSearch_enquiry_start_date();
	 * String enquiry_date_end=searchEnquiry.getSearch_enquiry_end_date();
	 * 
	 * if(enquiry_date_start!=null && enquiry_date_end!=null){
	 * enquiry_date_start=enquiry_date_start.replaceAll("/","-");
	 * StringTokenizer stringTokenizer=new
	 * StringTokenizer(enquiry_date_start,"-"); String
	 * mm=stringTokenizer.nextToken(); String dd=stringTokenizer.nextToken();
	 * String yy=stringTokenizer.nextToken();
	 * enquiry_date_start=yy+"-"+mm+"-"+dd;
	 * 
	 * enquiry_date_end=enquiry_date_end.replaceAll("/","-"); StringTokenizer
	 * tstringTokenizer=new StringTokenizer(enquiry_date_end,"-"); String
	 * tmm=tstringTokenizer.nextToken(); String
	 * tdd=tstringTokenizer.nextToken(); String
	 * tyy=tstringTokenizer.nextToken(); enquiry_date_end=tyy+"-"+tmm+"-"+tdd;
	 * query=query+" and enquiry_date between '"+enquiry_date_start+"' and '"+
	 * enquiry_date_end+"' "; }
	 * 
	 * String semester=searchEnquiry.getSearch_enquiry_semester();
	 * if(!semester.equalsIgnoreCase("Select")){
	 * query=query+" and semester = '"+semester+"'"; }
	 * 
	 * String
	 * search_enquiry_reference_no=searchEnquiry.getSearch_enquiry_reference_no
	 * (); if(search_enquiry_reference_no!=null){
	 * search_enquiry_reference_no=search_enquiry_reference_no.trim();
	 * if(search_enquiry_reference_no.length()>0){ query=query+
	 * " and reference_id in (select reference_id from tbl_reference where contact_no like '%"
	 * +search_enquiry_reference_no+"%')"; } }
	 * 
	 * String
	 * enquiry_pref_time_start=searchEnquiry.getSearch_enquiry_preferredtime_start
	 * (); String
	 * enquiry_pref_time_end=searchEnquiry.getSearch_enquiry_preferredtime_end
	 * (); if(enquiry_pref_time_start!=null && enquiry_pref_time_end!=null){
	 * query
	 * =query+" and ((preferred_time_start between '"+enquiry_pref_time_start
	 * +"' and '"+enquiry_pref_time_end+"') or (preferred_time_end between '"+
	 * enquiry_pref_time_start+"' and '"+enquiry_pref_time_end+"'))"; }
	 * 
	 * String course_code=searchEnquiry.getSearch_enquiry_course();
	 * if(!course_code.equalsIgnoreCase("select")){ query=query+
	 * " and enquiry_id in (select enquiry_id from tbl_intrested_course where course_id ='"
	 * +course_code+"')"; }
	 * 
	 * String status=searchEnquiry.getSearch_enquiry_status();
	 * if(!status.equalsIgnoreCase("Select")){
	 * query=query+" and enquiry_status = '"+status+"'"; }
	 * 
	 * query=query+"order by enquiry_date DESC";
	 * 
	 * //
	 * 
	 * ResultSet rs=st.executeQuery(query); while(rs.next()){ NewEnquiry
	 * newEnquiry=new NewEnquiry();
	 * newEnquiry.setEnquiry_id(rs.getString("enquiry_id"));
	 * newEnquiry.setFullname(rs.getString("full_name"));
	 * newEnquiry.setFather_name(rs.getString("father_name"));
	 * newEnquiry.setQualification(rs.getString("qualification"));
	 * newEnquiry.setReferenceId(rs.getString("reference_id"));
	 * 
	 * 
	 * String col=rs.getString("college"); Statement
	 * tst11=con.createStatement(); ResultSet
	 * trs11=tst11.executeQuery("select * from tbl_college where college_code='"
	 * +col+"'"); String col_name=""; if(trs11.next()){
	 * col_name=trs11.getString("college_name");
	 * newEnquiry.setCollege(col_name); }else{ newEnquiry.setCollege(col); }
	 * trs11.close(); tst11.close();
	 * 
	 * newEnquiry.setSemester(rs.getString("semester"));
	 * 
	 * 
	 * Statement tst1=con.createStatement(); ResultSet
	 * trs1=tst1.executeQuery("select * from tbl_contact where my_id='"
	 * +newEnquiry.getEnquiry_id()+"'"); String c_no=""; while(trs1.next()){
	 * c_no=c_no+trs1.getString("contact_no")+", "; } trs1.close();
	 * tst1.close(); newEnquiry.setContact_no(c_no);
	 * 
	 * Statement tst12=con.createStatement(); ResultSet
	 * trs12=tst12.executeQuery(
	 * "select * from tbl_email where my_id='"+newEnquiry.getEnquiry_id()+"'");
	 * String email=""; while(trs12.next()){
	 * email=email+trs12.getString("email_id")+", "; } trs12.close();
	 * tst12.close(); newEnquiry.setEmail_id(email);
	 * 
	 * Statement
	 * tst2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet
	 * .CONCUR_UPDATABLE); ResultSet trs2=tst2.executeQuery(
	 * "select course_name from tbl_cource where course_id in (select course_id from tbl_intrested_course where enquiry_id='"
	 * +newEnquiry.getEnquiry_id()+"')"); trs2.last(); String c_courses[]=new
	 * String[trs2.getRow()]; trs2.beforeFirst(); int count=0;
	 * while(trs2.next()){ c_courses[count]=trs2.getString("course_name");
	 * count++; } count=0; trs2.close(); tst2.close();
	 * newEnquiry.setCourse(c_courses);
	 * 
	 * newEnquiry.setJoining_date(rs.getString("joining_date"));
	 * 
	 * newEnquiry.setPreferredtime_start(rs.getString("preferred_time_start"));
	 * newEnquiry.setPreferredtime_end(rs.getString("preferred_time_end"));
	 * 
	 * newEnquiry.setEnquiry_date(rs.getString("enquiry_date"));
	 * 
	 * Statement tst3=con.createStatement(); ResultSet
	 * trs3=tst3.executeQuery("select * from tbl_reference where reference_id='"
	 * +rs.getString("reference_id")+"'"); String referenceName="";
	 * if(trs3.next()){ referenceName=trs3.getString("full_name"); String
	 * reference_contact_no=trs3.getString("contact_no"); String
	 * reference_note=trs3.getString("some_note");
	 * newEnquiry.setReference_contact_no(reference_contact_no);
	 * newEnquiry.setReference_note(reference_note); } trs3.close();
	 * tst3.close(); newEnquiry.setReference_name(referenceName);
	 * 
	 * Statement tst4=con.createStatement(); ResultSet
	 * trs4=tst4.executeQuery("select * from tbl_employee where employee_id='"
	 * +rs.getString("employee_id")+"'"); String employeeName="";
	 * if(trs4.next()){ employeeName=trs4.getString("full_name"); // }
	 * trs4.close(); tst4.close(); newEnquiry.setEmployee_id(employeeName);
	 * newEnquiry.setEnquiry_status(rs.getString("enquiry_status"));
	 * 
	 * enquiryList.add(newEnquiry); } rs.close(); st.close(); }finally{
	 * con.close(); } return enquiryList; }
	 */
	public List<NewVisitorEnquiryDTO> searchVisitorEnquiryBranchWise(
			SearchEnquiry searchEnquiry, String branchid) throws Exception {
		List<NewVisitorEnquiryDTO> enquiryList = new ArrayList<NewVisitorEnquiryDTO>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			String query = "select * from tbl_visitor where visitor_id like '"
					+ branchid + "%' ";

			String fullname = searchEnquiry
					.getSearch_visitor_enquiry_fullname();
			if (fullname != null) {
				fullname = fullname.trim();
				if (fullname.length() > 0) {
					query = query + " and full_name like '%"
							+ fullname + "%'";
				}
			}			

//			String college = searchEnquiry
//					.getSearch_academic_project_enquiry_college();
//			if (college != null) {
//				if (!college.equalsIgnoreCase("Select")) {
//					query = query + " and college = '" + college + "'";
//				}
//			}
//
//			String staus = searchEnquiry
//					.getSearch_academic_project_enquiry_status();
//
//			if (staus != null) {
//				if (!staus.equalsIgnoreCase("Select")) {
//					query = query + " and enquiry_status = '" + staus + "'";
//				}
//			}

			
//			String qualification = searchEnquiry
//					.getSearch_academic_project_enquiry_qualification();
//			if (!qualification.equalsIgnoreCase("Select")) {
//				query = query + " and qualification = '" + qualification + "'";
//			}

			String contact_no = searchEnquiry
					.getSearch_visitor_enquiry_contactno();
			if (contact_no != null) {
				query = query
						+ " and visitor_id in (select my_id from tbl_contact where contact_no like '%"
						+ contact_no + "%')";
			}

			String visit_date_start = searchEnquiry
					.getSearch_visitor_enquiry_start_date();
			String visit_date_end= searchEnquiry
					.getSearch_visitor_enquiry_end_date();
			if (visit_date_start != null && visit_date_end != null) {
				visit_date_start = visit_date_start.replaceAll("/", "-");
				StringTokenizer stringTokenizer = new StringTokenizer(
						visit_date_start, "-");
				String mm = stringTokenizer.nextToken();
				String dd = stringTokenizer.nextToken();
				String yy = stringTokenizer.nextToken();
				visit_date_start = yy + "-" + mm + "-" + dd;

				visit_date_end = visit_date_end.replaceAll("/", "-");
				StringTokenizer tstringTokenizer = new StringTokenizer(visit_date_end,
						"-");
				String tmm = tstringTokenizer.nextToken();
				String tdd = tstringTokenizer.nextToken();
				String tyy = tstringTokenizer.nextToken();
				visit_date_end = tyy + "-" + tmm + "-" + tdd;
				query = query + " and date_of_visit between '" + visit_date_start
						+ "' and '" + visit_date_end + "' ";
			}

			String referenceFullName = searchEnquiry
					.getSearch_visitor_enquiry_reference_name();
			if (referenceFullName != null) {
				referenceFullName = referenceFullName.trim();
				if (referenceFullName.length() > 0) {
					query = query
							+ " and reference_id in (select reference_id from tbl_reference where full_name like '%"
							+ referenceFullName + "%')";
				}
			}
			

			String search_enquiry_reference_no = searchEnquiry
					.getSearch_visitor_enquiry_reference_no();
			if (search_enquiry_reference_no != null) {
				search_enquiry_reference_no = search_enquiry_reference_no
						.trim();
				if (search_enquiry_reference_no.length() > 0) {
					query = query
							+ " and reference_id in (select reference_id from tbl_reference where contact_no like '%"
							+ search_enquiry_reference_no + "%')";
				}
			}
			String search_visitor_enquiry_address= searchEnquiry
					.getSearch_visitor_enquiry_address();
			if (search_visitor_enquiry_address != null) {
				search_visitor_enquiry_address = search_enquiry_reference_no
						.trim();
				if (search_visitor_enquiry_address.length() > 0) {
					query = query
							+ " and address like '%"
							+ search_visitor_enquiry_address + "%' ";
				}
			}
			
			String meet_with= searchEnquiry
					.getSearch_visitor_enquiry_appointment_with();
			if (meet_with != null) {
				meet_with = meet_with
						.trim();
				if (meet_with.length() > 0) {
					query = query
							+ " and meet_with like '%"
							+ meet_with + "%' ";
				}
			}
			
			String purpose_to_visit= searchEnquiry
					.getSearch_visitor_enquiry_visiting_purpose();
			if (purpose_to_visit != null) {
				purpose_to_visit = search_enquiry_reference_no
						.trim();
				if (purpose_to_visit.length() > 0) {
					query = query
							+ " and purpose_to_visit like '%"
							+ purpose_to_visit + "%' ";
				}
			}

			query = query + "order by date_of_visit DESC";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				NewVisitorEnquiryDTO visitorEnquiryDTO = new NewVisitorEnquiryDTO();
				visitorEnquiryDTO.setEmployee_id(rs.getString("employee_id"));				
				visitorEnquiryDTO.setVisitor_enquiry_address(rs.getString("address"));
				visitorEnquiryDTO.setVisitor_enquiry_appointment_with(rs.getString("meet_with"));								
				visitorEnquiryDTO.setVisitor_enquiry_date(rs.getString("date_of_visit"));				
				visitorEnquiryDTO.setVisitor_enquiry_enquiry_id(rs.getString("visitor_id"));
				visitorEnquiryDTO.setVisitor_enquiry_enquiry_status(rs.getString("status"));				
				visitorEnquiryDTO.setVisitor_enquiry_fullname(rs.getString("full_name"));
				visitorEnquiryDTO.setVisitor_enquiry_note(rs.getString("note"));
				visitorEnquiryDTO.setVisitor_enquiry_purpose(rs.getString("purpose_to_visit"));
				visitorEnquiryDTO.setVisitor_enquiry_visit_time_end(rs.getString("visit_time_end"));
				visitorEnquiryDTO.setVisitor_enquiry_visiting_time_start(rs.getString("visiting_time_start"));
				
				
				
				
				
							

				Statement tst1 = con.createStatement();
				ResultSet trs1 = tst1
						.executeQuery("select * from tbl_contact where my_id='"
								+ visitorEnquiryDTO
										.getVisitor_enquiry_enquiry_id()
								+ "'");
				String c_no = "";
				while (trs1.next()) {
					c_no = c_no + trs1.getString("contact_no") + ", ";
				}
				trs1.close();
				tst1.close();
				visitorEnquiryDTO.setVisitor_enquiry_contact_no(c_no);
				
				Statement tst12 = con.createStatement();
				ResultSet trs12 = tst12
						.executeQuery("select * from tbl_email where my_id='"
								+ visitorEnquiryDTO
										.getVisitor_enquiry_enquiry_id()
								+ "'");
				String email = "";
				while (trs12.next()) {
					email = email + trs12.getString("email_id") + ", ";
				}
				trs12.close();
				tst12.close();
				visitorEnquiryDTO.setVisitor_enquiry_email_id(email);

				Statement tst5 = con.createStatement();
				ResultSet trs5 = tst5
						.executeQuery("select * from relation_with_reference where myid='"
								+ visitorEnquiryDTO
										.getVisitor_enquiry_enquiry_id()
								+ "'");
				if (trs5.next()) {
					String reference_note = trs5.getString("note");
					String reference_id = trs5.getString("reference_id");
					visitorEnquiryDTO.setVisitor_enquiry_reference_note(reference_note);
					visitorEnquiryDTO.setVisitor_enquiry_referenceId(reference_id);
				}
				trs5.close();
				tst5.close();

				Statement tst3 = con.createStatement();
				ResultSet trs3 = tst3
						.executeQuery("select * from tbl_reference where reference_id='"
								+ visitorEnquiryDTO.getVisitor_enquiry_referenceId() + "'");
				String referenceName = "";
				if (trs3.next()) {
					referenceName = trs3.getString("full_name");
					String reference_contact_no = trs3.getString("contact_no");
					visitorEnquiryDTO.setVisitor_enquiry_reference_contact_no(reference_contact_no);
					visitorEnquiryDTO.setVisitor_enquiry_reference_name(referenceName);
					
				}
				trs3.close();
				tst3.close();			
				

				Statement tst4 = con.createStatement();
				ResultSet trs4 = tst4
						.executeQuery("select * from tbl_employee where employee_id='"
								+ visitorEnquiryDTO.getEmployee_id() + "'");
				String employeeName = "";
				if (trs4.next()) {
					employeeName = trs4.getString("full_name");

				}
				trs4.close();
				tst4.close();
				visitorEnquiryDTO.setEmployee_id(employeeName);
				enquiryList.add(visitorEnquiryDTO);
			}
			rs.close();
			st.close();
		} finally {
			con.close();
		}

		return enquiryList;
	}
	public List<NewAcademicProjectEnquiryDTO> searchAcademicEnquiryBranchWise(
			SearchEnquiry searchEnquiry, String branchid) throws Exception {
		List<NewAcademicProjectEnquiryDTO> enquiryList = new ArrayList<NewAcademicProjectEnquiryDTO>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			String query = "select * from tbl_enquiry e,tbl_academic_project p where e.enquiry_id like '"
					+ branchid + "%' and p.enquiry_id=e.enquiry_id";

			String ropjecrtitlaName = searchEnquiry
					.getSearch_academic_project_enquiry_project_title();
			if (ropjecrtitlaName != null) {
				ropjecrtitlaName = ropjecrtitlaName.trim();
				if (ropjecrtitlaName.length() > 0) {
					query = query + " and project_name like '%"
							+ ropjecrtitlaName + "%'";
				}
			}
			String fullName = searchEnquiry
					.getSearch_academic_project_enquiry_fullname();
			if (fullName != null) {
				fullName = fullName.trim();
				if (fullName.length() > 0) {
					query = query + " and full_name like '%" + fullName + "%'";
				}
			}

			String college = searchEnquiry
					.getSearch_academic_project_enquiry_college();
			if (college != null) {
				if (!college.equalsIgnoreCase("Select")) {
					query = query + " and college = '" + college + "'";
				}
			}

			String staus = searchEnquiry
					.getSearch_academic_project_enquiry_status();

			if (staus != null) {
				if (!staus.equalsIgnoreCase("Select")) {
					query = query + " and enquiry_status = '" + staus + "'";
				}
			}

			String purpose = searchEnquiry.getSearch_purpose();
			query = query + " and purpose = '" + purpose + "'";

			String qualification = searchEnquiry
					.getSearch_academic_project_enquiry_qualification();
			if (!qualification.equalsIgnoreCase("Select")) {
				query = query + " and qualification = '" + qualification + "'";
			}

			String contact_no = searchEnquiry
					.getSearch_academic_project_enquiry_contactno();
			if (contact_no != null) {
				query = query
						+ " and e.enquiry_id in (select my_id from tbl_contact where contact_no like '%"
						+ contact_no + "%')";
			}

			String doj_start = searchEnquiry
					.getSearch_academic_project_enquiry_start_date();
			String doj_end = searchEnquiry
					.getSearch_academic_project_enquiry_end_date();
			if (doj_start != null && doj_end != null) {
				doj_start = doj_start.replaceAll("/", "-");
				StringTokenizer stringTokenizer = new StringTokenizer(
						doj_start, "-");
				String mm = stringTokenizer.nextToken();
				String dd = stringTokenizer.nextToken();
				String yy = stringTokenizer.nextToken();
				doj_start = yy + "-" + mm + "-" + dd;

				doj_end = doj_end.replaceAll("/", "-");
				StringTokenizer tstringTokenizer = new StringTokenizer(doj_end,
						"-");
				String tmm = tstringTokenizer.nextToken();
				String tdd = tstringTokenizer.nextToken();
				String tyy = tstringTokenizer.nextToken();
				doj_end = tyy + "-" + tmm + "-" + tdd;
				query = query + " and joining_date between '" + doj_start
						+ "' and '" + doj_end + "' ";
			}

			String referenceFullName = searchEnquiry
					.getSearch_academic_project_enquiry_reference_name();
			if (referenceFullName != null) {
				referenceFullName = referenceFullName.trim();
				if (referenceFullName.length() > 0) {
					query = query
							+ " and reference_id in (select reference_id from tbl_reference where full_name like '%"
							+ referenceFullName + "%')";
				}
			}

			String delevery_date_start = searchEnquiry
					.getSearch_academic_project_enquiry_delivery_start_date();
			String delevery_date_end = searchEnquiry
					.getSearch_academic_project_enquiry_delivery_end_date();

			if (delevery_date_start != null && delevery_date_end != null) {
				delevery_date_start = delevery_date_start.replaceAll("/", "-");
				StringTokenizer stringTokenizer = new StringTokenizer(
						delevery_date_start, "-");
				String mm = stringTokenizer.nextToken();
				String dd = stringTokenizer.nextToken();
				String yy = stringTokenizer.nextToken();
				delevery_date_start = yy + "-" + mm + "-" + dd;

				delevery_date_end = delevery_date_end.replaceAll("/", "-");
				StringTokenizer tstringTokenizer = new StringTokenizer(
						delevery_date_end, "-");
				String tmm = tstringTokenizer.nextToken();
				String tdd = tstringTokenizer.nextToken();
				String tyy = tstringTokenizer.nextToken();
				delevery_date_end = tyy + "-" + tmm + "-" + tdd;
				query = query + " and delivery_date between '"
						+ delevery_date_start + "' and '" + delevery_date_end
						+ "' ";
			}

			String enquiry_date_start = searchEnquiry
					.getSearch_academic_project_enquiry_start_date();
			String enquiry_date_end = searchEnquiry
					.getSearch_training_enquiry_end_date();

			if (enquiry_date_start != null && enquiry_date_end != null) {
				enquiry_date_start = enquiry_date_start.replaceAll("/", "-");
				StringTokenizer stringTokenizer = new StringTokenizer(
						enquiry_date_start, "-");
				String mm = stringTokenizer.nextToken();
				String dd = stringTokenizer.nextToken();
				String yy = stringTokenizer.nextToken();
				enquiry_date_start = yy + "-" + mm + "-" + dd;

				enquiry_date_end = enquiry_date_end.replaceAll("/", "-");
				StringTokenizer tstringTokenizer = new StringTokenizer(
						enquiry_date_end, "-");
				String tmm = tstringTokenizer.nextToken();
				String tdd = tstringTokenizer.nextToken();
				String tyy = tstringTokenizer.nextToken();
				enquiry_date_end = tyy + "-" + tmm + "-" + tdd;
				query = query + " and enquiry_date between '"
						+ enquiry_date_start + "' and '" + enquiry_date_end
						+ "' ";
			}

			String semester = searchEnquiry
					.getSearch_academic_project_enquiry_semester();
			if (!semester.equalsIgnoreCase("Select")) {
				query = query + " and semester = '" + semester + "'";
			}

			String search_enquiry_reference_no = searchEnquiry
					.getSearch_academic_project_enquiry_reference_no();
			if (search_enquiry_reference_no != null) {
				search_enquiry_reference_no = search_enquiry_reference_no
						.trim();
				if (search_enquiry_reference_no.length() > 0) {
					query = query
							+ " and reference_id in (select reference_id from tbl_reference where contact_no like '%"
							+ search_enquiry_reference_no + "%')";
				}
			}

			String status = searchEnquiry
					.getSearch_academic_project_enquiry_status();
			if (!status.equalsIgnoreCase("Select")) {
				query = query + " and enquiry_status = '" + status + "'";
			}

			query = query + "order by enquiry_date DESC";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				NewAcademicProjectEnquiryDTO newEnquiry = new NewAcademicProjectEnquiryDTO();
				newEnquiry.setAcademic_project_enquiry_enquiry_id(rs
						.getString("e.enquiry_id"));

				newEnquiry.setAcademic_project_enquiry_fullname(rs
						.getString("e.full_name"));
				newEnquiry.setAcademic_project_enquiry_father_name(rs
						.getString("e.father_name"));
				newEnquiry.setAcademic_project_enquiry_qualification(rs
						.getString("e.qualification"));
				newEnquiry.setAcademic_project_enquiry_referenceId(rs
						.getString("e.reference_id"));
				newEnquiry.setEnquiry_purpose(rs.getString("e.purpose"));

				newEnquiry.setAcademic_project_enquiry_project_name(rs
						.getString("p.project_name"));
				newEnquiry.setAcademic_project_enquiry_description(rs
						.getString("project_description"));

				String col = rs.getString("e.college");
				Statement tst11 = con.createStatement();
				ResultSet trs11 = tst11
						.executeQuery("select * from tbl_college where college_code='"
								+ col + "'");
				String col_name = "";
				if (trs11.next()) {
					col_name = trs11.getString("college_name");
					newEnquiry.setAcademic_project_enquiry_college(col_name);
				} else {
					newEnquiry.setAcademic_project_enquiry_college(col);
				}
				trs11.close();
				tst11.close();

				newEnquiry.setAcademic_project_enquiry_semester(rs
						.getString("e.semester"));

				Statement tst1 = con.createStatement();
				ResultSet trs1 = tst1
						.executeQuery("select * from tbl_contact where my_id='"
								+ newEnquiry
										.getAcademic_project_enquiry_enquiry_id()
								+ "'");
				String c_no = "";
				while (trs1.next()) {
					c_no = c_no + trs1.getString("contact_no") + ", ";
				}
				trs1.close();
				tst1.close();
				newEnquiry.setAcademic_project_enquiry_contact_no(c_no);

				Statement tst12 = con.createStatement();
				ResultSet trs12 = tst12
						.executeQuery("select * from tbl_email where my_id='"
								+ newEnquiry
										.getAcademic_project_enquiry_enquiry_id()
								+ "'");
				String email = "";
				while (trs12.next()) {
					email = email + trs12.getString("email_id") + ", ";
				}
				trs12.close();
				tst12.close();
				newEnquiry.setAcademic_project_enquiry_email_id(email);

				newEnquiry.setAcademic_project_enquiry_delivery_date(rs
						.getString("p.delivery_date"));

				newEnquiry.setAcademic_project_enquiry_date(rs
						.getString("e.enquiry_date"));

				Statement tst3 = con.createStatement();
				ResultSet trs3 = tst3
						.executeQuery("select * from tbl_reference where reference_id='"
								+ rs.getString("reference_id") + "'");
				String referenceName = "";
				if (trs3.next()) {
					referenceName = trs3.getString("full_name");
					String reference_contact_no = trs3.getString("contact_no");
					newEnquiry
							.setAcademic_project_enquiry_reference_contact_no(reference_contact_no);
				}
				trs3.close();
				tst3.close();
				newEnquiry
						.setAcademic_project_enquiry_reference_name(referenceName);

				Statement tst5 = con.createStatement();
				ResultSet trs5 = tst5
						.executeQuery("select * from relation_with_reference where reference_id='"
								+ newEnquiry
										.getAcademic_project_enquiry_enquiry_id()
								+ "'");
				if (trs5.next()) {
					String reference_note = trs5.getString("note");
					newEnquiry
							.setAcademic_project_enquiry_reference_contact_no(reference_note);
				}
				trs5.close();
				tst5.close();

				Statement tst4 = con.createStatement();
				ResultSet trs4 = tst4
						.executeQuery("select * from tbl_employee where employee_id='"
								+ rs.getString("employee_id") + "'");
				String employeeName = "";
				if (trs4.next()) {
					employeeName = trs4.getString("full_name");

				}
				trs4.close();
				tst4.close();
				newEnquiry.setEmployee_id(employeeName);
				newEnquiry.setAcademic_project_enquiry_enquiry_status(rs
						.getString("e.enquiry_status"));
				enquiryList.add(newEnquiry);
			}
			rs.close();
			st.close();
		} finally {
			con.close();
		}

		return enquiryList;
	}

	public List<NewTrainingEnquiryDTO> searchTraininEnquiryBranchWise(
			SearchEnquiry searchEnquiry, String branchid) throws Exception {
		List<NewTrainingEnquiryDTO> enquiryList = new ArrayList<NewTrainingEnquiryDTO>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			String query = "select * from tbl_enquiry where enquiry_id like '"
					+ branchid + "%' ";

			String fullName = searchEnquiry
					.getSearch_training_enquiry_fullname();
			if (fullName != null) {
				fullName = fullName.trim();
				if (fullName.length() > 0) {
					query = query + " and full_name like '%" + fullName + "%'";
				}
			}

			String college = searchEnquiry.getSearch_training_enquiry_college();
			if (!college.equalsIgnoreCase("Select")) {
				query = query + " and college = '" + college + "'";
			}

			String staus = searchEnquiry.getSearch_training_enquiry_status();

			if (staus != null) {
				if (!staus.equalsIgnoreCase("Select")) {
					query = query + " and enquiry_status = '" + staus + "'";
				}
			}

			String purpose = searchEnquiry.getSearch_purpose();
			query = query + " and purpose = '" + purpose + "'";

			String course = searchEnquiry.getSearch_training_enquiry_course();
			if (!course.equalsIgnoreCase("Select")) {

			}

			String qualification = searchEnquiry
					.getSearch_training_enquiry_qualification();
			if (!qualification.equalsIgnoreCase("Select")) {
				query = query + " and qualification = '" + qualification + "'";
			}

			String contact_no = searchEnquiry
					.getSearch_training_enquiry_contactno();
			if (contact_no != null) {
				query = query
						+ " and enquiry_id in (select my_id from tbl_contact where contact_no like '%"
						+ contact_no + "%')";
			}

			String doj_start = searchEnquiry
					.getSearch_training_enquiry_start_date_doj();
			String doj_end = searchEnquiry
					.getSearch_training_enquiry_end_date_doj();
			if (doj_start != null && doj_end != null) {
				doj_start = doj_start.replaceAll("/", "-");
				StringTokenizer stringTokenizer = new StringTokenizer(
						doj_start, "-");
				String mm = stringTokenizer.nextToken();
				String dd = stringTokenizer.nextToken();
				String yy = stringTokenizer.nextToken();
				doj_start = yy + "-" + mm + "-" + dd;

				doj_end = doj_end.replaceAll("/", "-");
				StringTokenizer tstringTokenizer = new StringTokenizer(doj_end,
						"-");
				String tmm = tstringTokenizer.nextToken();
				String tdd = tstringTokenizer.nextToken();
				String tyy = tstringTokenizer.nextToken();
				doj_end = tyy + "-" + tmm + "-" + tdd;
				query = query + " and joining_date between '" + doj_start
						+ "' and '" + doj_end + "' ";
			}

			String referenceFullName = searchEnquiry
					.getSearch_training_enquiry_reference_name();
			if (referenceFullName != null) {
				referenceFullName = referenceFullName.trim();
				if (referenceFullName.length() > 0) {
					query = query
							+ " and reference_id in (select reference_id from tbl_reference where full_name like '%"
							+ referenceFullName + "%')";
				}
			}

			String enquiry_date_start = searchEnquiry
					.getSearch_training_enquiry_start_date();
			String enquiry_date_end = searchEnquiry
					.getSearch_training_enquiry_end_date();

			if (enquiry_date_start != null && enquiry_date_end != null) {
				enquiry_date_start = enquiry_date_start.replaceAll("/", "-");
				StringTokenizer stringTokenizer = new StringTokenizer(
						enquiry_date_start, "-");
				String mm = stringTokenizer.nextToken();
				String dd = stringTokenizer.nextToken();
				String yy = stringTokenizer.nextToken();
				enquiry_date_start = yy + "-" + mm + "-" + dd;

				enquiry_date_end = enquiry_date_end.replaceAll("/", "-");
				StringTokenizer tstringTokenizer = new StringTokenizer(
						enquiry_date_end, "-");
				String tmm = tstringTokenizer.nextToken();
				String tdd = tstringTokenizer.nextToken();
				String tyy = tstringTokenizer.nextToken();
				enquiry_date_end = tyy + "-" + tmm + "-" + tdd;
				query = query + " and enquiry_date between '"
						+ enquiry_date_start + "' and '" + enquiry_date_end
						+ "' ";
			}

			String semester = searchEnquiry
					.getSearch_training_enquiry_semester();
			if (!semester.equalsIgnoreCase("Select")) {
				query = query + " and semester = '" + semester + "'";
			}

			String search_enquiry_reference_no = searchEnquiry
					.getSearch_training_enquiry_reference_no();
			if (search_enquiry_reference_no != null) {
				search_enquiry_reference_no = search_enquiry_reference_no
						.trim();
				if (search_enquiry_reference_no.length() > 0) {
					query = query
							+ " and reference_id in (select reference_id from tbl_reference where contact_no like '%"
							+ search_enquiry_reference_no + "%')";
				}
			}

			String enquiry_pref_time_start = searchEnquiry
					.getSearch_training_enquiry_preferredtime_start();
			String enquiry_pref_time_end = searchEnquiry
					.getSearch_training_enquiry_preferredtime_end();
			if (enquiry_pref_time_start != null
					&& enquiry_pref_time_end != null) {
				query = query + " and ((preferred_time_start between '"
						+ enquiry_pref_time_start + "' and '"
						+ enquiry_pref_time_end
						+ "') or (preferred_time_end between '"
						+ enquiry_pref_time_start + "' and '"
						+ enquiry_pref_time_end + "'))";
			}

			String course_code = searchEnquiry
					.getSearch_training_enquiry_course();
			if (!course_code.equalsIgnoreCase("select")) {
				query = query
						+ " and enquiry_id in (select enquiry_id from tbl_intrested_course where course_id ='"
						+ course_code + "')";
			}

			String status = searchEnquiry.getSearch_training_enquiry_status();
			if (!status.equalsIgnoreCase("Select")) {
				query = query + " and enquiry_status = '" + status + "'";
			}

			query = query + "order by enquiry_date DESC";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				NewTrainingEnquiryDTO newEnquiry = new NewTrainingEnquiryDTO();
				newEnquiry.setTraining_enquiry_enquiry_id(rs
						.getString("enquiry_id"));
				newEnquiry.setTraining_enquiry_fullname(rs
						.getString("full_name"));
				newEnquiry.setTraining_enquiry_father_name(rs
						.getString("father_name"));
				newEnquiry.setTraining_enquiry_qualification(rs
						.getString("qualification"));
				newEnquiry.setTraining_enquiry_referenceId(rs
						.getString("reference_id"));
				newEnquiry.setEnquiry_purpose(rs.getString("purpose"));
				newEnquiry.setTraining_enquiry_entry_time(rs
						.getString("entry_time"));

				String col = rs.getString("college");
				Statement tst11 = con.createStatement();
				ResultSet trs11 = tst11
						.executeQuery("select * from tbl_college where college_code='"
								+ col + "'");
				String col_name = "";
				if (trs11.next()) {
					col_name = trs11.getString("college_name");
					newEnquiry.setTraining_enquiry_college(col_name);
				} else {
					newEnquiry.setTraining_enquiry_college(col);
				}
				trs11.close();
				tst11.close();

				newEnquiry.setTraining_enquiry_semester(rs
						.getString("semester"));

				Statement tst1 = con.createStatement();
				ResultSet trs1 = tst1
						.executeQuery("select * from tbl_contact where my_id='"
								+ newEnquiry.getTraining_enquiry_enquiry_id()
								+ "'");
				String c_no = "";
				while (trs1.next()) {
					c_no = c_no + trs1.getString("contact_no");
				}
				trs1.close();
				tst1.close();
				newEnquiry.setTraining_enquiry_contact_no(c_no);

				Statement tst12 = con.createStatement();
				ResultSet trs12 = tst12
						.executeQuery("select * from tbl_email where my_id='"
								+ newEnquiry.getTraining_enquiry_enquiry_id()
								+ "'");
				String email = "";
				while (trs12.next()) {
					email = email + trs12.getString("email_id") + ", ";
				}
				trs12.close();
				tst12.close();
				newEnquiry.setTraining_enquiry_email_id(email);

				Statement tst2 = con.createStatement(
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet trs2 = tst2
						.executeQuery("select course_name from tbl_cource where course_id in (select course_id from tbl_intrested_course where enquiry_id='"
								+ newEnquiry.getTraining_enquiry_enquiry_id()
								+ "')");

				trs2.last();
				String c_courses[] = new String[trs2.getRow()];
				trs2.beforeFirst();
				int count = 0;
				while (trs2.next()) {
					c_courses[count] = trs2.getString("course_name");
					count++;
				}
				count = 0;
				trs2.close();
				tst2.close();
				newEnquiry.setTraining_enquiry_course(c_courses);

				newEnquiry.setTraining_enquiry_joining_date(rs
						.getString("joining_date"));

				newEnquiry.setTraining_enquiry_preferredtime_start(rs
						.getString("preferred_time_start"));
				newEnquiry.setTraining_enquiry_preferredtime_end(rs
						.getString("preferred_time_end"));

				newEnquiry.setTraining_enquiry_date(rs
						.getString("enquiry_date"));

				Statement tst3 = con.createStatement();
				ResultSet trs3 = tst3
						.executeQuery("select * from tbl_reference where reference_id='"
								+ rs.getString("reference_id") + "'");
				String referenceName = "";
				if (trs3.next()) {
					referenceName = trs3.getString("full_name");
					String reference_contact_no = trs3.getString("contact_no");
					newEnquiry
							.setTraining_enquiry_reference_contact_no(reference_contact_no);
				}
				trs3.close();
				tst3.close();
				newEnquiry.setTraining_enquiry_reference_name(referenceName);

				Statement tst5 = con.createStatement();
				ResultSet trs5 = tst5
						.executeQuery("select * from relation_with_reference where myid='"
								+ newEnquiry.getTraining_enquiry_enquiry_id()
								+ "'");
				if (trs5.next()) {
					String reference_note = trs5.getString("note");
					newEnquiry
							.setTraining_enquiry_reference_note(reference_note);
				}
				trs5.close();
				tst5.close();

				Statement tst4 = con.createStatement();
				ResultSet trs4 = tst4
						.executeQuery("select * from tbl_employee where employee_id='"
								+ rs.getString("employee_id") + "'");
				String employeeName = "";
				if (trs4.next()) {
					employeeName = trs4.getString("full_name");

				}
				trs4.close();
				tst4.close();
				newEnquiry.setEmployee_id(employeeName);
				newEnquiry.setTraining_enquiry_enquiry_status(rs
						.getString("enquiry_status"));

				enquiryList.add(newEnquiry);
			}
			rs.close();
			st.close();
		} finally {
			con.close();
		}

		return enquiryList;
	}

	public List<EnquiryRemark> getAllRemarkForAnEnquiry(NewEnquiry newEnquiry)
			throws Exception {
		List<EnquiryRemark> remarkList = new ArrayList<EnquiryRemark>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st
					.executeQuery("select * from tbl_enquiry_remark where enquiry_id ='"
							+ newEnquiry.getEnquiry_id()
							+ "' order by remark_date DESC");
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
					EnquiryRemark enquiryRemark = new EnquiryRemark();
					enquiryRemark.setEnquiry_id(rs.getString("enquiry_id"));
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

	public List<AcademicProjectRemark> getAllRemarkForAnAcademicProjectEnquiry(
			NewAcademicProjectEnquiryDTO newEnquiry) throws Exception {

		List<AcademicProjectRemark> remarkList = new ArrayList<AcademicProjectRemark>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			String query = "select * from tbl_academic_project p ,tbl_academic_project_remark r where enquiry_id ='"
					+ newEnquiry.getAcademic_project_enquiry_enquiry_id()
					+ "' and p.project_id=r.project_id order by remark_date DESC";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
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

				AcademicProjectRemark enquiryRemark = new AcademicProjectRemark();
				enquiryRemark.setProject_id(rs.getString("r.project_id"));

				enquiryRemark.setRemark(rs.getString("r.remark"));
				enquiryRemark.setNext_meeting_date(rs
						.getString("r.next_meeting_date"));
				enquiryRemark.setNext_meeting_time_start(rs
						.getString("r.next_meeting_time_start"));
				enquiryRemark.setNext_meeting_time_end(rs
						.getString("r.next_meeting_time_end"));
				enquiryRemark.setRemark_docs_path(rs
						.getString("r.remark_docs_path"));
				enquiryRemark.setAppointment_with(rs
						.getString("r.appointment_with"));
				enquiryRemark.setEmployee_id(rs.getString("r.employee_id"));
				enquiryRemark.setRemark_date(rs.getString("r.remark_date"));
				enquiryRemark.setCouncillor(councillor);
				remarkList.add(enquiryRemark);
			}
			rs.close();
			st.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			con.close();
		}

		return remarkList;
	}

	public List<EnquiryRemark> getAllRemarkForAnTrainingEnquiry(
			NewTrainingEnquiryDTO newTrainingEnquiryDTO) throws Exception {
		List<EnquiryRemark> remarkList = new ArrayList<EnquiryRemark>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st
					.executeQuery("select * from tbl_enquiry_remark where enquiry_id ='"
							+ newTrainingEnquiryDTO
									.getTraining_enquiry_enquiry_id()
							+ "' order by remark_date DESC");

			while (rs.next()) {
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

				EnquiryRemark enquiryRemark = new EnquiryRemark();
				enquiryRemark.setEnquiry_id(rs.getString("enquiry_id"));
				enquiryRemark.setRemark_date(rs.getString("remark_date"));
				enquiryRemark.setRemark(rs.getString("remark"));
				enquiryRemark.setRemark_alert(rs.getString("remark_alert"));
				enquiryRemark.setEmployee_id(rs.getString("employee_id"));
				enquiryRemark.setCouncillor(councillor);
				remarkList.add(enquiryRemark);
			}
			rs.close();
			st.close();

		} finally {
			con.close();
		}

		return remarkList;
	}

	public List<String> getAllEnquiredQualification(String branchid)
			throws Exception {
		List<String> qualificationList = new ArrayList<String>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select DISTINCT qualification from tbl_enquiry where enquiry_id like '"
							+ branchid + "%'");
			while (rs.next()) {
				qualificationList.add(rs.getString("qualification"));
			}
			rs.close();
			st.close();
		} finally {
			con.close();
		}
		return qualificationList;
	}

	public List<String> getAllEnquiredStatus(String branchid) throws Exception {
		List<String> statusList = new ArrayList<String>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select DISTINCT enquiry_status from tbl_enquiry where enquiry_id like '"
							+ branchid + "%'");
			while (rs.next()) {
				statusList.add(rs.getString("enquiry_status"));
			}
			rs.close();
			st.close();
		} finally {
			con.close();
		}

		return statusList;
	}

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
			st.executeUpdate("insert into tbl_enquiry_remark (enquiry_id,remark_date,remark,remark_alert,employee_id) values ('"
					+ remark.getEnquiry_id()
					+ "','"
					+ remark.getRemark_date()
					+ "','"
					+ remark.getRemark()
					+ "','"
					+ remark.getRemark_alert()
					+ "','"
					+ remark.getEmployee_id() + "')");
			st.close();

			st = con.createStatement();
			st.executeUpdate("update tbl_enquiry set joining_date ='"
					+ remark.getRemark_alert()
					+ "', enquiry_status='Under Process' where enquiry_id='"
					+ remark.getEnquiry_id() + "'");
			st.close();
			con.commit();
		} finally {
			con.close();
		}
		return ret;
	}

	public String saveNewAcademicProjectRemark(
			AcademicProjectRemark academicProjectRemark) throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();

			String meetingDate = academicProjectRemark.getNext_meeting_date();
			meetingDate = meetingDate.replaceAll("/", "-");
			StringTokenizer stringTokenizer = new StringTokenizer(meetingDate,
					"-");
			String yy = stringTokenizer.nextToken();
			String mm = stringTokenizer.nextToken();
			String dd = stringTokenizer.nextToken();
			meetingDate = yy + "-" + mm + "-" + dd;
			academicProjectRemark.setNext_meeting_date(meetingDate);
			con.setAutoCommit(false);

			Statement st = con.createStatement();

			st.executeUpdate("insert into tbl_academic_project_remark (project_id,remark,next_meeting_date,next_meeting_time_start,next_meeting_time_end,remark_docs_path,appointment_with,employee_id,remark_date) values ('"
					+ academicProjectRemark.getEnquiry_id()
					+ "','"
					+ academicProjectRemark.getRemark()
					+ "','"
					+ academicProjectRemark.getNext_meeting_date()
					+ "','"
					+ academicProjectRemark.getNext_meeting_time_start()
					+ "','"
					+ academicProjectRemark.getNext_meeting_time_end()
					+ "','"
					+ academicProjectRemark.getRemark_docs_path()
					+ "','"
					+ academicProjectRemark.getAppointment_with()
					+ "','"
					+ academicProjectRemark.getEmployee_id()
					+ "','"
					+ academicProjectRemark.getRemark_date() + "')");
			st.close();

			st = con.createStatement();
			st.executeUpdate("update tbl_academic_project set delivery_date ='"
					+ academicProjectRemark.getNext_meeting_date()
					+ "' where enquiry_id='"
					+ academicProjectRemark.getEnquiry_id() + "'");
			st.close();
			con.commit();
		} finally {
			con.close();
		}

		return ret;
	}

	public List<List<NewTrainingEnquiryDTO>> getTrainingAllFollowUp(
			String branchid) throws Exception {

		List<List<NewTrainingEnquiryDTO>> todayFollowUpList = new ArrayList<List<NewTrainingEnquiryDTO>>();
		List<NewTrainingEnquiryDTO> todayFollowUpList_Active = new ArrayList<NewTrainingEnquiryDTO>();
		List<NewTrainingEnquiryDTO> todayFollowUpList_Passive = new ArrayList<NewTrainingEnquiryDTO>();

		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			Date date = new Date();

			// String
			// c_date=(1900+date.getYear())+"-"+(1+date.getMonth())+"-"+date.getDate();
			String doj_start = (1900 + date.getYear()) + "-"
					+ (1 + date.getMonth()) + "-" + date.getDate();
			int MILLIS_IN_DAY = ((1000 * 60 * 60 * 24) * 21);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String nextDate = dateFormat.format(date.getTime() + MILLIS_IN_DAY);

			String doj_end = nextDate;

			String query = "select * from tbl_enquiry where enquiry_id like '"
					+ branchid
					+ "%' and purpose='Training' and joining_date between '"
					+ doj_start
					+ "' and '"
					+ doj_end
					+ "' and enquiry_status not in ('Joined','Not Intrested') order by joining_date";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				NewTrainingEnquiryDTO newEnquiry = new NewTrainingEnquiryDTO();
				newEnquiry.setTraining_enquiry_enquiry_id(rs
						.getString("enquiry_id"));
				newEnquiry.setTraining_enquiry_fullname(rs
						.getString("full_name"));
				newEnquiry.setTraining_enquiry_father_name(rs
						.getString("father_name"));
				newEnquiry.setTraining_enquiry_qualification(rs
						.getString("qualification"));
				newEnquiry.setTraining_enquiry_referenceId(rs
						.getString("reference_id"));
				newEnquiry.setEnquiry_purpose(rs.getString("purpose"));

				String col = rs.getString("college");
				Statement tst11 = con.createStatement();
				ResultSet trs11 = tst11
						.executeQuery("select * from tbl_college where college_code='"
								+ col + "'");
				String col_name = "";
				if (trs11.next()) {
					col_name = trs11.getString("college_name");
					newEnquiry.setTraining_enquiry_college(col_name);
				} else {
					newEnquiry.setTraining_enquiry_college(col);
				}
				trs11.close();
				tst11.close();

				newEnquiry.setTraining_enquiry_semester(rs
						.getString("semester"));

				Statement tst1 = con.createStatement();
				ResultSet trs1 = tst1
						.executeQuery("select * from tbl_contact where my_id='"
								+ newEnquiry.getTraining_enquiry_enquiry_id()
								+ "'");
				String c_no = "";
				while (trs1.next()) {
					c_no = c_no + trs1.getString("contact_no") + ", ";
				}
				trs1.close();
				tst1.close();
				newEnquiry.setTraining_enquiry_contact_no(c_no);

				Statement tst12 = con.createStatement();
				ResultSet trs12 = tst12
						.executeQuery("select * from tbl_email where my_id='"
								+ newEnquiry.getTraining_enquiry_enquiry_id()
								+ "'");
				String email = "";
				while (trs12.next()) {
					email = email + trs12.getString("email_id") + ", ";
				}
				trs12.close();
				tst12.close();
				newEnquiry.setTraining_enquiry_email_id(email);

				Statement tst2 = con.createStatement(
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet trs2 = tst2
						.executeQuery("select course_name from tbl_cource where course_id in (select course_id from tbl_intrested_course where enquiry_id='"
								+ newEnquiry.getTraining_enquiry_enquiry_id()
								+ "')");

				trs2.last();
				String c_courses[] = new String[trs2.getRow()];
				trs2.beforeFirst();
				int count = 0;
				while (trs2.next()) {
					c_courses[count] = trs2.getString("course_name");
					count++;
				}
				count = 0;
				trs2.close();
				tst2.close();
				newEnquiry.setTraining_enquiry_course(c_courses);

				newEnquiry.setTraining_enquiry_joining_date(rs
						.getString("joining_date"));

				newEnquiry.setTraining_enquiry_preferredtime_start(rs
						.getString("preferred_time_start"));
				newEnquiry.setTraining_enquiry_preferredtime_end(rs
						.getString("preferred_time_end"));

				newEnquiry.setTraining_enquiry_date(rs
						.getString("enquiry_date"));

				Statement tst3 = con.createStatement();
				ResultSet trs3 = tst3
						.executeQuery("select * from tbl_reference where reference_id='"
								+ rs.getString("reference_id") + "'");
				String referenceName = "";
				if (trs3.next()) {
					referenceName = trs3.getString("full_name");
					String reference_contact_no = trs3.getString("contact_no");
					newEnquiry
							.setTraining_enquiry_reference_contact_no(reference_contact_no);
				}
				trs3.close();
				tst3.close();
				newEnquiry.setTraining_enquiry_reference_name(referenceName);

				Statement tst5 = con.createStatement();
				ResultSet trs5 = tst5
						.executeQuery("select * from relation_with_reference where myid='"
								+ newEnquiry.getTraining_enquiry_enquiry_id()
								+ "'");

				if (trs5.next()) {
					String reference_note = trs5.getString("note");

					newEnquiry
							.setTraining_enquiry_reference_note(reference_note);
				}

				trs5.close();
				tst5.close();

				Statement tst4 = con.createStatement();
				ResultSet trs4 = tst4
						.executeQuery("select * from tbl_employee where employee_id='"
								+ rs.getString("employee_id") + "'");
				String employeeName = "";
				if (trs4.next()) {
					employeeName = trs4.getString("full_name");

				}
				trs4.close();
				tst4.close();
				newEnquiry.setEmployee_id(employeeName);
				newEnquiry.setTraining_enquiry_enquiry_status(rs
						.getString("enquiry_status"));

				todayFollowUpList_Active.add(newEnquiry);
			}
			rs.close();
			st.close();

			doj_start = (1900 + date.getYear()) + "-" + (1 + date.getMonth())
					+ "-" + date.getDate();
			MILLIS_IN_DAY = ((1000 * 60 * 60 * 24) * 1);
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			nextDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
			doj_end = nextDate;

			query = "select * from tbl_enquiry where enquiry_id like '"
					+ branchid
					+ "%' and purpose='Training' and joining_date between '2012-01-01' and '"
					+ doj_end
					+ "' and enquiry_status not in ('Joined','Not Intrested') order by joining_date";

			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				NewTrainingEnquiryDTO newEnquiry = new NewTrainingEnquiryDTO();
				newEnquiry.setTraining_enquiry_enquiry_id(rs
						.getString("enquiry_id"));
				newEnquiry.setTraining_enquiry_fullname(rs
						.getString("full_name"));
				newEnquiry.setTraining_enquiry_father_name(rs
						.getString("father_name"));
				newEnquiry.setTraining_enquiry_qualification(rs
						.getString("qualification"));
				newEnquiry.setTraining_enquiry_referenceId(rs
						.getString("reference_id"));
				newEnquiry.setEnquiry_purpose(rs.getString("purpose"));

				String col = rs.getString("college");
				Statement tst11 = con.createStatement();
				ResultSet trs11 = tst11
						.executeQuery("select * from tbl_college where college_code='"
								+ col + "'");
				String col_name = "";
				if (trs11.next()) {
					col_name = trs11.getString("college_name");
					newEnquiry.setTraining_enquiry_college(col_name);
				} else {
					newEnquiry.setTraining_enquiry_college(col);
				}
				trs11.close();
				tst11.close();

				newEnquiry.setTraining_enquiry_semester(rs
						.getString("semester"));

				Statement tst1 = con.createStatement();
				ResultSet trs1 = tst1
						.executeQuery("select * from tbl_contact where my_id='"
								+ newEnquiry.getTraining_enquiry_enquiry_id()
								+ "'");
				String c_no = "";
				while (trs1.next()) {
					c_no = c_no + trs1.getString("contact_no") + ", ";
				}
				trs1.close();
				tst1.close();
				newEnquiry.setTraining_enquiry_contact_no(c_no);

				Statement tst12 = con.createStatement();
				ResultSet trs12 = tst12
						.executeQuery("select * from tbl_email where my_id='"
								+ newEnquiry.getTraining_enquiry_enquiry_id()
								+ "'");
				String email = "";
				while (trs12.next()) {
					email = email + trs12.getString("email_id") + ", ";
				}
				trs12.close();
				tst12.close();
				newEnquiry.setTraining_enquiry_email_id(email);

				Statement tst2 = con.createStatement(
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet trs2 = tst2
						.executeQuery("select course_name from tbl_cource where course_id in (select course_id from tbl_intrested_course where enquiry_id='"
								+ newEnquiry.getTraining_enquiry_enquiry_id()
								+ "')");
				trs2.last();
				String c_courses[] = new String[trs2.getRow()];
				trs2.beforeFirst();
				int count = 0;
				while (trs2.next()) {
					c_courses[count] = trs2.getString("course_name");
					count++;
				}
				count = 0;
				trs2.close();
				tst2.close();
				newEnquiry.setTraining_enquiry_course(c_courses);

				newEnquiry.setTraining_enquiry_joining_date(rs
						.getString("joining_date"));

				newEnquiry.setTraining_enquiry_preferredtime_start(rs
						.getString("preferred_time_start"));
				newEnquiry.setTraining_enquiry_preferredtime_end(rs
						.getString("preferred_time_end"));

				newEnquiry.setTraining_enquiry_date(rs
						.getString("enquiry_date"));

				Statement tst3 = con.createStatement();
				ResultSet trs3 = tst3
						.executeQuery("select * from tbl_reference where reference_id='"
								+ rs.getString("reference_id") + "'");
				String referenceName = "";
				if (trs3.next()) {
					referenceName = trs3.getString("full_name");
					String reference_contact_no = trs3.getString("contact_no");
					newEnquiry
							.setTraining_enquiry_reference_contact_no(reference_contact_no);
				}
				trs3.close();
				tst3.close();
				newEnquiry.setTraining_enquiry_reference_name(referenceName);

				Statement tst5 = con.createStatement();
				ResultSet trs5 = tst5
						.executeQuery("select * from relation_with_reference where myid='"
								+ newEnquiry.getTraining_enquiry_enquiry_id()
								+ "'");
				if (trs5.next()) {
					String reference_note = trs5.getString("note");
					newEnquiry
							.setTraining_enquiry_reference_note(reference_note);
				}

				trs5.close();
				tst5.close();

				Statement tst4 = con.createStatement();
				ResultSet trs4 = tst4
						.executeQuery("select * from tbl_employee where employee_id='"
								+ rs.getString("employee_id") + "'");
				String employeeName = "";
				if (trs4.next()) {
					employeeName = trs4.getString("full_name");

				}
				trs4.close();
				tst4.close();
				newEnquiry.setEmployee_id(employeeName);
				newEnquiry.setTraining_enquiry_enquiry_status(rs
						.getString("enquiry_status"));

				todayFollowUpList_Passive.add(newEnquiry);
			}
			rs.close();
			st.close();

			todayFollowUpList.add(todayFollowUpList_Active);
			todayFollowUpList.add(todayFollowUpList_Passive);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return todayFollowUpList;
	}

	public List<List<NewVisitorEnquiryDTO>> getAllVisitorFollowUp(
			String branchid) throws Exception {

		List<List<NewVisitorEnquiryDTO>> todayFollowUpList = new ArrayList<List<NewVisitorEnquiryDTO>>();
		List<NewVisitorEnquiryDTO> todayFollowUpList_Active = new ArrayList<NewVisitorEnquiryDTO>();
		List<NewVisitorEnquiryDTO> todayFollowUpList_Passive = new ArrayList<NewVisitorEnquiryDTO>();
		long one_day = 1000 * 60 * 60 * 24;
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			Date date = new Date();

			String doj_start = (1900 + date.getYear()) + "-"
					+ (1 + date.getMonth()) + "-" + date.getDate();
			long MILLIS_IN_DAY = (one_day * 7);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String nextDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);

			String doj_end = nextDate;

			String query = "select * from tbl_visitor v,tbl_email e,tbl_contact c where v.visitor_id like '"
					+ branchid
					+ "%' and v.date_of_visit between '"
					+ doj_end
					+ "' and '"
					+ doj_start
					+ "' and v.visitor_id=e.my_id and v.visitor_id=c.my_id and v.status not in ('Joined','Not Intrested') order by v.date_of_visit";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				NewVisitorEnquiryDTO dto = new NewVisitorEnquiryDTO();
				dto.setVisitor_enquiry_enquiry_id(rs.getString("visitor_id"));
				dto.setEmployee_id(rs.getString("employee_id"));
				dto.setEnquiry_purpose(rs.getString("purpose_to_visit"));
				dto.setVisitor_enquiry_address(rs.getString("address"));
				dto.setVisitor_enquiry_appointment_with(rs
						.getString("meet_with"));
				dto.setVisitor_enquiry_date(rs.getString("date_of_visit"));
				dto.setVisitor_enquiry_enquiry_status(rs.getString("status"));
				dto.setVisitor_enquiry_entry_time(rs
						.getString("visiting_time_start"));
				dto.setVisitor_enquiry_fullname(rs.getString("full_name"));
				dto.setVisitor_enquiry_note(rs.getString("note"));
				dto.setVisitor_enquiry_purpose(rs.getString("purpose_to_visit"));
				dto.setVisitor_enquiry_visit_time_end(rs
						.getString("visit_time_end"));
				dto.setVisitor_enquiry_visiting_time_start(rs
						.getString("visiting_time_start"));

				dto.setVisitor_enquiry_email_id(rs.getString("email_id"));
				dto.setVisitor_enquiry_contact_no(rs.getString("contact_no"));

				Statement st1 = con.createStatement();
				ResultSet rs1 = st1
						.executeQuery("select * from relation_with_reference rw,tbl_reference r where rw.myid='"
								+ dto.getVisitor_enquiry_enquiry_id()
								+ "' and rw.reference_id=r.reference_id");
				if (rs1.next()) {
					dto.setVisitor_enquiry_reference_contact_no(rs1
							.getString("contact_no"));
					dto.setVisitor_enquiry_reference_name(rs1
							.getString("full_name"));
					dto.setVisitor_enquiry_reference_note(rs1.getString("note"));
					dto.setVisitor_enquiry_referenceId(rs1
							.getString("rw.reference_id"));
				}
				rs1.close();
				st1.close();

				Statement tst2 = con.createStatement();
				ResultSet trs2 = tst2
						.executeQuery("select * from tbl_employee where employee_id='"
								+ dto.getEmployee_id() + "'");
				String employeeName = "";
				if (trs2.next()) {
					employeeName = trs2.getString("full_name");

				}
				trs2.close();
				tst2.close();
				dto.setEmployee_id(employeeName);

				todayFollowUpList_Active.add(dto);
			}
			rs.close();
			st.close();

			doj_start = (1900 + date.getYear()) + "-" + (1 + date.getMonth())
					+ "-" + date.getDate();

			MILLIS_IN_DAY = (one_day * 31);
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			nextDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
			doj_end = nextDate;

			query = "select * from tbl_visitor v,tbl_email e,tbl_contact c where v.visitor_id like '"
					+ branchid
					+ "%' and v.date_of_visit between '"
					+ doj_end
					+ "' and '"
					+ doj_start
					+ "' and v.visitor_id=e.my_id and v.visitor_id=c.my_id and v.status not in ('Joined','Not Intrested') order by v.date_of_visit";
			System.out.println(query);
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				NewVisitorEnquiryDTO dto = new NewVisitorEnquiryDTO();
				dto.setVisitor_enquiry_enquiry_id(rs.getString("visitor_id"));
				dto.setEmployee_id(rs.getString("employee_id"));
				dto.setEnquiry_purpose(rs.getString("purpose_to_visit"));
				dto.setVisitor_enquiry_address(rs.getString("address"));
				dto.setVisitor_enquiry_appointment_with(rs
						.getString("meet_with"));
				dto.setVisitor_enquiry_date(rs.getString("date_of_visit"));
				dto.setVisitor_enquiry_enquiry_status(rs.getString("status"));
				dto.setVisitor_enquiry_entry_time(rs
						.getString("visiting_time_start"));
				dto.setVisitor_enquiry_fullname(rs.getString("full_name"));
				dto.setVisitor_enquiry_note(rs.getString("note"));
				dto.setVisitor_enquiry_purpose(rs.getString("purpose_to_visit"));
				dto.setVisitor_enquiry_visit_time_end(rs
						.getString("visit_time_end"));
				dto.setVisitor_enquiry_visiting_time_start(rs
						.getString("visiting_time_start"));

				dto.setVisitor_enquiry_email_id(rs.getString("email_id"));
				dto.setVisitor_enquiry_contact_no(rs.getString("contact_no"));

				Statement st1 = con.createStatement();
				ResultSet rs1 = st1
						.executeQuery("select * from relation_with_reference rw,tbl_reference r where rw.myid='"
								+ dto.getVisitor_enquiry_enquiry_id()
								+ "' and rw.reference_id=r.reference_id");
				if (rs1.next()) {
					dto.setVisitor_enquiry_reference_contact_no(rs1
							.getString("contact_no"));
					dto.setVisitor_enquiry_reference_name(rs1
							.getString("full_name"));
					dto.setVisitor_enquiry_reference_note(rs1.getString("note"));
					dto.setVisitor_enquiry_referenceId(rs1
							.getString("rw.reference_id"));
				}
				rs1.close();
				st1.close();

				Statement tst2 = con.createStatement();
				ResultSet trs2 = tst2
						.executeQuery("select * from tbl_employee where employee_id='"
								+ dto.getEmployee_id() + "'");
				String employeeName = "";
				if (trs2.next()) {
					employeeName = trs2.getString("full_name");

				}
				trs2.close();
				tst2.close();
				dto.setEmployee_id(employeeName);

				todayFollowUpList_Passive.add(dto);
			}
			rs.close();
			st.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			todayFollowUpList.add(todayFollowUpList_Active);
			todayFollowUpList.add(todayFollowUpList_Passive);
			con.close();
		}

		return todayFollowUpList;
	}

	public List<List<NewAcademicProjectEnquiryDTO>> getAllAcademicProjectFollowUp(
			String branchid) throws Exception {

		List<List<NewAcademicProjectEnquiryDTO>> todayFollowUpList = new ArrayList<List<NewAcademicProjectEnquiryDTO>>();
		List<NewAcademicProjectEnquiryDTO> todayFollowUpList_Active = new ArrayList<NewAcademicProjectEnquiryDTO>();
		List<NewAcademicProjectEnquiryDTO> todayFollowUpList_Passive = new ArrayList<NewAcademicProjectEnquiryDTO>();

		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			Date date = new Date();

			String doj_start = (1900 + date.getYear()) + "-"
					+ (1 + date.getMonth()) + "-" + date.getDate();
			int MILLIS_IN_DAY = ((1000 * 60 * 60 * 24) * 21);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String nextDate = dateFormat.format(date.getTime() + MILLIS_IN_DAY);

			String doj_end = nextDate;

			String query = "select * from tbl_enquiry e,tbl_academic_project a where e.enquiry_id like '"
					+ branchid
					+ "%' and e.purpose='Academic Project' and e.enquiry_id=a.enquiry_id and a.delivery_date between '"
					+ doj_start
					+ "' and '"
					+ doj_end
					+ "' and e.enquiry_status not in ('Joined','Not Intrested') order by delivery_date";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				NewAcademicProjectEnquiryDTO newEnquiry = new NewAcademicProjectEnquiryDTO();
				newEnquiry.setAcademic_project_enquiry_enquiry_id(rs
						.getString("e.enquiry_id"));

				newEnquiry.setAcademic_project_enquiry_fullname(rs
						.getString("e.full_name"));
				newEnquiry.setAcademic_project_enquiry_father_name(rs
						.getString("e.father_name"));
				newEnquiry.setAcademic_project_enquiry_qualification(rs
						.getString("e.qualification"));
				newEnquiry.setAcademic_project_enquiry_referenceId(rs
						.getString("e.reference_id"));
				newEnquiry.setEnquiry_purpose(rs.getString("e.purpose"));

				newEnquiry.setAcademic_project_enquiry_project_name(rs
						.getString("a.project_name"));
				newEnquiry.setAcademic_project_enquiry_description(rs
						.getString("project_description"));

				String col = rs.getString("e.college");
				Statement tst11 = con.createStatement();
				ResultSet trs11 = tst11
						.executeQuery("select * from tbl_college where college_code='"
								+ col + "'");
				String col_name = "";
				if (trs11.next()) {
					col_name = trs11.getString("college_name");
					newEnquiry.setAcademic_project_enquiry_college(col_name);
				} else {
					newEnquiry.setAcademic_project_enquiry_college(col);
				}
				trs11.close();
				tst11.close();

				newEnquiry.setAcademic_project_enquiry_semester(rs
						.getString("e.semester"));

				Statement tst1 = con.createStatement();
				ResultSet trs1 = tst1
						.executeQuery("select * from tbl_contact where my_id='"
								+ newEnquiry
										.getAcademic_project_enquiry_enquiry_id()
								+ "'");
				String c_no = "";
				while (trs1.next()) {
					c_no = c_no + trs1.getString("contact_no") + ", ";
				}
				trs1.close();
				tst1.close();
				newEnquiry.setAcademic_project_enquiry_contact_no(c_no);

				Statement tst12 = con.createStatement();
				ResultSet trs12 = tst12
						.executeQuery("select * from tbl_email where my_id='"
								+ newEnquiry
										.getAcademic_project_enquiry_enquiry_id()
								+ "'");
				String email = "";
				while (trs12.next()) {
					email = email + trs12.getString("email_id") + ", ";
				}
				trs12.close();
				tst12.close();
				newEnquiry.setAcademic_project_enquiry_email_id(email);
				/*
				 * Statement
				 * tst2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE
				 * ,ResultSet.CONCUR_UPDATABLE); ResultSet
				 * trs2=tst2.executeQuery(
				 * "select course_name from tbl_cource where course_id in (select course_id from tbl_intrested_course where enquiry_id='"
				 * +newEnquiry.getAcademic_project_enquiry_enquiry_id()+"')");
				 * 
				 * trs2.last(); String c_courses[]=new String[trs2.getRow()];
				 * trs2.beforeFirst(); int count=0; while(trs2.next()){
				 * c_courses[count]=trs2.getString("course_name"); count++; }
				 * count=0; trs2.close(); tst2.close();
				 * newEnquiry.setAcademic_project_enquiry_course(c_courses);
				 */
				newEnquiry.setAcademic_project_enquiry_delivery_date(rs
						.getString("a.delivery_date"));

				newEnquiry.setAcademic_project_enquiry_date(rs
						.getString("e.enquiry_date"));

				Statement tst3 = con.createStatement();
				ResultSet trs3 = tst3
						.executeQuery("select * from tbl_reference where reference_id='"
								+ rs.getString("reference_id") + "'");
				String referenceName = "";
				if (trs3.next()) {
					referenceName = trs3.getString("full_name");
					String reference_contact_no = trs3.getString("contact_no");
					newEnquiry
							.setAcademic_project_enquiry_reference_contact_no(reference_contact_no);
				}
				trs3.close();
				tst3.close();
				newEnquiry
						.setAcademic_project_enquiry_reference_name(referenceName);

				Statement tst5 = con.createStatement();
				ResultSet trs5 = tst5
						.executeQuery("select * from relation_with_reference where reference_id='"
								+ newEnquiry
										.getAcademic_project_enquiry_enquiry_id()
								+ "'");
				if (trs5.next()) {
					String reference_note = trs5.getString("note");
					newEnquiry
							.setAcademic_project_enquiry_reference_contact_no(reference_note);
				}
				trs5.close();
				tst5.close();

				Statement tst4 = con.createStatement();
				ResultSet trs4 = tst4
						.executeQuery("select * from tbl_employee where employee_id='"
								+ rs.getString("employee_id") + "'");
				String employeeName = "";
				if (trs4.next()) {
					employeeName = trs4.getString("full_name");

				}
				trs4.close();
				tst4.close();
				newEnquiry.setEmployee_id(employeeName);
				newEnquiry.setAcademic_project_enquiry_enquiry_status(rs
						.getString("e.enquiry_status"));

				todayFollowUpList_Active.add(newEnquiry);
			}
			rs.close();
			st.close();

			doj_start = (1900 + date.getYear()) + "-" + (1 + date.getMonth())
					+ "-" + date.getDate();
			MILLIS_IN_DAY = ((1000 * 60 * 60 * 24) * 1);
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			nextDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
			doj_end = nextDate;

			query = "select * from tbl_enquiry e,tbl_academic_project a where e.enquiry_id like '"
					+ branchid
					+ "%' and e.purpose='Academic Project' and e.enquiry_id=a.enquiry_id and a.delivery_date between '2012-01-01' and '"
					+ doj_end
					+ "' and e.enquiry_status not in ('Joined','Not Intrested') order by delivery_date";

			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				NewAcademicProjectEnquiryDTO newEnquiry = new NewAcademicProjectEnquiryDTO();
				newEnquiry.setAcademic_project_enquiry_enquiry_id(rs
						.getString("e.enquiry_id"));
				newEnquiry.setAcademic_project_enquiry_fullname(rs
						.getString("e.full_name"));
				newEnquiry.setAcademic_project_enquiry_father_name(rs
						.getString("e.father_name"));
				newEnquiry.setAcademic_project_enquiry_qualification(rs
						.getString("e.qualification"));
				newEnquiry.setAcademic_project_enquiry_referenceId(rs
						.getString("e.reference_id"));
				newEnquiry.setEnquiry_purpose(rs.getString("e.purpose"));

				newEnquiry.setAcademic_project_enquiry_project_name(rs
						.getString("a.project_name"));
				newEnquiry.setAcademic_project_enquiry_description(rs
						.getString("project_description"));

				String col = rs.getString("e.college");
				Statement tst11 = con.createStatement();
				ResultSet trs11 = tst11
						.executeQuery("select * from tbl_college where college_code='"
								+ col + "'");
				String col_name = "";
				if (trs11.next()) {
					col_name = trs11.getString("college_name");
					newEnquiry.setAcademic_project_enquiry_college(col_name);
				} else {
					newEnquiry.setAcademic_project_enquiry_college(col);
				}
				trs11.close();
				tst11.close();

				newEnquiry.setAcademic_project_enquiry_semester(rs
						.getString("e.semester"));

				Statement tst1 = con.createStatement();
				ResultSet trs1 = tst1
						.executeQuery("select * from tbl_contact where my_id='"
								+ newEnquiry
										.getAcademic_project_enquiry_enquiry_id()
								+ "'");
				String c_no = "";
				while (trs1.next()) {
					c_no = c_no + trs1.getString("contact_no") + ", ";
				}
				trs1.close();
				tst1.close();
				newEnquiry.setAcademic_project_enquiry_contact_no(c_no);

				Statement tst12 = con.createStatement();
				ResultSet trs12 = tst12
						.executeQuery("select * from tbl_email where my_id='"
								+ newEnquiry
										.getAcademic_project_enquiry_enquiry_id()
								+ "'");
				String email = "";
				while (trs12.next()) {
					email = email + trs12.getString("email_id") + ", ";
				}
				trs12.close();
				tst12.close();
				newEnquiry.setAcademic_project_enquiry_email_id(email);
				/*
				 * Statement
				 * tst2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE
				 * ,ResultSet.CONCUR_UPDATABLE); ResultSet
				 * trs2=tst2.executeQuery(
				 * "select course_name from tbl_cource where course_id in (select course_id from tbl_intrested_course where enquiry_id='"
				 * +newEnquiry.getAcademic_project_enquiry_enquiry_id()+"')");
				 * 
				 * trs2.last(); String c_courses[]=new String[trs2.getRow()];
				 * trs2.beforeFirst(); int count=0; while(trs2.next()){
				 * c_courses[count]=trs2.getString("course_name"); count++; }
				 * count=0; trs2.close(); tst2.close();
				 * newEnquiry.setAcademic_project_enquiry_course(c_courses);
				 */
				newEnquiry.setAcademic_project_enquiry_delivery_date(rs
						.getString("a.delivery_date"));

				newEnquiry.setAcademic_project_enquiry_date(rs
						.getString("e.enquiry_date"));

				Statement tst3 = con.createStatement();
				ResultSet trs3 = tst3
						.executeQuery("select * from tbl_reference where reference_id='"
								+ rs.getString("reference_id") + "'");
				String referenceName = "";
				if (trs3.next()) {
					referenceName = trs3.getString("full_name");
					String reference_contact_no = trs3.getString("contact_no");
					newEnquiry
							.setAcademic_project_enquiry_reference_contact_no(reference_contact_no);
				}
				trs3.close();
				tst3.close();
				newEnquiry
						.setAcademic_project_enquiry_reference_name(referenceName);

				Statement tst5 = con.createStatement();
				ResultSet trs5 = tst5
						.executeQuery("select * from relation_with_reference where reference_id='"
								+ newEnquiry
										.getAcademic_project_enquiry_enquiry_id()
								+ "'");
				if (trs5.next()) {
					String reference_note = trs5.getString("note");
					newEnquiry
							.setAcademic_project_enquiry_reference_contact_no(reference_note);
				}
				trs5.close();
				tst5.close();

				Statement tst4 = con.createStatement();
				ResultSet trs4 = tst4
						.executeQuery("select * from tbl_employee where employee_id='"
								+ rs.getString("employee_id") + "'");
				String employeeName = "";
				if (trs4.next()) {
					employeeName = trs4.getString("full_name");

				}
				trs4.close();
				tst4.close();
				newEnquiry.setEmployee_id(employeeName);
				newEnquiry.setAcademic_project_enquiry_enquiry_status(rs
						.getString("e.enquiry_status"));

				todayFollowUpList_Passive.add(newEnquiry);
			}
			rs.close();
			st.close();

			todayFollowUpList.add(todayFollowUpList_Active);
			todayFollowUpList.add(todayFollowUpList_Passive);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

		return todayFollowUpList;
	}

	public List<List<NewEnquiry>> getAllFollowUp(String branchid)
			throws Exception {
		List<List<NewEnquiry>> todayFollowUpList = new ArrayList<List<NewEnquiry>>();
		List<NewEnquiry> todayFollowUpList_Active = new ArrayList<NewEnquiry>();
		List<NewEnquiry> todayFollowUpList_Passive = new ArrayList<NewEnquiry>();

		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			Date date = new Date();

			// String
			// c_date=(1900+date.getYear())+"-"+(1+date.getMonth())+"-"+date.getDate();
			String doj_start = (1900 + date.getYear()) + "-"
					+ (1 + date.getMonth()) + "-" + date.getDate();
			int MILLIS_IN_DAY = ((1000 * 60 * 60 * 24) * 21);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String nextDate = dateFormat.format(date.getTime() + MILLIS_IN_DAY);

			String doj_end = nextDate;

			String query = "select * from tbl_enquiry where enquiry_id like '"
					+ branchid
					+ "%' and purpose='Training' and joining_date between '"
					+ doj_start
					+ "' and '"
					+ doj_end
					+ "' and enquiry_status not in ('Joined','Not Intrested') order by joining_date";

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				NewEnquiry newEnquiry = new NewEnquiry();
				newEnquiry.setEnquiry_id(rs.getString("enquiry_id"));
				newEnquiry.setFullname(rs.getString("full_name"));
				newEnquiry.setFather_name(rs.getString("father_name"));
				newEnquiry.setQualification(rs.getString("qualification"));
				newEnquiry.setReferenceId(rs.getString("reference_id"));
				newEnquiry.setPurpose(rs.getString("purpose"));

				String col = rs.getString("college");
				Statement tst11 = con.createStatement();
				ResultSet trs11 = tst11
						.executeQuery("select * from tbl_college where college_code='"
								+ col + "'");

				String col_name = "";
				if (trs11.next()) {
					col_name = trs11.getString("college_name");
					newEnquiry.setCollege(col_name);
				} else {
					newEnquiry.setCollege(col);
				}
				trs11.close();
				tst11.close();

				newEnquiry.setSemester(rs.getString("semester"));

				Statement tst1 = con.createStatement();
				ResultSet trs1 = tst1
						.executeQuery("select * from tbl_contact where my_id='"
								+ newEnquiry.getEnquiry_id() + "'");
				String c_no = "";
				while (trs1.next()) {

					c_no = c_no + trs1.getString("contact_no") + ", ";
				}
				trs1.close();
				tst1.close();
				newEnquiry.setContact_no(c_no);

				Statement tst12 = con.createStatement();
				ResultSet trs12 = tst12
						.executeQuery("select * from tbl_email where my_id='"
								+ newEnquiry.getEnquiry_id() + "'");
				String email = "";
				while (trs12.next()) {
					email = email + trs12.getString("email_id") + ", ";
				}
				trs12.close();
				tst12.close();
				newEnquiry.setEmail_id(email);

				Statement tst2 = con.createStatement(
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet trs2 = tst2
						.executeQuery("select course_name from tbl_cource where course_id in (select course_id from tbl_intrested_course where enquiry_id='"
								+ newEnquiry.getEnquiry_id() + "')");
				trs2.last();
				String c_courses[] = new String[trs2.getRow()];
				trs2.beforeFirst();
				int count = 0;
				while (trs2.next()) {

					c_courses[count] = trs2.getString("course_name");
					count++;
				}
				count = 0;
				trs2.close();
				tst2.close();
				newEnquiry.setCourse(c_courses);

				newEnquiry.setJoining_date(rs.getString("joining_date"));

				newEnquiry.setPreferredtime_start(rs
						.getString("preferred_time_start"));
				newEnquiry.setPreferredtime_end(rs
						.getString("preferred_time_end"));

				newEnquiry.setEnquiry_date(rs.getString("enquiry_date"));

				Statement tst3 = con.createStatement();
				ResultSet trs3 = tst3
						.executeQuery("select * from tbl_reference where reference_id='"
								+ rs.getString("reference_id") + "'");
				String referenceName = "";
				if (trs3.next()) {

					referenceName = trs3.getString("full_name");
					String reference_contact_no = trs3.getString("contact_no");
					String reference_note = trs3.getString("some_note");
					newEnquiry.setReference_contact_no(reference_contact_no);
					newEnquiry.setReference_note(reference_note);
				}
				trs3.close();
				tst3.close();
				newEnquiry.setReference_name(referenceName);

				Statement tst4 = con.createStatement();
				ResultSet trs4 = tst4
						.executeQuery("select * from tbl_employee where employee_id='"
								+ rs.getString("employee_id") + "'");
				String employeeName = "";
				if (trs4.next()) {
					employeeName = trs4.getString("full_name");

				}
				trs4.close();
				tst4.close();
				newEnquiry.setEmployee_id(employeeName);
				newEnquiry.setEnquiry_status(rs.getString("enquiry_status"));

				todayFollowUpList_Active.add(newEnquiry);
			}
			rs.close();
			st.close();

			doj_start = (1900 + date.getYear()) + "-" + (1 + date.getMonth())
					+ "-" + date.getDate();
			MILLIS_IN_DAY = ((1000 * 60 * 60 * 24) * 1);
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			nextDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
			doj_end = nextDate;

			query = "select * from tbl_enquiry where enquiry_id like '"
					+ branchid
					+ "%' and purpose='Training' and joining_date between '2012-01-01' and '"
					+ doj_end
					+ "' and enquiry_status not in ('Joined','Not Intrested') order by joining_date";
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {

				NewEnquiry newEnquiry = new NewEnquiry();
				newEnquiry.setEnquiry_id(rs.getString("enquiry_id"));
				newEnquiry.setFullname(rs.getString("full_name"));
				newEnquiry.setFather_name(rs.getString("father_name"));
				newEnquiry.setQualification(rs.getString("qualification"));
				newEnquiry.setReferenceId(rs.getString("reference_id"));
				newEnquiry.setPurpose(rs.getString("purpose"));

				String col = rs.getString("college");
				Statement tst11 = con.createStatement();
				ResultSet trs11 = tst11
						.executeQuery("select * from tbl_college where college_code='"
								+ col + "'");
				String col_name = "";
				if (trs11.next()) {
					col_name = trs11.getString("college_name");
					newEnquiry.setCollege(col_name);
				} else {
					newEnquiry.setCollege(col);
				}
				trs11.close();
				tst11.close();

				newEnquiry.setSemester(rs.getString("semester"));

				Statement tst1 = con.createStatement();
				ResultSet trs1 = tst1
						.executeQuery("select * from tbl_contact where my_id='"
								+ newEnquiry.getEnquiry_id() + "'");
				String c_no = "";
				while (trs1.next()) {
					c_no = c_no + trs1.getString("contact_no") + ", ";
				}
				trs1.close();
				tst1.close();
				newEnquiry.setContact_no(c_no);

				Statement tst12 = con.createStatement();
				ResultSet trs12 = tst12
						.executeQuery("select * from tbl_email where my_id='"
								+ newEnquiry.getEnquiry_id() + "'");
				String email = "";
				while (trs12.next()) {

					email = email + trs12.getString("email_id") + ", ";
				}
				trs12.close();
				tst12.close();
				newEnquiry.setEmail_id(email);

				Statement tst2 = con.createStatement(
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet trs2 = tst2
						.executeQuery("select course_name from tbl_cource where course_id in (select course_id from tbl_intrested_course where enquiry_id='"
								+ newEnquiry.getEnquiry_id() + "')");
				trs2.last();
				String c_courses[] = new String[trs2.getRow()];
				trs2.beforeFirst();
				int count = 0;
				while (trs2.next()) {
					c_courses[count] = trs2.getString("course_name");
					count++;
				}
				count = 0;
				trs2.close();
				tst2.close();
				newEnquiry.setCourse(c_courses);

				newEnquiry.setJoining_date(rs.getString("joining_date"));

				newEnquiry.setPreferredtime_start(rs
						.getString("preferred_time_start"));
				newEnquiry.setPreferredtime_end(rs
						.getString("preferred_time_end"));

				newEnquiry.setEnquiry_date(rs.getString("enquiry_date"));

				Statement tst3 = con.createStatement();
				ResultSet trs3 = tst3
						.executeQuery("select * from tbl_reference where reference_id='"
								+ rs.getString("reference_id") + "'");
				String referenceName = "";
				if (trs3.next()) {
					referenceName = trs3.getString("full_name");
					String reference_contact_no = trs3.getString("contact_no");
					String reference_note = trs3.getString("some_note");
					newEnquiry.setReference_contact_no(reference_contact_no);
					newEnquiry.setReference_note(reference_note);
				}
				trs3.close();
				tst3.close();
				newEnquiry.setReference_name(referenceName);

				Statement tst4 = con.createStatement();
				ResultSet trs4 = tst4
						.executeQuery("select * from tbl_employee where employee_id='"
								+ rs.getString("employee_id") + "'");
				String employeeName = "";
				if (trs4.next()) {
					employeeName = trs4.getString("full_name");

				}
				trs4.close();
				tst4.close();
				newEnquiry.setEmployee_id(employeeName);
				newEnquiry.setEnquiry_status(rs.getString("enquiry_status"));

				todayFollowUpList_Passive.add(newEnquiry);
			}
			rs.close();
			st.close();

			todayFollowUpList.add(todayFollowUpList_Active);
			todayFollowUpList.add(todayFollowUpList_Passive);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return todayFollowUpList;
	}

	public static void main(String args[]) throws Exception {
		// new EnquiryDAO().getAllFollowUp("INDMPINDBTDC");
	}
}
