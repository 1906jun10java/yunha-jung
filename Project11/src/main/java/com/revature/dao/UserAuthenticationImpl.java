package com.revature.dao;

import com.revature.bean.User;

public class UserAuthenticationImpl implements UserAuthentication {
    private JDBCRepository userRepository;

    public UserAuthenticationImpl(JDBCRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User authenticate(String username, String password) {
        User u = userRepository.findByUsername(username);

        if(u == null) {
            return null;
        }

        if(u.getPassword().equals(password)) {
            return u;
        } else {
            return null;
        }
    }

    @Override
    public User findById(int user_id) {
        return userRepository.findById(user_id);
    }

}
