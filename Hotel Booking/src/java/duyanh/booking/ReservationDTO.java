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
public class ReservationDTO implements Serializable {

    private int reservationID;
    private String userName;
    private String dateGenerated;
    private String arrivalDate;
    private String departureDate;
    private int numberOfGuest;
    private boolean  isSmoking;
    private boolean isPet;

    public ReservationDTO() {
    }

    public ReservationDTO(int reservationID, String userName, String dateGenerated, String arrivalDate, String departureDate, int numberOfGuest, boolean isSmoking, boolean isPet) {
        this.reservationID = reservationID;
        this.userName = userName;
        this.dateGenerated = dateGenerated;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.numberOfGuest = numberOfGuest;
        this.isSmoking = isSmoking;
        this.isPet = isPet;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateGenerated() {
        return dateGenerated;
    }

    public void setDateGenerated(String dateGenerated) {
        this.dateGenerated = dateGenerated;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getNumberOfGuest() {
        return numberOfGuest;
    }

    public void setNumberOfGuest(int numberOfGuest) {
        this.numberOfGuest = numberOfGuest;
    }

    public boolean isIsSmoking() {
        return isSmoking;
    }

    public void setIsSmoking(boolean isSmoking) {
        this.isSmoking = isSmoking;
    }

    public boolean isIsPet() {
        return isPet;
    }

    public void setIsPet(boolean isPet) {
        this.isPet = isPet;
    }
    

}
