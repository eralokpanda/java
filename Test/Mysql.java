import java.sql.*;


// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class Mysql{
    public static void main(String[] args) throws Exception {

            Class.forName("com.mysql.jdbc.Driver");
		
	Connection con=	DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                                   "user=root&password=");
			Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from a");
		while(rs.next())
		{
			String name = rs.getString("name");
			int salary = rs.getInt("add");
			System.out.println("Employee Name is:"+name+" and Salary is:"+salary);
		}



    }
}