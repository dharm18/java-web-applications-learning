<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message};
		<form name="loginForm" action="../j_spring_security_check" method="post" >
			<label>Login</label><input name="username" type="text"><br>
			<label>Password</label><input name="password" type="password">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input value="Login" type="submit">
		</form>
	</body>
</html>