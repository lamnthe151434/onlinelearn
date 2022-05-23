/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Feedback;

/**
 *
 * @author ADMIN
 */
public class FeedbackDBContext extends DBContext {

    public ArrayList<Feedback> getFeedbacks() {
        UserDBContext udb = new UserDBContext();
        ArrayList<Feedback> feedbacks = new ArrayList<>();
        try {
            String sql = "SELECT [feedback_id]\n"
                    + "      ,[feedback_content]\n"
                    + "      ,[username]\n"
                    + "  FROM [dbo].[Feedback]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setFeedbackId(rs.getInt("feedback_id"));
                feedback.setFeedbackContent(rs.getString("feedback_content"));
                feedback.setUser(udb.getUser(rs.getString("username")));
                feedbacks.add(feedback);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return feedbacks;
    }
}
