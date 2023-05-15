package pl.jakubokrzesik.sales;

import org.junit.jupiter.api.Test;

public class CollectingProductsTest {
    CartStorage cartStorage;
    ProductDetailsProvider productDetailsProvider;

    @Test
    void itAllowsToAddProductToCart(){
        Sales sales = thereIsSalesModule();
        String customerId = thereIsCustomer("Jakub");
        String productId = thereIsProduct();

        sales.addToCart(customerId,productId);

        assertCustomerCartContainsNProducts(customerId, 1);
    }

    private void assertCustomerCartContainsNProducts(String customerId, int productCount) {
        Cart customerCart = cartStorage.lo
    }

    private String thereIsProduct() {
    }

    private String thereIsCustomer(String jakub) {
    }

    private Sales thereIsSalesModule() {
        return new
    }
}
