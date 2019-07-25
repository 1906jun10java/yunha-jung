package com.revature.bean;

public class ResponseLogin {
    private boolean userExist;
    private int userId;
    private boolean isEmployee;

    public boolean isUserExist() {

        return userExist;
    }

    public void setUserExist(boolean userEixst) {

        this.userExist = userEixst;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public boolean isEmployee() {

        return isEmployee;
    }

    public void setEmployee(boolean employee) {

        isEmployee = employee;
    }
}