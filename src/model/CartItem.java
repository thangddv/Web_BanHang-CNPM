package model;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product) {
        this.product = product;
        quantity = 1;
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
    public void incrementQuantity() {
        quantity++;
    }
    public void decrementQuantity() {
        quantity--;
    }
    public double getTotal() {
        double amount = 0;
        amount = (this.getQuantity() * product.getPrice());
        return amount;
    }
}
