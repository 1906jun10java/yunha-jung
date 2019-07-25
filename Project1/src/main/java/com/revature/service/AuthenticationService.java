package com.revature.service;

import com.revature.bean.Employee;

public class AuthenticationService {
	
	public AuthenticationService() {
		
	}
	public Employee authenticateEmployee(Credentials cred) {
		Employee u = new Employee();
		
		if(cred.getUsername().equals(u.getUsername()) && cred.getPassword().equals(u.getPassword())) {
			u = new Employee();
		}
		return u;
	}

}