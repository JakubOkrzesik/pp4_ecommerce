package pl.jakubokrzesik.sales;
import java.util.Optional;

public class Sales {
    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;

    public Sales(CartStorage cartStorage, ProductDetailsProvider productDetailsProvider) {
        this.cartStorage = cartStorage;
        this.productDetailsProvider = productDetailsProvider;
    }

    public void addToCart(String customerId, String productId) {
        Cart cart = loadForCustomer(customerId)
                .orElse(Cart.empty());

        ProductDetails product = loadDetailsForProduct(productId)
                .orElseThrow(() -> new NoSuchProductException());

        cart.add(product);
        cartStorage.save(customerId, cart);

    }

    private Optional<ProductDetails> loadDetailsForProduct(String productId){
        return Optional.ofNullable(productDetailsProvider.getProduct(productId));
    }

    private Optional<Cart> loadForCustomer(String customerId) {
        Optional<Cart> loaded = this.cartStorage.load(customerId);
        return loaded;
    }
    public Offer getCurrentOffer(String currentCustomer) {
        return new Offer();
    }

    public ProductDetailsProvider getProductDetailsProvider(){
        return this.productDetailsProvider;
    }
}
