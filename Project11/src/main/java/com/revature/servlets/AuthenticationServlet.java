package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bean.ResponseLogin;
import com.revature.bean.User;
import com.revature.dao.UserAuthentication;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class AuthenticationServlet extends HttpServlet {
    UserAuthentication userAuthentication;
    //private final Logger LOG = Logger.getLogger(String.valueOf(AuthenticationServlet.class));

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        String serviceName = config.getInitParameter("auth.service.login");
        userAuthentication = (UserAuthentication) context.getAttribute(serviceName);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        User u;
       // LOG.info("Login Attempt");
        if("/Project11_war/login".equals(requestURI)) {
            if(req.getContentType().equals("application/json")) {
                u = new ObjectMapper().readValue(req.getInputStream(), User.class);

                User test = userAuthentication.authenticate(u.getUsername(), u.getPassword());

                PrintWriter out = resp.getWriter();
                ResponseLogin response = new ResponseLogin();

                if(test == null) {
                    //LOG.info("Login Failed");
                    ObjectMapper objectMapper = new ObjectMapper();
                    response.setUserExist(false);
                    String jsonString = objectMapper.writeValueAsString(response);
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    out.print(jsonString);
                    out.close();
                } else {
                    //LOG.info("Login Success");
                    ObjectMapper objectMapper = new ObjectMapper();

                    response.setUserExist(true);
                    response.setUserId(test.getId());
                    response.setEmployee(test.isEmployee());

                    String jsonString = objectMapper.writeValueAsString(response);
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    out.print(jsonString);
                    out.flush();
                }

            } else if(req.getContentType().equals("application/x-www-form-urlencoded")) {
                u = new User();
                u.setEmail(req.getParameter("email"));
                u.setPassword(req.getParameter("password"));
                System.out.println("got form data " + u.getEmail());
            } else {
                System.out.println("Unknown data format");
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

        User user;
        user = userAuthentication.findById(user_id);

        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(user);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonString);
        out.flush();
    }
}