/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author duyan
 */
public class DBUtil implements Serializable {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Context context = new InitialContext();
            Context end = (Context) context.lookup("java:comp/env");
            DataSource ds = (DataSource) end.lookup("DBConnection");
            conn = ds.getConnection();

        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
