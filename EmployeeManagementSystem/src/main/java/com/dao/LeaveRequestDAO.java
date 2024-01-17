package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.util.DBConnection;
import com.model.Leave;

public class LeaveRequestDAO {

	public static String AddLeaveReq(Leave leave) {
		
		String Eid = leave.getEmp_id();
		String Reason = leave.getReason();
		String Description = leave.getDescription();
		String From = leave.getFrom();
		int days = leave.getDays();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			DBConnection DBcon =DBConnection.getInstance();
			
			conn = DBcon.createconnection();
			
			String Query = "Insert Into leaverequest(EmpId,Title,Description,FromDate,Days) values( ? , ? , ? , ? , ? )";
			
			stmt = conn.prepareStatement(Query);
			
			stmt.setString(1, Eid);
			stmt.setString(2, Reason);
			stmt.setString(3, Description);
			stmt.setString(4, From);
			stmt.setInt(5, days);
			
			int i = stmt.executeUpdate();
			
			if (i!=0)
				return "SUCCESS";
			
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return "Oops.. Something went wrong there..!" ;
		
	}
	public static String DeleteLeaveRequest(String ReqID) {
		  Connection con = null;
		  Statement stmt = null;
		  
		  try {
		       
			  DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();

		        stmt = con.createStatement();

		        int i = stmt.executeUpdate("DELETE FROM leaverequest WHERE ReqId='" + ReqID+"'");
				
				if (i!=0)
					return "SUCCESS";

		        con.close();
		    }
		    catch(Exception e){
		        e.printStackTrace();
		    }
		  
		  return "Oops.. Something went wrong there..!" ;
		}
}
