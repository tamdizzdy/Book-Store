/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tblUsers;

/**
 *
 * @author DELL
 */
public class UsersErrorDTO {
    String userIDError;
    String passwordError;
    String confirmPassword;
    String nameError;
    String addressError;
    String rankError;
    String imageError;

    public UsersErrorDTO() {
    }

    public UsersErrorDTO(String userIDError, String passwordError, String confirmPassword, String nameError, String addressError, String rankError, String imageError) {
        this.userIDError = userIDError;
        this.passwordError = passwordError;
        this.confirmPassword = confirmPassword;
        this.nameError = nameError;
        this.addressError = addressError;
        this.rankError = rankError;
        this.imageError = imageError;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }



    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }



    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getRankError() {
        return rankError;
    }

    public void setRankError(String statusError) {
        this.rankError = rankError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }
    
}
