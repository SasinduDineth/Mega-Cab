package com.megacab.dao;

import java.sql.*;

public class UserDAO {

    public boolean registerUser(String name, String email, String nic, String username, String password, String role) {
        String query = "INSERT INTO users (name, email, nic, username, password, role) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, nic);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setString(6, role); // 'admin' or 'customer'

            stmt.executeUpdate();
            return true; // Registration successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Registration failed
        }
    }

    public String validateUser(String username, String password) {
        String query = "SELECT role FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("role"); // Return the role if valid
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Invalid credentials
    }
}
