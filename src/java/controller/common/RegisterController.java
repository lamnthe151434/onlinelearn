package controller.common;

import dal.UserDBContext;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
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
        request.getRequestDispatcher("view/dynamic/access/register.jsp").forward(request, response);
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
        String raw_username = request.getParameter("username");
        String raw_password = request.getParameter("password");
        String raw_name = request.getParameter("name");
        String raw_email = request.getParameter("email");

        String username = raw_username;
        String password = raw_password;
        String name = raw_name;
        String email = raw_email;

        //check username is existed or not
        if (isExistUsername(username)) {
            int errorCode = 1;
            request.setAttribute("error", errorCode);
            request.getRequestDispatcher("view/dynamic/access/register.jsp").forward(request, response);
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);

        System.out.println(name);
        UserDBContext userDB = new UserDBContext();
        userDB.insertUser(user);
        userDB.insertUserGroup(user, 4);

        response.sendRedirect("http://localhost:8080/onlinelearn/login");
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

    private boolean isExistUsername(String username) {
        UserDBContext userDB = new UserDBContext();
        return userDB.getUserByUsername(username) != null;
    }

}
