/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblPromotion;

/**
 *
 * @author DELL
 */
public class PromotionErrorDTO {
    int rankError;

    public PromotionErrorDTO(int rankError) {
        this.rankError = rankError;
    }

    public PromotionErrorDTO() {
    }

    public int getRankError() {
        return rankError;
    }

    public void setRankError(int rankError) {
        this.rankError = rankError;
    }
    
}
