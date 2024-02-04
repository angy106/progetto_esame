package it.unimol.mc.app;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductOfTheDay {
    private Product specialProduct;
    private List<String> specialNames = Arrays.asList("Special Burger", "Deluxe Fries", "Premium Drink", "Gourmet Salad", "Fancy Dessert");


    public ProductOfTheDay() {
        this.generateSpecialProduct();
    }

    // Generate the special menu of the day with random attributes
    public void generateSpecialProduct() {
        // Genera un indice casuale per selezionare un nome dalla lista specialNames
        Random rand = new Random();
        int randomIndex = rand.nextInt(specialNames.size());
        String randomName = specialNames.get(randomIndex);

        double discountedPrice = 1 + rand.nextDouble() * 9; // Range tra 1 e 10
        discountedPrice = Math.round(discountedPrice * 100.0) / 100.0; // Arrotonda a due cifre decimali

        // Descrizione e tipo predefiniti per il prodotto speciale
        String description = "Prodotto del giorno";
        String type = "Special";

        // Crea e restituisce il prodotto speciale
        this.specialProduct = new Product(randomName, discountedPrice, description, type);
    }

    public Product getSpecialProduct(){
        return this.specialProduct;
    }

}
