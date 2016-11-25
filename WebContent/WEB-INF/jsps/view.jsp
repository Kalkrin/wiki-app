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
	<h1 align="center">${wiki.title }</h1>
	<p>${wiki.text } <br /> <br />
	<c:url var="url" value="/editWiki/${wiki.title }"/>
	<a href="${url }">Edit this wiki!</a> <br /> <br />
	Last edited by / Created by: ${wiki.edited } on ${wiki.modified }
</body>
</html>