<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-between align-items-center">
		<h2 class="mt-4">What is your question?</h2>
		<a href="/questions">Home</a>
	</div>
	<form:form action="/questions/create" method="post" modelAttribute="newQuestion">
		<form:label path="question">My question:</form:label>
		<form:errors class="text-danger" path="question"/>
		<textarea name="question" rows="3" path="question" class="form-control mb-2"></textarea>
		<label for="tags">Tags:</label>
		<span class="text-danger">${errorTag}</span>
		<input type="text" name="tagsString" id="tagsString" class="form-control mb-2">
		<input type="submit" value="Submit" class="btn btn-primary">
	</form:form>
</div>
</body>
</html>