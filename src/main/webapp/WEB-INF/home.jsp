<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="path/to/fontawesome.min.css">


<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h1>Hello, <c:out value="${user.name}"/>.Here are some name suggestions..</h1>		
		<h2>Baby Names</h2>
		
		<a href="/logout">logout</a>
		
		
		<table>
		
			<tr>
				
				<th>Name</th>
				<th>Gender</th>
				<th>Origin</th>
				<th>Action</th>
				<th><ion-icon name="heart"></ion-icon></i></th>
				
				
			</tr>
			<c:forEach var="babyName" items="${babyName}">
			
				<tr>
					
					<td><a href="names/${babyName.id}"><c:out value="${babyName.name}"/></a></td>
					<td><c:out value="${babyName.gender}"/></td>
					<td><c:out value="${babyName.origin}"/></td>
					<td>
					<c:choose>
					<c:when test="${babyName.likers.contains(user)}">
						<a href="/unlike/${babyName.id}">Unlike</a>
					</c:when>
					<c:otherwise>
						<a href="/like/${babyName.id}">Like</a>
					</c:otherwise>
					</c:choose>
					</td>
					<td><c:out value="${babyName.likers.size()}"/></td>
					
					
				
						    
		
			</c:forEach>		
		</table>
				<a href="/names/new"> new name</a>
				
				<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>