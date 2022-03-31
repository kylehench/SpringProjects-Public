<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h2 class="mt-4">Save Travels</h2>
	<table class="table table-hover">
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
		</tr>
		<c:forEach var="expense" items="${expenses}">
			<tr>
				<td><c:out value="${expense.name}"/></td>
				<td><c:out value="${expense.vendor}"/></td>
				<td><c:out value="${expense.amount}"/></td>
			</tr>
		</c:forEach>
	</table>
	<h2 class="mt-4">Add an expense:</h2>
	<form:form action="/" method="post" modelAttribute="expense">
		<form:label path="name">Name:</form:label>
		<form:errors path="name"/>
		<form:input type="text" path="name" class="form-control mb-2"/>
		<form:label path="vendor">Vendor:</form:label>
		<form:errors path="vendor"/>
		<form:input type="text" path="vendor" class="form-control mb-2"/>
		<form:label path="amount">Amount:</form:label>
		<form:errors path="amount"/>
		<form:input type="text" path="amount" class="form-control mb-2"/>
		<input type="submit" value="Submit" class="btn btn-primary"/>
	</form:form>
</div>
</body>
</html>