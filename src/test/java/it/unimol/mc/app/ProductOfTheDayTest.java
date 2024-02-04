package it.unimol.mc.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductOfTheDayTest {

    @Test
    public void testGenerateSpecialProduct() {
        ProductOfTheDay productOfTheDay = new ProductOfTheDay();
        Product specialProduct = productOfTheDay.getSpecialProduct();

        assertNotNull(specialProduct);
        assertTrue(specialProduct.getPrice() >= 1 && specialProduct.getPrice() <= 10);
        String priceString = String.valueOf(specialProduct.getPrice());
        int decimalIndex = priceString.indexOf('.');
        int decimalPlaces = priceString.length() - decimalIndex - 1;
        assertEquals(2, decimalPlaces);

        String[] specialNames = {"Special Burger", "Deluxe Fries", "Premium Drink", "Gourmet Salad", "Fancy Dessert"};
        boolean nameFound = false;
        for (String name : specialNames) {
            if (specialProduct.getName().equals(name)) {
                nameFound = true;
                break;
            }
        }
        assertTrue(nameFound);

        assertEquals("Prodotto del giorno", specialProduct.getDescription());
        assertEquals("Special", specialProduct.getType());
    }
}
