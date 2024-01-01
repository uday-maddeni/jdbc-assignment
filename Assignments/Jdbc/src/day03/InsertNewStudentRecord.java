package day03;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.db.DbConnector;

public class InsertNewStudentRecord {
	public static void main(String[] args) {
		Statement stmt = null;
		Connection con = null;
		//ResultSet rs = null;
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
}
