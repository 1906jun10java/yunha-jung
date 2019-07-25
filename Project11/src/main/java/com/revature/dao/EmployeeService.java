package com.revature.dao;

import com.revature.bean.ReimbursementEmployee;

import java.util.ArrayList;

public interface EmployeeService {
    void createRequestForm(int user_id, String content, double amount, String created);
    ArrayList<ReimbursementEmployee> getPendingStatus (int user_id);
    ArrayList<ReimbursementEmployee> getResolvedStatus (int user_id);
    void updateEmail (int user_id, String update);
    void updateFirst (int user_id, String update);
    void updateLast (int user_id, String update);
}
