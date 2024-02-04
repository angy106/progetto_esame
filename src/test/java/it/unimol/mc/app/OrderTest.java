package it.unimol.mc.app;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class OrderTest {
    private Order order;

    @Before
    public void setUp() {
        order = new Order();
        order.addProduct(new Product("Hamburger", 6.99, "Juicy beef patty on a bun", "Burger"));
        order.addProduct(new Product("French Fries", 1.99, "Crispy golden fries", "Side"));
        order.addProduct(new Product("Soft Drink", 1.49, "Refreshing carbonated beverage", "Beverage"));
    }

    @Test
    public void testAddProduct() {
        // Verifico se il metodo addProduct aggiunge correttamente un prodotto all'ordine
        assertEquals(3, order.getOrderedProducts().size());
        order.addProduct(new Product("Salad", 5.99, "Fresh mixed greens with tomatoes, cucumbers, and choice of dressing", "Salad"));
        assertEquals(4, order.getOrderedProducts().size());
    }

    @Test
    public void testCalculateTotal() {
        // Verifico se il metodo calculateTotal restituisce correttamente il totale dell'ordine
        assertEquals(10.47, order.calculateTotal(), 0.01);
    }
}
