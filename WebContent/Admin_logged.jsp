<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Admin" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Admin currentAdmin=(Admin)session.getAttribute("currentAdmin");%>
	Welcome <%= currentAdmin.getName() %><br><br>
	<a href="adm_pro">Profile</a><br><br>
	<a href="Add_faculty.html">Add Faculty</a><br><br>
	<a href="display_faculty">View Faculty</a><br><br>
</body>
</html>