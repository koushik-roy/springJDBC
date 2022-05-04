package com.springapps.springjdbc.employee.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springapps.springjdbc.employee.dao.EmployeeDao;
import com.springapps.springjdbc.employee.dao.rowMapper.EmployeeRowMapper;
import com.springapps.springjdbc.employee.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Employee employee) {
		String sql = "insert into employee values (?, ?, ?)";
		int result = jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName());
		return result;
	}


	@Override
	public int delete(Employee employee) {
		// TODO Auto-generated method stub
		String sql="delete from employee where id= ?";
		int result = jdbcTemplate.update(sql, employee.getId());
		return result;
	}

	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
		String sql="update employee set firstname=?, lastname=? where id=?";
		int result = jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getId());
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public Employee read(int id) {
		// TODO Auto-generated method stub
		String sql= "select * from employee where id=?";
		EmployeeRowMapper rowMapper=new EmployeeRowMapper();
		Employee employee=jdbcTemplate.queryForObject(sql, rowMapper, id);
		return employee; 
	}


	@Override
	public List<Employee> read() {
		// TODO Auto-generated method stub
		String sql = "select * from employee";
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper);
		return employees;
	}
	
	
}
