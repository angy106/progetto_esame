package it.unimol.mc.app;

public class ProductOfTheDay {
    private Product specialProduct;
    private String specialName = "Special Burger";
    private double specialPrice = 5.50;

    public ProductOfTheDay() {
        this.generateSpecialProduct();
    }

    // Generate the special menu of the day with random attributes
    public void generateSpecialProduct() {

        // Descrizione e tipo predefiniti per il prodotto speciale
        String description = "Prodotto del giorno";
        String type = "Special";

        // Crea e restituisce il prodotto speciale
        this.specialProduct = new Product(specialName, specialPrice, description, type);
    }

    public Product getSpecialProduct() {
        return this.specialProduct;
    }

}
