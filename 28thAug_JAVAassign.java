//Create a dao class of employee and implement menu driven program


package com.gainsight.dao;

class employee
{
    private int emp_no;
    private String emp_name;
    private double emp_sal;
    private String department;
    private String manager_name;
    public employee(){}
    public employee(int emp_no,String emp_name,double emp_sal,String department,String manager_name)
    {
        this.emp_no = emp_no;  this.emp_name = emp_name;  this.emp_sal = emp_sal;
        this.department = department;   this.manager_name = manager_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmp_sal(double emp_sal) {
        this.emp_sal = emp_sal;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public double getEmp_sal() {
        return emp_sal;
    }

    public String getDepartment() {
        return department;
    }

    public String getManager_name() {
        return manager_name;
    }
}

package com.gainsight.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

//It should contain the CRUD operations(create,read,update and delete)
public class employeedao {
    private static String url="jdbc:mysql://localhost:3306/gainsight";
    public employee getEmployeeId(int empid){

        employee emp=null;

        try(Connection con = DriverManager.getConnection(url,"root","Gainsight");
            PreparedStatement pst = con.prepareStatement("select * from emp");){
            pst.setInt(1,empid);
            ResultSet rs= pst.executeQuery();
            if(rs.next()){
                emp=new employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5));
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return emp;
    }
    public ArrayList<employee> getAllEmployee(){
        ArrayList<employee> elist = new ArrayList<>();

        try(Connection con = DriverManager.getConnection(url,"root","Gainsight");
            PreparedStatement pst = con.prepareStatement("select * from emp");){

            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                elist.add(new employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5)));
              //  System.out.println(rs.getString(2));
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return elist;
    }
    public boolean addEmployee(employee emp)
    {
        int count=0;
        try(Connection con=DriverManager.getConnection(url,"root","Gainsight");
        PreparedStatement pst=con.prepareStatement("insert into emp values(?,?,?,?,?)"))

        {
            pst.setInt(1,emp.getEmp_no());
            pst.setString(2,emp.getEmp_name());
            pst.setDouble(3,emp.getEmp_sal());
            pst.setString(4, emp.getDepartment());
            pst.setString(5,emp.getManager_name());
            count= pst.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return count==1;
    }
    public boolean modifyEmployee(employee emp)
    {
        int count=0;
        try(Connection con=DriverManager.getConnection(url,"root","Gainsight");
            PreparedStatement pst=con.prepareStatement("update emp set emp_sal=?,department=?,manager_name=? where emp_no=?");)
        {
            pst.setDouble(1,emp.getEmp_sal());
            pst.setString(2, emp.getDepartment());
            pst.setString(3,emp.getManager_name());
            pst.setInt(4,emp.getEmp_no());
            count=pst.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return count==1;
    }
    public boolean deleteEmployeebyemployeeId(int empid){

       int count=0;

        try(Connection con = DriverManager.getConnection(url,"root","Gainsight");
            PreparedStatement pst = con.prepareStatement("delete from emp where emp_no=?");){

           pst.setInt(1,empid);
           count=pst.executeUpdate();


        }
        catch(Exception ex){
            ex.printStackTrace();
        }
      return count==1;
    }
}
package com.gainsight.dao;

import java.util.ArrayList;
import java.util.Scanner;

public class company {
    employeedao edao=new employeedao();
    public void addEmployeeDetails(employee emp)
    {

        if(edao.addEmployee(emp))
            System.out.println("Employee details added succesfully");
        else System.out.println("Employee insertion failed");
    }
    public void displayAllEmployeeDetails()
    {
        ArrayList<employee> elist=new ArrayList<>();
        elist=edao.getAllEmployee();
        for(employee e:elist)
            System.out.println(e.getEmp_no()+" "+e.getEmp_name()+" "+e.getEmp_sal()+" "+e.getDepartment()+" "+e.getManager_name());
    }
    public void displayEmployeeDetailsById(int empid)
    {
       employee e= edao.getEmployeeId(empid);
       if(e!=null)
        System.out.println(e.getEmp_no()+" "+e.getEmp_name()+" "+e.getEmp_sal()+" "+e.getDepartment()+" "+e.getManager_name());
       else System.out.println("Employee does not exist");
    }
    public void modifyEmloyeeDetails(employee emp)
    {

      if(edao.modifyEmployee(emp))
          System.out.println("The employee details are modified");
      else
          System.out.println("The employee details are not modified");
    }
    public void deleteEmployeeDetails(int empid)
    {
        if(edao.deleteEmployeebyemployeeId(empid))
            System.out.println("The employee details are deleted");
        else
            System.out.println("The employee details are not deleted");
    }

    public static void main(String[] args) {

        company c=new company();
        Scanner sc=new Scanner(System.in);

        int ch=0;
        while(ch!=-1)
        {
            System.out.println("The menu is as follows-----\n Choose 1 to add employee\n Choose 2 for display all the employee details" +
                    "\n Choose 3 to display specific employee details\n Choose 4 to modify the details of the employees\n Choose 5 to delete the employee details\n -1 to stop");
            ch=sc.nextInt();
        switch (ch) {
            case 1:
                employee e = new employee(109, "Sam", 90000.0, "HR", "Stalon");
                c.addEmployeeDetails(e);
                break;
            case 2:
                c.displayAllEmployeeDetails();
                break;
            case 3:
                System.out.println("Enter the empid to see the details");
                int eid = sc.nextInt();
                c.displayEmployeeDetailsById(eid);
                break;
            case 4:
                employee emod = new employee(109, "", 50000, "Marketing", "DEF");
                c.modifyEmloyeeDetails(emod);
                break;
            case 5:
                System.out.println("Enter the empid to delete the details");
                int eidd = sc.nextInt();
                c.deleteEmployeeDetails(eidd);
                break;
        }
        }
    }


}
