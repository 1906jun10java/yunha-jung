package com.revature.driver;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bean.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.util.ConnFactory;

public class Drive {
	protected static Employee emp = new Employee();
	ConnFactory cf = ConnFactory.getInstance();
	static Scanner sc = new Scanner(System.in);
	static int employee_id = 1;
	static EmployeeDAO empD = new EmployeeDAOImpl();
	
	public static void main(String[] args) throws SQLException {
		System.out.println("1. Show list, 2. Add Employee, 3. Avg");
		int option = sc.nextInt();
		switch(option) {
		case 1:
			empD.getEmployeeList();
			break;
		case 2:
			System.out.println("Enter First name: ");
			sc.nextLine();
			String emp_firstname = sc.nextLine();
			
			System.out.println("Enter Last name: ");
			String emp_lastname = sc.nextLine();
			
			System.out.println("Enter Department ID (1-3):");
			int department_id = sc.nextInt();
			
			System.out.println("Enter Salary: ");
			int salary = sc.nextInt();
			
			System.out.println("Enter Email: ");
			sc.nextLine();
			String emp_email = sc.nextLine();
			
			emp = new Employee(employee_id, emp_firstname, emp_lastname, department_id, salary, emp_email);
			try {
				empD.addEmployee(emp);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			empD.Avg();
			break;
		default:
			System.out.println("Invalid Entry");
			break;
		}
		

	}

}
