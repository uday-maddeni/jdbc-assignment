package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.db.DbConnector;

public class DeleteStudent {
	
	public static void delete() {
		PreparedStatement pstmt = null;
		Connection con = null;
		con = DbConnector.getConnector();
		FetchAllStudents.printAllStudents();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student id to delete :");
		int sid = sc.nextInt();
		
		String query = "delete from std where sid = ?";
	    
		
		try {
			con = DbConnector.getConnector();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sid);
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("Student record delted successfully !!");
				FetchAllStudents.printAllStudents();
			} else {
				System.out.println("Please enter a valid sid ");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	public static void main(String[] args) {
		delete();
	}

}
