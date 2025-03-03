package com.megacab.dao;

import java.sql.*;
import java.util.List;

public class BookingDAO {
    public boolean bookRide(String username, String pickup, String dropoff, double distance, double fare) {
        String query = "INSERT INTO bookings (username, pickup, dropoff, distance, fare) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, pickup);
            ps.setString(3, dropoff);
            ps.setDouble(4, distance);
            ps.setDouble(5, fare);

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<String[]> getUserRides(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
