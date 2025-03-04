package com.megacab.controller;

import com.megacab.dao.BookingDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AssignDriverServlet")
public class AssignDriverServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int rideId = Integer.parseInt(request.getParameter("rideId"));
        int driverId = Integer.parseInt(request.getParameter("driverId"));

        BookingDAO bookingDAO = new BookingDAO();
        boolean success = bookingDAO.assignDriver(rideId, driverId);

        if (success) {
            response.sendRedirect("manageRides.jsp?success=1");
        } else {
            response.sendRedirect("manageRides.jsp?error=1");
        }
    }
}
