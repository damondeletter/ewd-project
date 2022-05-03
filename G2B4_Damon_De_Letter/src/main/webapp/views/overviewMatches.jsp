<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Overview matches in ${stadium}</title>
<spring:url value="/css/buyTickets.css" var="urlCss"/>
<link rel="stylesheet" href="${urlCss}" type="text/css" /> 
</head>
<body>
	<h1>Fifa World Cup Qatar 2022</h1>
	<h2>Stadion: ${stadium}</h2>
	<table style="width:100">
	<thead>
		<tr>
			<th>Nr</th>
			<th>Voetbalmatch</th>
			<th>Datum</th>
			<th>Aftrap</th>
			<th>Tickets</th>
		</tr>
	</thead>
	<tbody>
			<c:forEach var="match" items="${listMatch}">
			<tr>
				<td><a href="fifa/${match[0]}">${match[0]}</a></td>
				<td>${match[1]}</td>
				<td>${match[2]}</td>
				<td>${match[3]}</td>
				<td>${match[4]}</td>
				<td></td>
			</tr>
			</c:forEach>
	</tbody>
	</table>
	<form action='logout' method='post'>
		<input type="submit" value="Log out"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</body>
</html> 