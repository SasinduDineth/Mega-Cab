package com.megacab.controller;

import com.megacab.dao.BookingDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ViewRidesServlet")
public class ViewRidesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        BookingDAO bookingDAO = new BookingDAO();
        List<String[]> rides = bookingDAO.getUserRides(username);

        request.setAttribute("rides", rides);
        request.getRequestDispatcher("viewRides.jsp").forward(request, response);
    }
}
