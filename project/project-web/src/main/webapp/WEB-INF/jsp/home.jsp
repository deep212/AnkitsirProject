<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/css/style.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message}
<form:form action="save" method="POST" modelAttribute="registration">
<div id="content">
		<div class="search">
		
			<form action="#">
				<img src="resources/images/title.gif" alt="" width="90" height="30" />
				<input type="text" class="first input" value="Enter keywords" /> <input type="text" class="second input" value="Enter Locations (country, city, zip code)" />
				<a href="#" class="button">Search</a>
				<div class="line">
					<input type="checkbox" class="check" /> <span class="exept">Search Title Only</span>
					<div class="links">
						<a href="#">US Job Search</a> | <a href="#">More Search Options</a>
					</div>
				</div>
			</form>
		</div></div>
	</form:form>
</body>
</html>