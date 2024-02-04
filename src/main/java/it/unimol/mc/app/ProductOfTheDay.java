package it.unimol.mc.app;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductOfTheDay {
    private Product specialProduct;
    private List<String> specialNames = Arrays.asList("Special Burger", "Deluxe Fries", "Premium Drink", "Gourmet Salad", "Fancy Dessert");
    private Random rand;
    private double val;

    public ProductOfTheDay() {
        this.rand = new Random();
        this.val = rand.nextDouble();
        this.generateSpecialProduct();
    }

    // Generate the special menu of the day with random attributes
    public void generateSpecialProduct() {
        int randomIndex = (int)val;
        String randomName = specialNames.get(randomIndex);

        double discountedPrice = 1 + this.val * 9; // Range tra 1 e 10
        discountedPrice = Math.round(discountedPrice * 100.0) / 100.0; // Arrotonda a due cifre decimali

        // Descrizione e tipo predefiniti per il prodotto speciale
        String description = "Prodotto del giorno";
        String type = "Special";

        // Crea e restituisce il prodotto speciale
        this.specialProduct = new Product(randomName, discountedPrice, description, type);
    }

    public Product getSpecialProduct() {
        return this.specialProduct;
    }

}
