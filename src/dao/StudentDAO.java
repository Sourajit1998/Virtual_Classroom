package dao;

import java.sql.*;

import model.Student;

public class StudentDAO 
{
	static PreparedStatement ps;
	static Connection cn;
	
	public static Student register(Student student)
	{
		String name=student.getName();
		String u_id=student.getUser_id();
		String phno=student.getPh_no();
		String eid=student.getE_id();
		String pass=student.getPassword();
		try
		{
			cn=ConnectionManager.getConnection();
			ps=cn.prepareStatement("insert into Student values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, u_id);
			ps.setString(3, phno);
			ps.setString(4, eid);
			ps.setString(5, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				student.setValid(true);                  //Registration successful(Check for duplicate accounts later)
			}
			else
			{
		         student.setValid(false);				//Registration unsuccessfulS
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return student;
	}
	public static Student login(Student student)
	{
		String u_id=student.getUser_id();
		//System.out.println("uid="+u_id);
		String pass=student.getPassword();
		try 
		{
			cn=ConnectionManager.getConnection();
			ps=cn.prepareStatement("select * from Student where user_id=? and password=? ");
			ps.setString(1,u_id);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				student.setName(rs.getString(1));
				student.setPh_no(rs.getString(3));
				student.setE_id(rs.getString(4));
				//System.out.println("Welcome "+student.getUser_id());
				student.setValid(true);
			}
			else
			{
				 //System.out.println("Sorry, you are not a registered user! Please sign up first");
		         student.setValid(false);
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return student;
	}
	

}
