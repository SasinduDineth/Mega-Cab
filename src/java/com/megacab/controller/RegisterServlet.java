package com.megacab.controller;

import com.megacab.dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String nic = request.getParameter("nic");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = "customer"; // Default role is customer

        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.registerUser(name, email, nic, username, password, role);

        if (success) {
            response.sendRedirect("login.jsp?registered=1");
        } else {
            response.sendRedirect("register.jsp?error=1");
        }
    }
}
