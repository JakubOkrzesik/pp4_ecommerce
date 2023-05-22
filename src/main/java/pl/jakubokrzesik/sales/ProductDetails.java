package pl.jakubokrzesik.sales;

public class ProductDetails {
    private String productID;
    private String name;
    private float price;

    public ProductDetails(String productID, String name, float price){
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
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

}