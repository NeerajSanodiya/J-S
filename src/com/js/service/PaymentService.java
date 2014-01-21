package com.js.service;

import java.util.List;

import com.js.dao.PaymentDAO;
import com.js.dto.ChangePassword;
import com.js.dto.Payment;

public class PaymentService {
	public List searchResultForMakePayment(String code, String fullName,
			String source, String branchid, String employeeid) throws Exception {
		return new com.js.dao.PaymentDAO().searchResultForMakePayment(code,
				fullName, source, branchid, employeeid);
	}

	public List<Payment> getAllPaymentDetailById(Payment payment,
			String branchcode) throws Exception {
		return new com.js.dao.PaymentDAO().getAllPaymentDetailById(payment,
				branchcode);
	}

	public Payment makePayment(Payment payment, String branchcode)
			throws Exception {

		return new com.js.dao.PaymentDAO().makePayment(payment, branchcode);
	}
	public int getDueAmount(String regId) throws Exception {
		return new PaymentDAO().getDueAmount(regId);
	}

}
