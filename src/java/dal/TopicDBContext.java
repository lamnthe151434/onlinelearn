/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.sun.xml.ws.tx.at.v10.types.PrepareResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Image;
import model.Topic;

/**
 *
 * @author ADMIN
 */
public class TopicDBContext extends DBContext {

    public ArrayList<Topic> getTopics() {
        ArrayList<Topic> topics = new ArrayList<>();
        try {
            String sql = "SELECT [topic_id]\n"
                    + "      ,[topic_name]\n"
                    + "      ,[description]\n"
                    + "      ,[img]\n"
                    + "  FROM [dbo].[Topic]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Topic topic = new Topic();
                topic.setTopicId(rs.getInt("topic_id"));
                topic.setTopicName(rs.getString("topic_name"));
                topic.setDescription(rs.getString("description"));
                topic.setImage(rs.getBlob("img"));
                topics.add(topic);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return topics;
    }

    public Topic getTopic(int topicId) {
        try {
            String sql = "SELECT [topic_name]\n"
                    + "      ,[description]\n"
                    + "      ,[img]\n"
                    + "  FROM [dbo].[Topic] WHERE [topic_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, topicId);
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                Topic topic = new Topic();
                topic.setTopicName(rs.getString("topic_name"));
                topic.setDescription(rs.getString("description"));
                topic.setImage(rs.getBlob("img"));
                return topic;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TopicDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
