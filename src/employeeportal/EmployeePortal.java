package employeeportal;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeePortal 
{
    
    private String name,surname,department,address;
    private int id;
    
    public EmployeePortal(){}
    // //this is a constructor with without id
    public EmployeePortal(String name,String surname,String department,String address)
    {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.address = address;
    }
    //this is a constructor with id
    public EmployeePortal(String name,int id,String surname,String department,String address)
    {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.department = department;
        this.address = address;
    }
    //getter and setter methods of the class
    public void setname(String name)
    {
        this.name = name;
    }
    public String getname()
    {
        return name;
    }
    public void setsurname(String surname)
    {
        this.surname = surname;
    }
    public String getsurname()
    {
        return surname;
    }
    public void setid(int id)
    {
        this.id = id;
    }
    public int getid()
    {
        return id;
    }
    public void setdepartment(String department)
    {
        this.department = department;
    }
    public String getdepartment()
    {
        return department;
    }
    public void setaddress(String address)
    {
        this.address = address;
    }
    public String getaddress()
    {
        return address;
    }
    @Override
    public String toString()
    {
        return "Name       : "+name+"\n"+
               "Surname    : "+surname+"\n"+
               "Employee id: "+id+"\n"+
               "Department : "+department+"\n"+
               "Address    : "+address+"\n";
    }
    
     ///Main method
    public static void main(String[] args) throws SQLException 
    {
        Scanner sc = new Scanner(System.in); // creating input object
        Addaction ad = new Addaction(); //this will be generalize for all the cases
        
        System.out.println("\t****WELCOME TO EMPLOYEES PORTAL****");
        
        while(true)
        {
            System.out.println
            ("""
             
              Press 1 for adding Employee 
             
              Press 2 for Displaying Employee without id 
             
              Press 3 for Displaying Employee with id 
             
              Press 4 for Deleting Employee 
             
              Press 5 for Updating Employee 
             
              Press 6 for Existing Portal 
             """);
            System.out.print("Please provide input - ");
           int input = sc.nextInt();
           sc.nextLine(); //reading empty space from the buffer
          
          
          switch(input)
          {
              case 1:
              {
                  System.out.println("\t**** Add Employee ****");
                  System.out.print("Enter Name: ");
                  String name = sc.nextLine();
                  System.out.print("Enter Surname: ");
                  String surname = sc.nextLine();
                  System.out.print("Enter Department: ");
                  String department = sc.nextLine();
                  System.out.print("Enter Address: ");
                  String address = sc.nextLine();
                  
                  EmployeePortal sp = new EmployeePortal(name,surname,department,address);
                  
                  boolean valid = ad.addEmployee(sp);
                  
                  if(valid == true)
                      System.out.println("\t**** Employee added successfully ****");
                  else
                      System.out.println("\t**** Employee not added successfully, problem occured ****");
                  break;
              }
              case 2:
              {
                  System.out.println("****Displaying Employees added ****");
                  ad.display();
                  
                  break;
              }
              case 3:
              {
                  System.out.print("Enter the id of employee: ");
                  int id = sc.nextInt();
                  
                  System.out.println("*****Displaying Employee by id "+id+"*****");
                  
                  boolean valid =ad.displayById(id);
                  
                  if(valid == false)
                      System.out.println(" Employee with this id is not avaiable ");
                  
                  break;
              }
              case 4:
              {
                  System.out.print("Enter Employee id to be deteled: ");
                  int id = sc.nextInt();
                  boolean ValidDeleteId = ad.delete(id);
                  
                  if(ValidDeleteId == true)
                      System.out.println("****Employee id deleted successufully****");
                  else
                       System.out.println("****Employee id not deleted  successufully, problem occured****");
                  break;
              }
              case 5:
              {
                  System.out.println("****Updating the Employee details****");
                  System.out.println
                  (
                      "Press 1 to update department \n"+
                      "Press 1 to update address \n"
                  );
                  int choice = sc.nextInt();
                  
                  if(choice == 1)
                  {
                      System.out.print("Enter Employee ID: ");
                      int id = sc.nextInt();
                      sc.nextLine();
                      System.out.println("Enter new department: ");
                      String department = sc.nextLine();
                      
                      EmployeePortal ep = new EmployeePortal(); //creating new object of the EmployeePortal class
                      
                      ep.setdepartment(department);//changing the initial derpt name to new name that is entered by the user
                      boolean validUpadate = ad.update(id, department, choice, ep); //calling the function from addaction class
                      
                      if(validUpadate == true)
                          System.out.println("****Department changed successfully****");
                      else
                          System.out.println("****Department is not changed successfully, problem occured****");    
                  }
                  else if(choice == 2)
                  {
                      System.out.print("Enter Employee ID: ");
                      int id = sc.nextInt();
                      sc.nextLine();
                      System.out.println("Enter new address: ");
                      String address = sc.nextLine();
                      
                      EmployeePortal ep = new EmployeePortal(); //creating new object of the EmployeePortal class
                      
                      ep.setdepartment(address);//changing the initial derpt name to new name that is entered by the user
                      boolean validUpadate = ad.update(id, address, choice, ep); //calling the function from addaction class
                      
                      if(validUpadate == true)
                          System.out.println("****Address changed successfully****");
                      else
                          System.out.println("****Address is not changed successfully, problem occured****");   
                      
                  }
                  break;
              }
              case 6:
              {
                  System.out.println("\t****Exited the program****");
                  System.exit(0);
                  break;
              }
              default:
                  System.out.println("\tInvalid input");
          }
        }
    }
    
}
