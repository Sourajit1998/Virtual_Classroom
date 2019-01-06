package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StudentLogout extends HttpServlet 
{

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
    	response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html><body><font color='red' size='5'><center>");
        out.println("<b>You are successfully logged out!!!</b><br>");
        out.println("</center></font></body></html>");
        RequestDispatcher rd=request.getRequestDispatcher("Student_login.jsp");
        rd.include(request, response);
        HttpSession hs=request.getSession();
        hs.invalidate();
        //System.out.println(hs);
    	
	}
}