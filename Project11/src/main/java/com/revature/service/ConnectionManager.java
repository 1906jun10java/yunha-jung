package com.revature.service;

import java.sql.Connection;

public interface ConnectionManager {
    void init();
    Connection getConnection();
}
