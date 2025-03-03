package com.megacab.controller;

import com.megacab.dao.BookingDAO;
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

        // Get values from form
        String pickup = request.getParameter("pickup");
        String dropoff = request.getParameter("dropoff");
        double distance = Double.parseDouble(request.getParameter("distance"));

        // Calculate ride fare (Example: $2 per km)
        double fare = distance * 2.0;

        BookingDAO bookingDAO = new BookingDAO();
        boolean success = bookingDAO.bookRide(username, pickup, dropoff, distance, fare);

        if (success) {
            response.sendRedirect("viewRides.jsp?success=1&fare=" + fare);
        } else {
            response.sendRedirect("bookRide.jsp?error=1");
        }
    }
}
