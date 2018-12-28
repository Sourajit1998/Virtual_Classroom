package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import model.Faculty;
import model.UploadDetail;

public class FileUpload extends HttpServlet 
{
	private final String UPLOAD_DIRECTORY = "D:/uploads";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		Faculty currentFaculty=(Faculty)session.getAttribute("currentFaculty");
		String faculty_name=currentFaculty.getName();
		try 
		{
			String upload_path=UPLOAD_DIRECTORY+File.separator +faculty_name;
			//System.out.print("Upload path="+upload_path);
			File fileUploadDir=new File(upload_path);
			if(!fileUploadDir.exists())
			{
				fileUploadDir.mkdir();
			}
			String fileName = "";
			UploadDetail details;
	        List<UploadDetail> fileList = new ArrayList<UploadDetail>();
	    
			ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multifiles=sf.parseRequest(request);
			for(FileItem item:multifiles)                       //go thru the request 2 scan multiple files present in the request
			{
				if(!item.isFormField())
				{
					    String name = new File(item.getName()).getName();              
					    String file_type=FilenameUtils.getExtension(name);
					    details = new UploadDetail();
					    details.setFileName(name);
					    details.setFileSize(item.getSize()/1024);
					    details.setFileType(file_type);
					    try
					    {
					    	item.write(new File(upload_path+File.separator+name));
					    	details.setUploadStatus("Success");
					    }
					    catch(IOException io)
					    {
					    	details.setUploadStatus("Failure "+io);
					    }
					    fileList.add(details);
				}
			}
		
			request.setAttribute("uploadedFiles", fileList);
			out.println("<html><body><font color='red' size='5'><center>");
			out.println("<b>File uploaded successfully</b>");
			out.println("</center></font></body></html>");
			RequestDispatcher rd=request.getRequestDispatcher("Faculty_logged.jsp");
			rd.include(request,response);
		
		}
					  
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
	}
}
