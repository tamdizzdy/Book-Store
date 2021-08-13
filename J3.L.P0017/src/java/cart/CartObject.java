/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import tblPromotion.PromotionDTO;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class CartObject {

    private Map<String, PromotionDTO> cart;

    public CartObject() {
    }

    public CartObject(Map<String, PromotionDTO> cart) {
        this.cart = cart;
    }

    public Map<String, PromotionDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, PromotionDTO> cart) {
        this.cart = cart;
    }

    public void add(PromotionDTO list) {
        if (this.cart == null) {
            cart = new HashMap<>();
        }
//        if(this.cart.containsKey(list.getUserID())){
//            this.cart.put(list.getUserID(), list);
//        }
        this.cart.put(list.getUserID(), list);
    }

    public void delete(String id) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
            if (cart.size() == 0) {
                cart = null;
            }
        }
    }

    public void update(String id, PromotionDTO list) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.replace(id, list);
        }
    }

    @Override
    public String toString() {
        return "CartObject{" + "cart=" + cart + '}';
    }
    
}
