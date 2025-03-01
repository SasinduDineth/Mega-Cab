package com.megacab.controller;

import com.megacab.dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


public class AuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get username and password from login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate user using DAO
        UserDAO userDAO = new UserDAO();
        String role = userDAO.validateUser(username, password);

        if (role != null) {
            // Create session and set user attributes
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", role);

            // Redirect based on role
            if ("admin".equalsIgnoreCase(role)) {
                response.sendRedirect("admin_dashboard.jsp");
            } else {
                response.sendRedirect("CustomerDashboard.jsp");
            }
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
