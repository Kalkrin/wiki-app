<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
	<h1 align="center">Login</h1>
	<p style="color:red;">${message }</p>
	<c:url var="checkLogin" value="/checkLogin" />
	<form method="post" action="${checkLogin }">
		<table>
			<tr>
				<td>Username: </td>
				<td><input type="text" name="userName" /></td>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="login!" /></td>
				<c:url var="url" value="/createAccount" />
				<td>Not a member? <a href="${url}">Create an account</a></td>
			</tr>
		</table>
	</form>
</body>
</html>