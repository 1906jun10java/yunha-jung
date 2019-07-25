package com.revature.servlets;

import com.revature.dao.EmployeeService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateInfoServlet extends HttpServlet {
    EmployeeService employeeService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        String serviceName = config.getInitParameter("auth.service.userinfo");
        employeeService = (EmployeeService) context.getAttribute(serviceName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("user_id");
        int user_id = Integer.valueOf(id);
        String status = request.getParameter("status");
        String update = request.getParameter("update");

        PrintWriter out = response.getWriter();
        if(status.equals("email")) {
            employeeService.updateEmail(user_id, update);
            out.println("Email Updated");
            out.close();
        } else if (status.equals("first")) {
            employeeService.updateFirst(user_id, update);
            out.println("First Name Updated");
            out.close();
        } else if (status.equals("last")) {
            employeeService.updateLast(user_id, update);
            out.println("Last Name Updated");
            out.close();
        }
    }
}
