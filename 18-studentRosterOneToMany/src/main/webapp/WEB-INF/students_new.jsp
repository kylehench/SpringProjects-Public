<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Student</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<body>
<div class="container">
	<h2 class="pt-4">New Student</h2>
	<a href="/dorms">Dashboard</a><br>
	<form:form action="/students/create" method="post" class="mt-2" modelAttribute="newStudent">
	  	<form:label path="name">Name:</form:label>
	  	<form:errors path="name" class="text-danger"/>
	  	<form:input type="text" path="name" class="form-control mb-2" />
	  	
	  	<label name="dorm_id">Select Dorm:</label>
	  	<span class="text-danger">${dormError}</span>
		<select name="dorm_id" class="form-select mb-2">
	    <option value="none" selected disabled hidden>--- Select an Option ---</option>
	        <c:forEach var="dorm" items="${dorms}">
	          	<option value="${dorm.id}">${dorm.name}</option>
	        </c:forEach>
	    </select>
	  	
	  	
	  	<input type="submit" value="Add" class="btn btn-primary" />
	</form:form>
</div>
</body>
</html>