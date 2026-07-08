package util; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
        private static final String url = "jdbc:mysql://localhost:3306/hotel_db";

        private static final String username = "root";

        private static final String password = "Doll@123";

        public static Connection getConnection() throws SQLException{
                try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("MySQL Driver loaded successfully.");
} catch (ClassNotFoundException e) {
    System.out.println("Failed to load MySQL Driver.");
    e.printStackTrace();
}
           return DriverManager.getConnection(url,username,password);
        }
}