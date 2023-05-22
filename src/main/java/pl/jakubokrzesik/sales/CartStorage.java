package pl.jakubokrzesik.sales;

import java.util.HashMap;
import java.util.Optional;

public class CartStorage {
    HashMap<String, Cart> customerCart;

    public CartStorage() {
        this.customerCart = new HashMap<>();
    }

    public Optional<Cart> load(String customerId) {
        return Optional.ofNullable(customerCart.get(customerId));
    }

    public void save(String customerId, Cart cart) {
        customerCart.put(customerId, cart);
    }
}
