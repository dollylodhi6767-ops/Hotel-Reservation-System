package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Reservation;
import util.DBConnection;

public class getRoomNumberDAO {
    public Reservation getRoomNumber(int reservationId, String guestName) {

        Reservation reservation = null;

        String sql =
                "SELECT reservation_id, guest_name, room_number " +
                "FROM reservations " +
                "WHERE reservation_id = ? AND guest_name = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, reservationId);
            ps.setString(2, guestName);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                reservation = new Reservation();

                reservation.setId(rs.getInt("reservation_id"));
                reservation.setGuestName(rs.getString("guest_name"));
                reservation.setRoomNumber(rs.getInt("room_number"));
            }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return reservation;
        }
        
    }

