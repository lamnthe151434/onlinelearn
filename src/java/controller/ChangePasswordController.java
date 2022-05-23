/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ChangePasswordController", urlPatterns = {"/password/change"})
public class ChangePasswordController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Changepassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Changepassword at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.getRequestDispatcher("../view/dynamic/access/change-password.jsp").forward(request, response);
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
        String Username = request.getParameter("username");
        String Oldpass = request.getParameter("oldpass");
        String Newpass = request.getParameter("newpass");
        String Renewpass = request.getParameter("renewpass");
        UserDBContext uc = new UserDBContext();
        User user = uc.getUser(Username, Oldpass);
        if (user == null) {
            request.setAttribute("tbao1", "Tài khoản hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("../view/dynamic/access/change-password.jsp").forward(request, response);
        }
        if (Newpass.equals(Oldpass)) {
            request.setAttribute("tbao2", "Mật khẩu mới và cũ trùng nhau!");
            request.getRequestDispatcher("../view/dynamic/access/change-password.jsp").forward(request, response);
        }
        if (!(Newpass.equals(Renewpass))) {
            request.setAttribute("tbao3", "Hai mật khẩu mới không trùng khớp!");
            request.getRequestDispatcher("../view/dynamic/access/change-password.jsp").forward(request, response);
        }
        uc.ChangePass(Username, Newpass);
        request.setAttribute("tbao", "Đổi mật khẩu thành công!");
        request.getRequestDispatcher("../view/notification/notification.jsp").forward(request, response);
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
