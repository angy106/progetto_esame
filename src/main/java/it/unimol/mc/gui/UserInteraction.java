package it.unimol.mc.gui;

import it.unimol.mc.app.Menu;
import it.unimol.mc.app.Order;
import it.unimol.mc.app.Product;
import it.unimol.mc.app.ProductOfTheDay;

import java.util.List;
import java.util.Scanner;

public class UserInteraction {
    private Menu menu;
    private Scanner scanner;
    private ProductOfTheDay prodDay;
    private String choice;
    private int result;
    private Order order;

    public UserInteraction() {
        this.menu = new Menu();
        this.prodDay = new ProductOfTheDay();
        this.order = new Order();
        this.scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Benvenuto alla brutta copia del McDonald!\nCosa vorresti fare?");
    }

    public void printFirstMenu() {
        do {
            this.result = 0;
            System.out.println("1. Visualizzare il menu\n");
            System.out.println("2. Visualizzare l'offerta di oggi\n");
            System.out.println("3. Esci\n");
            choice = scanner.nextLine();
            // Verifica se l'input è un intero a una cifra
            if (choice.matches("[1-3]")) {
                // Converte l'input in un intero
                result = Integer.parseInt(choice);

                switch (result) {
                    case 1:
                        checkMenu();
                        break;
                    case 2:
                        displaySpecialMenu();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a single-digit integer (1-3).");
            }
        } while (result != 3);
    }

    public void displaySpecialMenu() {
        do {
            System.out.println("Today we have for you:\n");
            System.out.println(this.prodDay.getSpecialProduct().getName() + " - $" + this.prodDay.getSpecialProduct().getPrice());
            System.out.println("\n0. Go back to the main menu");
            System.out.println("1. Add to the cart");
            System.out.println("If you want to see your cart, enter 'shop'\n");
            System.out.print("Enter your choice: \n");
            choice = scanner.nextLine();
            result = 0;
            // Verifica se l'input è un intero da 0 a 7
            if (choice.matches("[0-1]")) {
                // Converte l'input in un intero
                result = Integer.parseInt(choice);

                switch (result) {
                    case 0:
                        System.out.println("Returning to the main menu...");
                        try {
                            Thread.sleep(3000); // 3000 millisecondi corrispondono a 4 secondi
                        } catch (InterruptedException e) {
                            // Gestione dell'eccezione
                            e.printStackTrace();
                        }
                        break;
                    case 1:
                        this.addToCart();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else if (choice.equalsIgnoreCase("shop")) {
                displayOrder();
            } else {
                System.out.println("Invalid input. Please enter a number between 0 and 7 or 'shop' to view the order.");
            }
        } while (result != 0);
    }

    public void addToCart() {
        // Add the special product to the cart
        this.order.addProduct(prodDay.getSpecialProduct());
        System.out.println("Special product added to the cart.");
        try {
            Thread.sleep(3000); // 3000 millisecondi corrispondono a 4 secondi
        } catch (InterruptedException e) {
            // Gestione dell'eccezione
            e.printStackTrace();
        }
    }

    public void displayMenu() {
        List<Product> menuItems = this.menu.getMenu();
        if (menuItems.isEmpty()) {
            System.out.println("The menu is empty.");
        } else {
            System.out.println("Menu:");
            int i = 1;
            for (Product item : menuItems) {
                System.out.println(i + ". " + item.getName() + " - $" + item.getPrice() + "\nWhat is it: " + item.getDescription());
                i += 1;
            }
        }

        System.out.println("\nWhat do you want to order? (Click 0 if you want to exit, shop if you want to see your order)");
    }

    public void checkMenu() {
        do {
            this.displayMenu();
            choice = scanner.nextLine();
            result = 0;
            // Verifica se l'input è un intero da 0 a 7
            if (choice.matches("[0-7]")) {
                // Converte l'input in un intero
                result = Integer.parseInt(choice);

                switch (result) {
                    case 0:
                        System.out.println("Returning to the main menu...");
                        try {
                            Thread.sleep(3000); // 3000 millisecondi corrispondono a 4 secondi
                        } catch (InterruptedException e) {
                            // Gestione dell'eccezione
                            e.printStackTrace();
                        }
                        return;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        this.addToOrder(result);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else if (choice.equalsIgnoreCase("shop")) {
                displayOrder();
            } else {
                System.out.println("Invalid input. Please enter a number between 0 and 7 or 'shop' to view the order.");
            }
        } while (result != 0);
    }

    public void addToOrder(int index) {
        // Check if the menu has at least (index) items
        List<Product> menuItems = this.menu.getMenu();
        if (index <= menuItems.size() && index > 0) {
            Product selectedProduct = menuItems.get(index - 1); // Adjust index to match list index
            this.order.addProduct(selectedProduct);
            System.out.println(selectedProduct.getName() + " added to the order.");
            try {
                Thread.sleep(3000); // 3000 millisecondi corrispondono a 4 secondi
            } catch (InterruptedException e) {
                // Gestione dell'eccezione
                e.printStackTrace();
            }
            return;
        } else {
            System.out.println("Invalid choice. Please select a valid item from the menu.");
        }
    }

    public void displayOrder() {
        System.out.println("Your order:");
        List<Product> orderProd = this.order.getOrderedProducts();
        for (Product item : orderProd) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("\nThe total is: " + this.order.calculateTotal());

        System.out.println("\n1. Buy and exit");
        System.out.println("2. Continue ordering");

        Scanner scanner = new Scanner(System.in, "UTF-8");
        int choice = 0;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    System.out.println("Thank you for your purchase!");
                    break;
                case 2:
                    System.out.println("Continuing ordering...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 1 && choice != 2);
    }

}
