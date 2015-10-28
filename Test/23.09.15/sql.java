import java.sql.*;
import java.io.*;
import java.util.*;
class sql 
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream("db.properties");
		Properties fs = new Properties();
		fs.load(fis);
		String driver = fs.getProperty("driver");
		String url = fs.getProperty("url");
		Class.forName(driver);
		Connection con =DriverManager.getConnection(url);
		System.out.println("connection established");
		con.close();
		fis.close();
	}
}
