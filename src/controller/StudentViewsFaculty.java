package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FacultyDAO;
import model.Faculty;

public class StudentViewsFaculty extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 HttpSession session=request.getSession(false);
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		
		if(session!=null)
		{
			try
			{
			     List<Faculty> facultyList = FacultyDAO.view_all();
				 request.setAttribute("facultyList", facultyList);
			     RequestDispatcher rd=request.getRequestDispatcher("student_display_faculty.jsp");
			     rd.include(request, response);
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		else
		{
			out.println("<html><body><font color='red' size='5'><center>");
			out.println("<b>Please Login first !!</b>");
			out.println("</center></font></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("Student_login.jsp");
			rd.include(request,response);
		}
	 }

}
