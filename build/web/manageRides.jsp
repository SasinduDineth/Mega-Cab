<%@page import="java.sql.*, com.megacab.dao.DatabaseConnection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Rides</title>
</head>
<body>
    <h2>Manage Rides - Assign Drivers</h2>

    <table border="1">
        <tr>
            <th>Ride ID</th>
            <th>Customer</th>
            <th>Pickup</th>
            <th>Drop-off</th>
            <th>Vehicle Type</th>
            <th>Assign Driver</th>
        </tr>

        <%
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM bookings WHERE driver_id IS NULL";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int rideId = rs.getInt("booking_id");
                String username = rs.getString("username");
                String pickup = rs.getString("pickup");
                String dropoff = rs.getString("dropoff");
                String vehicleType = rs.getString("vehicle_type");
        %>
        <tr>
            <td><%= rideId %></td>
            <td><%= username %></td>
            <td><%= pickup %></td>
            <td><%= dropoff %></td>
            <td><%= vehicleType %></td>
            <td>
                <form action="AssignDriverServlet" method="post">
                    <input type="hidden" name="rideId" value="<%= rideId %>">
                    <select name="driverId">
                        <%
                            // Fetch available drivers with the same vehicle type
                            String driverQuery = "SELECT driver_id, name FROM drivers WHERE vehicle_type = ?";
                            PreparedStatement ps = conn.prepareStatement(driverQuery);
                            ps.setString(1, vehicleType);
                            ResultSet driverRs = ps.executeQuery();
                            while (driverRs.next()) {
                        %>
                        <option value="<%= driverRs.getInt("driver_id") %>">
                            <%= driverRs.getString("name") %>
                        </option>
                        <%
                            }
                        %>
                    </select>
                    <button type="submit">Assign</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <button onclick="location.href='admin_dashboard.jsp';">Back</button>
</body>
</html>
