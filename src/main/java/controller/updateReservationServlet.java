package controller;
import java.io.IOException;

import DAO.updateReservationDAO;
import model.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/update")

public class updateReservationServlet
        extends HttpServlet {

    @Override

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        Reservation reservation = new Reservation();

        reservation.setId(
                Integer.parseInt(request.getParameter("reservationId")));

        reservation.setGuestName(
                request.getParameter("guestName"));

        reservation.setRoomNumber(
                Integer.parseInt(request.getParameter("roomNumber")));

        reservation.setContactNumber(
                request.getParameter("contactNumber"));
        updateReservationDAO dao =
                new updateReservationDAO();

        dao.updateReservations(reservation);

        response.sendRedirect("success1.html");

    }

}

