import java.sql.*;
class Sql
{
	public static void main(String args[]) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=");
		System.out.println("Connection established");
		con.setAutoCommit(false);
		Statement st = con.createStatement();
		st.addBatch("insert into db values(13,'app',33,44)");
		st.addBatch("insert into db values(19,'app',33,44)");
		st.addBatch("insert into db values(25,'app',33,44)");
		st.addBatch("insert into db values(33,'app',33,44)");
		int i[] = st.executeBatch();
		for (int x:i)
		{
			System.out.println(x);
		}
		ResultSet rs = st.executeQuery("select * from db");

		while(rs.next())
		{
			String s = rs.getString("name");
			System.out.println(s);
		}
		con.rollback();


	}
}