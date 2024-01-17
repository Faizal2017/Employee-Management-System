package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.db.util.DBConnection;
import com.model.Attendance;

public class AttendanceDAO {

	static LocalDate currentDate = LocalDate.now();
	
	//Static method
	public static String insertAttendence(Attendance attendance) {
		
		
		String[] Emp = attendance.getEmp();
		String[] Status = attendance.getStatus();
		int j = 0;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// create Connection object to connect database
			DBConnection DBcon =DBConnection.getInstance();
			
			conn = DBcon.createconnection();
			stmt = conn.createStatement();
			
			
			
			 //Loop for enter all the attendance of all employee
            
			for(int i = 0; i < Emp.length; i++) {
				
				String nameId = Emp[i];
				String status = Status[i];
				String query = "select * from attendancehistory where date ='"+currentDate+"' AND EmpId = '"+nameId+"'"; // query to execute
	            rs = stmt.executeQuery(query);
	            if(!rs.next()) { // check if their any rows return if not data will insert
	            String sql = "INSERT INTO attendancehistory (EmpId,Status) VALUES ('"+nameId+"','"+status+"')";
	            stmt.executeUpdate(sql);  
	            
	            }
	            else { // if their any rows that will update
	            	String sql = "update attendancehistory set Status='"+status+"' where EmpId = '"+nameId+"' AND date ='"+currentDate+"'";
		            stmt.executeUpdate(sql);  
		            }
			}
			j= 1;
			
			// if success
			if (j!=0)
				return "SUCCESS";
			
			
		}
		catch (SQLException e) { // If Any Sql Exception occur
			
			e.printStackTrace();
			
		}
		
		return "Oops.. Something went wrong there..!" ;  // if unsuccess
		
	}
	
	//Static method
	public static ResultSet DisplayAttendence(String eid) {
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// create Connection object to connect database
			DBConnection DBcon =DBConnection.getInstance();
			
			conn = DBcon.createconnection();
		stmt = conn.createStatement();
		
		String query = "select * from attendancehistory where EmpId = '"+eid+"'"; // Query to execute
        rs = stmt.executeQuery(query);
       
	}
	catch (SQLException e) {
		
		e.printStackTrace();
		
	}
		 return rs; // return ResultSet to shrink the code and easy to call 
		
	}
}
