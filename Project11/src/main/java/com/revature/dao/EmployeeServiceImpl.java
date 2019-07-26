package com.revature.dao;
import com.revature.bean.ReimbursementEmployee;

import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {
    JDBCRepository employeeRepository;

    public EmployeeServiceImpl(JDBCRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createRequestForm(int user_id, String content, double amount, String created) {
        employeeRepository.createRequestForm(user_id, content, amount, created  );
    }

    @Override
    public ArrayList<ReimbursementEmployee> getPendingStatus (int user_id) {
        return employeeRepository.getPendingStatus(user_id);
    }

    @Override
    public ArrayList<ReimbursementEmployee> getResolvedStatus (int user_id) {
        return employeeRepository.getResolvedStatus(user_id);
    }

    @Override
    public void updateEmail (int user_id, String update) {

        employeeRepository.updateEmail(user_id, update);
    }

    @Override
    public void updateFirst (int user_id, String update) {

        employeeRepository.updateFirst(user_id, update);
    }

    @Override
    public void updateLast (int user_id, String update) {

        employeeRepository.updateLast(user_id, update);
    }


}
