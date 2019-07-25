package com.revature.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.revature.bean.ReimbursementEmployee;
import com.revature.bean.RequestForm;
import com.revature.dao.EmployeeService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ReimbursementRequestServlet extends HttpServlet {
    EmployeeService employeeService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        String serviceName = config.getInitParameter("auth.service.reimbursement");
        employeeService = (EmployeeService) context.getAttribute(serviceName);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        RequestForm requestForm;
        if("/Project11_war/submitform".equals(requestURI)) {
            if(req.getContentType().equals("application/json")) {
                System.out.println("it works");
                requestForm = new ObjectMapper().readValue(req.getInputStream(), RequestForm.class);
                System.out.println(requestForm.getUser_id() + " " + requestForm.getAmount() + " " + requestForm.getCreated() + " " + requestForm.getDescription());

                employeeService.createRequestForm(requestForm.getUser_id(), requestForm.getDescription(), requestForm.getAmount(),requestForm.getCreated());
            }
        } else {
            System.out.println("Forwarding to proper endpoint");
            req.getRequestDispatcher("/auth/authenticate").forward(req, resp);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("user_id");
        int user_id = Integer.valueOf(id);
        String status = request.getParameter("status");

        if (status.equals("pending")) {
            ArrayList<ReimbursementEmployee> arrayList = employeeService.getPendingStatus(user_id);
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            JsonObject myObj = new JsonObject();
            JsonElement listObj = gson.toJsonTree(arrayList);
            myObj.add("reimbursements", listObj);
            out.println(myObj.toString());
            out.close();
        } else if (status.equals("resolved")) {
            ArrayList<ReimbursementEmployee> arrayList = employeeService.getResolvedStatus(user_id);
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            JsonObject myObj = new JsonObject();
            JsonElement listObj = gson.toJsonTree(arrayList);
            myObj.add("reimbursements", listObj);
            out.println(myObj.toString());
            out.close();
        }
    }

}
