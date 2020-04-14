/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.users;

import java.io.Serializable;

/**
 *
 * @author duyan
 */
public class UserErr implements Serializable {

    private String userNameErr;
    private String passWordErr;
    private String confirmPassWordErr;
    private String fullNameErr;
    private String phoneErr;
    private String addressErr;
    public UserErr() {
    }

    public UserErr(String userNameErr, String passWordErr, String confirmPassWordErr, String fullNameErr, String phoneErr, String addressErr) {
        this.userNameErr = userNameErr;
        this.passWordErr = passWordErr;
        this.confirmPassWordErr = confirmPassWordErr;
        this.fullNameErr = fullNameErr;
        this.phoneErr = phoneErr;
        this.addressErr = addressErr;
    }

    public String getUserNameErr() {
        return userNameErr;
    }

    public String getPassWordErr() {
        return passWordErr;
    }

    public String getConfirmPassWordErr() {
        return confirmPassWordErr;
    }

    public String getFullNameErr() {
        return fullNameErr;
    }

    public String getPhoneErr() {
        return phoneErr;
    }

    public String getAddressErr() {
        return addressErr;
    }

    public void setUserNameErr(String userNameErr) {
        this.userNameErr = userNameErr;
    }

    public void setPassWordErr(String passWordErr) {
        this.passWordErr = passWordErr;
    }

    public void setConfirmPassWordErr(String confirmPassWordErr) {
        this.confirmPassWordErr = confirmPassWordErr;
    }

    public void setFullNameErr(String fullNameErr) {
        this.fullNameErr = fullNameErr;
    }

    public void setPhoneErr(String phoneErr) {
        this.phoneErr = phoneErr;
    }

    public void setAddressErr(String addressErr) {
        this.addressErr = addressErr;
    }
    
   

}
