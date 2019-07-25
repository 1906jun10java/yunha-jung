package com.revature.bean;


public class Reimbursement {
    private String firstName;
    private String lastName;
    private String theContents;
    private int reimbursementID;
    private double amount;
    private int statusID;
    private String status;
    private String created;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reimbursement(String firstName, String lastName, String theContents, int reimbursementID
            , double amount, int statusID, String status, String created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.theContents = theContents;
        this.reimbursementID = reimbursementID;
        this.amount = amount;
        this.statusID = statusID;
        this.status = status;
        this.created = created;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public int getReimbursementID() {
        return reimbursementID;
    }
    public void setReimbursementID(int reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContent() {
        return theContents;
    }

    public void setContent(String content) {
        this.theContents = content;
    }
}
