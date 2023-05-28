package pl.jakubokrzesik.sales;
import java.util.HashMap;

public class ProductDetailsProvider {

    public HashMap<String, ProductDetails> detailsProvider = new HashMap<>();

    public ProductDetailsProvider(ProductDetails... product){
        for(ProductDetails pr:product){
            String size = Integer.toString(this.detailsProvider.size() + 1);
            this.detailsProvider.put(size, pr);
        }
    }

    public ProductDetails getProduct(String productID){
        return detailsProvider.get(productID);
    }

    public HashMap<String, ProductDetails> getDetailsProvider() {
        return detailsProvider;
    }

}
