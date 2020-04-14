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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author duyan
 */
public class BookingDAO implements Serializable {

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

    public boolean insertBooking(BookingDTO dto) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "Insert into Booking(bookingID, reservationID, dateGenerated, roomID, userName) values(?,?,?,?,?)";
            conn = DBUtil.getConnection();
            prStm = conn.prepareStatement(sql);
            prStm.setInt(1, dto.getBookingID());
            prStm.setInt(2, dto.getReservationID());
            prStm.setString(3, dto.getDateGenerated());
            prStm.setInt(4, dto.getRoomID());
            prStm.setString(5, dto.getUserName());
            check = prStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;

    }
    public List<BookingDTO> getAllBooking()throws NamingException, SQLException{
        List<BookingDTO> list ;
        String sql = "Select bookingID, reservationID, dateGenerated, roomID, userName From Booking";
        conn = DBUtil.getConnection();
        prStm = conn.prepareStatement(sql);
        rs = prStm.executeQuery();
        list = new ArrayList<>();
        while(rs.next()){
            list.add(new BookingDTO(rs.getInt("bookingID"), rs.getInt("reservationID"), String.valueOf(rs.getDate("dateGenerated")), rs.getInt("roomID"), rs.getString("userName")));
        }
        return list;
    }
}
