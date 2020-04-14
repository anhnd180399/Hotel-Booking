/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duyanh.products;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author duyan
 */
public class CartDTO implements Serializable{
    private Map<Integer, JewelryDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<Integer, JewelryDTO> cart) {
        this.cart = cart;
    }

    public Map<Integer, JewelryDTO> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, JewelryDTO> cart) {
        this.cart = cart;
    }
    public void addToCart (JewelryDTO dto){
        if(this.cart == null){
            this.cart = new HashMap<>();
        }
        if(this.cart.containsKey(dto.getProductID())){
            int quantity = this.cart.get(dto.getProductID()).getProductQuantity();
            dto.setProductQuantity(quantity +1);
        }
        this.cart.put(dto.getProductID(), dto);
    }
    public void deleteCart(int id){
        if(this.cart == null) return;
        if(this.cart.containsKey(id)){
            this.cart.remove(id);
        }
    }
//    public void updateCart(JewelryDTO dto ){
//        if(this.cart == null){
//            return;
//        }
//        if(this.cart.containsKey(dto.getProductID())){
//            this.cart.replace(dto.getProductID(), dto);
//        }
//    }
}
