<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FIFA</title>
<spring:url value="/css/buyTickets.css" var="urlCss"/>
<link rel="stylesheet" href="${urlCss}" type="text/css" /> 
</head>
<body>
	<c:if test="${uitverkochteMatch.uitverkocht()}">De voetbalmatch is uitverkocht!</c:if><br/>
	<c:if test="${ticketsAantal > 1}">${ticketsAantal} tickets werden aangekocht</c:if>
	<c:if test="${ticketsAantal  == 1}">${ticketsAantal} ticket werd aangekocht</c:if>
	<h1>FIFA World Cup Qatar 2022</h1>
	<form:form method="POST" action="fifa" modelAttribute="matchCommand">
    Stadia: 
        <form:select path="stadiumSelected" multiple="false">
            <form:options items="${stadiumList}" />
        </form:select>
        <br/><br/>
        <input type="submit" value="Voer uit" />
    </form:form>
    <form action='logout' method='post'>
		<input type="submit" value="Log out" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</body>
</html>