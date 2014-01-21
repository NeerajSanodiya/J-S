package com.js.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

import com.js.dto.Employee;
import com.js.dto.NewEnquiry;
import com.js.dto.NewTrainingEnquiryDTO;
import com.js.dto.TrainingRegistrationDTO;

public class TrainingRegistrationDAO {
	public String saveTraningRegistration(TrainingRegistrationDTO registration,
			HttpServletRequest request, FileItem fi,String path) throws Exception {
		long registration_id_long = 0;
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from tbl_counter");
			if (rs.next()) {
				registration_id_long = rs.getLong("tra_id");
			}
			rs.close();
			st.close();

			String dob = registration.getDate_of_birth();
			System.out.println(dob);
			dob = dob.replaceAll("/", "-");
			StringTokenizer stringTokenizer = new StringTokenizer(dob, "-");
			String mm = stringTokenizer.nextToken();
			String dd = stringTokenizer.nextToken();
			String yy = stringTokenizer.nextToken();
			dob = yy + "-" + mm + "-" + dd;
			registration.setDate_of_birth(dob);

			String base = registration.getEmployee_id().substring(0, 12);
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
			String enq_id = "" + registration_id_long;
			counter = counter
					.substring(0, (counter.length() - enq_id.length()));
			counter = counter + enq_id;

			base = base + "TRA" + fdate + fmonth + fyear;
			String registration_id = base + counter;

			registration.setRegistration_id(registration_id);


			String fileName = fi.getName();
            String extention=fileName.substring(fileName.lastIndexOf("."));            
            File f1 = new File(path);
            File f2 = f1.getParentFile();
            File f3 = f2.getParentFile();
            File f4 = new File(f3, "web/allempimages");
            f4.mkdirs();
            File file=new File(f4, registration.getRegistration_id()
					+ "." + fileName.substring(fileName.lastIndexOf(".") + 1));
           
			
			
			st = con.createStatement();

			st = con.createStatement();
			String query = "insert into tbl_registration(registration_id,enquiry_id,reg_date,address,date_of_birth,enrollment_no,batch_time_start,batch_time_end,photo_path,employee_id,total_amount,discount_amount,discount_detail,register_for_course) values ('"
					+ registration.getRegistration_id()
					+ "','"
					+ registration.getEnquiry_id()
					+ "','"
					+ registration.getReg_date()
					+ "','"
					+ registration.getAddress()
					+ "','"
					+ registration.getDate_of_birth()
					+ "','"
					+ registration.getEnrollment_no()
					+ "','"
					+ registration.getBatch_time_start()
					+ "','"
					+ registration.getBatch_time_end()
					+ "','"
					+ registration.getPhoto_path()
					+ "','"
					+ registration.getEmployee_id()
					+ "','"
					+ registration.getTotal_amount()
					+ "','"
					+ registration.getDiscount_amount()
					+ "','"
					+ registration.getDiscount_detail()
					+ "','"
					+ registration.getRegisterForCourse() + "')";
			System.out.println(query);
			st.executeUpdate(query);
			st.close();

			st = con.createStatement();
			query = "update tbl_enquiry set enquiry_status='Joined' where enquiry_id='"
					+ registration.getEnquiry_id() + "'";
			System.out.println(query);
			st.executeUpdate(query);
			st.close();

			fi.write(file);

			registration_id_long++;
			st = con.createStatement();
			st.executeUpdate("update tbl_counter set tra_id="
					+ registration_id_long + " where myid=1");
			st.close();
			ret = "success";

			con.commit();
		} catch (Exception e) {
			ret = "Data error";
			e.printStackTrace();
		} finally {
			con.close();
		}
		return ret;
	}
	public List<List<String>> getAcademicProjectRegistationAllFollowUp(String branchid)
			throws Exception {
		List<List<String>> todayFollowUpList = new ArrayList<List<String>>();
		List<String> activeList = new ArrayList<String>();
		List<String> passiveList = new ArrayList<String>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			Date date = new Date();

			String doj_end = (1900 + date.getYear()) + "-"
					+ (1 + date.getMonth()) + "-" + date.getDate();
			long MILLIS_IN_DAY = MILLIS_IN_DAY = (long) 1000 * 60 * 60 * 24 * 15;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String nextDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);

			String doj_start = nextDate;

			String query = "select registration_id from tbl_registration where registration_id like '"
					+ branchid
					+ "%' and reg_date between '"
					+ doj_start
					+ "' and '" + doj_end + "' order by reg_date";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				activeList.add(rs.getString(1));
			}
			rs.close();
			st.close();

			doj_end = (1900 + date.getYear()) + "-"
					+ (1 + date.getMonth()) + "-" + date.getDate();
			MILLIS_IN_DAY = (long) 1000 * 60 * 60 * 24 * 90;
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			nextDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
			doj_start = nextDate;

			query = "select registration_id from tbl_registration where registration_id like '"
					+ branchid
					+ "%' and reg_date between '"
					+ doj_start
					+ "' and '" + doj_end + "' order by reg_date";
			System.out.println(query);
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				passiveList.add(rs.getString(1));
			}
			rs.close();
			st.close();
			todayFollowUpList.add(0, activeList);
			todayFollowUpList.add(1, passiveList);
		} finally {
			con.close();
		}
		return todayFollowUpList;
	}
	public List<List<String>> getTrainningRegistationAllFollowUp(String branchid)
			throws Exception {
		List<List<String>> todayFollowUpList = new ArrayList<List<String>>();
		List<String> activeList = new ArrayList<String>();
		List<String> passiveList = new ArrayList<String>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			Date date = new Date();

			String doj_end = (1900 + date.getYear()) + "-"
					+ (1 + date.getMonth()) + "-" + date.getDate();
			long MILLIS_IN_DAY = MILLIS_IN_DAY = (long) 1000 * 60 * 60 * 24 * 15;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String nextDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);

			String doj_start = nextDate;

			String query = "select registration_id from tbl_registration where registration_id like '"
					+ branchid
					+ "%' and reg_date between '"
					+ doj_start
					+ "' and '" + doj_end + "' order by reg_date";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				activeList.add(rs.getString(1));
			}
			rs.close();
			st.close();

			doj_end = (1900 + date.getYear()) + "-"
					+ (1 + date.getMonth()) + "-" + date.getDate();
			MILLIS_IN_DAY = (long) 1000 * 60 * 60 * 24 * 90;
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			nextDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
			doj_start = nextDate;

			query = "select registration_id from tbl_registration where registration_id like '"
					+ branchid
					+ "%' and reg_date between '"
					+ doj_start
					+ "' and '" + doj_end + "' order by reg_date";
			System.out.println(query);
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				passiveList.add(rs.getString(1));
			}
			rs.close();
			st.close();
			todayFollowUpList.add(0, activeList);
			todayFollowUpList.add(1, passiveList);
		} finally {
			con.close();
		}
		return todayFollowUpList;
	}
	public String getRegistrationIdByEnquiryId(String enqId)
			throws Exception {
		String id="NO";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			String query = "select registration_id from tbl_registration where enquiry_id='"
					+ enqId + "'";
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				id=rs.getString("registration_id");
			}
			rs.close();
			rs.close();
		}finally{			
			con.close();
		}
		return id;
	}
	public TrainingRegistrationDTO getRegistration(String regId)
			throws Exception {
		TrainingRegistrationDTO dto = new TrainingRegistrationDTO();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			String query = "select * from tbl_registration r where registration_id='"
					+ regId + "'";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				dto.setAddress(rs.getString("r.address"));
				dto.setBatch_time_end(rs.getString("r.batch_time_end"));
				dto.setBatch_time_start(rs.getString("r.batch_time_start"));
				dto.setDate_of_birth(rs.getString("r.date_of_birth"));
				dto.setDiscount_amount(rs.getInt("r.discount_amount"));
				dto.setDiscount_detail(rs.getString("r.discount_detail"));
				dto.setEnquiry_id(rs.getString("r.enquiry_id"));
				dto.setReg_employee_id(rs.getString("r.employee_id"));
				dto.setEnrollment_no(rs.getString("r.enrollment_no"));
				dto.setPhoto_path(rs.getString("r.photo_path"));
				dto.setRegistration_id(rs.getString("r.registration_id"));
				dto.setReg_date(rs.getString("r.reg_date"));
				dto.setRegisterForCourse(rs.getString("r.register_for_course"));
				dto.setTotal_amount(rs.getInt("r.total_amount"));

				Statement st1 = con.createStatement();
				ResultSet rs1 = st1
						.executeQuery("Select * from tbl_enquiry where enquiry_id='"
								+ dto.getEnquiry_id() + "'");
				if (rs1.next()) {
					dto.setFather_name(rs1.getString("father_name"));
					dto.setFullname(rs1.getString("full_name"));
					dto.setQualification(rs1.getString("qualification"));
					dto.setReferenceId(rs1.getString("reference_id"));
					dto.setCollege(rs1.getString("college"));
					dto.setSemester(rs1.getString("semester"));
					dto.setEmployee_id(rs1.getString("employee_id"));
				}
				st1.close();
				rs1.close();

				Statement tst11 = con.createStatement();
				ResultSet trs11 = tst11
						.executeQuery("select * from tbl_college where college_code='"
								+ dto.getCollege() + "'");				
				if (trs11.next()) {
					dto.setCollege(trs11.getString("college_name"));
				}
				trs11.close();
				tst11.close();
				
				
				st1 = con.createStatement();
				rs1 = st1
						.executeQuery("Select * from tbl_contact where my_id='"
								+ dto.getEnquiry_id() + "'");
				if (rs1.next()) {
					dto.setContact_no(rs1.getString("contact_no"));
				}
				st1.close();
				rs1.close();
				
				st1 = con.createStatement();
				rs1 = st1
						.executeQuery("Select * from tbl_cource where course_id='"
								+ dto.getRegisterForCourse()+ "'");
				if (rs1.next()) {
					dto.setRegisterForCourse(rs1.getString("course_name"));
				}
				st1.close();
				rs1.close();

				st1 = con.createStatement();
				rs1 = st1.executeQuery("Select * from tbl_email where my_id='"
						+ dto.getEnquiry_id() + "'");
				if (rs1.next()) {
					dto.setEmail_id(rs1.getString("email_id"));
				}
				st1.close();
				rs1.close();

				st1 = con.createStatement();
				rs1 = st1
						.executeQuery("Select * from tbl_reference where reference_id='"
								+ dto.getReferenceId() + "'");
				if (rs1.next()) {
					dto.setReference_contact_no(rs1.getString("contact_no"));
					dto.setReference_name(rs1.getString("full_name"));
					dto.setReference_note(rs1.getString("some_note"));
				}
				st1.close();
				rs1.close();
				
				Statement tst5 = con.createStatement();
				ResultSet trs5 = tst5
						.executeQuery("select * from relation_with_reference where reference_id='"
								+ dto
										.getReferenceId()
								+ "'");
				if (trs5.next()) {
					String reference_note = trs5.getString("note");
					dto.setReference_note(reference_note);					
				}
				trs5.close();
				tst5.close();
				
				String eName = new EmployeeDAO().getEmployeeDetailByEmployeeId(
						new Employee(dto.getReg_employee_id())).getFull_name();
				dto.setReg_employee_id(eName);
			}
		} finally {
			con.close();
		}
		return dto;
	}
	public static void main(String asd[]){
		Date date=new Date();
		String doj_end = (1900 + date.getYear()) + "-"
				+ (1 + date.getMonth()) + "-" + date.getDate();
		Long MILLIS_IN_DAY = (long) 1000 * 60 * 60 * 24 * 90;
			
		date = new Date(date.getTime()-MILLIS_IN_DAY);
		doj_end = (1900 + date.getYear()) + "-"
				+ (1 + date.getMonth()) + "-" + date.getDate();
		System.out.println(doj_end);
	}
}
