<%-- 
    Document   : logout
    Created on : Mar 2, 2025, 1:12:39 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>