<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Faculty" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function checkFile() {
    var fileElement = document.getElementById("file");
    var fileExtension = "";
    if (fileElement.value.lastIndexOf(".") > 0) {
        fileExtension = fileElement.value.substring(fileElement.value.lastIndexOf(".") + 1, fileElement.value.length);
    }
    if (fileExtension.toLowerCase()=="pptx" || fileExtension.toLowerCase()=="ppt" || fileExtension.toLowerCase()=="pdf" || fileExtension.toLowerCase()=="doc" || fileExtension.toLowerCase()=="docx" || fileExtension.toLowerCase()=="txt") 
    {
        return true;
    }
    else 
    {
        alert("You must select a pptx/ppt/pdf/doc/docx/txt file for upload");
        return false;
    }
}
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Faculty currentFaculty=(Faculty)session.getAttribute("currentFaculty");%>
	Welcome <%= currentFaculty.getName() %><br><br>
	<a href="fac_pro">Profile</a><br><br>
	
	<form action="upload" method="post" encType="multipart/form-data" onsubmit="return checkFile();">
		<input type="file" name="file" id="file" multiple/>
		<input type="submit" value="Upload File">
	</form><br><br>
	<a href="disp_files">Display uploaded files</a>

</body>
</html>