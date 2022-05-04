package com.springapps.springjdbc.employee.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springapps.springjdbc.employee.dao.EmployeeDao;
import com.springapps.springjdbc.employee.dao.impl.EmployeeDaoImpl;
import com.springapps.springjdbc.employee.dto.Employee;

public class SpringJDBCapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context= new ClassPathXmlApplicationContext("com/springapps/springjdbc/employee/config/config.xml");
		EmployeeDao employeedao = (EmployeeDao) context.getBean("employeedao");
		
		readEmployees(employeedao);
		

	}
	private static void createEmployee(EmployeeDao employeedao) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setId(4);
		emp.setFirstName("Hog");
		emp.setLastName("Rider");
		int result = employeedao.create(emp);
		System.out.println("Number of records inserted are: " + result);
	}
	
	private static void updateEmployee(EmployeeDao employeedao) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setId(3);
		emp.setFirstName("Reynolds");
		emp.setLastName("Rider");
		int result = employeedao.update(emp);
		System.out.println("Number of records updated are: " + result);

	}
	
	private static void deleteEmployee(EmployeeDao employeedao) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setId(1);
		int result = employeedao.delete(emp);
		System.out.println("Number of records deleted are: " + result);
		
	}
	
	private static void readEmployee(EmployeeDao employeedao) {
		// TODO Auto-generated method stub
		Employee emp=employeedao.read(4);
		System.out.println(emp);

	}
	
	private static void readEmployees(EmployeeDao employeedao) {
		List<Employee> emps = employeedao.read();
		System.out.println(emps);		
	}

}
