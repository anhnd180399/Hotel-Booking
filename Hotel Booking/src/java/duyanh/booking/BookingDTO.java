/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.booking;

import java.io.Serializable;

/**
 *
 * @author duyan
 */
public class BookingDTO implements Serializable{
    private int bookingID;
    private int reservationID;
    private String dateGenerated;
    private int roomID;
    private String userName;

    public BookingDTO() {
    }

    public BookingDTO(int bookingID, int reservationID, String dateGenerated, int roomID, String userName) {
        this.bookingID = bookingID;
        this.reservationID = reservationID;
        this.dateGenerated = dateGenerated;
        this.roomID = roomID;
        this.userName = userName;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getDateGenerated() {
        return dateGenerated;
    }

    public void setDateGenerated(String dateGenerated) {
        this.dateGenerated = dateGenerated;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
