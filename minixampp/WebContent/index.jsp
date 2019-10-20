<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Minixampp Index Page</title>
<script type="text/javascript" src="/minixampp/js/common.js"></script>
</head>
<body>

	<h1>Connect !</h1>
	<form id="log_form" action="/minixampp/DbConnectServlet" method="post" onsubmit="return validate('log_form');">
	
	<table cellpadding="3px" cellspacing="3px">
	
	<tr>
		<td>Database Name : </td>
		<td>
			<select name="database">
				<option value="-1">Select Database</option>

				<c:forEach items="${dbnames}" var="d">
				<option value="${d.name}"><c:out value="${d.name}"></c:out></option>
				</c:forEach>
			
			</select>
		</td>
		<td id="db_msg"></td>
	</tr>
	
	<tr>
		<td>User name:</td>
		<td>
			<input type="text" name="username">
		</td>
		<td id="username_msg"></td>
		
	</tr>
	
	<tr>
		<td>Password:</td>
		<td>
			<input type="password" name="pass">
		</td>
		
		
	</tr>
	
	<tr>
		<td>
			<input type="submit" name="login" value="Connect">
		</td>
		<td>
			<input type="reset" name="reset" value="Reset">
		</td>
	</tr>
	</table>
	</form>
</body>
</html>