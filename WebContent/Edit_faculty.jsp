<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Faculty" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function checkForm(form)
{
  if(form.name.value == "") 
  {
    alert("Error: Name cannot be blank!");
    form.name.focus();
    return false;
  }
  re =/^[a-z]+$/i;
  if(!re.test(form.name.value)) 
  {
    alert("Error:Name must contain only letters!");
    form.name.focus();
    return false;
  }
  
  if(form.uid.value == "") 
  {
    alert("Error: User-ID cannot be blank!");
    form.uid.focus();
    return false;
  }
  re = /^\w+$/;
  if(!re.test(form.uid.value)) 
  {
    alert("Error: User-ID must contain only letters, numbers and underscores!");
    form.uid.focus();
    return false;
  }
  
  if(form.cno.value=="")
  {
	  alert("Error: Contact no. cannot be blank!");
	    form.cno.focus();
	    return false;
  }
  
  if(form.cno.value!="")
  {
	  if(form.cno.value.length !=10) 
	  {
	      alert("Error: Enter a valid 10 digit contact no.!");
	      form.cno.focus();
	      return false;
	  }
	  
  }
  
  if(form.eid.value=="")
  {
	  alert("Error: Email id cannot be blank!");
	    form.eid.focus();
	    return false;
  }

  if(form.pass.value != "" && form.pass.value == form.repass.value) 
  {
    if(form.pass.value.length < 6) 
    {
      alert("Error: Password must contain at least six characters!");
      form.pass.focus();
      return false;
    }
    re = /[0-9]/;
    if(!re.test(form.pass.value)) 
    {
      alert("Error: password must contain at least one number (0-9)!");
      form.pass.focus();
      return false;
    }
    re = /[a-z]/;
    if(!re.test(form.pass.value)) 
    {
      alert("Error: password must contain at least one lowercase letter (a-z)!");
      form.pass.focus();
      return false;
    }
    
  } 
  else 
  {
    alert("Error: Please check that you've entered and confirmed your password!");
    form.pass.focus();
    return false;
  }

}
</script>
<head>
<title>Edit Faculty </title>
<link rel="stylesheet" type="text/css" href="style1.css" >
</head>
<body>
<center>
<font color="blue" size="3">
<h1><b>VIRTUAL-CLASSROOM</b></h1>

<div class="vclass-form">

<form action="update_faculty" method="post" onsubmit="return checkForm(this);">

<table>

<h2 align="center"><b>EDIT FACULTY</b></h2>
<%Faculty editFaculty=(Faculty)request.getAttribute("facultyDetails");%>
<tr><td>Name</td><td><input type="text" name="name" class="field left" readonly="readonly" value="<%=editFaculty.getName() %>" id="button"></td></tr>
<tr><td>User-ID</td><td><input type="text" name="uid" class="field left" readonly="readonly" value="<%=editFaculty.getUser_id() %>" id="button"></td></tr>
<tr><td>Contact no.</td><td><input type="number" name="cno" title="Contact no. must be of 10 digits" value="<%=editFaculty.getPhno() %>" id="button" placeholder="Enter the contact no."></td></tr>
<tr><td>Email id</td><td><input type="email" name="eid" title="Email id must be a valid one" id="button" value="<%=editFaculty.getEid() %>" placeholder="Enter the email-id"></td></tr>
<tr><td>Password</td><td><input type="password" name="pass" title="Password must contain at least 6 characters, including UPPER/lowercase and numbers." value="<%=editFaculty.getPassword() %>" id="button" placeholder="Enter the password"></td></tr>
<tr><td>Confirm Password</td><td><input type="password" name="repass" title="Please enter the same Password as above." value="<%=editFaculty.getPassword() %>" id="button" placeholder="Re-Enter the password"></td></tr>

</table>
<br><br>

<input type="submit" value="UPDATE" id="butt">&nbsp
<input type="reset" value="RESET" id="butt">
<br><br><br>
<a href="Admin_logged.jsp"> <i>Back</i></a>
</form>
</div>
</font>
</center>
</body>
</html>