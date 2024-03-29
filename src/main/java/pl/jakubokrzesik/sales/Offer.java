package pl.jakubokrzesik.sales;

import java.math.BigDecimal;

public class Offer {
    BigDecimal total;
    Integer itemsCount;

    public BigDecimal getTotal() {
        return total;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public Offer() {
        this.total = BigDecimal.ZERO;
        this.itemsCount = 0;
    }
}
