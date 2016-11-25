<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<p style="float: right;">${message }</p>
	<h1 align="center">Craig's Wiki's</h1>
	<h2>Subjects</h2>
	<table>
	<c:forEach items="${subjects }" var="subject">
		<tr>
			<c:url value="/viewSubject/${subject }" var="url"></c:url>
			<td align="left"><a href="${url }">${subject }</a></td>
		</tr>
	</c:forEach>
	</table>
	<br />
	<table>
		<tr>
			<td>
				<c:url value="/login" var="login"/>
				<a href="${login }">Login</a>
			</td>
			<td>
				<c:url value="/createWiki" var="create"/>
				<a href="${create }">Create New Wiki</a>
			</td>
			<td>
				<c:url value="/randomArticle" var="random" />
				<a href="${random }">Random Article</a>
			</td>
		</tr>
	</table>
</body>
</html>