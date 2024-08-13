package Connectivity;
import java.sql.*;

public class DB 
{
    public static Connection getCon()
    {
       try
       {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localHost/employees","root","0703");
           return con;
       }catch(Exception e)
       {
           System.out.println(e);
           return null;
       }
    }
}
