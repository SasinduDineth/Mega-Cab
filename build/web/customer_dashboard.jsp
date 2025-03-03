<%-- 
    Document   : customer_dashboard
    Created on : Mar 2, 2025, 1:10:59 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.megacab.dao.DatabaseConnection" %>
<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Dashboard - Mega City Cab</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Welcome, <%= username %>!</h2>
    
    <ul>
        <li><a href="bookRide.jsp">Book a Ride</a></li>
        <li><a href="viewRides.jsp">View My Rides</a></li>
        <li><a href="updateProfile.jsp">Update Profile</a></li>
        <li><a href="logout.jsp">Logout</a></li>
    </ul>

    <h3>Your Ride History</h3>
    <table border="1">
        <tr>
            <th>Ride ID</th>
            <th>Pickup Location</th>
            <th>Drop Location</th>
            <th>Fare</th>
            <th>Status</th>
        </tr>
        <%
            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "SELECT ride_id, pickup, dropoff, fare, status FROM rides WHERE username = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("ride_id") %></td>
            <td><%= rs.getString("pickup") %></td>
            <td><%= rs.getString("dropoff") %></td>
            <td><%= rs.getDouble("fare") %></td>
            <td><%= rs.getString("status") %></td>
        </tr>
        <%
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        %>
    </table>
</body>
</html>