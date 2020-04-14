/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.users;

import duyanh.users.UserDTO;
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
public class UserDAO implements Serializable {

    Connection conn = null;
    PreparedStatement prStm = null;
    ResultSet rs = null;

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
            e.printStackTrace();
        }
    }
    public boolean checkUser(String userName)throws NamingException, SQLException{
        boolean check = false;
        try{
            String sql = "Select userName From Users Where userName = ?";
            conn = DBUtil.getConnection();
            prStm = conn.prepareStatement(sql);
            prStm.setString(1, userName);
            rs = prStm.executeQuery();
            if(rs.next()){
                check = true;
            }
        } finally{
            closeConnection();
        }
        return check;
    }
    public UserDTO checkLogin(String userName, String passWord) throws NamingException, SQLException {
        UserDTO dto = null;
        try {
            String sql = "Select userName, passWord, fullName, phone, address, role From Users Where userName = ? AND passWord = ?"
                    + " AND status = ?";
            conn = DBUtil.getConnection();
            prStm = conn.prepareStatement(sql);
            prStm.setString(1, userName);
            prStm.setString(2, passWord);
            prStm.setBoolean(3, true);
            rs = prStm.executeQuery();
            if (rs.next()) {
                String fullName, address, role;
                int phone;
                fullName = rs.getString("fullName");
                phone = rs.getInt("phone");
                address = rs.getString("address");
                role = rs.getString("role");
                dto = new UserDTO(userName, passWord, fullName, phone, address, role);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean insert(UserDTO dto) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "Insert into Users(userName,passWord,fullName,phone,address,role,status) values(?,?,?,?,?,?,?)";
            conn = DBUtil.getConnection();
            prStm = conn.prepareStatement(sql);
            prStm.setString(1, dto.getUserName());
            prStm.setString(2, dto.getPassWord());
            prStm.setString(3, dto.getFullName());
            prStm.setInt(4, dto.getPhone());
            prStm.setString(5, dto.getAddress());
            prStm.setString(6, "user");
            prStm.setBoolean(7, true);
            check = prStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<UserDTO> loadUser() throws NamingException, SQLException {
        List<UserDTO> list;
        try {
            String sql = "Select userName,passWord,fullName,phone,address From Users Where role = 'user' AND status = ? ";
            conn = DBUtil.getConnection();
            prStm = conn.prepareStatement(sql);
            prStm.setBoolean(1, true);
            rs = prStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                String userName = rs.getString("userName");
                String passWord = rs.getString("passWord");
                String fullName = rs.getString("fullName");
                int phone = rs.getInt("phone");
                String address = rs.getString("address");
                list.add(new UserDTO(userName, passWord, fullName, phone, address, ""));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean updateUser(UserDTO dto) throws NamingException, SQLException {
        boolean check = false;
        try {
            String sql = "Update Users set passWord = ?, fullName = ?, phone = ?, address = ? Where userName = ?";
            conn = DBUtil.getConnection();
            prStm = conn.prepareStatement(sql);
            prStm.setString(1, dto.getPassWord());
            prStm.setString(2, dto.getFullName());
            prStm.setInt(3, dto.getPhone());
            prStm.setString(4, dto.getAddress());
            prStm.setString(5, dto.getUserName());
            check = prStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public boolean deleteUser(String userName) throws NamingException,SQLException{
        boolean check = false;
        try{
            String sql = "Update Users set status = ? Where userName = ?";
            conn = DBUtil.getConnection();
            prStm = conn.prepareStatement(sql);
            prStm.setBoolean(1, false);
            prStm.setString(2, userName);
            check = prStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
