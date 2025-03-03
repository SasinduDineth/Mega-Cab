<%-- 
    Document   : bookRide
    Created on : Mar 2, 2025, 2:35:53 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Book a Ride</title>
</head>
<body>
    <h2>Book Your Ride</h2>
    
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Booking failed. Try again!</p>
    <% } %>
    
    <form action="BookRideServlet" method="post">
        <label>Pickup Location:</label>
        <input type="text" name="pickup" required><br>

        <label>Drop-off Location:</label>
        <input type="text" name="dropoff" required><br>

        <label>Distance (km):</label>
        <input type="number" step="0.1" name="distance" required><br>

        <button type="submit">Book Ride</button>
    </form>
    
    
    

</body>
</html>