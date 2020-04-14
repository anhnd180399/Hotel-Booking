/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.controller;

import duyanh.constant.Constant;
import duyanh.users.UserDAO;
import duyanh.users.UserDTO;
import duyanh.users.UserErr;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "CreateServlet", urlPatterns = {"/CreateServlet"})
public class CreateServlet extends HttpServlet {

    private static final String ERROR = Constant.CREATE_JSP_PAGE;
    private static final String SUCCESS = Constant.HOME_PAGE;

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
        String url = ERROR;
        try {
            UserDAO dao = new UserDAO();
            UserErr errors = new UserErr();
            boolean valid = true;
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            String confirmPassWord = request.getParameter("confirmPassWord");
            String fullName = request.getParameter("fullName");
            int phone = Integer.parseInt(request.getParameter("phone"));;
            String address = request.getParameter("address");
            if (userName.length() < 6 || userName.length() > 20) {
                errors.setUserNameErr("Length of username must be between 6 and 20 characters!");
                valid = false;
            } else if (dao.checkUser(userName)){
                errors.setUserNameErr("This user is existed, please try again!");
                valid = false;
            }
            if (passWord.length() < 8 || passWord.length() > 16) {
                errors.setPassWordErr("Length of password must be between 8 and 16 characters!");
                valid = false;
            }
            if (!confirmPassWord.equals(passWord)) {
                errors.setConfirmPassWordErr("Confirm PassWord is not match!");
                valid = false;
            }
            if (fullName.length() < 6 || fullName.length() > 30) {
                errors.setFullNameErr("Length of username must be between 6 and 30 characters!");
                valid = false;
            }
            if (request.getParameter("phone").length() != 10) {
                errors.setPhoneErr("Length of phone must be 10 digits");
                valid = false;
            } else if (phone < 0) {
                errors.setPhoneErr("Phone must be a positive number");
                valid = false;
            }

            if (valid == false) {
                request.setAttribute("ERRORS", errors);
            } else {
                url = "send_mail_verify.jsp";
                UserDTO dto = new UserDTO(userName, passWord, fullName, phone, address, "user");
                HttpSession session = request.getSession();
                session.setAttribute("USER", dto);
            }
        } catch (NamingException ex) {
            log("NamingException at CreateServlet " + ex.getMessage());
        } catch (SQLException ex) {
            log("SQLException at CreateServlet " + ex.getMessage());
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
