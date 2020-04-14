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
public class InvoiceDAO implements Serializable {

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

    public boolean insertInvoice(InvoiceDTO dto) throws NamingException, SQLException {
        boolean check = false;
        try{
            String sql = "Insert into Invoice(invoiceID, productID, quantity, dateGenerated, userName) values(?,?,?,?,?)";
            conn = DBUtil.getConnection();
            prStm = conn.prepareStatement(sql);
            prStm.setInt(1, dto.getInvoiceID());
            prStm.setInt(2, dto.getProductID());
            prStm.setInt(3, dto.getQuantity());
            prStm.setString(4, dto.getDateGenerated());
            prStm.setString(5, dto.getUserName());
            check  = prStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

}
