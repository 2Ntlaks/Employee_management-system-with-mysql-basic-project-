package employeeportal;

import Connectivity.DB;
import java.sql.*;

public class Addaction 
{
    //method for adding employee to the database
    public boolean addEmployee(EmployeePortal sp)
    {
        boolean check = false;
        Connection con = DB.getCon();
        try
        {
            String query = "insert into profile(name,surname,department,address) values(?,?,?,?)";
            PreparedStatement p = con.prepareStatement(query);
            
            p.setString(1,sp.getname());
            p.setString(2,sp.getsurname());
            p.setString(3,sp.getdepartment());
            p.setString(4,sp.getaddress());
            p.executeUpdate();
            
            check = true;
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return check; 
    }
    //method to display adde employees to the database
    public void display() throws SQLException
    {
        Connection con = DB.getCon();
        String query = "Select * from profile";
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(query);
        
        while(rs.next())
        {
            System.out.println
        (
            "Name       : "+rs.getString(1)+"\n"+
            "Surname    : "+rs.getString(2)+"\n"+
            "Employee id: "+rs.getInt(3)+"\n"+
            "Department : "+rs.getString(4)+"\n"+
            "Address    : "+rs.getString(5)
        );
            System.out.println("\t************************");// this line is to separate employees details 
        }  
    }
    //method for displaying employee by id
    public boolean displayById(int id)
    {
         Connection con = DB.getCon();
         boolean check = false;
        try{
        String query = "Select * from profile where id="+id;
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(query);
        
        while(rs.next())
        {
            System.out.println
        (
            "Name       : "+rs.getString(1)+"\n"+
            "Surname    : "+rs.getString(2)+"\n"+
            "Employee id: "+rs.getInt(3)+"\n"+
            "Department : "+rs.getString(4)+"\n"+
            "Address    : "+rs.getString(5)
        );
            System.out.println("\t ************************ ");// this line is to separate employees details 
        }
        check = true;
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return check;
    }
    //method for delection
    public boolean delete(int id)
    {
        Connection con = DB.getCon();
        boolean check = false;
        
        try
        {
            String query = "delete from profile where id="+id;
            PreparedStatement p = con.prepareStatement(query);
            p.executeUpdate();
            
            check = true;
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
       return check;
    }
    public boolean update(int id, String newUpdate, int choice, EmployeePortal ep)
    {
        Connection con = DB.getCon();
        boolean check = false;
        
        try
        {
            if(choice == 1)
            {
                String query = "Update profile set department =? where id =?";
                PreparedStatement p = con.prepareStatement(query);
                
                p.setString(1,newUpdate);
                p.setInt(2,id);
                p.executeUpdate();                
                check = true;
            }
            else if( choice == 2)
            {
                String query = "Update profile set address =? where id =?";
                PreparedStatement p = con.prepareStatement(query);
                
                p.setString(1,newUpdate);
                p.setInt(2,id);
                p.executeUpdate();                
                check = true;
            }
           
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        return check;
    }
   
}
