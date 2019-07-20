package com.revature.dao;

import java.io.IOException;
import java.util.List;

import com.revature.bean.Employee;

public interface EmployeeDAO {
	int createEmployee(Employee employee);
	Employee getEmployeeById(int id);
	List<Employee> getAllEmployee() throws IOException;
	int updateEmployeeById(int id) throws IOException;
}
