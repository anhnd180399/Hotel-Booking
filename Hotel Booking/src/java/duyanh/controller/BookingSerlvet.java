/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.controller;

import duyanh.booking.BookingDAO;
import duyanh.booking.BookingDTO;
import duyanh.booking.ReservationDAO;
import duyanh.booking.ReservationDTO;
import duyanh.constant.Constant;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duyan
 */
@WebServlet(name = "BookingSerlvet", urlPatterns = {"/BookingSerlvet"})
public class BookingSerlvet extends HttpServlet {

    private boolean checkDate(String dateCreate, String arrivalDate, String departureDate) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dCreate = df.parse(dateCreate.trim());
        Date dArrival = df.parse(arrivalDate);
        Date dDeparture = df.parse(departureDate);

        if (dArrival.after(dCreate) && dDeparture.after(dCreate) && dArrival.before(dDeparture)) {
            return true;
        } else {
            return false;
        }
    }

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
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String numRage = "0123456789";
        String idReservation = "";
        String idBooking = "";
        String url = Constant.ERROR;
        Random rd = new Random();
        int reservationID;
        int bookingID;
        String dateCreate = df.format(date);
        String userName = request.getParameter("userName");
        String arrivalDate = request.getParameter("arrivalDate");
        String departureDate = request.getParameter("departureDate");
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        int numberOfGuest = Integer.parseInt(request.getParameter("numberOfGuest"));
        boolean isSmoking = request.getParameter("isSmoking").equals("no") ? false : true;
        boolean isPet = request.getParameter("isPet").equals("no") ? false : true;

        for (int i = 0; i < 6; i++) {
            idReservation += numRage.charAt(rd.nextInt(numRage.length() - 1));
            idBooking += numRage.charAt(rd.nextInt(numRage.length() - 1));
        }
        try {
            bookingID = Integer.parseInt(idBooking);
            reservationID = Integer.parseInt(idReservation);
            BookingDAO bookingDAO = new BookingDAO();
            BookingDTO bookingDTO = new BookingDTO(bookingID, reservationID, dateCreate, roomID, userName);
            ReservationDAO reservationDAO = new ReservationDAO();
            ReservationDTO reservationDTO = new ReservationDTO(reservationID, userName, dateCreate, arrivalDate, departureDate, numberOfGuest, isSmoking, isPet);
            if (!checkDate(dateCreate, arrivalDate, departureDate)) {
                url = Constant.BOOKING_PAGE;
                request.setAttribute("ERROR", "Your DateBooking is not correct, please try again!");
                request.getRequestDispatcher(url).forward(request, response);
            } else if (reservationDAO.insertReservation(reservationDTO) && bookingDAO.insertBooking(bookingDTO)) {
                url = Constant.BOOKING_PAGE;
                request.setAttribute("SUCCESS", "We are processing your booking, Thanks for booking us!");
                request.getRequestDispatcher(url).forward(request, response);
            } else {
                response.sendRedirect(url);
            }
        } catch (Exception e) {
            log("Error at BookingServlet " + e.getMessage());
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
