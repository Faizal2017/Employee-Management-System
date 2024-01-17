package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.db.util.DBConnection;

public class GetDAO {
	
	public static ResultSet PerEmp() {
		  Connection con = null;
		  ResultSet rs = null;
		  Statement stmt = null;
		  
			try {
				
DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();
				stmt = con.createStatement();	
				String query = "select EmpId, Name from permenant_employee";
				
				
				rs = stmt.executeQuery(query);
				
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		}
	
	public static ResultSet TempEmp() {
		  Connection con = null;
		  ResultSet rs1 = null;
		  Statement stmt = null;
		  
			try {
				
DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();
				stmt = con.createStatement();	
				String query = "select EmpId, Name from temporary_employee";
				
				
				rs1 = stmt.executeQuery(query);
				
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs1;
		}
	
	public static ResultSet getMonth(String EmpID) {
		Connection con = null;
		  ResultSet rs = null;
		  Statement stmt = null;
		  
			try {
				
DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();
				stmt = con.createStatement();	
				String query = "select months from month where months not in (select month from payment where empid='"+EmpID+"')"
						+ "order by No";
				
				
				rs = stmt.executeQuery(query);
				
				
				
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		
	}
	
	public static ResultSet getLeave(String EmpID) {
		Connection con = null;
		  ResultSet rs = null;
		  Statement stmt = null;
		  
			try {
				
DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();
				stmt = con.createStatement();	
				String query = "select LeaveBalance from leavebalance where EmpId='"+EmpID+"'";
				
				
				rs = stmt.executeQuery(query);
				
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		
	}
	
	public static ResultSet getPayHistory() {
		  Connection con = null;
		  ResultSet rs = null;
		  Statement stmt = null;
		  
			try {
				
DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();
				stmt = con.createStatement();	
				String query = "select * from payment";
				
				
				rs = stmt.executeQuery(query);
				
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		}
	
	
}