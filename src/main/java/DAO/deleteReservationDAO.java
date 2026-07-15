package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Reservation;
import util.DBConnection;

public class deleteReservationDAO {
    public void deleteRervations(Reservation reservation) {
        try {
            String sql = "DELETE FROM reservations WHERE reservation_id = ?;";

            try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

                if (!reservationExists(reservation)) {
                    System.out.println("Reservation not found for the given ID.");
                    return;
                } else {
                    ps.setInt(1, reservation.getId());
                    int affectedRows = ps.executeUpdate();
                    if (affectedRows > 0) {
                        System.out.println("Reservation deleted successfully!");
                    } else {
                        System.out.println("Reservation deletion failed.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
