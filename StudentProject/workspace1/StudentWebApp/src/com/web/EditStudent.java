package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dto.Student;


@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int stdId = Integer.parseInt(request.getParameter("stdId"));
		
		StudentDAO stdDao = new StudentDAO();
		Student std = stdDao.getStudentById(stdId);
		
		if (std != null) {

			request.setAttribute("std", std);
			
			RequestDispatcher rd = request.getRequestDispatcher("UpdateStudent.jsp");
			rd.forward(request, response);

		} else {
			
			RequestDispatcher rd = request.getRequestDispatcher("TeacherHomePage.jsp");
			rd.include(request, response);
			
			out.println("<center>");
			out.println("<h1 style='color:red;'>Unable to Update Student Record!!!</h1>");	
			out.println("</center>");
		}
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
