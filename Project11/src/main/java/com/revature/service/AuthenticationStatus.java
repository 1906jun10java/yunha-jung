package com.revature.service;

import com.revature.bean.User;

import java.sql.Connection;

public interface AuthenticationStatus {
    void authStatus (User u, boolean sucess);
}
