package com.revature.bean;

public class Employee {
	private int employee_id;
	private String emp_firstname;
	private String emp_lastname;
	private int department_id;
	private int salary;
	private String emp_email;
	
	public Employee() {
		super();
	}
	
	public Employee(int employee_id, String emp_firstname, String emp_lastname,
			int department_id, int salary, String emp_email) {
		super();
		this.employee_id = employee_id;
		this.emp_firstname = emp_firstname;
		this.emp_lastname = emp_lastname;
		this.department_id = department_id;
		this.salary = salary;
		this.emp_email = emp_email;
	}
	
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmp_firstname() {
		return emp_firstname;
	}

	public void setEmp_firstname(String emp_firstname) {
		this.emp_firstname = emp_firstname;
	}

	public String getEmp_lastname() {
		return emp_lastname;
	}

	public void setEmp_lastname(String emp_lastname) {
		this.emp_lastname = emp_lastname;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

}
