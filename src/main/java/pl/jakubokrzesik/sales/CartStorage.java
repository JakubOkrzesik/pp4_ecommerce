package pl.jakubokrzesik.sales;

import java.util.HashMap;
import java.util.Optional;

public class CartStorage {
    static HashMap<String, Optional<Cart>> storage = new HashMap<String, Optional<Cart>>();

    public static Optional<Cart> load(String customerId) {
        Optional<Cart> cart = storage.get(customerId);
        
        return cart;
    }

    public void save(String customerId, Optional<Cart> cart) {
        storage.put(customerId, cart);
    }
}
