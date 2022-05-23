/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CourseDBContext;
import dal.TopicDBContext;
import dal.UserDBContext;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Course;
import model.Topic;
import model.User;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

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
        response.setContentType("image/gif");
        request.setCharacterEncoding("utf-8");
        String url = "";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        UserDBContext udb = new UserDBContext();
        if (user == null) {
            TopicDBContext tdb = new TopicDBContext();
            CourseDBContext cdb = new CourseDBContext();
            Blob image = null;
//            OutputStream os = response.getOutputStream();
//            byte byteArray[];
            ArrayList<Topic> topics = tdb.getTopics();
            ArrayList<Course> courses = cdb.getCourses();
            
            request.setAttribute("topics", topics);
            request.setAttribute("courses", courses);
            request.setAttribute("image", image);
//            request.setAttribute("os", os);
//            request.setAttribute("byteArray", byteArray);
            url = "view/dynamic/guest/home.jsp";
        } else {
            String userGroup = udb.getUserGroup(user);
            System.out.println("(" + userGroup + ")");
            if (userGroup.equals("Học viên")) {
                url = "view/dynamic/learner/home.jsp";
            }
            if (userGroup.equals("Giảng viên")) {
                url = "view/dynamic/expert/home.jsp";
            }
            if (userGroup.equals("Admin")) {
                url = "view/dynamic/admin/dashboard.jsp";
            }
            session.setAttribute("user", user);
            session.setAttribute("userGroup", userGroup);
        }
        request.getRequestDispatcher(url).forward(request, response);

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
