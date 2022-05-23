/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Image;

/**
 *
 * @author ADMIN
 */
public class CourseDBContext extends DBContext {

    public ArrayList<Course> getCourses() {
        TopicDBContext tdb = new TopicDBContext();
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "SELECT [course_id]\n"
                    + "      ,[course_title]\n"
                    + "      ,[topic_id]\n"
                    + "      ,[status]\n"
                    + "      ,[description]\n"
                    + "      ,[rate]\n"
                    + "      ,[img]\n"
                    + "  FROM [dbo].[Course]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setCourseTitle(rs.getString("course_title"));
                course.setTopic(tdb.getTopic(rs.getInt("topic_id")));
                course.setStatus(rs.getBoolean("status"));
                course.setDescription(rs.getString("description"));
                course.setRate(rs.getFloat("rate"));
                course.setImage(rs.getBlob("img"));
                courses.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }
}
