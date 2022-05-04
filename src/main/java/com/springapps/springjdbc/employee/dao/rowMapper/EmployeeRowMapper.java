package com.springapps.springjdbc.employee.dao.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springapps.springjdbc.employee.dto.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee=new Employee();
		employee.setId(rs.getInt(1));
		employee.setFirstName(rs.getString(2));
		employee.setLastName(rs.getString(1));
		return employee;
	}
	
	
}
