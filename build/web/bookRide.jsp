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
    
<form action="RideServlet" method="post">
    <label for="pickup">Pickup Location:</label>
    <input type="text" id="pickup" name="pickup" required><br>

    <label for="dropoff">Drop-off Location:</label>
    <input type="text" id="dropoff" name="dropoff" required><br>

    <label for="vehicleType">Select Vehicle Type:</label>
    <select id="vehicleType" name="vehicleType" required>
        <option value="Car">Car</option>
        <option value="Van">Van</option>
        <option value="Bike">Bike</option>
    </select><br>

    <label for="distance">Distance (km):</label>
    <input type="number" id="distance" name="distance" step="0.1" required><br>

    <label for="paymentMethod">Payment Method:</label>
    <select id="paymentMethod" name="paymentMethod" required>
        <option value="Cash">Cash</option>
        <option value="Card">Card</option>
    </select><br>

    <button type="submit" name="action" value="bookRide">Book Ride</button>
</form>

    

</body>
</html>