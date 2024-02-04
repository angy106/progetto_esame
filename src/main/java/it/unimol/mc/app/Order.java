package it.unimol.mc.app;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> orderedProducts;

    // Constructor
    public Order() {
        this.orderedProducts = new ArrayList<>();
    }

    // Adds a product to the order
    public void addProduct(Product product) {
        orderedProducts.add(product);
    }

    public List<Product> getOrderedProducts(){
        return this.orderedProducts;
    }

    // Calculates the total of the order
    public double calculateTotal() {
        double total = 0;
        for (Product product : orderedProducts) {
            total += product.getPrice();
        }
        return total;
    }
}
