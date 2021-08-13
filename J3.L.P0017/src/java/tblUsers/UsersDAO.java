/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author DELL
 */
public class UsersDAO {

    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public UsersDTO checkLogin(String userID, String password) throws NamingException, SQLException {
        UsersDTO user = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT userID, password, name, address, status, roleID FROM tblUsers WHERE userID = ? AND password = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, userID);
            stm.setString(2, password);
            rs = stm.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                String status = rs.getString("status");
                int roleID = rs.getInt("roleID");
                user = new UsersDTO(userID, password, name, address, status, roleID);
            }
        } finally {
            closeConnection();
        }
        return user;
    }

    public List<UsersDTO> searchAll(String name) throws NamingException, SQLException {
        List<UsersDTO> list = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT userID, password, name, address, status, roleID, image FROM tblUsers WHERE name LIKE ? AND status = 'active'";
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + name + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                String userID = rs.getString(1);
                String password = rs.getString(2);
                String name1 = rs.getString(3);
                String address = rs.getString(4);
                String status = rs.getString(5);
                int roleID = rs.getInt(6);
                String image = rs.getString(7);
                list.add(new UsersDTO(userID, password, name1, address, status, image, roleID));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public UsersDTO searchUserByID(String userID) throws NamingException, SQLException {
        UsersDTO user = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT userID, password, name, address, status, image FROM tblUsers WHERE userID = ? AND status = 'active'";
            stm = conn.prepareStatement(sql);
            stm.setString(1, userID);
            rs = stm.executeQuery();
            while (rs.next()) {
                String userID1 = rs.getString(1);
                String password = rs.getString(2);
                String name = rs.getString(3);
                String address = rs.getString(4);
                String status = rs.getString(5);
                String image = rs.getString(6);
                user = new UsersDTO(userID1, password, name, address, status, image);
            }
        } finally {
            closeConnection();
        }
        return user;
    }

    public boolean deleteUser(String userID) throws SQLException, NamingException {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            String sql = "UPDATE tblUsers SET status = 'notActive' WHERE userID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, userID);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateUser(UsersDTO user) throws SQLException, NamingException {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            String sql = "UPDATE tblUsers SET image =?, name = ?, address = ? WHERE userID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, user.getImage());
            stm.setString(2, user.getName());
            stm.setString(3, user.getAddress());
            stm.setString(4, user.getUserID());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean createUser(UsersDTO dto) throws NamingException, SQLException {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            String sql = "INSERT INTO tblUsers(userID, password, name, address, image)VALUES(?,?,?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getUserID());
            stm.setString(2, dto.getPassword());
            stm.setString(3, dto.getName());
            stm.setString(4, dto.getAddress());
            stm.setString(5, dto.getImage());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

}
