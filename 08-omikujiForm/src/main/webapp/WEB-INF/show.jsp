<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container mb-3">
		<h2 class="text-center my-3">Here's Your Omikuji!</h2>
		<div class="border p-3" id="main-content">
			<span>In <c:out value="${number}" /> years, you will live in <c:out value="${city}" /> with <c:out value="${name}" /> as your roommate, <c:out value="${activity}" /> for a living. The next time you see a <c:out value="${lifeform}" /> you will have good luck. Also, <c:out value="${comment}" /></span>
		</div>
		<div class="text-center my-4"><a href="/omikuji">Go Back</a></div>
		
	</div>
</body>
</html>