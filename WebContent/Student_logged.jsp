<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
    <%Student currentUser=(Student)session.getAttribute("currentSessionUser");
    if ( currentUser == null) 
    {
 	   response.sendRedirect("Student_login.jsp?error=Login First");
    }
    else{%>

		Welcome <%= currentUser.getName() %><br><br>
		<a href="stud_pro">Profile</a><br><br>
		<a href="stud_view_fac">Lecture Notes</a><br><br>
		<a href="stud_logout">Logout</a>
      <% } %>

</body>
</html>