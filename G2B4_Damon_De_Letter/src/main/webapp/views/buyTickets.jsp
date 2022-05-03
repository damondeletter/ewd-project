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
<spring:url value="/css/buyTickets.css" var="urlCss"/>
<link rel="stylesheet" href="${urlCss}" type="text/css" /> 
<title>Koop tickets</title>
</head>
<body>
	<h1>Fifa World Cup Qatar 2022</h1>
	<h2>Stadion: ${stadium}</h2>
	<h3>${wedstrijdnaam}</h3>
	<h3>aantal tickets beschikbaar: ${tickets}</h3>
	<form:form method="POST" action="${id}" modelAttribute="aanschafTicket">
	
		<label for="email">email:</label>
		<form:input path="email" size="20"/>
		<form:errors path="email" cssClass="error"/>
		
		<br/>
		
		<label for="aantalTickets">aantal tickets:</label>
		<form:input path="tickets" size="20"/>
		<form:errors path="tickets" cssClass="error"/>
		
		<br/>
		
		<label for="voetbalCode1">voetbalCode1</label>
		<form:input path="voetbalCode1" size="20"/>
		<form:errors path="voetbalCode1" cssClass="error"/>
		
		<br/>
		
		<label for="voetbalCode2">voetbalCode2</label>
		<form:input path="voetbalCode2" size="20"/>
		<form:errors path="voetbalCode2" cssClass="error"/>
		
		<br/>
		<input type="submit" value="Koop">
	</form:form>
</body>
</html>