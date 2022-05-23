/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.common;

import dal.UserDBContext;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("view/dynamic/access/login.jsp").forward(request, response);

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

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String passwrod = request.getParameter("password");

        UserDBContext userDB = new UserDBContext();
        User u = new User();
        u.setUsername(username);
        u.setPassword(passwrod);
        User user = userDB.getUser(username, passwrod);

        if (user != null) {

            HttpSession session = request.getSession();
            UserDBContext udb = new UserDBContext();
            String userGroup = udb.getUserGroup(user);
            user = udb.getUser(username, passwrod);
            session.setAttribute("user", user);

            String url = "home";
            response.sendRedirect(url);

        } else if (!isExistUser(username)) {
            int errorCode = 1;
            request.setAttribute("error", errorCode);
            request.getRequestDispatcher("view/dynamic/access/login.jsp").forward(request, response);
        } else if (isExistUser(username) && user == null) {
            int errorCode = 2;
            System.out.println("error 2");
            request.setAttribute("error", errorCode);
            request.getRequestDispatcher("view/dynamic/access/login.jsp").forward(request, response);
        } else {
            int errorCode = 3;
            request.setAttribute("error", errorCode);
            request.getRequestDispatcher("view/dynamic/access/login.jsp").forward(request, response);
        }
    }

    private boolean isExistUser(String username) {
        UserDBContext udb = new UserDBContext();
        return udb.getUserByUsername(username) != null;
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
