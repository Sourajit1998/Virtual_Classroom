package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;
import model.Admin;


public class AdminLogin extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  try
		  {
			  Admin admin=new Admin();
			  admin.setUser_id(request.getParameter("uid"));
			  admin.setPassword(request.getParameter("pass"));
			  admin=AdminDAO.login(admin);
			  if(admin.isValid())
			  {
				  HttpSession session=request.getSession(true);
				  session.setAttribute("currentAdmin", admin);
				  response.sendRedirect("Admin_logged.jsp");
			  }
			  else
			  {
				  out.println("<html><body><font color='red' size='5'><center>");
				  out.println("<b>Sorry, USER-ID/PASSWORD is Wrong!!</b>");
				  out.println("</center></font></body></html>");
				  RequestDispatcher rd=request.getRequestDispatcher("Admin_login.html");
				  rd.include(request,response);
			  }
		  }
		  catch(Exception ee)
		  {
			  ee.printStackTrace();
		  }
	}

}
