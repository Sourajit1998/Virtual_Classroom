package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Faculty;;

public class FacultyProfile extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession(false);
		Faculty currentFaculty=(Faculty)session.getAttribute("currentFaculty");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("name="+currentFaculty.getName());
		out.println("User ID="+currentFaculty.getUser_id());
		out.println("pass="+currentFaculty.getPassword());
		out.println("email="+currentFaculty.getEid());
		out.println("Phone no="+currentFaculty.getPhno());
		

	}

}
