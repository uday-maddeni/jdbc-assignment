<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GetStdById</title>
</head>
<body>

  <jsp:include page="TeacherHomePage.jsp" />

<br/>
<form action="GetStdById" method="post">

	<table align="center">
		<tr>
			<td>Enter StdId </td>
			<td><input type="text" name="stdId"/></td>
		</tr>
		
		<tr>
			<td></td>
			<td><button>Get Student</button></td>
		</tr>
		
	</table>

</form>

<br/>

</body>
</html>