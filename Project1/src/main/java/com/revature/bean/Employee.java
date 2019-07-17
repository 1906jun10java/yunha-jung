package com.revature.bean;

public class Employee {

	public Employee(int id, String firstname, String lastname, String username, String email, int employeetype) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.employeetype = employeetype;
	}
	public Employee(String firstname, String lastname, String username, String email, int employeetype) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.employeetype = employeetype;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	private int id;
	private String firstname;
	private String lastname;
	private String username;
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
}

	
	
