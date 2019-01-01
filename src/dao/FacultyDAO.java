package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Faculty;
import model.UploadDetail;

public class FacultyDAO 
{
	static Connection cn;
	static PreparedStatement ps;
	public static Faculty login(Faculty faculty)
	{
		String user_id=faculty.getUser_id();
		String pass=faculty.getPassword();
		try
		{
			cn=ConnectionManager.getConnection();
			ps=cn.prepareStatement("select * from Faculty where user_id=? and password=?");
			ps.setString(1, user_id);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				faculty.setValid(true);
				faculty.setName(rs.getString(1));
				faculty.setPhno(rs.getString(3));
				faculty.setEid(rs.getString(4));
			}
			else
			{
				faculty.setValid(false);
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return faculty;
	}
	public static Faculty register(Faculty faculty) 
	{
		String name=faculty.getName();
		String user_id=faculty.getUser_id();
		String phno=faculty.getPhno();
		String eid=faculty.getEid();
		String pass=faculty.getPassword();
		try
		{
			cn=ConnectionManager.getConnection();
			ps=cn.prepareStatement("insert into Faculty values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, user_id);
			ps.setString(3, phno);
			ps.setString(4, eid);
			ps.setString(5, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				faculty.setValid(true);
			}
			else
			{
				faculty.setValid(false);
			}
			
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return faculty;
	}
	public static List<Faculty> view_all()
	{
		List<Faculty> facultyList=new ArrayList<Faculty>();
		try
		{
			cn=ConnectionManager.getConnection();
			Faculty faculty;
			ps=cn.prepareStatement("select name,user_id,phno,email_id from Faculty");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				faculty=new Faculty();
				faculty.setName(rs.getString(1));
				faculty.setUser_id(rs.getString(2));
				faculty.setPhno(rs.getString(3));
				faculty.setEid(rs.getString(4));
				facultyList.add(faculty);
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return facultyList;
		
	}
	public static List<Faculty> remove(Faculty faculty) 
	{
		List<Faculty> facultyList = null;
		String name=faculty.getName();
		String user_id=faculty.getUser_id();
		//System.out.println("Name="+name+" "+"User ID="+user_id);
		try
		{
			//Faculty remove_faculty;
			cn=ConnectionManager.getConnection();
			ps=cn.prepareStatement("delete from Faculty where name=? and user_id=?");
			ps.setString(1, name);
			ps.setString(2, user_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				 facultyList =view_all();
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return facultyList;
	}
	public static Faculty edit(Faculty faculty)
	{
		String name=faculty.getName();
		String user_id=faculty.getUser_id();
		try
		{
			cn=ConnectionManager.getConnection();
			ps=cn.prepareStatement("select * from Faculty where name=? and user_id=?");
			ps.setString(1, name);
			ps.setString(2, user_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				faculty.setValid(true);
				faculty.setName(rs.getString(1));
				faculty.setPhno(rs.getString(3));
				faculty.setEid(rs.getString(4));
				faculty.setPassword(rs.getString(5));
			}
			else
			{
				faculty.setValid(false);
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return faculty;
	}
	public static Faculty update(Faculty faculty)
	{
		String name=faculty.getName();
		String user_id=faculty.getUser_id();
		String phno=faculty.getPhno();
		String eid=faculty.getEid();
		String pass=faculty.getPassword();
		try
		{
			cn=ConnectionManager.getConnection();
			ps=cn.prepareStatement("update Faculty set phno=?,email_id=?,password=? where name=? and user_id=?");
			ps.setString(1, phno);
			ps.setString(2, eid);
			ps.setString(3, pass);
			ps.setString(4, name);
			ps.setString(5, user_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				faculty.setValid(true);
			}
			else
			{
				faculty.setValid(false);
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return faculty;
		
		
	}

}
