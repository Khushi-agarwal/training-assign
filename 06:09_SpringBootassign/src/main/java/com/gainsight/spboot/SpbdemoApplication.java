package com.gainsight.spboot;

import com.gainsight.spboot.beans.Person;
import com.gainsight.spboot.entity.*;
import com.gainsight.spboot.repository.AddressRepository;
import com.gainsight.spboot.repository.CourseRepository;
import com.gainsight.spboot.repository.DepartmentRepository;
import com.gainsight.spboot.repository.EmployeeRepository;
import com.gainsight.spboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@SpringBootApplication
public class SpbdemoApplication {
	//@Autowired
	 //DepartmentRepository departmentRepository;

	public static void main(String[] args) {

		ConfigurableApplicationContext container = SpringApplication.run(SpbdemoApplication.class, args);
//	DepartmentService dservice=container.getBean(DepartmentService.class);
		//Department d=new Department(60,"HR1","Delhi");
//	dservice.addDepartment(d);
// for(Department d: dservice.getAllDepartments())
//	 System.out.println(d.getDepartmentNo()+" "+d.getDepartmentName()+" "+d.getDepartmentLocation());
// Department d=null;
// try
// {
//	 d=dservice.getDepartmentById(20);
//	 System.out.println(d.getDepartmentName()+"  "+d.getDepartmentLocation());
// }
// catch(Exception ex)
// {
//	 System.out.println(ex);
// }
//
//		Department d=dservice.getDepartmentByName("Sales");
//		System.out.println(d.getDepartmentNo()+" "+d.getDepartmentLocation());
//		container.close();

		//Address added now
//		AddressRepository ar=container.getBean(AddressRepository.class);
//		Optional<Address> ad=ar.findById("1-2-3");
//
//		if(ad.isPresent())
//		{
//			Address a=ad.get();
//			System.out.println(a.getHouseNo()+" "+a.getCity()+" "+a.getStreetName()+" "+a.getState());
//			System.out.println(a.getDepartment().getDepartmentNo()+" "+a.getDepartment().getDepartmentName()+" "+a.getDepartment().getDepartmentLocation());
//
//		}
//		DepartmentRepository dr=container.getBean(DepartmentRepository.class);
//		Optional<Department> od=dr.findById(10);
//		if(od.isPresent()) {
//			Department d = od.get();
//			System.out.println(d.getDepartmentNo() + " " + d.getDepartmentName());
//			System.out.println(d.getAddres().getHouseNo() + " " + d.getAddres().getState());

		DepartmentRepository dr = container.getBean(DepartmentRepository.class);
		Optional<Department> od = dr.findById(20);
		if (od.isPresent()) {
			Department d = od.get();
			System.out.println(d.getDepartmentName() + " " + d.getDepartmentLocation());
			for (Employee e : d.getEmployees()) {
				System.out.println(e.getEmployeeNo() + " " + e.getEmployeeName() + " " + e.getSalary());
			}

		}
		EmployeeRepository er = container.getBean(EmployeeRepository.class);
		Optional<Employee> oe = er.findById(7004);
		if (oe.isPresent()) {
			Employee e = oe.get();
			System.out.println(e.getEmployeeName() + " " + e.getSalary());
			System.out.println(e.getDepartment().getDepartmentNo() + " " + e.getDepartment().getDepartmentName());
		}
		CourseRepository cr = container.getBean(CourseRepository.class);
		Optional<Course> oc = cr.findById(10);
		System.out.println("huuygu");
		if(oc.isPresent())
		{
			System.out.println(oc+"yuvuv");
			Course c=oc.get();
			System.out.println(c.getCourseName());
			for(Student s:c.getLstud())
			{
				System.out.println(s.getName()+" "+s.getMobile());
			}
	}
		else System.out.println("nothing");

		container.close();
	}

}
