import java.sql.*;
class Test 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:orcl","scott","tiger");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from emp");
		while(rs.next())
		{
			String name = rs.getString("ename");
			int salary = rs.getInt("sal");
			System.out.println("Employee Name is:"+name+" and Salary is:"+salary);
		}
	}
}
