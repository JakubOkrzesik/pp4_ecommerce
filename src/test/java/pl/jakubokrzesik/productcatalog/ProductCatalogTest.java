package pl.jakubokrzesik.productcatalog;

import org.junit.jupiter.api.Test;

public class ProductCatalogTest {
    @Test
    void itExposeEmptyProductList{

    }

    @Test
    void itAllowsToChangePrice{
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.addProduct("lego 1245", );

        catalog.assignImage(productId, "nicepicture.jpeg");
        Product loaded = catalog.loadById(productId);
        assertEquals()

    }
}
