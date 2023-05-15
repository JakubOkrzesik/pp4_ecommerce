package pl.jakubokrzesik.sales;

import java.util.ArrayList;

public class Cart {
    
    private ArrayList<ProductDetails> cart;

    public Cart(){
        this.cart = new ArrayList<ProductDetails>();
    }

    public static Cart empty() {
        return new Cart();
    }

    public void add(ProductDetails product) {
        cart.add(product);
    }

    public void delete(int num){
        cart.remove(num);
    }

}
