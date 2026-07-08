package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Reservation;
import util.DBConnection;

public class ViewReservationDAO{

public List<Reservation> viewReservations() {

        ArrayList<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT* FROM reservations;";

        try(Connection connection = DBConnection.getConnection();
         PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()  ){

            while (rs.next()){
            Reservation reservation = new Reservation();
            reservation.setId(rs.getInt("reservation_id"));
            reservation.setGuestName(rs.getString("guest_name"));
            reservation.setRoomNumber(rs.getInt("room_number"));
            reservation.setContactNumber(rs.getString("contact_number"));

            reservations.add(reservation);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return reservations;

    } 
}
