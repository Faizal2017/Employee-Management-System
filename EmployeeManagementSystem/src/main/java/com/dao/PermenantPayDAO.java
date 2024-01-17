package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.util.DBConnection;
import com.model.PaymentDetails;

public class PermenantPayDAO implements Pay{
	
	public String AddPayment(PaymentDetails payment) {
		
		String employeeID = payment.getEmpId();
		double salary = payment.getSalary();
		String month= payment.getMonth();
		int leave= payment.getLeave();
		int bonus= payment.getBonus();
		double netSalary= payment.getNetSalary();
		String account= payment.getAccount();
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			
			String query = "insert into payment(EmpId, Salary, Month, ExtraLeave, BonusPercentage, NetSalary, Account) values ( ? , ? , ? , ? , ? , ?, ? )";
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, employeeID);
			stmt.setDouble(2, salary);
			stmt.setString(3, month);
			stmt.setInt(4, leave);
			stmt.setInt(5, bonus);
			stmt.setDouble(6, netSalary);
			stmt.setString(7, account);
			
			int i = stmt.executeUpdate();
			
			if (i!=0)
				return "SUCCESS";
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong there..!" ;
		
		}
	
	public ResultSet getPaymentDetails(String EmpID) {
		
		  Connection con = null;
		  ResultSet rs = null;
		  Statement stmt = null;
		  
			try {
				
DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();
				stmt = con.createStatement();	
				String query = "select EmpId, Salary from permenant_employee where EmpId= '" + EmpID+"'";
				
				rs = stmt.executeQuery(query);
				
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
	}

	
	public double calculateSalary(Double salary, int leave, int bonus) {
		
		double finalSal;
		
		salary= salary-leave*(salary*2.5/100);
		
		finalSal= salary+ (salary*bonus/100);
		
		return finalSal;
	}
	
	public static ResultSet getSalary() {
		  Connection con = null;
		  ResultSet rs = null;
		  Statement stmt = null;
		  
			try {
				
DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();
				stmt = con.createStatement();	
				String query = "select EmpId, Salary from permenant_employee";
				
				
				rs = stmt.executeQuery(query);
				
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		}
	
	public static String updateSalary(String EmpId, double salary) {
		  Connection con = null;
		  Statement stmt = null;
		  
			try {
				
DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();
				stmt = con.createStatement();	
				String query = "update permenant_employee set Salary="+salary+"  where EmpId='"+EmpId+"'";
				
				int i = stmt.executeUpdate(query);
				
				if (i!=0)
					return "SUCCESS";
				
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return "Oops.. Something went wrong there..!" ;
	}

}
