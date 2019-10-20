<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
		<table cellpadding="2px" cellspacing="2px" border=2px>
		<tr>
		<c:set var="count1" value="0" scope="page" />
		<c:set var="count2" value="0" scope="page" />
		<c:forEach items="${showtable}" var="t">
			<c:set var="count1" value="${count1 + 1}" scope="page"/>
			<th>${t.cdata}</th>
		</c:forEach>
		<tr>
		<c:forEach items="${tabledata}" var="d">
			<c:set var="count2" value="${count2 + 1}" scope="page"/>
			<c:choose>
			<c:when test="${count2 mod count1 == 0}">
			</c:when>
			<c:when test="${count2 == count1}">

			</c:when>
			</c:choose>
			
			
				<td>${d.cdata}</td>
			
			
			
		</c:forEach>
		<tr>
		</table>
</body>
</html>