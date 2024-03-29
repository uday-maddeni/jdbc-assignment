
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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



public List<Student> getAllStudents() {
	
	Connection con = DbConnection.getConnection();
	PreparedStatement pst = null;
	ResultSet rs = null;		
	List<Student> stdList = null;
	
	String selectQuery = "Select * from s";
	
	
	try {
		pst = con.prepareStatement(selectQuery);
		rs = pst.executeQuery();
		
		stdList = new ArrayList<Student>();
		
		while (rs.next()) {
			Student std = new Student();
			std.setStdId(rs.getInt(1));
			std.setStdName(rs.getString(2));
			std.setBatch(rs.getString(3));
			std.setGender(rs.getString(4));
			std.setEmailId(rs.getString(5));
			std.setPassword(rs.getString(6));
			
			stdList.add(std);
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
	
	return stdList;
}

public int registerStudent(Student std) {
	Connection con = DbConnection.getConnection();
	PreparedStatement pst = null;
	
	String insertQuery = "insert into s " + 
	"(stdName, batch, gender, emailId, password) values (?, ?, ?, ?, ?)";
	
	try {
		pst = con.prepareStatement(insertQuery);
		
		pst.setString(1, std.getStdName());
		pst.setString(2, std.getBatch());
		pst.setString(3, std.getGender());
		pst.setString(4, std.getEmailId());
		pst.setString(5, std.getPassword());
		
		return pst.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	finally {
		if (con != null) {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	return 0;
}

public Student getStudentById(int stdId) {	
	
	Connection con = DbConnection.getConnection();
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	String selectQuery = "Select * from s where stdId=?";
	
	
	try {
		pst = con.prepareStatement(selectQuery);
		pst.setInt(1, stdId);
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


public int deleteStudent(int stdId) {
	
	Connection con = DbConnection.getConnection();
	PreparedStatement pst = null;
	
	String deleteQuery = "delete from s where stdId=?";
	
	
	try {
		pst = con.prepareStatement(deleteQuery);
		pst.setInt(1, stdId);
		
		return pst.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	finally {
		if (con != null) {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	return 0;
}


public int updateStudent(Student std) {
	
	Connection con = DbConnection.getConnection();
	PreparedStatement pst = null;
	
	String updateQuery = "update s set stdName=?, batch=?, gender=?, emailId=?, password=? where stdId=?";
	
	try {
		pst = con.prepareStatement(updateQuery);
		
		pst.setString(1, std.getStdName());
		pst.setString(2, std.getBatch());
		pst.setString(3, std.getGender());
		pst.setString(4, std.getEmailId());
		pst.setString(5, std.getPassword());
		pst.setInt(6, std.getStdId());
		
		return pst.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	finally {
		if (con != null) {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	return 0;
}

}





