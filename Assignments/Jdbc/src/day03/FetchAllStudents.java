
package day03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.DbConnector;

//Fetch Employee Data: select * from emp
public class FetchAllStudents {
	
	public static void printAllStudents() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = "Select * from std";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DbConnector.getConnector();

			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("===========================================================");
			System.out.println("                   Student Details");
			System.out.println("===========================================================");
			while (rs.next()) {
				System.out.print(rs.getInt(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getString(3)+" ");
				System.out.print(rs.getString(4)+" ");
				System.out.print(rs.getString(5)+" ");
				System.out.print(rs.getString(6)+" ");
				System.out.println(rs.getString(7));
			}
			System.out.println("===========================================================");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		printAllStudents();
	}
}
