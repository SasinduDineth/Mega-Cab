package com.megacab.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {
    
     // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/MegaCab"; // Update your DB name
    private static final String USER = "root"; // Update your username if necessary
    private static final String PASSWORD = "admin"; // Update your password if necessary
    
    // Method to establish database connection
    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure MySQL driver is loaded
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Database Driver Not Found!", e);
        }
    }
    // Add a new driver
    public static boolean addDriver(String name, String license, String phone, String vehicleType) {
        String sql = "INSERT INTO drivers (name, `license`, phone, vehicleType) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, license);
            ps.setString(3, phone);
            ps.setString(4, vehicleType);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a driver by ID
    public static boolean deleteDriver(int id) {
        String sql = "DELETE FROM drivers WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all drivers from the database
    public static List<String[]> getDrivers() {
        List<String[]> drivers = new ArrayList<>();
        String sql = "SELECT * FROM drivers";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String[] driver = new String[5];
                driver[0] = String.valueOf(rs.getInt("id"));
                driver[1] = rs.getString("name");
                driver[2] = rs.getString("license");
                driver[3] = rs.getString("phone");
                driver[4] = rs.getString("vehicleType");
                drivers.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }
}
