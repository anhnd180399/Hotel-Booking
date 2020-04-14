/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.controller;

import duyanh.users.UserDAO;
import duyanh.users.UserDTO;
import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.APIWrapper;

/**
 *
 * @author anhndSE130595
 */
@WebServlet(name = "FacebookServlet", urlPatterns = {"/FacebookServlet"})
public class FacebookServlet extends HttpServlet {

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
        String url = "invalid.html";
        try {
            /* TODO output your page here. You may use following sample code. */
            String code = request.getParameter("code");
            APIWrapper wrapper = new APIWrapper();
            String accessToken = wrapper.getAccessToken(code);
            UserDTO userInfo = wrapper.getUserInfo();
            if (userInfo != null) {
                url = "home.jsp";
                UserDAO dao = new UserDAO();
                if (!dao.checkUser(userInfo.getUserName())) {
                    dao.insert(userInfo);
                }
                HttpSession session = request.getSession();
                session.setAttribute("USER", userInfo);
            }
        } catch (NamingException ex) {
            log("NamingException at FacebookServlet " + ex.getMessage());
        } catch (SQLException ex) {
            log("SQLException at FacebookServlet " + ex.getMessage());
        } finally {
            response.sendRedirect(url);
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
