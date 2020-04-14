/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.users;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author duyan
 */
public class UserDTO implements Serializable {

    @SerializedName(value = "id") private String userName;
    private String passWord;
    @SerializedName(value = "name") private String fullName;
    private int phone;
    private String address;
    private String role;

    public UserDTO() {
    }

    public UserDTO(String userName, String passWord, String fullName, int phone, String address, String role) {
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
   
}
