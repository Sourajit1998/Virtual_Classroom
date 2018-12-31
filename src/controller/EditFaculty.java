package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FacultyDAO;
import model.Faculty;

//Admin edits Faculty's profile
public class EditFaculty extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name=request.getParameter("facultyName");
		String user_id=request.getParameter("user-id");
		Faculty faculty=new Faculty();
		faculty.setName(name);
		faculty.setUser_id(user_id);
		faculty=FacultyDAO.edit(faculty);
		request.setAttribute("facultyDetails", faculty);
		RequestDispatcher rd=request.getRequestDispatcher("Edit_faculty.jsp");
	    rd.include(request, response);
          
	}

}
