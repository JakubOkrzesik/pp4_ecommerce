package pl.jakubokrzesik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.jakubokrzesik.productcatalog.HashMapProductStorage;
import pl.jakubokrzesik.productcatalog.ProductCatalog;
import pl.jakubokrzesik.sales.CartStorage;
import pl.jakubokrzesik.sales.ProductDetails;
import pl.jakubokrzesik.sales.ProductDetailsProvider;
import pl.jakubokrzesik.sales.Sales;

import java.math.BigDecimal;

@SpringBootApplication
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

    @Bean
    ProductCatalog createMyProductCatalog() {
        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());
        String product1 = productCatalog.addProduct("my nice ebook", "Nice one");
        productCatalog.changePrice(product1, BigDecimal.valueOf(10.10));
        productCatalog.assignImage(product1,"foo/nice/image.jpeg");
        productCatalog.publishProduct(product1);

        String product2 = productCatalog.addProduct("my nice ebook", "Nice one");
        productCatalog.changePrice(product2, BigDecimal.valueOf(10.10));
        productCatalog.assignImage(product2,"foo/nice/image.jpeg");
        productCatalog.publishProduct(product2);
        return productCatalog;
    }

    @Bean
    Sales Createsales(){
        return new Sales(new CartStorage(), new ProductDetailsProvider(new ProductDetails("Harry Potter", 35.78),new ProductDetails("Lord of the Rings", 45.00)));
    }
}
