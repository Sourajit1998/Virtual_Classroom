package controller;

import java.io.IOException;
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
		try
		{
			Student student=new Student();
			student.setUser_id(request.getParameter("uid"));
			student.setPassword(request.getParameter("pass"));
			student=StudentDAO.login(student);
			if(student.isValid())
			{
				HttpSession session=request.getSession(true);
				session.setAttribute("currentSessionUser", student);
				response.sendRedirect("logged.jsp");
			}
			else
			{
				response.sendRedirect("invalid_log.jsp");
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

}
