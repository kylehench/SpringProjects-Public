<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Expense</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-between align-items-baseline">
		<h2 class="mt-4">Expense Details:</h2>
		<p><a href="/">Go back</a></p>
	</div>
	<table class="table table-hover">
	  <tr>
	    <td>Expense Name:</td>
	    <td><c:out value="${expense.name}" /></td>
	  </tr>
	  <tr>
	    <td>Vendor:</td>
	    <td><c:out value="${expense.vendor}" /></td>
	  </tr>
	  <tr>
	    <td>Amount Spent:</td>
	    <td>$<c:out value="${expense.amount}" /></td>
	  </tr>
	</table>
</div>
</body>
</html>