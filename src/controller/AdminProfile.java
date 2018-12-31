package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;


public class AdminProfile extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession(false);
		Admin currentAdmin=(Admin)session.getAttribute("currentAdmin");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("name="+currentAdmin.getName());
		out.println("User ID="+currentAdmin.getUser_id());
		out.println("pass="+currentAdmin.getPassword());
		out.println("email="+currentAdmin.getEid());
		out.println("Phone no="+currentAdmin.getPhno());
	}
}
