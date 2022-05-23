/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Image;
import model.User;

/**
 *
 * @author ADMIN
 */
public class UserDBContext extends DBContext {

    public User getUser(String username, String passwrod) {
        try {
            String sql = "SELECT [username]\n"
                    + "      ,[password]\n"
                    + "      ,[name]\n"
                    + "      ,[gender]\n"
                    + "      ,[dob]\n"
                    + "      ,[phone]\n"
                    + "      ,[email]\n"
                    + "      ,[address]\n"
                    + "      ,[description]\n"
                    + "      ,[status]\n"
                    + "      ,[img]\n"
                    + "  FROM [dbo].[User]\n"
                    + "  WHERE username = ? and [password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, passwrod);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getBoolean("gender"));
                user.setDob(rs.getDate("dob"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setDescription(rs.getString("description"));
                user.setStatus(rs.getBoolean("status"));
                user.setImg(rs.getBlob("img"));
                return user;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User getUser(String username) {
        try {
            String sql = "SELECT [username]\n"
                    + "      ,[password]\n"
                    + "      ,[name]\n"
                    + "      ,[gender]\n"
                    + "      ,[dob]\n"
                    + "      ,[phone]\n"
                    + "      ,[email]\n"
                    + "      ,[address]\n"
                    + "      ,[description]\n"
                    + "      ,[status]\n"
                    + "      ,[img]\n"
                    + "  FROM [dbo].[User]\n"
                    + "  WHERE username = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getBoolean("gender"));
                user.setDob(rs.getDate("dob"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setDescription(rs.getString("description"));
                user.setStatus(rs.getBoolean("status"));
                user.setImg(rs.getBlob("img"));
                return user;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User getUserByUsername(String username) {
        try {
            String sql = "SELECT [username]\n"
                    + "      ,[password]\n"
                    + "      ,[name]\n"
                    + "      ,[gender]\n"
                    + "      ,[dob]\n"
                    + "      ,[phone]\n"
                    + "      ,[email]\n"
                    + "      ,[address]\n"
                    + "      ,[description]\n"
                    + "  FROM [dbo].[User]\n"
                    + "  WHERE username = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void UpdateUser(User u) {
        try {
            String sql = "UPDATE [User]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[phone] = ?\n"
                    + "      ,[address] = ?\n"
                    + "      ,[description] = ?\n"
                    + " WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setBoolean(2, u.isGender());
            ps.setDate(3, u.getDob());
            ps.setString(4, u.getPhone());
            ps.setString(5, u.getAddress());
            ps.setString(6, u.getDescription());
            ps.setString(7, u.getUsername());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUserPasswordByEmail(String email) {
        String password = null;
        try {
            String sql = "SELECT \n"
                    + "      [password]\n"
                    + "  FROM [User]\n"
                    + "  WHERE email = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                password = rs.getString("password");

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return password;
    }

    public String getUserGroup(User u) {
//        System.out.println(u.getUsername());
        String userGroup = "";
        try {
            String sql = "select group_name as group_name from [group] g join user_group ug\n"
                    + "on g.group_id = ug.group_id join [user] u\n"
                    + "on u.username = ug.username \n"
                    + "where u.username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                userGroup = rs.getString("group_name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println(userGroup);
        return userGroup;
    }

    public User getUserByEmail(String email) {
        User user = new User();
        try {
            String sql = "SELECT  [username]\n"
                    + "      ,[password]\n"
                    + "      ,[name]\n"
                    + "      ,[gender]\n"
                    + "      ,[dob]\n"
                    + "      ,[phone]\n"
                    + "      ,[email]\n"
                    + "      ,[address]\n"
                    + "      ,[description]\n"
                    + "  FROM [User]\n"
                    + "  WHERE email = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setGender(rs.getBoolean("gender"));
                user.setDob(rs.getDate("dob"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(email);
                user.setAddress(rs.getString("address"));
                user.setDescription(rs.getString("description"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[name]\n"
                + "           ,[gender]\n"
                + "           ,[dob]\n"
                + "           ,[phone]\n"
                + "           ,[email]\n"
                + "           ,[address]\n"
                + "           ,[description]\n"
                + "           ,[status])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
            stm.setString(3, user.getName());
            stm.setBoolean(4, user.isGender());
            stm.setDate(5, user.getDob());
            stm.setString(6, user.getPhone());
            stm.setString(7, user.getEmail());
            stm.setString(8, user.getAddress());
            stm.setString(9, user.getDescription());
            stm.setBoolean(10, true);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
//        } finally {
//            if (stm != null) {
//                try {
//                    stm.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }

    public void insertUserGroup(User user, int groupId) {
        String sql = "INSERT INTO [dbo].[User_Group]\n"
                + "           ([username]\n"
                + "           ,[group_id])\n"
                + "     VALUES (?,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, user.getUsername());
            stm.setInt(2, groupId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void ChangePass(String Username, String Newpass) {
        try {
            String sql = "UPDATE [User]\n"
                    + "   SET [password] = ?\n"
                    + " WHERE [username] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setNString(1, Newpass);
            ps.setNString(2, Username);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
