package it.unimol.mc.app;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Product> menu;

    // Constructor
    public Menu() {
        this.menu = new ArrayList<>();
        this.initializeProducts();
    }

    // Method to initialize products
    private void initializeProducts() {
        menu.add(new Product("Hamburger", 6.99, "Juicy beef patty on a bun", "Burger"));
        menu.add(new Product("French Fries", 1.99, "Crispy golden fries", "Side"));
        menu.add(new Product("Cheeseburger", 3.49, "Delicious beef patty with melted cheese", "Burger"));
        menu.add(new Product("Chicken Nuggets", 4.99, "Crispy chicken bites served with dipping sauce", "Appetizer"));
        menu.add(new Product("Salad", 5.99, "Fresh mixed greens with tomatoes, cucumbers, and choice of dressing", "Salad"));
        menu.add(new Product("Soft Drink", 1.49, "Refreshing carbonated beverage", "Beverage"));
        menu.add(new Product("Ice Cream Sundae", 3.99, "Vanilla ice cream with chocolate syrup and whipped cream", "Dessert"));
    }

    public List<Product> getMenu(){
        return this.menu;
    }
}
