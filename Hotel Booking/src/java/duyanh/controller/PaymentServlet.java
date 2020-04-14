/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.controller;

import duyanh.booking.InvoiceDAO;
import duyanh.booking.InvoiceDTO;
import duyanh.constant.Constant;
import duyanh.products.CartDTO;
import duyanh.products.JewelryDTO;
import duyanh.users.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duyan
 */
@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Random rd = new Random();
        String url = Constant.ERROR;
        Date date = new Date();
        String dateGenerated = df.format(date);
        String numRage = "0123456789";
        String id = "";
        int invoiceID;
        for (int i = 0; i < 6; i++) {
            id += numRage.charAt(rd.nextInt(numRage.length() - 1));
        }
        try {
            if (session.getAttribute("USER") == null) {
                url = Constant.JEWELRY_SHOPPING_PAGE;
                request.setAttribute("ERROR_PAY", "You have to login to pay!");
                request.getRequestDispatcher(url).forward(request, response);
            } else {
                UserDTO user = (UserDTO) session.getAttribute("USER");
                invoiceID = Integer.parseInt(id);
                CartDTO cart = (CartDTO) session.getAttribute("CART");
                InvoiceDAO invoiceDAO = new InvoiceDAO();
                InvoiceDTO invoiceDTO;
                for (JewelryDTO jewelryDTO : cart.getCart().values()) {
                    invoiceDTO = new InvoiceDTO(invoiceID, jewelryDTO.getProductID(), jewelryDTO.getProductQuantity(), dateGenerated, user.getUserName());
                    invoiceDAO.insertInvoice(invoiceDTO);
                }
                url = Constant.JEWELRY_SHOPPING_PAGE;
                session.removeAttribute("CART");
                request.setAttribute("SUCCESS", "We are processing your payment, thanks for shopping!");
                request.getRequestDispatcher(url).forward(request, response);
            }
        } catch (NamingException ex) {
            log("NamingException at PayMentServlet " + ex.getMessage());
        } catch (SQLException ex) {
            log("SQLException at PayMentServlet " + ex.getMessage());
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
