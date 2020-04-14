/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.controller;

import duyanh.booking.BookingDAO;
import duyanh.booking.BookingDTO;
import duyanh.users.UserDAO;
import duyanh.users.UserDTO;
import duyanh.products.JewelryDAO;
import duyanh.products.JewelryDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duyan
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

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
        try{
            
            String searchValue = request.getParameter("type");
            request.setAttribute("SEARCH", searchValue);
            if(searchValue.equals("userManagement")){
                UserDAO dao = new UserDAO();
                List<UserDTO> list = dao.loadUser();
                request.setAttribute("LIST_USER", list);
            } else if (searchValue.equals("productManagement")){
                JewelryDAO dao = new JewelryDAO();
                List<JewelryDTO> list = dao.getAllProduct();
                request.setAttribute("LIST_PRODUCT", list);
            } else if (searchValue.equals("bookingManagement")){
                BookingDAO dao = new BookingDAO();
                List<BookingDTO> list = dao.getAllBooking();
                request.setAttribute("LIST_BOOKING", list);
            }
        } catch (NamingException ex) {
            log("NamingException at SearchServlet : " + ex.getMessage());
        } catch (SQLException ex) {
            log("SQLException at SearchServlet : " + ex.getMessage());
        } finally {
            request.getRequestDispatcher("home_admin.jsp").forward(request, response);
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
