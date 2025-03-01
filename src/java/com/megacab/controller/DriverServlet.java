package com.megacab.controller;

import com.megacab.dao.DriverDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DriverServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String license = request.getParameter("license");
            String phone = request.getParameter("phone");
            String vehicleType = request.getParameter("vehicleType");

            boolean success = DriverDAO.addDriver(name, license, phone, vehicleType);
            response.sendRedirect("manage_drivers.jsp?status=" + (success ? "success" : "error"));
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean success = DriverDAO.deleteDriver(id);
            response.sendRedirect("manage_drivers.jsp?status=" + (success ? "deleted" : "error"));
        } else {
            response.sendRedirect("manage_drivers.jsp?status=invalid");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Fetch drivers from the database
        List<String[]> drivers = DriverDAO.getDrivers();
        // Set the list as a request attribute
        request.setAttribute("drivers", drivers);
        // Forward the request to the JSP
        request.getRequestDispatcher("manage_drivers.jsp").forward(request, response);
    }
}
