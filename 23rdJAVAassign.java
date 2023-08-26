1st assignment of deque of employee
-------------------------------------------------

import java.util.ArrayDeque;
import java.util.Deque;

class Employee4
    {
        String name;
        int emp_id;
        Employee4(String name, int emp_id)
        {
            this.name=name;
            this.emp_id=emp_id;
        }
        public String toString()
        {
            return (name+" "+emp_id);
        }
    }
    public class deque {
        public static void main(String[] args) {

            Deque<Employee4> d= new ArrayDeque<>();
            d.addFirst(new Employee4("ajay",101));
            d.addLast(new Employee4("sunil",102));
            d.addLast(new Employee4("babau",107));
            d.addFirst(new Employee4("mohan",109));
            System.out.println(d);

        }
    }
-------------------------------------------------------------

  2nd assignment of hashmap of emailid and password
  ----------------------------------------------------------
  public class hashmap {
    public static void main(String[] args)
    {
     HashMap<String ,String >emailAccountMap = new HashMap<>();
        emailAccountMap.put("Ajay@gmail.com", "Ajay@123");
        System.out.println(emailAccountMap);

    }
}

---------------------------------------------------------------

  3rd assignment of hashmap of emailid and address
  ---------------------------------------------------------

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class employee{
    private int empid;
    private double salary;
    private String department;
    employee() {};
    public employee(int ssn, String name, int age, char gender, int empid, double salary, String department) {
        super(ssn, name, gender, age);
        this.empid = empid;
        this.salary = salary;
        this.department = department;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getEmpid() {
        return empid;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return empid + " " + getName() + " " + salary + " " + department;
    }
 
}



class address
{
    private String hno;
    private String street;
    private String city;
    private String state;
 
    address(){};
    address(String hno,String street,String city,String state)
    {
        this.hno=hno;
        this.street=street;
        this.city=city;
        this.state=state;
   
    }
    public void setHno(String hno){this.hno=hno;}
    public void setStreet(String street){this.street=street;}
    public void setCity(String city){this.city=city;}
 
    public String getState() {
        return state;
    }

    public String getHno(){return hno;}

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }


    public String toString(){
       
        return hno+" "+street+" "+city+" "+state;
    }
}

public class hashmap {
    public static void main(String[] args)
    {
        HashMap<employee,address> map=new HashMap<employee, address>();
        map.put(new employee(102,"Charan",12,'M',7001,60000.00,"Sales"),new address("626","Indira","Lko","226016"));
        map.put(new employee(101,"Vijay",34,'F',2661,100000.00,"HR"),new address("123","patli","Hyd","2260"));
        Set<Entry<employee,address>> eSet=map.entrySet();
        for(Entry<employee,address> e:eSet)
        {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    
    }
}
----------------------------------------------------------------------------

