package com.js.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.js.dto.Payment;
import com.js.dto.TrainingRegistrationDTO;

public class PaymentDAO {
	public List searchResultForMakePayment(String code, String fullName,
			String source, String branchid, String employeeid) throws Exception {
		Connection con = null;
		List candidateList = new ArrayList();
		// System.out.println("Code : "+code);
		// System.out.println("Full Name : "+fullName);
		// System.out.println("Soure : "+source);
		String query = "select * from ";
		if (!source.equalsIgnoreCase("Select")) {
			if (source.contains("Training")) {
				query = query + " tbl_enquiry where enquiry_id like '"
						+ branchid + "%'";
				if (!code.equalsIgnoreCase("")) {
					query = query
							+ " and enquiry_id in (select enquiry_id from tbl_registration where registration_id like '%"
							+ code + "%')";
				}
				if (!fullName.equalsIgnoreCase("")) {
					query = query + " and full_name like '%" + fullName + "%'";
				}
				try {
					con = new com.js.db.MyConnection().getConnection();
					Statement st = con.createStatement();
					// System.out.println("Query : "+query);
					ResultSet rs = st.executeQuery(query);
					while (rs.next()) {
						TrainingRegistrationDTO trainingRegistrationDTO = new TrainingRegistrationDTO();
						trainingRegistrationDTO.setEnquiry_id(rs
								.getString("enquiry_id"));
						trainingRegistrationDTO.setFullname(rs
								.getString("full_name"));
						trainingRegistrationDTO.setFather_name(rs
								.getString("father_name"));
						trainingRegistrationDTO.setQualification(rs
								.getString("qualification"));
						trainingRegistrationDTO.setSemester(rs
								.getString("semester"));
						trainingRegistrationDTO.setPreferredtime_start(rs
								.getString("preferred_time_start"));
						trainingRegistrationDTO.setJoining_date(rs
								.getString("joining_date"));
						trainingRegistrationDTO.setReferenceId(rs
								.getString("reference_id"));
						trainingRegistrationDTO.setEmployee_id(rs
								.getString("employee_id"));
						trainingRegistrationDTO.setEnquiry_status(rs
								.getString("enquiry_status"));
						trainingRegistrationDTO.setPreferredtime_end(rs
								.getString("preferred_time_end"));
						trainingRegistrationDTO.setEnquiry_date(rs
								.getString("enquiry_date"));

						String col = rs.getString("college");
						Statement tst11 = con.createStatement();
						ResultSet trs11 = tst11
								.executeQuery("select * from tbl_college where college_code='"
										+ col + "'");
						String col_name = "";
						if (trs11.next()) {
							col_name = trs11.getString("college_name");
							trainingRegistrationDTO.setCollege(col_name);
						} else {
							trainingRegistrationDTO.setCollege(col);
						}
						trs11.close();
						tst11.close();

						Statement tst1 = con.createStatement();
						ResultSet trs1 = tst1
								.executeQuery("select * from tbl_contact where my_id='"
										+ trainingRegistrationDTO
												.getEnquiry_id() + "'");
						String c_no = "";
						while (trs1.next()) {
							c_no = c_no + trs1.getString("contact_no") + ", ";
						}
						trs1.close();
						tst1.close();
						trainingRegistrationDTO.setContact_no(c_no);

						Statement tst12 = con.createStatement();
						ResultSet trs12 = tst12
								.executeQuery("select * from tbl_email where my_id='"
										+ trainingRegistrationDTO
												.getEnquiry_id() + "'");
						String email = "";
						while (trs12.next()) {
							email = email + trs12.getString("email_id") + ", ";
						}
						trs12.close();
						tst12.close();
						trainingRegistrationDTO.setEmail_id(email);

						Statement tst2 = con.createStatement(
								ResultSet.TYPE_SCROLL_SENSITIVE,
								ResultSet.CONCUR_UPDATABLE);
						ResultSet trs2 = tst2
								.executeQuery("select course_name from tbl_cource where course_id in (select course_id from tbl_intrested_course where enquiry_id='"
										+ trainingRegistrationDTO
												.getEnquiry_id() + "')");
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
						trainingRegistrationDTO.setCourse(c_courses);

						Statement tst3 = con.createStatement();
						ResultSet trs3 = tst3
								.executeQuery("select * from tbl_reference where reference_id='"
										+ trainingRegistrationDTO
												.getEnquiry_id() + "'");
						String referenceName = "";
						if (trs3.next()) {
							referenceName = trs3.getString("full_name");
							String reference_contact_no = trs3
									.getString("contact_no");
							String reference_note = trs3.getString("some_note");
							trainingRegistrationDTO
									.setReference_name(referenceName);
							trainingRegistrationDTO
									.setReference_contact_no(reference_contact_no);
							trainingRegistrationDTO
									.setReference_note(reference_note);

						}
						trs3.close();
						tst3.close();

						Statement tst4 = con.createStatement();
						ResultSet trs4 = tst4
								.executeQuery("select * from tbl_employee where employee_id='"
										+ trainingRegistrationDTO
												.getEnquiry_id() + "'");
						String employeeName = "";
						if (trs4.next()) {
							employeeName = trs4.getString("full_name");
						}
						trs4.close();
						tst4.close();
						trainingRegistrationDTO.setEmployee_id(employeeName);

						Statement tst5 = con.createStatement();
						String myquery = "select * from tbl_registration where enquiry_id ='"
								+ trainingRegistrationDTO.getEnquiry_id() + "'";
						System.out.println(myquery);
						ResultSet trs5 = tst5.executeQuery(myquery);

						if (trs5.next()) {
							trainingRegistrationDTO.setRegistration_id(trs5
									.getString("registration_id"));
							trainingRegistrationDTO.setReg_date(trs5
									.getString("reg_date"));
							// trainingRegistrationDTO.setAddress(trs5.getString("address"));
							// trainingRegistrationDTO.setDate_of_birth(trs5.getString("date_of_birth"));
							// trainingRegistrationDTO.setEnrollment_no(trs5.getString("enrollment_no"));
							trainingRegistrationDTO.setBatch_time_start(trs5
									.getString("batch_time_start"));
							trainingRegistrationDTO.setBatch_time_end(trs5
									.getString("batch_time_end"));
							// trainingRegistrationDTO.setPhoto_path(trs5.getString("photo_path"));
							trainingRegistrationDTO.setReg_employee_id(trs5
									.getString("employee_id"));
							trainingRegistrationDTO.setTotal_amount(trs5
									.getInt("total_amount"));
							trainingRegistrationDTO.setDiscount_amount(trs5
									.getInt("discount_amount"));
							trainingRegistrationDTO.setDiscount_detail(trs5
									.getString("discount_detail"));
							String course[] = new String[] { trs5
									.getString("register_for_course") };
							Statement st5 = con.createStatement();
							ResultSet rs5 = st5
									.executeQuery("select * from tbl_cource where course_id='"
											+ course[0] + "'");
							if (rs5.next()) {
								trainingRegistrationDTO.setCoursename(rs5
										.getString("course_name"));
							}
							rs5.close();
							st5.close();
							trainingRegistrationDTO.setCourse(course);
						}
						trs5.close();
						tst5.close();
						System.out.println(trainingRegistrationDTO
								.getRegistration_id());
						candidateList.add(trainingRegistrationDTO);
					}
					rs.close();
					st.close();
				} finally {
					con.close();
				}
			}
		}

		return candidateList;
	}

	public Payment makePayment(Payment payment, String branchcode)
			throws Exception {
		System.out.println("dao2 : " + branchcode + " : " + payment.getMyid());
		Payment tPayment = null;
		Connection con = null;
		long payment_id_long = 0;
		System.out.println("dao1");
		try {
			con = new com.js.db.MyConnection().getConnection();
			con.setAutoCommit(false);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from tbl_counter");
			if (rs.next()) {
				payment_id_long = rs.getLong("payment_id");
			}
			rs.close();
			st.close();

			String base = payment.getReceived_by().substring(0, 12);
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
			String enq_id = "" + payment_id_long;
			counter = counter
					.substring(0, (counter.length() - enq_id.length()));
			counter = counter + enq_id;

			base = base + "PAY" + fdate + fmonth + fyear;
			String payment_id = base + counter;

			payment.setPayment_id(payment_id);
			System.out.println("dao2 : " + branchcode + " : "
					+ payment.getMyid());

			if (payment.getMyid().contains(branchcode)) {
				st = con.createStatement();
				String query = "insert into tbl_payment (payment_id,amount,payment_date,myid,received_by,source,mode,transfer_code,bank_name) values ('"
						+ payment.getPayment_id()
						+ "',"
						+ payment.getAmount()
						+ ",'"
						+ payment.getPayment_date()
						+ "','"
						+ payment.getMyid()
						+ "','"
						+ payment.getReceived_by()
						+ "','"
						+ payment.getSource()
						+ "','"
						+ payment.getPayment_mode()
						+ "','"
						+ payment.getTransfer_code()
						+ "','"
						+ payment.getTransfer_bank_name() + "')";
				System.out.println(query);
				st.executeUpdate(query);
				st.close();

				payment_id_long++;
				st = con.createStatement();
				st.executeUpdate("update tbl_counter set payment_id="
						+ payment_id_long + " where myid=1");
				st.close();
				tPayment = payment;
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return tPayment;
	}

	public String updatePaymentDetail(Payment payment, String branchcode)
			throws Exception {
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			if (payment.getMyid().contains(branchcode)) {
				Statement st = con.createStatement();
				st.executeUpdate("update tbl_payment set amount="
						+ payment.getAmount() + ", payment_date='"
						+ payment.getPayment_date() + "', myid='"
						+ payment.getMyid() + "', received_by='"
						+ payment.getReceived_by() + "', source='"
						+ payment.getSource() + "' where payment_id='"
						+ payment.getPayment_id() + "'");
				st.close();
				ret = "success";
			}
		} finally {
			con.close();
		}
		return ret;
	}

	public Payment getPaymentDetailByPaymentId(Payment payment,
			String branchcode) throws Exception {
		Payment tpayment = null;
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			if (payment.getPayment_id().contains(branchcode)) {
				Statement st = con.createStatement();
				ResultSet rs = st
						.executeQuery("select * from tbl_payment where payment_id='"
								+ payment.getPayment_id() + "'");
				if (rs.next()) {
					payment.setPayment_id(rs.getString("payment_id"));
					payment.setAmount(rs.getInt("amount"));
					payment.setPayment_date(rs.getString("payment_date"));
					payment.setMyid(rs.getString("myid"));
					payment.setReceived_by(rs.getString("received_by"));
					payment.setSource(rs.getString("source"));
					tpayment = payment;
				}
				rs.close();
				st.close();
			}
		} finally {
			con.close();
		}
		return tpayment;
	}

	public List<Payment> getAllPaymentDetailById(Payment payment,
			String branchcode) throws Exception {
		List<Payment> paymentList = new ArrayList<Payment>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select * from tbl_payment where payment_id like '"
							+ branchcode
							+ "%' and  myid='"
							+ payment.getMyid()
							+ "' order by payment_date DESC");
			while (rs.next()) {
				Payment tpayment = new Payment();
				tpayment.setPayment_id(rs.getString("payment_id"));
				tpayment.setAmount(rs.getInt("amount"));
				tpayment.setPayment_date(rs.getString("payment_date"));
				tpayment.setMyid(rs.getString("myid"));
				tpayment.setPayment_mode(rs.getString("mode"));
				tpayment.setReceived_by(rs.getString("received_by"));
				tpayment.setSource(rs.getString("source"));
				paymentList.add(tpayment);
			}
			rs.close();
			st.close();
		} finally {
			con.close();
		}
		return paymentList;
	}

	public int getDueAmount(String regId) throws Exception {
		int amount = 0;
		Connection con = null;
		try {
			Payment tpayment = new Payment();
			con = new com.js.db.MyConnection().getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select amount from tbl_payment where myid='"
							+ regId + "'");
			while (rs.next()) {
				amount = amount + rs.getInt("amount");
			}
			rs.close();
			st.close();

			st = con.createStatement();
			rs = st.executeQuery("select discount_amount,total_amount from tbl_registration where registration_id='"
					+ regId + "'");
			if (rs.next()) {
				int discount = rs.getInt("discount_amount");
				int total = rs.getInt("total_amount");
				amount=total-discount-amount;
			}
			rs.close();
			st.close();
		} finally {
			con.close();
		}
		return amount;
	}

	public static void main(String args[]) {
		try {
			Payment payment = new Payment("INDMPINDBTDCPAY250120130001", 4000,
					"2013-01-25", "INDMPINDBTDC20130125REG0001",
					"INDMPINDBTDC09EMP0001", "Training");
			// String ret=new PaymentDAO().makePayment(payment,"INDMPINDBBHK");

			String ret = new PaymentDAO().updatePaymentDetail(payment,
					"INDMPINDBTDC");
			System.out.println(ret);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
