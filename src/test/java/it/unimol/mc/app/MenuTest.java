package it.unimol.mc.app;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class MenuTest {
    private Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void testGetMenu() {
        // Verifica se il metodo getMenu restituisce correttamente il menu
        List<Product> products = menu.getMenu();
        assertEquals(7, products.size()); // Verifica se ci sono 7 prodotti nel menu

        // Verifica se i prodotti sono correttamente inizializzati
        assertEquals("Hamburger", products.get(0).getName());
        assertEquals(6.99, products.get(0).getPrice(), 0.01);
        assertEquals("Juicy beef patty on a bun", products.get(0).getDescription());
        assertEquals("Burger", products.get(0).getType());
    }
}
