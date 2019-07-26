package com.revature.bean;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String first_Name;
    private String last_Name;
    private boolean isEmployee;

    public User(){

    }

    public User(int id, String username, String first_Name, String last_Name, String email) {
        this.id = id;
        this.username = username;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.email = email;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }
}
