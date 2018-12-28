package dao;

import java.sql.*;

import model.Faculty;

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

}
