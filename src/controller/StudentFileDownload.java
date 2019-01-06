package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Faculty;

public class StudentFileDownload extends HttpServlet 
{
	private final String UPLOAD_DIRECTORY = "D:/uploads";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession(false);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String faculty_name=request.getParameter("facultyName");
		String file_name=request.getParameter("fileName");
		String download_path=UPLOAD_DIRECTORY+File.separator+faculty_name;
		File file = new File(download_path+File.separator+file_name);
	
			if(session!=null)
			{
				try
				{
					if (file.exists()) 
					{
			
						response.setContentType("APPLICATION/OCTET-STREAM");   
						response.setHeader("Content-Disposition","attachment; filename=\"" + file_name + "\"");   
						  
						FileInputStream fileInputStream = new FileInputStream(download_path +File.separator+ file_name);  
						            
						int i;   
						while ((i=fileInputStream.read()) != -1) 
						{  
							out.write(i);   
						}   
						fileInputStream.close();   
						out.close();   
					}  
					else
					{
						out.println("<h3>File "+ file_name +" Is Not Present .....!</h3>");             //design to be done later
					}
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
	