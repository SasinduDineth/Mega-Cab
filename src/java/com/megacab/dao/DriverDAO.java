package com.megacab.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DriverDAO {
    
    public boolean addDriver(String name, String licenseNo, String phone, String vehicleType) {
        String query = "INSERT INTO drivers (name, license_no, phone, vehicle_type) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, licenseNo);
            stmt.setString(3, phone);
            stmt.setString(4, vehicleType);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Map<String, String>> getAllDrivers() {
        List<Map<String, String>> driverList = new ArrayList<>();
        String query = "SELECT * FROM drivers";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Map<String, String> driver = new HashMap<>();
                driver.put("driver_id", String.valueOf(rs.getInt("driver_id")));
                driver.put("name", rs.getString("name"));
                driver.put("license_no", rs.getString("license_no"));
                driver.put("phone", rs.getString("phone"));
                driver.put("vehicle_type", rs.getString("vehicle_type"));
                driverList.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driverList;
    }

    public boolean deleteDriver(int driverId) {
        String query = "DELETE FROM drivers WHERE driver_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, driverId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Driver getDriverByVehicleType(String vehicleType) {
    Driver driver = null;
    // Query the database to find a driver who has the specified vehicle type
    String query = "SELECT * FROM drivers WHERE vehicle_type = ? AND available = true LIMIT 1";
    // Execute the query and retrieve the driver details
    // If a driver is found, return the driver object
    return driver;
}

}
