package com.megacab.controller;

import com.megacab.dao.DriverDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DriverServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        DriverDAO driverDAO = new DriverDAO();
        
        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String licenseNo = request.getParameter("license_no");
            String phone = request.getParameter("phone");
            String vehicleType = request.getParameter("vehicle_type");

            if (driverDAO.addDriver(name, licenseNo, phone, vehicleType)) {
                request.setAttribute("message", "Driver added successfully!");
            } else {
                request.setAttribute("error", "Failed to add driver!");
            }
        } else if ("delete".equals(action)) {
            int driverId = Integer.parseInt(request.getParameter("driver_id"));
            if (driverDAO.deleteDriver(driverId)) {
                request.setAttribute("message", "Driver deleted successfully!");
            } else {
                request.setAttribute("error", "Failed to delete driver!");
            }
        }
        
        request.getRequestDispatcher("manageDriver.jsp").forward(request, response);
    }
}
