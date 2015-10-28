<%-- 
    Document   : index
    Created on : Sep 9, 2015, 8:28:10 PM
    Author     : alok
--%>

<%@page import="java.sql.*"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Date;"%>
<%@page import="java.text.*;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%Date dt= new Date();
               SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
        %></h1>
        <%= sd.format(dt) %>
        
        <%
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:orcl","scott","tiger");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from emp");
		while(rs.next())
		{
                        String name = rs.getString("ename");
			int salary = rs.getInt("sal");
        
        %>
        <%= name+" : "+salary+"<br />" %>
        <% } %>
        
    </body>
</html>
