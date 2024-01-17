package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.db.util.DBConnection;

public class DisplayLeaveReqDAO {
	
	

	public static ResultSet DisplayLR(String E_ID) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
	try {
			
		DBConnection DBcon =DBConnection.getInstance();
		
		con = DBcon.createconnection();
			stmt = con.createStatement();	
			String query = "select * from leaverequest where Empid='"+E_ID+"'";
			
			rs = stmt.executeQuery(query);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet DisplayProfile(String EID) {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
	try {
			
		DBConnection DBcon =DBConnection.getInstance();
		
		con = DBcon.createconnection();
			stmt = con.createStatement();	
			String query = "select * from permenant_employee where EmpID='"+EID+"'";
			
			rs = stmt.executeQuery(query);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet DisplayLR() {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
	try {
			
		DBConnection DBcon =DBConnection.getInstance();
		
		con = DBcon.createconnection();
			stmt = con.createStatement();	
			String query = "SELECT * FROM leaverequest lq , permenant_employee pe where pe.Empid = lq.EmpId AND Status='Pending' ";
			
			rs = stmt.executeQuery(query);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet DisplayEmp() {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
	try {
			
		DBConnection DBcon =DBConnection.getInstance();
		
		con = DBcon.createconnection();
			stmt = con.createStatement();	
			String query = "SELECT * FROM permenant_employee ";
			
			rs = stmt.executeQuery(query);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
	

}
