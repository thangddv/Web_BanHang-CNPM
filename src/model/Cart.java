package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    private int numberOfItems;
    private float total;

    public Cart() {
        items = new ArrayList<CartItem>();
        numberOfItems = 0;
        total = 0;
    }

    public synchronized void addItem(Product product) {
        boolean newItem = true;
        for (CartItem scItem : items) {
            if (scItem.getProduct().getProductId() == product.getProductId()) {
                newItem = false;
                scItem.incrementQuantity();
            }
        }
        if (newItem) {
            CartItem scItem = new CartItem(product);
            items.add(scItem);
        }
    }

    public synchronized void update(Product product, String quantity) {
        short qty = -1;
        // cast quantity as short
        qty = Short.parseShort(quantity);
        if (qty >= 0) {
            CartItem item = null;
            for (CartItem scItem : items) {
                if (scItem.getProduct().getProductId() ==
                        product.getProductId()) {
                    if (qty != 0) {
                        // set item quantity to new value
                        scItem.setQuantity(qty);
                    } else {
                        // if quantity equals 0, save item and break
                        item = scItem;
                        break;
                    }
                }
            }
            if (item != null) {
                // remove from cart
                items.remove(item);
            }
        }
    }

    public synchronized List<CartItem> getItems() {
        return items;
    }

    public synchronized void setItems(List<CartItem> items) {
        this.items = items;
    }

    public synchronized int getNumberOfItems() {
        numberOfItems = 0;
        for (CartItem scItem : items) {
            numberOfItems += scItem.getQuantity();
        }
        return numberOfItems;
    }

    public synchronized float getSubtotal() {
        float amount = 0;
        for (CartItem scItem : items) {
            Product product = (Product) scItem.getProduct();
            amount += (scItem.getQuantity() *
                    product.getPrice());
        }
        return amount;
    }

    public synchronized void calculateTotal(String surcharge) {
        float amount = 0;
        // cast surcharge as double
        float s = (float) Double.parseDouble(surcharge);
        amount = this.getSubtotal();
        amount += s;
        total = amount;
    }

    public synchronized float setTotal() {
        float amount = 0;
        // cast surcharge as double
        for (int i = 0; i < this.items.size(); i++) {
            CartItem item = items.get(i);
            amount += item.getQuantity() * item.getProduct().getPrice();
        }
        this.total = amount;
        return amount;
    }

    public synchronized float getTotal() {
        return total;
    }

    public synchronized void clear() {
        items.clear();
        numberOfItems = 0;
        total = 0;
    }
}
