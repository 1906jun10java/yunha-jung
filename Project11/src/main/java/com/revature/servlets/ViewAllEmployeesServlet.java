package com.revature.servlets;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.revature.bean.Employee;
import com.revature.bean.Reimbursement;
import com.revature.dao.JDBCRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ViewAllEmployeesServlet extends HttpServlet {
    private JDBCRepository userRepository;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        String serviceName = config.getInitParameter("get.repo");
        this.userRepository = (JDBCRepository) context.getAttribute(serviceName);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        if (request.getParameterMap().containsKey("theId")) {
            ArrayList<Reimbursement> theList = this.userRepository.findEmployeeReimbursement(request.getParameter("theId"));
            //ArrayList<Reimbursement> theList = this.userRepository.findEmployeeReimbursement("theId");
            response.setContentType("application/json");
            response.setHeader("Cache-control", "no-cache, no-store");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "-1");

            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setHeader("Access-Control-Max-Age", "86400");

            Gson gson = new Gson();
            JsonObject myObj = new JsonObject();
            JsonElement listObj = gson.toJsonTree(theList);
            myObj.add("employeeReimbursements", listObj);
            out.println(myObj.toString());
            out.close();
        }else
        {
            ArrayList<Employee> list = this.userRepository.findALLEmployees();



            response.setContentType("application/json");
            response.setHeader("Cache-control", "no-cache, no-store");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "-1");

            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type");
            response.setHeader("Access-Control-Max-Age", "86400");



            Gson gson = new Gson();
            JsonObject myObj = new JsonObject();
            JsonElement listObj = gson.toJsonTree(list);
            myObj.add("allEmployees", listObj);
            out.println(myObj.toString());
            out.close();

        }


    }
}
