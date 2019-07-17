package com.revature.service;

import com.revature.bean.Employee;

public class AuthenticationService {
	
	public AuthenticationService() {
		
	}
	public Employee authenticateEmployee(Credentials cred) {
		Employee u = null;
		
		if(cred.getUsername().equals("merlin") && cred.getPassword().equals("cat")) {
			u = new Employee(1, "Merlin", "Higgins", cred.getUsername(), "merlin@wizcat.com", 1);
		}
		
		return u;
	}

}