package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FacultyDAO;
import model.Faculty;

public class AddFaculty extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Faculty faculty=new Faculty();
		faculty.setName(request.getParameter("name"));
		faculty.setUser_id(request.getParameter("uid"));
		faculty.setPhno(request.getParameter("cno"));
		faculty.setEid(request.getParameter("eid"));
		faculty.setPassword(request.getParameter("pass"));
		faculty=FacultyDAO.register(faculty);
		if(faculty.isValid())
		{
			out.println("<html><body><font color='blue' size='5'><center>");
			out.println("<b>Successfully added new Faculty</b>");
			out.println("</center></font></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("Admin_logged.jsp");
			rd.include(request,response);
			
		}
		else
		{
			out.println("<html><body><font color='red' size='5'><center>");
			out.println("<b>Something went wrong..Plz try again!!</b>");
			out.println("</center></font></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("Add_faculty.html");
			rd.include(request,response);
			
		}
		
	}

}
