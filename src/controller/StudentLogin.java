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

import dao.StudentDAO;
import model.Student;

@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try
		{
			Student student=new Student();
			student.setUser_id(request.getParameter("uid"));
			student.setPassword(request.getParameter("pass"));
			student=StudentDAO.login(student);
			if(student.isValid())
			{
				HttpSession session=request.getSession(true);
				//System.out.println(session);
				session.setAttribute("currentSessionUser", student);
				response.sendRedirect("Student_logged.jsp");
			}
			else
			{
				out.println("<html><body><font color='red' size='5'><center>");
				out.println("<b>Sorry, you are not a registered user! Please sign up first!!</b>");
				out.println("</center></font></body></html>");
				RequestDispatcher rd=request.getRequestDispatcher("Student_login.html");
				rd.include(request,response);
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

}
