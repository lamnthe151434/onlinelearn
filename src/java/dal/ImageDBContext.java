/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Image;

/**
 *
 * @author Admin
 */
public class ImageDBContext extends DBContext {

    public void addImg(InputStream is, String username) {
        String sql = "UPDATE [User]\n"
                + "   SET [img] = ?\n"
                + " WHERE [username] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setBlob(1, is);
            stm.setNString(2, username);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImageDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImageDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImageDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void addImage(InputStream is, String entity) {
        String sql = "UPDATE " + entity + "\n"
                + "   SET [img] = ?\n"
                + " WHERE [topic_id] = 1";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setBlob(1, is);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ImageDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImageDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImageDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Image getImage(String username) {
        try {
            String sql = "select username, img from [User] where username= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Image s = new Image();
                s.setUsername(rs.getString("username"));
                s.setImg(rs.getBlob("img"));
                return s;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImageDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
