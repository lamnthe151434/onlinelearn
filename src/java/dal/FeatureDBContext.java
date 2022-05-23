/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class FeatureDBContext extends DBContext {

    public boolean checkContextPath(String contextPath, String username) {

        try {
            String sql = "select a.url from Feature a \n"
                    + "join Group_Feature b on a.feature_id = b.feature_id\n"
                    + "join [Group] c on b.group_id = c.group_id\n"
                    + "join User_Group d on c.group_id = d.group_id\n"
                    + "join [User] e on d.username = e.username\n"
                    + "where e.username = ? and url = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, contextPath);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeatureDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
