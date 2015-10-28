import java.sql.*;




class Mysql{
    public static void main(String[] args) throws Exception {

            Class.forName("com.mysql.jdbc.Driver");
		
	Connection con=	DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                                   "user=root&password=");
			Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from a");
		while(rs.next())
		{
			String name = rs.getString("name");
			String add = rs.getString("add");
			System.out.println("Employee Name is:"+name+" and Salary is:"+add);
		}



    }
}