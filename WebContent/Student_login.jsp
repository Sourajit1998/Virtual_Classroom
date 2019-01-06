<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<script>
	function Valid1()
	{
	     var a=document.stud.uid.value;
	     var b=document.stud.pass.value;
	     if(a==""||a==null)
	     {
	    	 alert("Please enter ur user-id");
	         return false;
	     }
	     if(b==""||b==null)
	     {
	    	 alert("Please enter ur Password");
	         return false;
	     }
	}
	function change(x)
	{
		if(x==1)
	    {
		     location.href='Faculty_login.html';
		}
		else if(x==2)
		{
			location.href='Admin_login.html';		
		}
		return;
	}
	</script>
	<head>
		<title>Student Login_Page </title>
		<link rel="stylesheet" type="text/css" href="style1.css" >
	</head>
	<body>
		<center>
		 <font color='red' size='5'>
		    <% String error=request.getParameter("error");
		          if(error!=null){%>
		    	Error message :  <%= request.getParameter("error") %>!
		    <%} %>	
		    </font>
			<font color="blue" size="3">
			<h1><b>V-CLASSROOM</b></h1>
			<p><marquee behavior="alternate" onmouseover="this.stop()" onmouseout="this.start()">Welcome to Virtual Classroom </marquee></p>
			<div class="v-form">
			
			<form action="stud_log" name="stud" method="post" onsubmit="return Valid1();">
			
				<table>
				<input type="radio" name="occ" value="faculty" onclick="change(1)">Faculty &nbsp&nbsp
				<input type="radio" name="occ" value="student" checked>Student &nbsp&nbsp
				<input type="radio" name="occ" value="admin" onclick="change(2)">Admin<br><br>
				<h2 align="center"><b>STUDENT_LOGIN</b></h2>
				<tr><td>User-ID</td><td><input type="text" name="uid" id="button" placeholder="Enter your User-ID"></td></tr>
				<br>
				<tr><td>Password</td><td> <input type="password" name="pass" id="button" placeholder="Enter your Password"></td></tr>
				</table>
				<br><br>
				
				<input type="submit" value="LOGIN" id="butt">&nbsp
				<input type="reset" value="RESET" id="butt"><br><br>
				<b>Dont hav an account??</b><br><br>
				<a href="Student_register.html">Click here 2 register</a></tr><br><br>
				
				
			
			</form>
			</div>
			</font>
		</center>
	</body>
</html>




