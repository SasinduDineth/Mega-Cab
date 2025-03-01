package com.megacab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Mapping this servlet to `/adminDashboard`

public class AdminDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Check if admin is logged in
        if (session == null || session.getAttribute("adminUser") == null) {
            response.sendRedirect("login.jsp?error=Unauthorized Access!");
            return;
        }

        // Forward request to the dashboard view
        request.getRequestDispatcher("view/admin_dashboard.jsp").forward(request, response);
    }
}
