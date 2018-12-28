package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FacultyDAO;
import model.Faculty;

public class FacultyLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  try
		  {
			  Faculty faculty=new Faculty();
			  faculty.setUser_id(request.getParameter("uid"));
			  faculty.setPassword(request.getParameter("pass"));
			  faculty=FacultyDAO.login(faculty);
			  if(faculty.isValid())
			  {
				  HttpSession session=request.getSession(true);
				  session.setAttribute("currentFaculty", faculty);
				  response.sendRedirect("Faculty_logged.jsp");
			  }
			  else
			  {
				  out.println("<html><body><font color='red' size='5'><center>");
				  out.println("<b>Sorry, USER-ID/PASSWORD is Wrong!!</b>");
				  out.println("</center></font></body></html>");
				  RequestDispatcher rd=request.getRequestDispatcher("Faculty_login.html");
				  rd.include(request,response);
			  }
		  }
		  catch(Exception ee)
		  {
			  ee.printStackTrace();
		  }
	}

}
