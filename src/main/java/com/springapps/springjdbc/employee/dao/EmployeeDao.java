package com.springapps.springjdbc.employee.dao;

import java.util.List;

import com.springapps.springjdbc.employee.dto.Employee;

public interface EmployeeDao {
		int create(Employee employee);
		
		int delete(Employee employee);
		
		int update(Employee employee);
		
		Employee read(int id);
		
		List<Employee> read();

}
