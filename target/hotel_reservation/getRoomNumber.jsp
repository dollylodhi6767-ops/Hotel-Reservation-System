<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Reservation" %>

<!DOCTYPE html>
<html>

<head>

    <title>Get Room Number</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow p-4">

        <h2 class="text-center mb-4">Get Room Number</h2>

        <!-- Form -->

        <form action="getRoomNumber" method="post">

            <div class="mb-3">

                <label class="form-label">
                    Reservation ID
                </label>

                <input type="number"
                       class="form-control"
                       name="reservationId"
                       required>

            </div>

            <div class="mb-3">

                <label class="form-label">
                    Guest Name
                </label>

                <input type="text"
                       class="form-control"
                       name="guestName"
                       required>

            </div>

            <button class="btn btn-primary w-100">

                Get Room Number

            </button>

        </form>

        <hr>

        <!-- Result -->

        <%
            Reservation reservation =
                    (Reservation)request.getAttribute("reservation");

            if(reservation != null){
        %>

        <div class="alert alert-success mt-3">

            <h5>Reservation Found</h5>

            <p><strong>Reservation ID:</strong>
                <%= reservation.getId() %>
            </p>

            <p><strong>Guest Name:</strong>
                <%= reservation.getGuestName() %>
            </p>

            <p><strong>Room Number:</strong>
                <%= reservation.getRoomNumber() %>
            </p>

        </div>

        <%
            }
        %>

    </div>

</div>

</body>

</html>