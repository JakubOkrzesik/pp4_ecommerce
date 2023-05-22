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
        Cart customerCart = loadForCustomer(customerId)
                .orElse(Cart.empty());

        ProductDetails product = loadDetailsForProduct(productId);

        customerCart.add(product);
    }

    private ProductDetails loadDetailsForProduct(String productId) {
        return productDetailsProvider.getProduct(productId);
    }

    private Optional<Cart> loadForCustomer(String customerId){
        return CartStorage.load(customerId);
    }
}
