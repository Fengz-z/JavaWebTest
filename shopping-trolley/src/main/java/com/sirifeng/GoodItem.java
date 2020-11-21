package com.sirifeng;

import java.io.Serializable;

public class  GoodItem implements Serializable {
    private Product product;
    private int quantity;

    public GoodItem(Product product) {
        this.product = product;
    }

    public GoodItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
