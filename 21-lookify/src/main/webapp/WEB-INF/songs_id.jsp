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
		<a href="/songs/top">Top Song</a>
		<div><a href="/welcome">Dashboard</a></div>
	</div>
	<table class="table table-hover mt-3">
		<tr>
			<td>Title</td>
			<td>${song.title}</td>
		</tr>
		<tr>
			<td>Artist</td>
			<td>${song.artist}</td>
		</tr>
		<tr>
			<td>Rating (1-10)</td>
			<td>${song.rating}</td>
		</tr>
	</table>
	<a href="/songs/${song.id}/destroy">Delete</a>
</div>
</body>
</html>