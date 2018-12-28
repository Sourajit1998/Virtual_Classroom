package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Faculty;
import model.UploadDetail;

public class UploadedFiles extends HttpServlet 
{
	private final String UPLOAD_DIRECTORY = "D:/uploads";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		Faculty currentFaculty=(Faculty)session.getAttribute("currentFaculty");
		String faculty_name=currentFaculty.getName();
		try 
		{
			String upload_path=UPLOAD_DIRECTORY+File.separator +faculty_name;
			File fileUploadDir=new File(upload_path);
			if(!fileUploadDir.exists())
			{
				fileUploadDir.mkdir();
			}
			UploadDetail details;
			File allFiles[]=fileUploadDir.listFiles();
	        List<UploadDetail> fileList = new ArrayList<UploadDetail>();
	        for(File file:allFiles)
	        {
	        	details=new UploadDetail();
	        	details.setFileName(file.getName());
	        	details.setFileSize(file.length()/1024);
	        	fileList.add(details);
	        }
	        request.setAttribute("uploadedFiles", fileList);
	        RequestDispatcher rd=request.getRequestDispatcher("display_files.jsp");
	        rd.include(request,response);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		
	}

}
