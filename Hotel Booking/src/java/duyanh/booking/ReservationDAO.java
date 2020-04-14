/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.booking;

import duyanh.utils.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author duyan
 */
public class ReservationDAO implements Serializable {

    Connection conn;
    PreparedStatement prStm;
    ResultSet rs;

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (prStm != null) {
                prStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }

    public boolean insertReservation(ReservationDTO dto) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "Insert into Reservations(reservationID, userName, dateGenerated, arrivalDate, departureDate, numberOfGuest, smoking, pets) values(?,?,?,?,?,?,?,?)";
            conn = DBUtil.getConnection();
            prStm = conn.prepareStatement(sql);
            prStm.setInt(1, dto.getReservationID());
            prStm.setString(2, dto.getUserName());
            prStm.setString(3, dto.getDateGenerated());
            prStm.setString(4, dto.getArrivalDate());
            prStm.setString(5, dto.getDepartureDate());
            prStm.setInt(6, dto.getNumberOfGuest());
            prStm.setBoolean(7, dto.isIsSmoking());
            prStm.setBoolean(8, dto.isIsPet());
            check = prStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
