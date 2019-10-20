<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database Home Page</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div style="float:left; padding-top:10px;padding-bottom:10px;margin:50px auto 50px 5px;background-color:red;width:250px;background-color:aqua; ">
		<ul>
			<li>Table (<b>${fn:length(table)}</b>)</li>
			
			<ol>
			<c:forEach items="${table}" var="t">
			<li><a href="/minixampp/DisplayTableServlet?table=${t.tname}">${t.tname}</a></li>
			</c:forEach>
			</ol>
			
			
		</ul>
		
</div>
<div id="maindiv" style="margin-top:50px;padding-top:10px;padding-left:10px">
Create Table: <input type="text" name="tname"/>
<br>
	<table   border="1">
		<tr>
			<td>Field 1</td>
			<td>Data Type</td>
			<td>DataType-length</td>
			
			
		</tr>
		<tr>
			<td><input type="text"></td>
			<td><select id="fType1" name="fType1">
								<option value="int">int</option>
							</select>

			<td><input type="text"></td>
			<td><input type="button" value="Add more"></td>
		</tr>
	</table>




</div>


</body>
</html>