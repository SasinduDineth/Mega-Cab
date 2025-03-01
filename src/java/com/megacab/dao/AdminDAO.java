package com.megacab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    
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

    // Check admin login credentials
    public static boolean validateAdmin(String username, String password) {
        boolean isValid = false;
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
