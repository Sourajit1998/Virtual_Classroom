package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDAO;
import model.Student;

public class StudentProfile extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession(false);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//System.out.println(session);
		
		if(session!=null)
		{
			try
			{
				Student currentUser=(Student)session.getAttribute("currentSessionUser");
				out.println("name="+currentUser.getName());
				out.println("User ID="+currentUser.getUser_id());
				out.println("pass="+currentUser.getPassword());
				out.println("email="+currentUser.getE_id());
				out.println("Phone no="+currentUser.getPh_no());
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