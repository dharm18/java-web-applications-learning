<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add User</title>
		<style>
			.error {
				color: #ff0000;
				font-weight: bold;
			}
		</style>
	</head>
	<body>
	${msg} | <a href="../workbench">Home</a>
		<form:form action="/spring-training/user/update" modelAttribute="user" method="post">
			<form:hidden path="id"/>
			<label>Name: </label> <form:input path="name"/><form:errors path="name" cssClass="error" /><br>
			<label>Code: </label> <form:select path="code" items="${codes}" /><form:errors path="code" cssClass="error" /><br>
			<label>Description: </label> <form:input path="description"/><form:errors path="description" cssClass="error" /><br>
			<input type="submit">
		</form:form>
	</body>
</html>