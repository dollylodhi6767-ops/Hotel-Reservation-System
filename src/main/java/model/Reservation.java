package model;

public class Reservation { 
 private int id;
 private String guestName;
 private int roomNumber;
 private String contactNumber;

public Reservation(){

}

 public Reservation(String guestName, int roomNumber, String contactNumber) {
    this.guestName = guestName;
    this.roomNumber = roomNumber;
    this.contactNumber = contactNumber;
 }
 public String getGuestName() {
    return guestName;
 }
 public void setGuestName(String guestName) {
    this.guestName = guestName;
 }
 public int getRoomNumber() {
    return roomNumber;
 }
 public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
 }
 public String getContactNumber() {
    return contactNumber;
 }
 public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
 }

 public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}
     
}
