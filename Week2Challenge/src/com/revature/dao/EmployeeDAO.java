package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.bean.Employee;

public interface EmployeeDAO{
	
	public List<Employee> getEmployee()
			throws SQLException;
	public Employee getEmployeeById(String id)
			throws SQLException;
	public Employee getEmployeeById(String id, Connection conn)
			throws SQLException;
	public int addEmployee(Employee emp)
			throws SQLException;
	public List<Employee> getEmployeeList() 
			throws SQLException;
	public void Avg()
			throws SQLException;
}