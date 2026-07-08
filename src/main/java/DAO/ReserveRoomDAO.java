package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Reservation;
import util.DBConnection;

public class ReserveRoomDAO{
public boolean reserveRoom(Reservation reservation) {
            
            String sql = "INSERT INTO reservations (guest_name, room_number, contact_number ) VALUES(?,?,?)";

            try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1,reservation.getGuestName());
                ps.setInt(2,reservation.getRoomNumber());
                ps.setString(3, reservation.getContactNumber());

                return ps.executeUpdate()>0;
            }catch(SQLException e){
                e.printStackTrace();

            }
            return false;
        }    
    }

