<%-- 
    Document   : register
    Created on : Mar 2, 2025, 11:53:11 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
    <title>Register - Mega City Cab</title>
</head>
<body>
    <h2>Customer Registration</h2>
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Registration failed! Try again.</p>
    <% } %>
    <form action="RegisterServlet" method="post">
        <input type="text" name="name" placeholder="Full Name" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="text" name="nic" placeholder="NIC" required>
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Register</button>
    </form>
</body>
</html>