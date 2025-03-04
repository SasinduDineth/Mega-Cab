<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Rides</title>
</head>
<body>
    <h2>Your Booked Rides</h2>

    <% if (request.getParameter("success") != null) { %>
        <p style="color: green;">Ride booked successfully! Fare: $<%= request.getParameter("fare") %></p>
    <% } %>

    <table border="1">
        <tr>
            <th>Ride ID</th>
            <th>Pickup Location</th>
            <th>Drop-off Location</th>
            <th>Distance (km)</th>
            <th>Fare ($)</th>
            <th>Status</th>
        </tr>
        <%
            List<String[]> rides = (List<String[]>) request.getAttribute("rides");
            if (rides != null && !rides.isEmpty()) {
                for (String[] ride : rides) {
        %>
        <tr>
            <td><%= ride[0] %></td>
            <td><%= ride[1] %></td>
            <td><%= ride[2] %></td>
            <td><%= ride[3] %></td>
            <td><%= ride[4] %></td>
            <td><%= ride[5] %></td>
        </tr>
        
        <% 
                }
            } else { 
        %>
        <tr><td colspan="6">No rides booked yet.</td></tr>
        <% } %>
    </table>

    <br>
    <a href="bookRide.jsp">Book Another Ride</a>
    <a href="customer_dashboard.jsp">Go to Dashboard</a>
</body>
</html>