package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ViewReservationDAO;
import model.Reservation;

@WebServlet("/viewReservations")
public class ViewReservationServlet extends HttpServlet {

    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        final ViewReservationDAO dao = new ViewReservationDAO();
    
        final List<Reservation> list = dao.viewReservations();

        request.setAttribute("reservations", list);

        request.getRequestDispatcher("viewReservations.jsp")
               .forward(request, response);
    }
} 
