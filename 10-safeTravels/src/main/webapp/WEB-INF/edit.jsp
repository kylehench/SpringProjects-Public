<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit My Task</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-between align-items-baseline">
		<h2 class="mt-4">Edit expense:</h2>
		<p><a href="/">Go back</a></p>
	</div>
	<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
		<form:label path="name">Name:</form:label>
		<form:errors path="name"/>
		<form:input type="text" path="name" class="form-control mb-2"/>
		<form:label path="vendor">Vendor:</form:label>
		<form:errors path="vendor"/>
		<form:input type="text" path="vendor" class="form-control mb-2"/>
		<form:label path="amount">Amount:</form:label>
		<form:errors path="amount"/>
		<form:input type="text" path="amount" class="form-control mb-2"/>
		<input type="submit" value="Submit" class="btn btn-primary"/>
	</form:form>
</div>
</body>
</html>