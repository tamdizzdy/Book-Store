/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblPromotion;

import utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author DELL
 */
public class PromotionDAO {

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

    public boolean insertList(PromotionDTO dto) throws SQLException, NamingException {
        boolean check = false;
        try {
            
            conn = DBUtils.getConnection();
            String sql1 = "Update tblPromotion set rank = ?, dateAdd = getdate() Where userID = ?";
            stm = conn.prepareStatement(sql1);
            stm.setString(2, dto.getUserID());
            stm.setInt(1, dto.getRank());
            check = stm.executeUpdate() > 0 ;
            if(!check) {
            String sql = "INSERT INTO tblPromotion(userID, nameuser, rank) VALUES(?,?,?) ";
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getUserID());
            stm.setString(2, dto.getNameUser());
            stm.setInt(3, dto.getRank());
            return stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    
    public List<PromotionDTO> viewList(Date dateAdd) throws NamingException, SQLException{
        List<PromotionDTO> list = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT promotionID, userID, nameuser, rank, dateAdd FROM tblPromotion WHERE dateAdd = ? ORDER BY promotionID DESC";
            stm = conn.prepareStatement(sql);
            stm.setDate(1, dateAdd);
            rs = stm.executeQuery();
            while(rs.next()){
                if(list == null){
                    list = new ArrayList<>();
                }
                int promotionID = rs.getInt(1);
                String userID = rs.getString(2);
                String nameuser = rs.getString(3);
                int rank = rs.getInt(4);
//                dateAdd = rs.getDate(5);
                PromotionDTO dto = new PromotionDTO(promotionID, userID, nameuser, rank, dateAdd);
                list.add(dto);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return list;
    }
    
}
