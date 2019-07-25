package com.revature.bean;

public class Employee {

	public Employee(int id, String firstname, String lastname, int manager_id, String username, String password, String email, int employeetype) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.manager_id = manager_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.employeetype = employeetype;
	}
	public Employee(String firstname, String lastname, int manager_id, String username, String password, String email, int employeetype) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.manager_id = manager_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.employeetype = employeetype;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	private int id;
	private String firstname;
	private String lastname;
	private int manager_id;
	private String username;
	private String password;
	private String email;
	private int employeetype;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEmployeetype() {
		return employeetype;
	}
	public void setEmployeetype(int employeetype) {
		this.employeetype = employeetype;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", email=" + email + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
}

	
	
