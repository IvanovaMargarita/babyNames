<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Name</title>
</head>
<body>
<form:form action="/names/new/create" modelAttribute="babyName" method="post">
			<h1>Change <c:out value="${babyName.name}"/></h1>
			
			<form:input type="hidden" path="id"/>
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
			<a href="/names/${babyName.id}/delete">Delete Show</a>
			
			
		</form:form>
</body>
</html>