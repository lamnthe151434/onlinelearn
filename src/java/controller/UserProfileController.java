/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ImageDBContext;
import dal.UserDBContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Image;
import model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "UserProfileController", urlPatterns = {"/authen/user/profile"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 50)
public class UserProfileController extends HttpServlet {

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
        UserDBContext uc = new UserDBContext();
        ImageDBContext ic = new ImageDBContext();

        User user = (User) request.getSession().getAttribute("user");
        user = uc.getUser(user.getUsername(), user.getPassword());
        
        request.setAttribute("user", user);
        request.getRequestDispatcher("../../view/dynamic/user/profile.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");

        String Username = request.getParameter("username");
        String Name = request.getParameter("name");
        String Rawdob = request.getParameter("dob");
        String Phone = request.getParameter("phone");
        String RawGender = request.getParameter("gender");
        String Address = request.getParameter("address");
        String Description = request.getParameter("description");
        User u = new User();
        Date dob = null;
        System.out.println("(" + Rawdob + ")");
        if(Rawdob != null && !Rawdob.equals("")) {
            dob = Date.valueOf(Rawdob);
        } 
        u.setDob(dob);
        if (RawGender != null) {
            boolean Gender = RawGender.equals("male");
            u.setGender(Gender);
        }
        u.setUsername(Username);
        u.setAddress(Address);
        u.setDescription(Description);
        u.setName(Name);
        u.setPhone(Phone);
        UserDBContext uc = new UserDBContext();
        uc.UpdateUser(u);

        ImageDBContext ic = new ImageDBContext();
        Part part = request.getPart("img");
        if (part.getSize() > 0) {
            InputStream is = part.getInputStream();
            ic.addImg(is, u.getUsername());
            //ic.addImg(is,"admin");
        }
        // response.getWriter().println("done");        
        response.sendRedirect("../../view/notification/notification.jsp");
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
