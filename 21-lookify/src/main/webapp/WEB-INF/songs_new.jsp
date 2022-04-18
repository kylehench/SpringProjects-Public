<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Song</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container p-3">
	<div class="d-flex justify-content-end">
		<a href="/welcome">Dashboard</a>
	</div>
	<form:form action="/songs/create" method="post" modelAttribute="newSong">
	
		<form:label path="title">Title:</form:label>
		<form:errors path="title" class="text-danger"/>
		<form:input type="text" path="title" class="form-control mb-2" />
		
		<form:label path="artist">Artist:</form:label>
		<form:errors path="artist" class="text-danger"/>
		<form:input type="text" path="artist" class="form-control mb-2" />
		
		<div class="number mb-2">
			<form:label path="rating">Rating:</form:label>
			<form:errors path="rating" class="text-danger"/>
			<form:input type="number" path="rating" value="1" min="1" max="10" class="form-control"/>
		</div>
		
		<input type="submit" value="Add Song" class="btn btn-primary" />
		
	</form:form>
</div>
</body>
</html>