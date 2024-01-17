package com.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.db.util.DBConnection;

public class DisplayAllEmpDAO {
	

	
	public static ResultSet Displayp() {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			stmt = con.createStatement();	
			String query = "select * from permenant_employee";
			
			rs = stmt.executeQuery(query);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet Displayt() {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			stmt = con.createStatement();	
			String query = "select * from temporary_employee";
			
			rs = stmt.executeQuery(query);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
}
