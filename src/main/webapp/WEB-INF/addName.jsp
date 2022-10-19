<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/logout">logout</a>
<form:form action="/names/new/create" modelAttribute="babyName" method="post">
			<h1>Add a name!</h1>
			<form:label path="name">New Name:</form:label>
			<form:errors path="name"/> 
			<form:input type= "text" path="name"/>
			
			
			<form:select path="gender">  
	        <form:option value="neutral" label="neutral"/>  
	        <form:option value="boy" label="boy"/>  
	        <form:option value="girl" label="girl"/>  
	        </form:select>  
			
			<form:label path="origin">Origin:</form:label>
			<form:errors path="origin"/> 
			<form:input type= "text" path="origin"/>
			
			<form:label path="meaning">Meaning:</form:label>
			<form:errors path="meaning"/> 
			<form:input type= "text" path="meaning"/>
			
			<form:errors path="user" />
			<form:input type="hidden" path="user" value="${user.id}"/>
			
	
			
			<input type="submit" value ="Submit">
			<a href="/home">Cancel</a>
			
		</form:form>
</body>
</html>