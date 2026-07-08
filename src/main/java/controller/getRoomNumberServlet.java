package controller;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Reservation;
import DAO.getRoomNumberDAO;

@WebServlet("/getRoomNumber")
public class getRoomNumberServlet extends HttpServlet {
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        final getRoomNumberDAO dao = new getRoomNumberDAO();

        int reservationId = Integer.parseInt(request.getParameter("reservationId"));

        String guestName = request.getParameter("guestName");

        Reservation reservation = dao.getRoomNumber(reservationId, guestName);

        request.setAttribute("reservation", reservation);

        request.getRequestDispatcher("getRoomNumber.jsp")
                .forward(request, response);
    }
}
