package com.megacab.controller;

import com.megacab.dao.RideDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RideServlet")
public class RideServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("bookRide".equals(action)) {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            if (username == null) {
                response.sendRedirect("login.jsp?error=Please+log+in+first");
                return;
            }

            String pickup = request.getParameter("pickup");
            String dropoff = request.getParameter("dropoff");
            String vehicleType = request.getParameter("vehicleType");
            String paymentMethod = request.getParameter("paymentMethod");
            double distance = Double.parseDouble(request.getParameter("distance"));

            RideDAO rideDAO = new RideDAO();
            boolean success = rideDAO.bookRide(username, pickup, dropoff, vehicleType, paymentMethod, distance);

            if (success) {
                response.sendRedirect("viewRides.jsp?msg=Ride+Booked+Successfully");
            } else {
                response.sendRedirect("bookRide.jsp?error=Failed+to+Book+Ride");
            }
        }
    }
}
