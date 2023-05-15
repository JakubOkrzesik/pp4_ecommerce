package pl.jakubokrzesik.sales;

import java.util.Optional;

public class Sales {
    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;

    public Sales(CartStorage cartStorage, ProductDetailsProvider productDetailsProvider){
        this.cartStorage = cartStorage;
        this.productDetailsProvider = productDetailsProvider;
    }


    public void addToCart(String productId, String customerId){
        Cart cart = loadForCustomer(customerId)
                .orElse(Cart.empty());

        Product product = loadDetailsForProduct(productId)
                .orElseThrow(() -> new NoSuchProductException());

        cart.add(product);
        cartStorage.save(customerId,cart);
    }

    private Product loadDetailsForProduct(String productId) {
        return ProductDetailsProvider
    }

    private Optional<Cart> loadForCustomer(String customerId){
        return CartStorage.load(customerId);
    }
}
