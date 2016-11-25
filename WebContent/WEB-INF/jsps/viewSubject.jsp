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
	<h1 align="center">Wiki's for the subject ${subject }</h1>
		<c:forEach var="wiki" items="${subjectList }">
			<c:url var="view" value="/view/${wiki.title }" />
			<a href="${view}">${wiki.title }</a> <br />
		</c:forEach>
</body>
</html>