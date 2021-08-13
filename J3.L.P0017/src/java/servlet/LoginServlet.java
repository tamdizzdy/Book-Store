/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tblUsers.UsersDAO;
import tblUsers.UsersDTO;
import utils.VerifyUtils;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.servlet.ServletContext;

/**
 *
 * @author DELL
 */
public class LoginServlet extends HttpServlet {

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
        ServletContext sc = request.getServletContext();
        String url = "loginPage";
        try {
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            //hashPassword
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashByte = md.digest(password.getBytes(StandardCharsets.UTF_8));
            log("hashByte[]: " + hashByte);
            BigInteger noHash = new BigInteger(1, hashByte);
            String hashPassword = noHash.toString(16);
            UsersDAO dao = new UsersDAO();
            UsersDTO user = dao.checkLogin(userID, hashPassword);
            HttpSession session = request.getSession();
            boolean valid = false;
            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
            valid = VerifyUtils.verify(gRecaptchaResponse);
            if (valid == true) {
                if (user != null) {
                    if ("active".equals(user.getStatus())) {
                        session.setAttribute("LOGIN_USER", user);
                        if (user.getRoleID() == 1) {
                            url = "adminView";
                        }
                        if (user.getRoleID() == 2) {
                            url = "userView";
                        }
                    } else {
                        request.setAttribute("NOTI", "User not active");
                        url = "loginPage";
                    }
                } else {
                    request.setAttribute("NOTI", "User is not found");
                }
            } else {
                url = "loginPage";
                request.setAttribute("NOTI", "Recapcha invalid!");
            }

        } catch (Exception ex) {
            log("Error at LoginController: " + ex.getMessage());

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
