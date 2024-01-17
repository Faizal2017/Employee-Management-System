package com.dao;

import java.sql.ResultSet;

import com.model.PaymentDetails;

public interface Pay {
	
	ResultSet getPaymentDetails(String EmpID);
	
	double calculateSalary(Double salary, int leave, int bonus);
	
	String AddPayment(PaymentDetails payment);
}
