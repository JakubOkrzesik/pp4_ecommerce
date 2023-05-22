package pl.jakubokrzesik.sales;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart {
    
    private HashMap<ProductDetails, AtomicInteger> cart;

    public Cart(){
        this.cart = new HashMap<ProductDetails, AtomicInteger>();
    }

    public static Cart empty() {
        return new Cart();
    }

    public void add(ProductDetails product) {
        for(ProductDetails key: cart.keySet()){
            if(key==product){
                cart.get(key).incrementAndGet();
            }
        }
        cart.put(product, new AtomicInteger(1));
    }
    
    public void delete(ProductDetails product){
        cart.remove(product);
    }

    
}
