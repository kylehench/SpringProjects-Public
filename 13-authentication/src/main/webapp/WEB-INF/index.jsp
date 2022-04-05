<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container d-flex pt-4">
		<div class="container p-3">
			<h2>Register</h2>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<form:label path="userName">User Name:</form:label>
				<form:errors path="userName"/>
				<form:input type="text" path="userName" class="form-control mb-2" />
				<form:label path="email">Email:</form:label>
				<form:errors path="email"/>
				<form:input type="text" path="email" class="form-control mb-2" />
				<form:label path="password">Password:</form:label>
				<form:errors path="password"/>
				<form:input type="password" path="password" class="form-control mb-2" />
				<form:label path="confirm">Confirm Password:</form:label>
				<form:errors path="confirm"/>
				<form:input type="password" path="confirm" class="form-control mb-2" />
				<input type="submit" value="Register" class="btn btn-primary" />
			</form:form>
		</div>
		<div class="container p-3">
			<h2>Login</h2>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<form:label path="email">Email:</form:label>
				<form:errors path="email"/>
				<form:input type="text" path="email" class="form-control mb-2" />
				<form:label path="password">Password:</form:label>
				<form:errors path="password"/>
				<form:input type="text" path="password" class="form-control mb-2" />
				<input type="submit" value="Login" class="btn btn-success" />
			</form:form>
		</div>
	</div>
</body>
</html>