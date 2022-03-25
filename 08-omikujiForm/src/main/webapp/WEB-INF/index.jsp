<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container mb-3">
		<h2 class="text-center my-3">Send an Omikuji!</h2>
		<form class="border p-3" action="/omikuji" method="post">
			<div class="number mb-2">
			  <label for="number">Pick any number from 5 to 25:</label>
			  <input type="number" class="form-control" name="number" min="5" max="25">
			</div>
			<label for="city">Enter the name of any city:</label>
			<input type="text" name="city" class="form-control mb-2">
			<label for="name">Enter the name of any real person:</label>
			<input type="text" name="name" class="form-control mb-2">
			<label for="activity">Enter professional endeavor or hobby:</label>
			<input type="text" name="activity" class="form-control mb-2">
			<label for="lifeform">Enter any type of living thing:</label>
			<input type="text" name="lifeform" class="form-control mb-2">
			<label for="comment">Say something nice to someone:</label>
			<textarea name="comment" cols="20" rows="3" class="form-control mb-2"></textarea>
			<p><i>Send and show a friend.</i></p>
			<input type="submit" value="Send" class="btn btn-primary">
		</form>
	</div>
</body>
</html>