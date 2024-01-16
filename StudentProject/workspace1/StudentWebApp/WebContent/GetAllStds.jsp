<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, com.dto.Student"%>

<!-- To Use JSTL Core Tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GetAllStds</title>
</head>
<body>

	<jsp:include page="TeacherHomePage.jsp" />

	<table border="2" align="center">

		<tr>
			<th>StdId</th>
			<th>StdName</th>
			<th>Batch</th>
			<th>Gender</th>
			<th>Email-Id</th>
			<th colspan="2">Actions</th>
		</tr>

		<c:forEach var="std" items="${stdList}">
		
		<tr>
			<td> ${ std.stdId   } </td>
			<td> ${ std.stdName } </td>
			<td> ${ std.batch  } </td>
			<td> ${ std.gender  } </td>
			<td> ${ std.emailId } </td>
			<td> <a href='EditStudent?stdId=${std.stdId}'>Edit</a>   </td>
			<td> <a href='DeleteStudent?stdId=${std.stdId}'>Delete</a> </td>
		</tr>
		
		</c:forEach>
		
	</table>

</body>
</html>