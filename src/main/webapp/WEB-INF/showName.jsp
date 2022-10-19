<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Name</title>
</head>
<body>
<h1><c:out value="${babyName.name}"/></h1>
<h2>Added by<c:out value="${user.name}"/></h2>
		
		<p>Gender: <c:out value="${babyName.gender}"/></p>
		<p>Origin: <c:out value="${babyName.origin}"/></p>
		<p>Meaning: <c:out value="${babyName.meaning}"/></p>
		
		<p>Liked By: </p>
			<ol>
				<c:forEach items="${babyName.likers}" var ="user">
					<li>${user.name}</li>
				</c:forEach>
			</ol>
			
	<h3>Comments</h3>
		<ul>
		<c:forEach items="${allComments}" var ="comment">
					<li>${comment.text}, By ${comment.user.name}</li>
				</c:forEach>
		</ul>

    	<a href="/names/${babyName.id}/comment">Comment</a>
		<a href="/names/${babyName.id}/edit">Edit</a>
 --></body>
</html>