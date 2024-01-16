package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dto.Student;

@WebServlet("/GetAllStds")
public class GetAllStds extends HttpServlet {

       
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		StudentDAO stdDao = new StudentDAO();		
		List<Student> stdList = stdDao.getAllStudents();
		
		if (stdList != null) {
			
			//Storing employees list under request object
			request.setAttribute("stdList", stdList);
			
			RequestDispatcher rd = request.getRequestDispatcher("GetAllStds.jsp");
			rd.forward(request, response);			
		
		} else {	
			
			RequestDispatcher rd = request.getRequestDispatcher("TeacherHomePage.jsp");
			rd.include(request, response);
			
			out.println("<center>");
			out.println("<h1 style='color:red;'>Unable to Fetch the Student Record(s)!!!</h1>");	
			out.println("</center>");
		}
}
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

