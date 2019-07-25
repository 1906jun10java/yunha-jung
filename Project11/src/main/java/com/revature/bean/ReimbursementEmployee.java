package com.revature.bean;

public class ReimbursementEmployee {
    private String content;
    private double amount;
    private String created;
    private String status;

    public ReimbursementEmployee(String content, double amount, String created, String status) {
        this.content = content;
        this.amount = amount;
        this.created = created;
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

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
}
