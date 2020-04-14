/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.controller;

import duyanh.constant.Constant;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duyan
 */
public class MainController extends HttpServlet {

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
        String button = request.getParameter("btnAction");
        String url = Constant.HOME_PAGE;
        try {
            if (button == null) {
                url = Constant.HOME_PAGE;
            } else if (button.equals("Login")) {
                url = Constant.LOGIN_SERVLET;
            } else if (button.equals("Logout")) {
                url = Constant.LOGOUT_SERVLET;
            } else if (button.equals("Create")) {
                url = Constant.CREATE_SERVLET;
            } else if (button.equals("Submit booking")) {
                url = Constant.BOOKING_PROCESS_SERVLET;
            } else if (button.equals("Pay")) {
                url = Constant.PAYMENT_SERVLET;
            } else if (button.equals("Search")) {
                url = Constant.SEARCH_SERVLET;
            } else if (button.equals("Send comment")) {
                url = Constant.CONTACT_SERVLET;
            } else if (button.equals("Add to cart")) {
                url = Constant.ADD_TO_CART_SERVLET;
            } else if (button.equals("Delete product from cart")) {
                url = Constant.DELETE_PRODUCT_FROM_CART;
            } else if (button.equals("Send Mail To Verify")) {
                url = Constant.SEND_MAIL_VERIFY_SERVLET;
            } else if (button.equals("Update User")) {
                url = Constant.UPDATE_USER_SERVLET;
            } else if (button.equals("Delete User")) {
                url = Constant.DELETE_USER_SERVLET;
            } else if (button.equals("Update Product")){
                url = Constant.UPDATE_PRODUCT_SERVLET;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
