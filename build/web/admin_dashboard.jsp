<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin Dashboard - Mega City Cab</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="card shadow-lg">
            <div class="card-body">
                <h2 class="card-title text-center text-primary">Admin Dashboard</h2>
                
                <div class="text-end">
                    <a href="login.jsp" class="btn btn-danger">Logout</a>
                </div>

                <hr>

                <div class="list-group">
                    <a href="manageDriver.jsp" class="list-group-item list-group-item-action">🚖 Manage Drivers</a>
                    <a href="manageRides.jsp" class="list-group-item list-group-item-action">🚗 Manage Rides</a>
                    <a href="ManageCustomersServlet" class="list-group-item list-group-item-action">👤 Manage Customers</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS (Optional for interactive features like dropdowns) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
