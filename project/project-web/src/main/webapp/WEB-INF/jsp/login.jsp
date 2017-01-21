<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="matchEmail" method="POST" modelAttribute="registration">
<table align="center" bordercolor="green" border="6" cellpadding="8" cellspacing="7">

<tr><td>Email:</td><td><form:input type="email" path="email" size="40"/></td></tr>
<tr><td>Password:</td><td><form:input type="password" path="password" size="40"/></td></tr>

<tr><td><input type="submit" value="Submit"></td></tr>

<tr><td><a href="ForgetPassword">ForgetPassword</a></td></tr>
</table>
</form:form>
</body>
</html>