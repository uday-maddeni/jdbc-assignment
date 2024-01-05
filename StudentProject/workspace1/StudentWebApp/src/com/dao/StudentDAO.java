
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DbConnection;
import com.dto.Student;

public class StudentDAO {
public Student stdLogin(String emailId, String password) {
		
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String loginQuery = "Select * from s where emailId=? and password=?";
		
		
		try {
			pst = con.prepareStatement(loginQuery);
			pst.setString(1, emailId);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				Student std = new Student();
				std.setStdId(rs.getInt(1));
				std.setStdName(rs.getString(2));
				std.setBatch(rs.getString(3));
				std.setGender(rs.getString(4));
				std.setEmailId(rs.getString(5));
				std.setPassword(rs.getString(6));
				return std;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			if (con != null) {
				try {
					rs.close();
					pst.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return null;
	}
}
