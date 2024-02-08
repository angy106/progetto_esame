package it.unimol.mc.app;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProductTest {

    @Test
    public void testGetPrice() {
        // Verifico se il metodo getPrice restituisce correttamente il prezzo del prodotto
        Product product = new Product("Hamburger", 6.99, "Juicy beef patty on a bun", "Burger");
        assertEquals(6.99, product.getPrice(), 0.01); // Confronta il prezzo con una tolleranza di 0.01
    }

    @Test
    public void testGetName() {
        // Verifico se il metodo getName restituisce correttamente il nome del prodotto
        Product product = new Product("Hamburger", 6.99, "Juicy beef patty on a bun", "Burger");
        assertEquals("Hamburger", product.getName());
    }

    @Test
    public void testGetDescription() {
        // Verifico se il metodo getDescription restituisce correttamente la descrizione del prodotto
        Product product = new Product("Hamburger", 6.99, "Juicy beef patty on a bun", "Burger");
        assertEquals("Juicy beef patty on a bun", product.getDescription());
    }

    @Test
    public void testGetType() {
        // Verifico se il metodo getType restituisce correttamente il tipo del prodotto
        Product product = new Product("Hamburger", 6.99, "Juicy beef patty on a bun", "Burger");
        assertEquals("Burger", product.getType());
    }
}
