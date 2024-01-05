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

@WebServlet("/Login")
public class Login extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		
		out.println("<html>");
		if (emailId.equalsIgnoreCase("Teacher") && password.equals("Teacher")) {			
			
			RequestDispatcher rd = request.getRequestDispatcher("TeacHomePage");
			rd.forward(request, response);
			
		} else {			
			
			
			StudentDAO stdDao = new StudentDAO();
			Student std = stdDao.stdLogin(emailId, password);
			
			if (std != null) {
				
				RequestDispatcher rd = request.getRequestDispatcher("StdHomePage");
				rd.forward(request, response);
				
			} else {
				out.println("<body bgcolor='lightyellow' text='red'>");
				out.println("<center>");
				out.println("<h1>Invalid Credentials</h1>");
				
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
			
			
		}
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
