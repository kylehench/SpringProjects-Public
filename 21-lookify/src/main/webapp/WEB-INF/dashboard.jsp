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
	<div class="d-flex justify-content-between mb-5">
		<h1>Welcome to Lookify!</h1>
		<a href="/logout">Logout</a>
	</div>
	<div class="d-flex justify-content-center mt-5">
		<a href="/songs">Start Looking!</a>
	</div>
</div>
</body>
</html>