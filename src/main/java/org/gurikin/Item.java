package org.gurikin;

import java.math.BigDecimal;

public class Item {
    private int itemId;
    private BigDecimal price;
    private String description;

    public Item (int itemId, BigDecimal price, String description) {
        this.itemId = itemId;
        this.setPrice(price);
        this.setDescription(description);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("ItemId:\t%d,%nPrice:\t%4.2f,%nDescription:\t%s%n", itemId, price.doubleValue(), description);
    }
}
