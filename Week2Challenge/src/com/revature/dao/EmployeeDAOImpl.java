package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bean.Employee;
import com.revature.util.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public List<Employee> getEmployee() throws SQLException {
		List<Employee> employeeList = new ArrayList<>();
		
		String sql = "SELECT * FROM EMPLOYEE";
		
		try(Connection conn = ConnFactory.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);){
			
			while(rs.next()) {
				Employee emp = new Employee();
				int employee_id = rs.getInt("EMPLOYEE_ID");
				emp.setEmployee_id(employee_id);
				
				String emp_firstname = rs.getString("EMP_FIRSTNAME");
				emp.setEmp_firstname(emp_firstname);
				
				String emp_lastname = rs.getString("EMP_LASTNAME");
				emp.setEmp_lastname(emp_lastname);
				
				int department_id = rs.getInt("DEPARTMENT_ID");
				emp.setDepartment_id(department_id);
				
				int salary = rs.getInt("SALARY");
				emp.setSalary(salary);
				
				String emp_email = rs.getString("EMP_EMAIL");
				emp.setEmp_email(emp_email);
				
				employeeList.add(emp);
			}
			
		}
		return employeeList;
	}
	public List<Employee> getEmployeeList() throws SQLException {
		List<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = ConnFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		String colName;
		
		Employee emp = null;
		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				colName = rsmd.getColumnName(i);
				System.out.print(colName+" ["+rs.getString(i) + "] ");
			}
			System.out.println();
			employeeList.add(emp);
		}
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(String id) throws SQLException {
		Employee e = null;
		String sql = "SELECT EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL FROM EMPLOYEE WHERE EMPLOYEE_ID = '?' AND EMP_FIRSTNAME = '?' AND EMP_LASTNAME = '?' AND DEPARTMENT_ID = '?' AND SALARY = '?' AND EMP_EMAIL = '?'";

		ResultSet rs = null;
		try (Connection conn = ConnFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				int employee_id = rs.getInt("EMPLOYEE_ID");
				String emp_firstname = rs.getString("EMP_FIRSTNAME");
				String emp_lastname = rs.getString("EMP_LASTNAME");
				int department_id = rs.getInt("DEPARTMENT_ID");
				int salary = rs.getInt("SALARY");
				String emp_email = rs.getString("EMP_EMAIL");


				e = new Employee(employee_id, emp_firstname, emp_lastname, department_id, salary, emp_email);
			}
		} catch (SQLException c) {
			// TODO Auto-generated catch block
			c.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException c) {
					c.printStackTrace();
				}
			}
		}
		return e;
	}

	@Override
	public Employee getEmployeeById(String id, Connection conn) throws SQLException {
		Employee e = null;
		String sql = "SELECT EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL FROM EMPLOYEE WHERE EMPLOYEE_ID = '?' AND EMP_FIRSTNAME = '?' AND EMP_LASTNAME = '?' AND DEPARTMENT_ID = '?' AND SALARY = '?' AND EMP_EMAIL = '?'";

		ResultSet rs = null;
		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				int employee_id = rs.getInt("EMPLOYEE_ID");
				String emp_firstname = rs.getString("EMP_FIRSTNAME");
				String emp_lastname = rs.getString("EMP_LASTNAME");
				int department_id = rs.getInt("DEPARTMENT_ID");
				int salary = rs.getInt("SALARY");
				String emp_email = rs.getString("EMP_EMAIL");


				e = new Employee(employee_id, emp_firstname, emp_lastname, department_id, salary, emp_email);
			}
		} catch (SQLException c) {
			// TODO Auto-generated catch block
			c.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException c) {
					c.printStackTrace();
				}
			}
		}
		return e;
	}
	@Override
	public int addEmployee(Employee emp) throws SQLException {
		int addedEmployee = 0;
		String sql = "INSERT INTO EMPLOYEE(EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) VALUES (?,?,?,?,?)";
		try(Connection conn = ConnFactory.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, emp.getEmp_firstname());
			ps.setString(2, emp.getEmp_lastname());
			ps.setInt(3, emp.getDepartment_id());
			ps.setInt(4, emp.getSalary());
			ps.setString(5, emp.getEmp_email());
			addedEmployee = ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addedEmployee;
	}
	public void Avg() throws SQLException{
	Connection conn = ConnFactory.getConnection();
	String sql = "SELECT AVG(SALARY)FROM EMPLOYEE GROUP BY DEPARTMENT_ID";
	PreparedStatement ps = conn.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	int i = 1;
	while(rs.next()) {
		if(i == 1) {
			System.out.println("Customer Care: "+rs.getInt(1));
			i++;
		}
		else if(i == 2) {
			System.out.println("Warehouse Specialist: "+rs.getInt(1));
			i++;
		}
		else if(i == 3) {
			System.out.println("Sales Associate: "+rs.getInt(1));	
			i++;
		}
		
	}
}

}