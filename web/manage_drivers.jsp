<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Drivers</title>
</head>
<body>

<h2>Manage Drivers</h2>

<!-- Add Driver Form -->
<form action="DriverServlet" method="post">
    <input type="hidden" name="action" value="add">
    
    <input type="text" name="name" placeholder="Driver Name" required>
    <input type="text" name="license" placeholder="License Number" required>
    <input type="text" name="phone" placeholder="Phone Number" required>
    
    <select name="vehicleType" required>
        <option value="" disabled selected>Select Vehicle Type</option>
        <option value="Car">Car</option>
        <option value="Van">Van</option>
        <option value="SUV">SUV</option>
        <option value="Truck">Truck</option>
    </select>
    
    <button type="submit">Add Driver</button>
</form>

<!-- Displaying Status Message -->
<% String status = request.getParameter("status"); %>
<% if ("success".equals(status)) { %>
    <p>Driver added successfully!</p>
<% } else if ("error".equals(status)) { %>
    <p>There was an error adding the driver.</p>
<% } else if ("deleted".equals(status)) { %>
    <p>Driver deleted successfully!</p>
<% } else if ("invalid".equals(status)) { %>
    <p>Invalid action.</p>
<% } %>

<!-- Driver List -->
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>License</th>
        <th>Phone</th>
        <th>Vehicle Type</th>
        <th>Action</th>
    </tr>
    <% 
        List<String[]> drivers = (List<String[]>) request.getAttribute("drivers");
        if (drivers != null) {
            for (String[] driver : drivers) { 
    %>
        <tr>
            <td><%= driver[0] %></td>
            <td><%= driver[1] %></td>
            <td><%= driver[2] %></td>
            <td><%= driver[3] %></td>
            <td><%= driver[4] %></td>
            <td>
                <form action="DriverServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= driver[0] %>">
                    <button type="submit" onclick="return confirm('Are you sure?')">Delete</button>
                </form>
            </td>
        </tr>
    <% 
            }
        }
    %>
</table>

</body>
</html>
