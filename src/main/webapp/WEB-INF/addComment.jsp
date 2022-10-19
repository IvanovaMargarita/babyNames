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
		<table>
			<tr>
				<th>Comments</th>
			<tr>
<%-- 				<td><c:out value="${comment.text}"/></td>
 --%>		</table>
			
	 	<form:form action="/${babyName.id}/comment/add" modelAttribute="newComment" method="post">
<%-- 				<form:input type="hidden" path="id"/>
 --%>			<form:hidden path="babyName" value="${babyName.id}"/>
				<form:hidden path="user" value="${user.id}"/>
				
				<form:label path="text">Add Comment:</form:label>
				<form:errors path="text"/> 
				<form:input type= "text" path="text"/>
			<input type="submit" value ="Submit">
			<a href="/home">Cancel</a>
	    </form:form> 
</body>
</html>
				
					
					
		
				
					
				
						    
		