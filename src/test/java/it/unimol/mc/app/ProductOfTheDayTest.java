package it.unimol.mc.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductOfTheDayTest {

    @Test
    public void testGenerateSpecialProduct() {
        // Verifico se il prodotto speciale è stato inizializzato correttamente
        ProductOfTheDay productOfTheDay = new ProductOfTheDay();
        Product specialProduct = productOfTheDay.getSpecialProduct();

        assertNotNull(specialProduct);
        assertEquals("Special Burger", specialProduct.getName());
        assertEquals(5.50, specialProduct.getPrice(), 0.001);
        assertEquals("Prodotto del giorno", specialProduct.getDescription());
        assertEquals("Special", specialProduct.getType());
    }

}
