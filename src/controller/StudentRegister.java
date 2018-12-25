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

@WebServlet("/StudentRegister")
public class StudentRegister extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try
		{
			Student student=new Student();
			student.setName(request.getParameter("name"));
			student.setUser_id(request.getParameter("rno"));
			student.setPh_no(request.getParameter("phno"));
			student.setE_id(request.getParameter("eid"));
			student.setPassword(request.getParameter("pass1"));
			student=StudentDAO.register(student);
			if(student.isValid())
			{
				out.println("<html><body><font color='blue' size='5'><center>");
				out.println("<b>Registration successful</b>");
				out.println("</center></font></body></html>");
				RequestDispatcher rd=request.getRequestDispatcher("Student_login.html");
				rd.include(request,response);
			}
			else
			{
				out.println("<html><body><font color='red' size='5'><center>");
				out.println("<b>Something went wrong</b>");
				out.println("</center></font></body></html>");
				RequestDispatcher rd=request.getRequestDispatcher("Student_register.html");
				rd.include(request,response);
			}
		}	
		
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

}

