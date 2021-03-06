<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wiki Creation</title>
</head>
<body>
	<p style="float: right;">${message }</p>
	<h1 align="center">Create a new wiki article</h1>
	<table>
		<c:url var="url" value="/saveWiki" />
		<form:form commandName="wiki" method="post" action="${url }">
			<tr>
				<td>Title: </td>
				<td><form:input path="title"/></td>
			<tr>
				<td>Subject: </td>
				<td><form:select path="subject" items="${wiki.subjects }"/></td>
			</tr>
			<tr>
				<td valign="top">Content: </td>
				<td><form:textarea path="text" cols="100" rows="50"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Create Wiki!" /></td>
			</tr>
		</form:form>
	</table>
</body>
</html>