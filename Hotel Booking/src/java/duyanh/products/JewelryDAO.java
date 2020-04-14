/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.products;

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
public class JewelryDAO implements Serializable{
    Connection conn ;
    PreparedStatement prStm ;
    ResultSet rs;
    private void closeConnection (){
        try {
            if(rs != null){
                rs.close();
            }
            if(prStm != null){
                prStm.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (Exception e) {
        }
    }
    public JewelryDTO getProduct(int productID)throws NamingException, SQLException{
        JewelryDTO dto = null;
        try{
            String sql = "Select productName, productPrice From Products Where productID = ?";
            conn = DBUtil.getConnection();
            prStm = conn.prepareStatement(sql);
            prStm.setInt(1, productID);
            rs = prStm.executeQuery();
            if(rs.next()){
                dto = new JewelryDTO(productID,rs.getString("productName"), rs.getFloat("productPrice"), 1);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public List<JewelryDTO> getAllProduct()throws NamingException, SQLException{
        List<JewelryDTO> result = null;
        try{
            String sql = "Select productID, productName, productPrice, productQuantity From Products";
            conn = DBUtil.getConnection();
            prStm = conn.prepareStatement(sql);
            rs = prStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                float productPrice = rs.getFloat("productPrice");
                int productQuantity = rs.getInt("productQuantity");
                result.add(new JewelryDTO(productID, productName, productPrice, productQuantity));
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    public boolean updateProduct(int productID, int productQuantity)throws NamingException, SQLException{
        boolean check = false;
        try{
            String sql = "Update Products set productQuantity = ? Where productID = ?";
            conn = DBUtil.getConnection();
            prStm = conn.prepareStatement(sql);
            prStm.setInt(1, productQuantity);
            prStm.setInt(2, productID);
            check  = prStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
