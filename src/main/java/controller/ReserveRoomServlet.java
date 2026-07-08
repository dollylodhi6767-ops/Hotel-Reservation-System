package controller;

import java.io.IOException;

import DAO.ReserveRoomDAO;
import model.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/reserve")

public class ReserveRoomServlet
        extends HttpServlet {

    @Override

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        String guestName =
                request.getParameter("guestName");

        int roomNumber =
                Integer.parseInt(
                        request.getParameter("roomNumber"));

        String contact =
                request.getParameter("contactNumber");

        Reservation reservation = new Reservation(
                        guestName,
                        roomNumber,
                        contact);

        ReserveRoomDAO dao =
                new ReserveRoomDAO();

        dao.reserveRoom(reservation);

        response.sendRedirect("success.html");

    }

}


