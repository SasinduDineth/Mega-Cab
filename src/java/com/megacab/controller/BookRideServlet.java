package com.megacab.controller;

import com.megacab.dao.RideDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/BookRideServlet")
public class BookRideServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String pickup = request.getParameter("pickup");
        String dropoff = request.getParameter("dropoff");
        String vehicleType = request.getParameter("vehicleType");
        String paymentMethod = request.getParameter("paymentMethod");

        RideDAO rideDAO = new RideDAO();
        boolean success = rideDAO.bookRide(username, pickup, dropoff, vehicleType, paymentMethod);

        if (success) {
            response.sendRedirect("viewRide.jsp");
        } else {
            response.getWriter().println("Error booking ride. Please try again.");
        }
    }
}
