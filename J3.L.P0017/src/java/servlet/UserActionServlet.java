/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tblUsers.UsersDAO;
import tblUsers.UsersDTO;
import tblUsers.UsersErrorDTO;
import java.io.File;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author DELL
 */
@WebServlet(name = "UserActionServlet", urlPatterns = {"/UserActionServlet"})
public class UserActionServlet extends HttpServlet {

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
        UsersErrorDTO userError = new UsersErrorDTO();
        boolean flag = true;
        try {
            boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
            if (!isMultiPart) {
            } else {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = null;
                try {
                    items = upload.parseRequest(request);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
                Iterator iter = items.iterator();
                Hashtable params = new Hashtable();
                String itemName = null;
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    if (item.isFormField()) {
                        params.put(item.getFieldName(), item.getString());
                    } else {
                        try {
                            itemName = item.getName();
                            String realPath = "D:\\FU FPT\\CN5\\LAB231\\J3.L.P0017\\web\\images\\" + itemName;
                            log("RealPath: " + realPath);
                            File savedFile = new File(realPath);
                            if (!savedFile.exists()) {
                                item.write(savedFile);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                String userID = (String) params.get("userID");
                String name = (String) params.get("name");
                String address = (String) params.get("address");
                String button = (String) params.get("Action");
                if (name.isEmpty() || (name.length() < 5 || name.length() > 15)) {
                    userError.setNameError("User name must be [5-15] characters");
                    flag = false;
                }

                if (address.isEmpty() || (address.length() < 10 || address.length() > 50)) {
                    userError.setAddressError("Address must be [10-50] characters");
                    flag = false;
                }

                UsersDTO user = new UsersDTO(userID, itemName, name, address);
                UsersDAO dao = new UsersDAO();
                if (flag) {
                    if ("Update".equals(button)) {
                        boolean temp = dao.updateUser(user);
                        if (temp == true) {
                            request.setAttribute("UPDATE", "Update user successfully");
                            url = "userView";
                        } else {
                            request.setAttribute("UPDATE", "Update user fail");
                            url = "userView";
                        }
                    }
                } else {
                    request.setAttribute("ERROR", userError);
                    url = "userView";
                }
            }
        } catch (Exception ex) {
            log("Error at UserActionServlet: " + ex.getMessage());

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
