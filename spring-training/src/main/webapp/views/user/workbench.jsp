<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Workbench </title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
		
		 
	</head>
	<body>
	 <div class="container theme-showcase" role="main">
	
		<h2>User Workbench</h2>
		<a href="add">Add user</a> 
		<div class="table-responsive">
		<table class="table table-condensed table-hover .table-striped">
			<thead>
				<tr>
					<th class="info">ID</th>
					<th>NAME</th>
					<th>CODE</th>
					<th>DESC</th>
					<th>created on</th>
					<th>Modified on</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td class="info">${user.id}</td>
						<td>${user.name}</td>
						<td>${user.code}</td>
						<td>${user.description}</td>
						<td><fmt:formatDate type="both" dateStyle="long" timeStyle="short" value="${user.createdOn}" /></td>
						<td><fmt:formatDate type="both" dateStyle="long" timeStyle="short" value="${user.modifiedOn}" /></td>
						<td><a href="edit/${user.id}" class="btn btn-primary">Edit</a><form action="delete" method="Post"><input type="hidden" name="id" value="${user.id}"/><input type="submit" class="btn btn-primary" value="Delete"/></form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</body>
</html>