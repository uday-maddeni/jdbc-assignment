<%@ page import="com.dto.Student"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.io.IOException"%>
<%@ page import="javax.servlet.ServletException"%>

<%
	//response.setContentType("text/html");
	//PrintWriter out = response.getWriter();

	//HttpSession session = request.getSession(false);
	Student std = (Student) session.getAttribute("std");
%>

<!DOCTYPE html>
<html>
<head>
<title>Student Profile</title>
</head>
<body>
	<jsp:include page="StdHomePage.jsp" />

	<table border='2' align='center'>
		<tr>
			<th>StdId</th>
			<th>StdName</th>
			<th>Batch</th>
			<th>Gender</th>
			<th>Email-Id</th>
			<th>Password</th>
		</tr>
		
			<tr>
			<td> ${ std.stdId } </td>
			<td> ${ std.stdName } </td>
			<td> ${ std.batch } </td>
			<td> ${ std.gender } </td>
			<td> ${ std.emailId } </td>
			<td> ${ std.password } </td>
		</tr>

	</table>
</body>
</html>