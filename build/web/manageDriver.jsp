<%@ page import="com.megacab.dao.DriverDAO" %>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Manage Drivers</title>
</head>
<body>

<h2>Manage Drivers</h2>

<%-- Add Driver Form --%>
<form action="DriverServlet" method="post">
    <input type="hidden" name="action" value="add">
    <label>Name:</label>
    <input type="text" name="name" required>
    <label>License No:</label>
    <input type="text" name="license_no" required>
    <label>Phone:</label>
    <input type="text" name="phone" required>
    <label>Vehicle Type:</label>
    <select name="vehicle_type">
        <option value="Sedan">Sedan</option>
        <option value="SUV">SUV</option>
        <option value="Van">Van</option>
    </select>
    <button type="submit">Add Driver</button>
</form>

<%-- Display Messages --%>
<% if (request.getAttribute("message") != null) { %>
    <p style="color: green;"><%= request.getAttribute("message") %></p>
<% } %>
<% if (request.getAttribute("error") != null) { %>
    <p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>

<%-- Driver Table --%>
<h3>Driver List</h3>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>License No</th>
        <th>Phone</th>
        <th>Vehicle Type</th>
        <th>Action</th>
    </tr>

    <%
        DriverDAO driverDAO = new DriverDAO();
        List<Map<String, String>> driverList = driverDAO.getAllDrivers();
        for (Map<String, String> driver : driverList) {
    %>
        <tr>
            <td><%= driver.get("driver_id") %></td>
            <td><%= driver.get("name") %></td>
            <td><%= driver.get("license_no") %></td>
            <td><%= driver.get("phone") %></td>
            <td><%= driver.get("vehicle_type") %></td>
            <td>
                <form action="DriverServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="driver_id" value="<%= driver.get("driver_id") %>">
                    <button type="submit" onclick="return confirm('Are you sure?')">Delete</button>
                </form>
            </td>
        </tr>
    <% } %>
</table>

</body>
</html>
