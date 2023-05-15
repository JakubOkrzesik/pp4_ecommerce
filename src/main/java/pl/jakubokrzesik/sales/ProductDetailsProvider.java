package pl.jakubokrzesik.sales;
import java.util.HashMap;

public class ProductDetailsProvider {

    public HashMap<String, ProductDetails> detailsProvider;

    public ProductDetailsProvider(HashMap<String, ProductDetails> provider){
        this.detailsProvider = provider;
    }

    public ProductDetails getProduct(String productID){
        return detailsProvider.get(productID);
    }
}
