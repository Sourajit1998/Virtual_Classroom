package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Admin;

public class AdminDAO 
{
	
	static Connection cn;
	static PreparedStatement ps;
	public static Admin login(Admin admin)
	{
		String user_id=admin.getUser_id();
		String pass=admin.getPassword();
		try
		{
			cn=ConnectionManager.getConnection();
			ps=cn.prepareStatement("select * from VirtualClassroom_Admin where user_id=? and password=?");
			ps.setString(1, user_id);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				admin.setValid(true);
				admin.setName(rs.getString(1));
				admin.setPhno(rs.getString(3));
				admin.setEid(rs.getString(4));
			}
			else
			{
				admin.setValid(false);
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return admin;
	}

}



