<%@ page import="com.megacab.dao.DriverDAO" %>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Manage Drivers - Mega City Cab</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <h2 class="text-center text-primary">Manage Drivers</h2>

        <!-- Display Messages -->
        <% if (request.getAttribute("message") != null) { %>
            <div class="alert alert-success text-center"><%= request.getAttribute("message") %></div>
        <% } %>
        <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger text-center"><%= request.getAttribute("error") %></div>
        <% } %>

        <!-- Add Driver Form -->
        <div class="card p-4 shadow-sm">
            <h4 class="text-center">Add Driver</h4>
            <form action="DriverServlet" method="post">
                <input type="hidden" name="action" value="add">

                <div class="mb-3">
                    <label class="form-label">Name:</label>
                    <input type="text" name="name" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">License No:</label>
                    <input type="text" name="license_no" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Phone:</label>
                    <input type="text" name="phone" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Vehicle Type:</label>
                    <select name="vehicle_type" class="form-select">
                        <option value="Car">Car</option>
                        <option value="Van">Van</option>
                        <option value="Bike">Bike</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-success w-100">Add Driver</button>
            </form>
        </div>

        <!-- Driver Table -->
        <h3 class="mt-4">Driver List</h3>
        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>License No</th>
                        <th>Phone</th>
                        <th>Vehicle Type</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
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
                                <form action="DriverServlet" method="post">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="driver_id" value="<%= driver.get("driver_id") %>">
                                    <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</button>
                                </form>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <!-- Back Button -->
        <button class="btn btn-secondary mt-3" onclick="location.href='admin_dashboard.jsp';">Back</button>
    </div>

    <!-- Bootstrap JS (Optional for interactive features) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
