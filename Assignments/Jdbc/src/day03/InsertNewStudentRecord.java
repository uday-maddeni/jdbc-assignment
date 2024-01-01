package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.db.DbConnector;

public class InsertNewStudentRecord {
	
	public static void insertRecord() {
		Statement stmt = null;
		Connection con = null;
		con = DbConnector.getConnector();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student sid,sname,course,batch,trainer,email,password");
		int sid = sc.nextInt();
		sc.nextLine();
		String sname = sc.nextLine();
		String course = sc.next(), batch = sc.next(), trainer = sc.next(), email = sc.next(), password = sc.next();
		
		String query = "insert into std values("+sid+",'"+sname+"','"+course+"','"+batch+"','"+trainer+"','"+email+"','"+password+"')";
	    
		
		try {
			con = DbConnector.getConnector();
			stmt = con.createStatement();
			int cnt = stmt.executeUpdate(query);
			if(cnt > 0) {
				System.out.println("Student Record inserted successfully !!");
				System.out.println("-----------------------------------------------------");
				FetchAllStudents.printAllStudents();
			} else {
				System.out.println("Student Record not inserted successfully !!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	public static void insertRecordPrepareStatement() {
		PreparedStatement pstmt = null;
		Connection con = null;
		con = DbConnector.getConnector();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student sid,sname,course,batch,trainer,email,password");
		int sid = sc.nextInt();
		sc.nextLine();
		String sname = sc.nextLine();
		String course = sc.next(), batch = sc.next(), trainer = sc.next(), email = sc.next(), password = sc.next();
		
		String query = "insert into std values(?,?,?,?,?,?,?)";
	    
		
		try {
			con = DbConnector.getConnector();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sid);
			pstmt.setString(2, sname);
			pstmt.setString(3, course);
			pstmt.setString(4, batch);
			pstmt.setString(5, trainer);
			pstmt.setString(6, email);
			pstmt.setString(7, password);
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("Student Record inserted successfully !!");
				System.out.println("-----------------------------------------------------");
				FetchAllStudents.printAllStudents();
			} else {
				System.out.println("Student Record not inserted successfully !!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	public static void main(String[] args) {
		//insertRecord();
		insertRecordPrepareStatement() ;
	}
}
