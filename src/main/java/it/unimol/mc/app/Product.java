package it.unimol.mc.app;

public class Product {
    private String name;
    private double price;
    private String description;
    private String type;

    // Constructor
    public Product(String name, double price, String description, String type) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getType() {
        return this.type;
    }
}
