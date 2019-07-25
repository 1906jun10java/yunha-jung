package com.revature.service;

import com.revature.dao.EmployeeService;
import com.revature.dao.EmployeeServiceImpl;
import com.revature.dao.UserAuthentication;
import com.revature.dao.UserAuthenticationImpl;
import com.revature.ulti.ConnFactory;
import com.revature.dao.JDBCRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    //Receives notification that the web application initialization process is starting.
    //All ServletContextListeners are notified of context initialization before any filters or servlets in the web application are initialized.
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();

        ConnectionManager manager = new ConnFactory();
        manager.init();

        JDBCRepository userRepository = new JDBCRepository(manager);
        UserAuthentication userAuthentication = new UserAuthenticationImpl(userRepository);
        EmployeeService employeeService = new EmployeeServiceImpl(userRepository);

        context.setAttribute("userRepository", userRepository);
        context.setAttribute("userAuthentication", userAuthentication);
        context.setAttribute("employeeService", employeeService);
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {


    }
}