package pl.jakubokrzesik.productcatalog;

import java.util.Collections;
import java.util.HashMap;

public class HashMapProductStorage implements ProductStorage {
    private Map<String, Product> products;

    public HashMapProductStorage(){

        this.products = new HashMap<>();
    }

    @Override
    public List<Product> allProducts(){
        return products.values()
                .stream
                .collect(Collections.toList());
    }

    @Override
    public String addProduct(String name, String desc) {
        Product newOne = new Product (
                UUID.randomUUID(),
                name,
                desc,
                image,
                isPublished,
                price,
                color,
                x,
                y
        );
        this.products.add(newOne);
        return newOne.getId();
    }


}
