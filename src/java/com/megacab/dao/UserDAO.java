package com.megacab.dao;

import java.sql.*;

public class UserDAO {
    /**
     * Validates the user credentials.
     * @param username the username input
     * @param password the password input
     * @return the role of the user if valid, otherwise null
     */
    public String validateUser(String username, String password) {
        String query = "SELECT role FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("role"); // Return the role of the user
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Invalid credentials
    }
}
