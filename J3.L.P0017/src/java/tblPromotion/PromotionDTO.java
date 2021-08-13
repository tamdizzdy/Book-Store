/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblPromotion;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class PromotionDTO {
    int promotionID;
    String userID;
    String nameUser;
    int rank;
    Date dateAdd; 

    public PromotionDTO() {
    }

    public PromotionDTO(int promotionID, String userID, String nameUser, int rank, Date dateAdd) {
        this.promotionID = promotionID;
        this.userID = userID;
        this.nameUser = nameUser;
        this.rank = rank;
        this.dateAdd = dateAdd;
    }

    public PromotionDTO(String userID, String nameUser, int rank, Date dateAdd) {
        this.userID = userID;
        this.nameUser = nameUser;
        this.rank = rank;
        this.dateAdd = dateAdd;
    }

    public PromotionDTO(String userID, String nameUser, int rank) {
        this.userID = userID;
        this.nameUser = nameUser;
        this.rank = rank;
    }
    
    public PromotionDTO(int promotionID, int rank) {
        this.promotionID = promotionID;
        this.rank = rank;
    }
    
    public PromotionDTO(String userID, int rank) {
        this.userID = userID;
        this.rank = rank;
    }
    
    public PromotionDTO(String userID, String nameUser) {
        this.userID = userID;
        this.nameUser = nameUser;
    }

    public int getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(int promotionID) {
        this.promotionID = promotionID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public String toString() {
        return "PromotionDTO{" + "promotionID=" + promotionID + ", userID=" + userID + ", nameUser=" + nameUser + ", rank=" + rank + ", dateAdd=" + dateAdd + '}';
    }
    
}
