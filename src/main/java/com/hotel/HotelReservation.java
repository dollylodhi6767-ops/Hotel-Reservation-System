package com.hotel;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;


public class HotelReservation {
    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";

    private static final String username = "root";

    private static final String password = "Doll@123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {

            Connection connection = DriverManager.getConnection(url,username,password);


            while (true){
                System.out.println();
                System.out.println("[*]=================[HOTEL MANAGEMENT SYSTEM]==================[*]");
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. Reserve a room");
                System.out.println("2. View Reservations");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservations");
                System.out.println("5. Delete Reservations");
                System.out.println("0. Exit");
                System.out.println("Choose an option(1/2/3 etc.): ");
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        reserveRoom(connection,scanner);
                        break;
                    case 2:
                        viewReservations(connection);
                        break;
                    case 3:
                        getRoomNumber(connection,scanner);
                        break;
                    case 4:
                        updateReservations(connection,scanner);
                        break;
                    case 5:
                        deleteRervations(connection,scanner);
                        break;
                    case 0:
                        exit();
                        scanner.close();
                        return;
                    default:
                        System.out.println("INVALID CHOICE..TRY AGAIN!");
                }
            }

        }catch (SQLException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteRervations(Connection connection, Scanner scanner) {
        try {
            System.out.println("Enter Reservation ID to delete : ");
            int reservationID = scanner.nextInt();

            if (!reservationExists(connection,reservationID)){
                System.out.println("Reservation not found for the given ID.");
                return;
            }
            String sql = "DELETE FROM reservations WHERE reservation_id = "+reservationID;
            try (Statement statement = connection.createStatement()){
                int affectedRows = statement.executeUpdate(sql);

                if (affectedRows > 0){
                    System.out.println("Reservation deleted successfully!");
                }else {
                    System.out.println("Reservation deletion failed.");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    private static void updateReservations(Connection connection, Scanner scanner) {
        try {
            System.out.println("Enter Reservation ID to update: ");
            int reservationID = scanner.nextInt();
            scanner.nextLine();//consume the newline character

            if (!reservationExists(connection,reservationID)){
                System.out.println("Reservation not found for the given ID");
                return;
            }
            System.out.println("Enter new guest name: ");
            String guestName = scanner.nextLine();
            scanner.nextLine();
            System.out.println("Enter new room number: ");
            int roomNumber = scanner.nextInt();
            System.out.println("Enter new contact number: ");
            String contactNumber = scanner.next();

            String sql = "UPDATE reservations SET guest_name = '"+guestName+"', "+
                    "room_number = "+roomNumber+", "+" contact_number = '"+contactNumber+"' "+
                    "WHERE reservation_id = "+reservationID;

            try (Statement statement = connection.createStatement();){
                int affectedRows = statement.executeUpdate(sql);

                if (affectedRows > 0){
                    System.out.println("Reservation updated successfully!");
                }else {
                    System.out.println("Reservation update failed.");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static boolean reservationExists(Connection connection, int reservationID) {
        try {
            String sql = "Select reservation_id from reservations where reservation_id = "+reservationID;

            try(Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
                return resultSet.next(); // if there's a result , the reservation exists
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void getRoomNumber(Connection connection, Scanner scanner) {
        try{
            System.out.println("Enter reservation ID : ");
            int reservationID = scanner.nextInt();
            System.out.println("Enter guest name: ");
            String guestName = scanner.next();
            scanner.nextLine();

            String sql =" select room_number from  reservations where reservation_id = "+reservationID+" and guest_name = '"+guestName+"';";
            try (Statement statement = connection.createStatement() ; ResultSet resultSet = statement.executeQuery(sql)){
                if (resultSet.next()){
                    int roomNumber = resultSet.getInt("room_number");
                    System.out.println("Room number of Reservation ID "+reservationID+" and Guest "+guestName+" is : "+roomNumber);
                }else {
                    System.out.println("Reservation not found for the given ID and Name: ");
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void viewReservations(Connection connection) {

        String sql = "SELECT reservation_id, guest_name, room_number, contact_number, reservation_date FROM reservations;";

        try(Statement statement = connection.createStatement() ; ResultSet resultSet = statement.executeQuery(sql)  ){

            System.out.println("Current Reservations: ");
            System.out.println("+---------------------+----------------------+--------------------+-----------------------+---------------------------+");
            System.out.println("| RESERVATION ID      | GUEST                | ROOM NUMBER        | CONTACT NUMBER        | RESERVATION TIME          |");
            System.out.println("+---------------------+----------------------+--------------------+-----------------------+---------------------------+");

            while (resultSet.next()){
                int reservationId = resultSet.getInt("reservation_id");
                String guestName = resultSet.getString("guest_name");
                int roomNumber = resultSet.getInt("room_number");
                String contactNumber = resultSet.getString("contact_number");
                String reservationDate = resultSet.getTimestamp("reservation_date").toString();

                // format and display the reservation date in a table-like format
                System.out.printf("| %d                   | %s                 | %d               | %s               | %s  |\n",reservationId,guestName,roomNumber,contactNumber,reservationDate);
                System.out.println("+---------------------+----------------------+--------------------+-----------------------+---------------------------+");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void reserveRoom(Connection connection, Scanner scanner) {
        try{
            System.out.println("Enter guest name: ");
            String guestName = scanner.next();
            scanner.nextLine();
            System.out.println("Enter room number: ");
            int roomNumber = scanner.nextInt();
            System.out.println("Enter contact number: ");
            String contactNumber = scanner.next();

            String sql = "INSERT INTO reservations (guest_name, room_number, contact_number) "+"VALUES ('"+guestName+"', "+roomNumber+", '"+contactNumber+"')";

            try (Statement statement = connection.createStatement()){
                int affectedRows = statement.executeUpdate(sql);

                if (affectedRows > 0){
                    System.out.println("Reservation successful!");
                }else {
                    System.out.println("Reservation failed.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void exit() throws InterruptedException{
        System.out.println("Exiting System");
        int i = 5;
        while (i != 0){
            System.out.print(".");
            Thread.sleep(500);
            i--;
        }
        System.out.println();
        System.out.println("Thank You For Using Hotel Reservation system!!");
    }
}
