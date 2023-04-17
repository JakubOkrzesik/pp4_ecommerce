package pl.jakubokrzesik.productcatalog;

public interface ProductStorage {
    List<Product> allProducts();

    String addProduct(String name, String desc);
}
