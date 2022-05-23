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
import model.Email;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ForgotPasswordController", urlPatterns = {"/password/forgot"})

public class ForgotPasswordController extends HttpServlet {

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
        request.getRequestDispatcher("../view/dynamic/access/forgot-password.jsp").forward(request, response);
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
        try {
            String emailName = request.getParameter("email");
            UserDBContext userDB = new UserDBContext();
            String password = userDB.getUserPasswordByEmail(emailName);
            if (password == null || password.length() == 0) {
                request.setAttribute("error", "Email are incorrect");
                request.getRequestDispatcher("").forward(request, response);
            } else {
                Email email = new Email();
                email.setFrom("aduc00005@gmail.com");
                email.setFromPassword("khongnoi123");
                email.setTo(emailName);
                email.setSubject("Forgot Password");
                String message = "<!DOCTYPE html>\n"
                        + "<html lang=\"en\">\n"
                        + "\n"
                        + "<head>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <h3 style=\"color: blue;\">Mật khẩu của bạn là:.</h3>\n"
                        + "    <div> Mật khẩu của bạn:" + password + "</div>\n"
                        + "    <div>Người gửi :Admin</div>\n"
                        + "    <div>số điện thoại : 0899999999</div>\n"
                        + "    <div>địa chỉ : Hoa Lac, Ha Noi</div>\n"
                        + "    <h3 style=\"color: blue;\">Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi!</h3>\n"
                        + "\n"
                        + "</body>\n"
                        + "\n"
                        + "</html>";
                email.setContent(message);
                EmailUtils.send(email);
                request.getRequestDispatcher("../view/notification/notification.jsp").forward(request, response);

            }
        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("error", e.getMessage());
        }

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
