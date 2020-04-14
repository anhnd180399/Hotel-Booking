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
public class InvoiceDTO implements Serializable{
    private int invoiceID;
    private int productID;
    private int quantity;
    private String dateGenerated;
    private String userName;

    public InvoiceDTO() {
    }

    public InvoiceDTO(int invoiceID, int productID, int quantity, String dateGenerated, String userName) {
        this.invoiceID = invoiceID;
        this.productID = productID;
        this.quantity = quantity;
        this.dateGenerated = dateGenerated;
        this.userName = userName;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDateGenerated() {
        return dateGenerated;
    }

    public void setDateGenerated(String dateGenerated) {
        this.dateGenerated = dateGenerated;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
