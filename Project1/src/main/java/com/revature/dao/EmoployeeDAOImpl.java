package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import com.revature.bean.Employee;
import com.revature.ulti.ConnFactory;

import java.io.IOException;
import java.sql.*;

public class EmoployeeDAOImpl implements EmployeeDAO{

	@Override
	public int createEmployee(Employee employee) {
		int employeeCreated = 0;
		String sql = "INSERT INTO EMPLOYEES (FIRSTNAME, LASTNAME, MANAGER_ID, EMP_USERNAME, EMP_PASSWORD, IS_MANAGER) VALUES (?,?,?,?,?,?)";
		try(Connection con = ConnFactory.getConnection();
			PreparedStatement ps =con.prepareStatement(sql)){
			ps.setString(1, employee.getFirstname());
			ps.setString(2, employee.getLastname());
			ps.setInt(3, employee.getManager_id());
			ps.setString(4, employee.getUsername());
			ps.setString(5, employee.getPassword());
			ps.setInt(6, employee.getEmployeetype());
			
			employeeCreated = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeCreated;
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		Employee emp = new Employee();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMP_ID = ?";
		ResultSet rs = null;
		
		try(Connection con = ConnFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1, id);
			rs = ps.executeQuery();
			try {
				while(rs.next()) {
					emp.setId(rs.getInt("EMP_ID"));
					emp.setFirstname(rs.getString("FIRSTNAME"));
					emp.setLastname(rs.getString("LASTNAME"));
					emp.setUsername(rs.getString("EMP_USERNAME"));
					emp.setPassword(rs.getString("EMP_PASSWORD"));
					emp.setEmployeetype(rs.getInt("IS_MANAGER"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = new ArrayList<Employee>();
		String sql = "SELECT * FROM EMPLOYEES";
		ResultSet rs = null;
		
		try(Connection con = ConnFactory.getConnection();
				Statement stmt = con.createStatement();){
			rs = stmt.executeQuery(sql);
			
			try {
				while(rs.next()){
					Employee emp = new Employee();
					int employeeId = rs.getInt("EMP_ID");
					emp.setId(employeeId);
					
					String firstname = rs.getString("FIRSTNAME");
					emp.setFirstname(firstname);
					
					String lastname = rs.getString("LASTNAME");
					emp.setLastname(lastname);
					
					String username = rs.getString("EMP_USERNAME");
					emp.setUsername(username);
					
					String password = rs.getString("EMP_PASSWORD");
					emp.setPassword(password);
					
					int employeetype = rs.getInt("IS_MANAGER");
					emp.setEmployeetype(employeetype);
					
					employeeList.add(emp);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(rs != null) {
					try {
						rs.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
			
	}

	@Override
	public int updateEmployeeById(int id) throws IOException {
		int updateEmployee = 0;
		String sql = "UPDATE EMPLOYEES WHERE EMP_ID = ?";
		
		try(Connection con = ConnFactory.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			updateEmployee = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return updateEmployee;
	}


}
