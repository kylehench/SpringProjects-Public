<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify!</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container p-3">
	<div class="d-flex justify-content-between">
		<a href="/songs/new">Add New Song</a>
		<a href="/songs/top">Top Songs</a>
		<form action="/songs/search" method="post" class="d-flex align-items-center">
			<input type="text" name="artist" class="form-control me-2 in-line">
			<input type="submit" value="Search Artists" class="btn btn-primary in-line">
		</form>
	</div>
	<table class="table table-hover">
		<tr>
			<th>Name</th>
			<th>Rating</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="song" items="${songs}">
			<tr>
				<td><a href="/songs/${song.id}">${song.title}</a></td>
				<td>${song.rating}</td>
				<td><a href="/songs/${song.id}/edit">Edit</a> <a href="/songs/${song.id}/destroy">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>