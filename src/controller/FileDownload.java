package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Faculty;

public class FileDownload extends HttpServlet 
{
	private final String UPLOAD_DIRECTORY = "D:/uploads";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//first need 2 get the path of the file 2 be downloaded
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		Faculty currentFaculty=(Faculty)session.getAttribute("currentFaculty");
		String faculty_name=currentFaculty.getName();
		String file_name=request.getParameter("fileName");
		//System.out.println("file name="+file_name);
		String download_path=UPLOAD_DIRECTORY+File.separator+faculty_name;
		//System.out.println("download path="+download_path);
		File file = new File(download_path+File.separator+file_name);
	
		if (file.exists()) 
		{

			response.setContentType("APPLICATION/OCTET-STREAM");   
			response.setHeader("Content-Disposition","attachment; filename=\"" + file_name + "\"");   
			  
			FileInputStream fileInputStream = new FileInputStream(download_path +File.separator+ file_name);  
			//System.out.println("file input stream="+fileInputStream);
			            
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
}