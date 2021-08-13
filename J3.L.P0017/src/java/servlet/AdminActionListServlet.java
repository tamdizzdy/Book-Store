/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import cart.CartObject;
import tblPromotion.PromotionDAO;
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
@WebServlet(name = "AdminActionListServlet", urlPatterns = {"/AdminActionListServlet"})
public class AdminActionListServlet extends HttpServlet {

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
        String url = "errorPage";
        try {
            int rank = 0;
            String rank1 = request.getParameter("rank");
            if (rank1 == null) {
                rank1 = "0";
            } else {
                rank = Integer.parseInt(rank1);
            }
            String name = request.getParameter("name");
            String userID = request.getParameter("userID");
            log("userid: " + userID);
            HttpSession session = request.getSession();
            CartObject cart = (CartObject) session.getAttribute("CART");
            String button = request.getParameter("Action");
            if ("Delete".equals(button)) {
                cart.delete(userID);
                session.setAttribute("CART", cart);
                request.setAttribute("NOTI", "Remove user from list successfully! ");
                url = "promotionListPage";
            }
            if ("Update".equals(button)) {
                PromotionDTO list = null;
                log("userID:" + userID);
                for (PromotionDTO dto : cart.getCart().values()) {
                    if (dto.getUserID().equals(userID)) {
                        list = new PromotionDTO(userID, name, rank);
                    }
                }
                if (rank < 0 || rank > 10) {
                    request.setAttribute("NOTI", "Rank from 0 to 10");
                    url = "promotionListPage";
                } else {
                    cart.update(userID, list);
                    session.setAttribute("CART", cart);
                    request.setAttribute("NOTI", "Update user in list successfully! ");
                    url = "promotionListPage";
                }
            }
            if ("Save to database".equals(button)) {
                boolean temp = false;
                PromotionDAO dao = new PromotionDAO();
                if (cart.getCart().isEmpty()) {
                    request.setAttribute("NOTI", "List promotion is empty");
                    url = "promotionListPage";
                } else {
                    for (PromotionDTO dto : cart.getCart().values()) {
                        temp = dao.insertList(dto);
                    }
                    if (temp == true) {
                        request.setAttribute("NOTI", "Store promotion list to database successfully");
                        url = "promotionListPage";
                        session.removeAttribute("CART");
                    }
                }
            }

        } catch (Exception ex) {
            log("Error at AdminActionListServlet: " + ex.getMessage());
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
