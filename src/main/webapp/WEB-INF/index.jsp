<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous"> -->
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>

<div class="container">
<form:form method="post" action="/register" modelAttribute="newUser">
<h1>Joy Bundler Name</h1>
	<h2>Register</h2>
		<div class="form-group">
			<form:label  path="name">Name</form:label>
			<form:errors path="name"/> 
			<form:input class="form-control" type= "text" path="name"/>
		</div>
	
		
		<div class="form-group">
			<form:label path="email">Email</form:label>
			<form:errors path="email"/> 
			<form:input class="form-control" type= "email" path="email"/>
		</div>
		
		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:errors path="password"/> 
			<form:password class="form-control" path="password"/>
		</div>
		
		<div class="form-group">
			<form:label path="confirm">Confirm Password</form:label>
			<form:errors path="confirm"/> 
			<form:password  class="form-control" path="confirm"/>
		</div>
		
			<input type="submit" value ="Register">

		</form:form>
	</div>
		

<div class="container">

<form:form method="post" action="/login" modelAttribute="newLogin">
			<h2>Login</h2>
		<div class="form-group">
			<form:label  path="email">Email</form:label>
			<form:errors path="email"/> 
			<form:input class="form-control" type="email" path="email"/>
		</div>
		<div class="form-group">
			<form:label   path="password">Password</form:label>
			<form:errors path="password"/> 
			<form:input class="form-control" type="password" path="password"/>
		</div>	
			
			
			<input type="submit" value ="Login">
			
		

		</form:form>
		
</div>

</body>
</html>