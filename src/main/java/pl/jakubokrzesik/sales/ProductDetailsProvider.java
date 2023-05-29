package pl.jakubokrzesik.sales;
import java.util.ArrayList;
import java.util.Collections;

public class ProductDetailsProvider {

    public ArrayList<ProductDetails> detailsProvider = new ArrayList<ProductDetails>();

    public ProductDetailsProvider(ProductDetails... products){
        Collections.addAll(this.detailsProvider, products);
    }

    public ProductDetails getProduct(String productID){
        return this.detailsProvider.get(Integer.parseInt(productID));
    }

    public ArrayList<ProductDetails> getDetailsProvider() {
        return detailsProvider;
    }

}
