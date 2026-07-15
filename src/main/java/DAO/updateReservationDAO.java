package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Reservation;
import util.DBConnection;

public class updateReservationDAO {
    public void updateReservations(Reservation reservation) {
        try {
            String sql = "UPDATE reservations SET guest_name = ?, room_number = ?, contact_number = ? WHERE reservation_id = ?;";

            try (Connection connection = DBConnection.getConnection();
                    PreparedStatement ps = connection.prepareStatement(sql)) {
                if (!reservationExists(reservation)) {

                    throw new SQLException("Reservation not found!");

                } else {
                    ps.setString(1, reservation.getGuestName());
                    ps.setInt(2, reservation.getRoomNumber());
                    ps.setString(3, reservation.getContactNumber());
                    ps.setInt(4, reservation.getId());
                    int rowsAffected = ps.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Reservation updated successfully.");
                    } else {
                        System.out.println("Reservation not found.");
                    }

                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean reservationExists(Reservation reservation) {
        try {
            String sql = "Select reservation_id from reservations where reservation_id = ?;";

            try (Connection con = DBConnection.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql);) {
                ps.setInt(1, reservation.getId());
                ResultSet resultSet = ps.executeQuery();
                return resultSet.next(); // if there's a result , the reservation exists
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
