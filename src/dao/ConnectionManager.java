package dao;
import java.sql.*;

public class ConnectionManager 
{
	static Connection cn;
	public static Connection getConnection()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return cn;
	}

}
