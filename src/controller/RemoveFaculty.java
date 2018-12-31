package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FacultyDAO;
import model.Faculty;


public class RemoveFaculty extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Faculty faculty=new Faculty();
		faculty.setName(request.getParameter("facultyName"));
		faculty.setUser_id(request.getParameter("user-id"));
		List<Faculty> facultyList = FacultyDAO.remove(faculty);
		request.setAttribute("facultyList", facultyList);
		//response.sendRedirect("display_faculty.jsp");
		out.println("<html><body><font color='red' size='5'><center>");
		out.println("<b>Faculty removed successfully</b>");
		out.println("</center></font></body></html>");
	    RequestDispatcher rd=request.getRequestDispatcher("Admin_logged.jsp");
	    //rd.forward(request, response);
	    rd.include(request,response);
	
	}
}
