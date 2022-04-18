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
		<h2>Top Ten Songs:</h2>
		<a href="/welcome">Dashboard</a>
	</div>
	<div class="border mt-3 p-2">
		<c:forEach var="song" items="${topSongs}">
			${song.rating} - <a href="songs/${song.id}">${song.title}</a> - ${song.artist}<br>
		</c:forEach>
	</div>
</div>
</body>
</html>