package pl.jakubokrzesik.productcatalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ProductCatalog {
    HashMapProductStorage productStorage;

    public ProductCatalog(HashMapProductStorage productStorage) {
        this.products = productStorage;
    }

    public void changePrice(String productId, BigDecimal newPrice){
        Product loaded = this.loadById(productId);
        loaded.changePrice(newPrice);
    }

    public void assignImage

    public void publish(String productId){
        Product loaded = this.loadById(productId);

        if (loaded.getPrice()==null){
            throw new ProductCantBePublishedException();
        }
        if (loaded.getImageKey()==null){
            throw new ProductCantBePublishedException();
        }

        loaded.setOnline();
    }
}
