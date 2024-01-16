package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dto.Student;




@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int stdId = Integer.parseInt(request.getParameter("stdId"));
		String stdName = request.getParameter("stdName");
		String batch = request.getParameter("batch");
		String gender = request.getParameter("gender");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		
		Student std = new Student(stdId, stdName, batch, gender, emailId, password);
		
		StudentDAO stdDao = new StudentDAO();
		int result = stdDao.updateStudent(std);
		
		if (result > 0) {
			request.getRequestDispatcher("GetAllStds").forward(request, response);
		} else {
			request.getRequestDispatcher("TeacherHomePage.jsp").include(request, response);
			
			out.println("<center>");
			out.println("<h1 style='color:red;'>Unable to Update the Student Record!!!</h1>");	
			out.println("</center>");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
