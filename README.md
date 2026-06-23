# Hotel Reservation System

A console-based Hotel Reservation System developed using **Java**, **JDBC**, and **MySQL**. This application allows users to manage hotel room reservations efficiently through a simple menu-driven interface.

## 🚀 Technologies Used

* **Java** - Core application development
* **JDBC (Java Database Connectivity)** - Database connectivity
* **MySQL** - Data storage and management

## 📋 Features

### 1. Reserve a Room

* Create a new hotel room reservation.
* Store guest details and reservation information in the database.

### 2. View Reservations

* Display all existing reservations.
* View reservation details such as reservation ID, guest name, room number, contact information, and reservation date.

### 3. Get Room Number

* Retrieve the room number associated with a specific reservation.
* Search using reservation details.

### 4. Update Reservations

* Modify existing reservation information.
* Update guest details, room allocation, or reservation dates.

### 5. Delete Reservations

* Cancel and remove reservations from the database.
* Maintain accurate reservation records.

## 🗄️ Database Setup

### Create Database

```sql
CREATE DATABASE hotel_db;
```

### Create Reservations Table

```sql
CREATE TABLE reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    guest_name VARCHAR(100) NOT NULL,
    room_number INT NOT NULL,
    contact_number VARCHAR(15),
    reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## ⚙️ Installation and Setup

1. Clone the repository:

```bash
git clone <repository-url>
```

2. Open the project in your preferred IDE (IntelliJ IDEA, Eclipse, VS Code).

3. Configure MySQL database credentials in the Java source file:

```java
private static final String URL = "jdbc:mysql://localhost:3306/hotel_db";
private static final String USERNAME = "your_username";
private static final String PASSWORD = "your_password";
```

4. Add the MySQL JDBC Driver to the project dependencies.

5. Compile and run the application:

```bash
javac HotelReservationSystem.java
java HotelReservationSystem
```

## 📂 Project Structure

```text
HotelReservationSystem/
│
├── HotelReservationSystem.java
├── README.md
└── mysql-connector-j.jar
```

## 💡 Future Enhancements

* User authentication and authorization
* Room availability tracking
* Online payment integration
* Graphical User Interface (GUI)
* Reservation reporting and analytics
* Email/SMS booking confirmations

## 👨‍💻 Author

Developed as a Java JDBC and MySQL project for learning database connectivity and CRUD operations.

## 📄 License

This project is open-source and available for educational and learning purposes.
