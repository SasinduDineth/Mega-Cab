package com.megacab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RideDAO {

    public boolean bookRide(String username, String pickup, String dropoff, String vehicleType, String paymentMethod, double distance) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO rides (customer_name, pickup, dropoff, vehicle_type, payment_method, distance) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, pickup);
            ps.setString(3, dropoff);
            ps.setString(4, vehicleType);
            ps.setString(5, paymentMethod);
            ps.setDouble(6, distance);

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean bookRide(String username, String pickup, String dropoff, String vehicleType, String paymentMethod) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
