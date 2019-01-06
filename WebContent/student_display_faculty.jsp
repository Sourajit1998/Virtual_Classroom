<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Faculty"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
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
    
     <div class="panel">
            <h1>Faculty List</h1>
            <table class="bordered_table">
               <thead>
                  <tr align="center"><th>Faculty Name</th><th>Action</th></tr>
               </thead>
               <tbody>
                  <% List<Faculty> facultyList = (List<Faculty>)request.getAttribute("facultyList");
                     if(facultyList != null && facultyList.size() > 0) 
                     {
							for(int i=0; i<facultyList.size(); i++) 
							{
                   %>

                  <tr>
                     <td align="center"><span id="facultyName"><%=facultyList.get(i).getName() %></span></td>
                     <td align="center"><span id="lectureNotes"><a id="lectureNotesLink" class="hyperLink" href="notes?facultyName=<%=facultyList.get(i).getName()%>&user-id=<%=facultyList.get(i).getUser_id() %>">Lecture Notes</a></span></td>
                 
                  </tr>
                  <% }

                   } else { %>
                  <tr>

                     <td colspan="3" align="center"><span id="noFiles">No Faculty.....!</span></td>

                  </tr>

                  <% } %>

               </tbody>

            </table>

         </div>
         <% } %>
   
</body>
</html>