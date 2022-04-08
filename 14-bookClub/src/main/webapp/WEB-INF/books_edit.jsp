<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Share</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-between mt-3">
			<h2>Edit Book</h2>
			<a href="/books">Back to the shelves</a>
	</div>
	<form:form action="/books/${book.id}" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="put">
		<form:label path="title">Title:</form:label>
		<form:errors path="title"/>
		<form:input type="text" path="title" class="form-control mb-2" />
		<form:label path="author">Author:</form:label>
		<form:errors path="author"/>
		<form:input type="text" path="author" class="form-control mb-2" />
		<form:label path="thoughts">My thoughts:</form:label>
		<form:errors path="thoughts"/>
		<textarea name="thoughts" rows="3" path="thoughts" class="form-control mb-2">${book.thoughts}</textarea>
		<input type="submit" value="Edit" class="btn btn-primary" />
	</form:form>
</div>
</body>
</html>