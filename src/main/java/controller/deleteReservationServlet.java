package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.deleteReservationDAO;
import model.Reservation;

@WebServlet("/delete")
public class deleteReservationServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final deleteReservationDAO dao = new deleteReservationDAO();

        Reservation reservation = new Reservation();
        reservation.setId(
                Integer.parseInt(request.getParameter("reservationId")));

        dao.deleteRervations(reservation);

       response.sendRedirect("delete_success.html");;
    }
}
