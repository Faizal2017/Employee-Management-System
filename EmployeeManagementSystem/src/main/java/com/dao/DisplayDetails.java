package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.util.DBConnection;

public class DisplayDetails {

	public static ResultSet Displayp(String EID) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			stmt = con.createStatement();	
			String query = "select * from permenant_employee where EmpId='"+EID+"'";
			
			rs = stmt.executeQuery(query);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	};
public static ResultSet Displayt(String EID) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			stmt = con.createStatement();	
			String query = "select * from temporary_employee where EmpId='"+EID+"'";
			
			rs = stmt.executeQuery(query);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	};
	public static ResultSet DisplayAcdetails(String EID) {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			stmt = con.createStatement();	
			String query = "select * from accountdetails where EmpID='"+EID+"'";
			
			rs = stmt.executeQuery(query);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet DisplayPaymentHistory(String EID) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			stmt = con.createStatement();	
			String query = "select * from payment where EmpId='"+EID+"'";
			
			rs = stmt.executeQuery(query);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet DisplayTempEmp(String EID) {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
	try {
			
		DBConnection DBcon =DBConnection.getInstance();
		
		con = DBcon.createconnection();
			stmt = con.createStatement();	
			String query = "SELECT * FROM temporary_employee where Empid='"+EID+"'";
			
			rs = stmt.executeQuery(query);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
}
