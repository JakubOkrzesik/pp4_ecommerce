package pl.jakubokrzesik.sales;
import java.util.UUID;

public class ProductDetails {
    private String productID;
    private String name;
    private double price;

    public ProductDetails(String name, double price){
        this.productID = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}