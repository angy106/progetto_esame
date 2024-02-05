package it.unimol.mc.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductOfTheDayTest {

    @Test
    public void testGenerateSpecialProduct() {
        ProductOfTheDay productOfTheDay = new ProductOfTheDay();
        Product specialProduct = productOfTheDay.getSpecialProduct();

        assertNotNull(specialProduct);
        assertEquals("Special Burger", specialProduct.getName());
        assertEquals(5.50, specialProduct.getPrice(), 0.001); // Verifica con tolleranza per double
        assertEquals("Prodotto del giorno", specialProduct.getDescription());
        assertEquals("Special", specialProduct.getType());
    }

}
