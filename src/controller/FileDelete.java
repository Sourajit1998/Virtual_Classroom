package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Faculty;

public class FileDelete extends HttpServlet 
{

	private final String UPLOAD_DIRECTORY = "D:/uploads";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//first need 2 get the path of the file 2 be deleted
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		Faculty currentFaculty=(Faculty)session.getAttribute("currentFaculty");
		String faculty_name=currentFaculty.getName();
		String file_name=request.getParameter("fileName");
		//System.out.println("file name="+file_name);
		String delete_path=UPLOAD_DIRECTORY+File.separator+faculty_name;
		//System.out.println("download path="+download_path);
		try
		{
			File file = new File(delete_path+File.separator+file_name);
			if(file.delete())
			{
				out.println("<html><body><font color='red' size='5'><center>");
				out.println("<b>"+file.getName()+" has been deleted successfully</b>");
				out.println("</center></font></body></html>");
				RequestDispatcher rd=request.getRequestDispatcher("Faculty_logged.jsp");
				rd.include(request, response);
			}
			else
			{
				out.println("<html><body><font color='red' size='5'><center>");
				out.println("<b>Failed to delete file</b>");
				out.println("</center></font></body></html>");
				RequestDispatcher rd=request.getRequestDispatcher("Faculty_logged.jsp");
				rd.include(request, response);
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
}