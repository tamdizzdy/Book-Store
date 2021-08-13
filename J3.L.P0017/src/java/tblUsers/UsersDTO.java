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
public class UsersDTO {
    String userID;
    String password;
    String name;
    String address;
    String status;
    String image;
    int roleID;
    
    public UsersDTO() {
    }

    public UsersDTO(String userID, String password, String name, String address, String status) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.address = address;
        this.status = status;
    }
    
    public UsersDTO(String userID, String password, String name, String address, String status, String image) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.address = address;
        this.status = status;
        this.image = image;
    }

    public UsersDTO(String userID, String password, String name, int roleID) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.roleID = roleID;
    }

    public UsersDTO(String userID, String image, String name, String address) {
        this.userID = userID;
        this.image = image;
        this.name = name;
        this.address = address;
    }

    public UsersDTO(String userID, String password, String name, String address,  int roleID) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.address = address;
        this.roleID = roleID;
    }

    public UsersDTO(String userID, String password, String name, String address, String status, int roleID) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.address = address;
        this.status = status;
        this.roleID = roleID;
    }

    public UsersDTO(String userID, String password, String name, String address, String status, String image, int roleID) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.address = address;
        this.status = status;
        this.image = image;
        this.roleID = roleID;
    }


    


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
    
}
