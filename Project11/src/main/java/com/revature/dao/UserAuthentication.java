package com.revature.dao;

import com.revature.bean.User;

public interface UserAuthentication {
    User authenticate(String username, String password);
    User findById(int user_id);
}
