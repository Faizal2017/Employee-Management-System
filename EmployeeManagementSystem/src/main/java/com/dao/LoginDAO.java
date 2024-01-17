package com.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.util.DBConnection;
import com.model.Login;

public class LoginDAO {

	public String LoginUser(Login login) {
		
		String email = login.getEmail();
		String password = login.getPassword();
		
		
		Connection con = null;
		
		
		try {
			
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from user_logins where username = '"+email+"' and password ='"+password+"'  ");
			
			
			
			if (rs.next())
				return rs.getString("EmpID");
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong there..!" ;
	}
}
