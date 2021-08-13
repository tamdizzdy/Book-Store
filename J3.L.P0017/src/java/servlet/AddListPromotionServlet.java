/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import cart.CartObject;
import tblPromotion.PromotionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
@WebServlet(name = "AddListPromotionServlet", urlPatterns = {"/AddListPromotionServlet"})
public class AddListPromotionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = "errorPage";
        try {
            int rank = 5;
            String userID = request.getParameter("userID");
            String nameuser = request.getParameter("name");
            PromotionDTO list = new PromotionDTO(userID, nameuser, rank);
            HttpSession session = request.getSession(false);
            boolean checkCart = false;
            if (session != null) {
                CartObject cart = (CartObject) session.getAttribute("CART");              
                if (cart == null) {
                    cart = new CartObject();
                    checkCart = true;
                }
                int temp = 0;
                log("checkcart: " +checkCart);
                if (!checkCart) {
                            if(cart.getCart()!= null) {
                                if(cart.getCart().containsKey(userID)){
                                    request.setAttribute("NOTI", "The user had in the promotion list");
                                    temp++;
                                }
                            }
                                                       
                }
                if (temp == 0) {
                    cart.add(list);
                    request.setAttribute("NOTI", "The user add to the promotion list successfully");
                }
                session.setAttribute("CART", cart);
                url = "adminView";
            }
        } catch (Exception ex) {
            log("Error at AddListPromotionServlet: " + ex.getMessage());
            ex.printStackTrace();
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
