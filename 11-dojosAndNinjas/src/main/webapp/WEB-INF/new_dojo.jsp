<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h2 class="mt-4">New Dojo:</h2>
	<form:form action="/dojos/create" method="post" modelAttribute="dojo">
		<form:label path="name">Name:</form:label>
		<form:errors path="name"/>
		<form:input type="text" path="name" class="form-control mb-2"/>
		<input type="submit" value="Submit" class="btn btn-primary"/>
	</form:form>
</div>
</body>
</html>