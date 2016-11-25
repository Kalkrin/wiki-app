<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Creation</title>
</head>
<body>
	<h1 align="center">Create an account</h1>
	<p style="color: red;">${message }</p>
	<table>
		<c:url var="url" value="/saveAccount" />
		<form:form commandName="user" method="post" action="${url }">
			<tr>
				<td>Username: </td>
				<td><form:input path="username"/></td>
			<tr>
				<td>Password: </td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td>First Name: </td>
				<td><form:input path="fName"/></td>
			</tr>
			<tr>
				<td>Last Name: </td>
				<td><form:input path="lName"/></td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="Create Account!" /></td>
				<c:url var="home" value="/" />
				<td align="center"><a href="${home }">Back to home</a>
			</tr>
		</form:form>
	</table>
</body>
</html>