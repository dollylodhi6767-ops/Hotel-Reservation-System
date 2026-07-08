<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Reservation" %>

<!DOCTYPE html>
<html>
<head>

<title>View Reservations</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>

<body>

<div class="container mt-5">

<h2>Reservations</h2>

<table class="table table-bordered table-striped">

<tr>
<th>Reservation ID</th>
<th>Guest Name</th>
<th>Room Number</th>
<th>Contact</th>
</tr>

<%
List<Reservation> reservations =
(List<Reservation>)request.getAttribute("reservations");

for(Reservation r : reservations){
%>

<tr>

<td><%= r.getId() %></td>

<td><%= r.getGuestName() %></td>

<td><%= r.getRoomNumber() %></td>

<td><%= r.getContactNumber() %></td>

</tr>

<%
}
%>

</table>

</div>

</body>
</html>