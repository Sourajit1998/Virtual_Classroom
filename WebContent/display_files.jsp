<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.UploadDetail" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <div class="panel">
            <h1>Uploaded Files</h1>
            <table class="bordered_table">
               <thead>
                  <tr align="center"><th>File Name</th><th>File Size</th><th>Action</th></tr>
               </thead>
               <tbody>
                  <% List<UploadDetail> uploadDetails = (List<UploadDetail>)request.getAttribute("uploadedFiles");
                     if(uploadDetails != null && uploadDetails.size() > 0) 
                     {
							for(int i=0; i<uploadDetails.size(); i++) 
							{
                   %>

                  <tr>
                     <td align="center"><span id="fileName"><%=uploadDetails.get(i).getFileName() %></span></td>
                     <td align="center"><span id="fileSize"><%=uploadDetails.get(i).getFileSize() %> KB</span></td>
                     <td align="left"><span id="fileDownload"><a id="downloadLink" class="hyperLink" href="download?fileName=<%=uploadDetails.get(i).getFileName() %>">Download</a></span></td>
           			 <td align="right"><span id="fileDelete"><a id="deleteLink" class="hyperLink" href="delete?fileName=<%=uploadDetails.get(i).getFileName() %>">Delete</a></span></td>
                  </tr>
                  <% }

                   } else { %>
                  <tr>

                     <td colspan="3" align="center"><span id="noFiles">No Files Uploaded.....!</span></td>

                  </tr>

                  <% } %>

               </tbody>

            </table>

         </div>
   
</body>
</html>