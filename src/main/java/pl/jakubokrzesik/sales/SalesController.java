package pl.jakubokrzesik.sales;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SalesController {

    Sales sales;

    public SalesController(Sales sales) {
        this.sales = sales;
    }
    /* 
    @GetMapping("api/offer")
    public Offer getCurrentOffer(){
        return sales.getCurrentOffer(getCurrentCustomer());
    }
    */

    @PostMapping("/api/add-to-cart/{productId}")
    public void addToCart(@PathVariable String productId){
        sales.addToCart(getCurrentCustomer(), productId);
    }

    @PostMapping("/api/get_current_products")
    public List<ProductDetails> getProducts(){
        return sales.getProductDetailsProvider().getDetailsProvider();
    }

    private String getCurrentCustomer() {
        return null;
    }
}