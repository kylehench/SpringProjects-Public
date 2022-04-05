<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h2 class="mt-4">New Ninja:</h2>
	<form:form action="/ninjas/create" method="post" modelAttribute="ninja">
		<form:label path="dojo">Dojo:</form:label>
		<form:errors path="dojo"/>
		<form:select path="dojo" class="form-select mb-2">
			<option value="none" selected disabled hidden>--- Select an Option ---</option>
			<c:forEach var="dojo" items="${dojos}">
				<option value="${dojo.id}"><c:out value="${dojo.name}"/></option>
				
			</c:forEach>
		</form:select>
		<form:label path="first_name">First name:</form:label>
		<form:errors path="first_name"/>
		<form:input type="text" path="first_name" class="form-control mb-2"/>
		<form:label path="last_name">Last name:</form:label>
		<form:errors path="last_name"/>
		<form:input type="text" path="last_name" class="form-control mb-2"/>
		<div class="number mb-2">
		  <form:label path="age">Age:</form:label>
		  <form:input type="number" class="form-control" path="age" value="18" min="18" max="125" />
		</div>
		<input type="submit" value="Submit" class="btn btn-primary"/>
	</form:form>
</div>
</body>
</html>