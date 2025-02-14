/* Implement a Shopping Cart
Description:
Use HashMap to store product prices.
Use LinkedHashMap to maintain the order of items added.
Use TreeMap to display items sorted by price.
 */
package com.shopping_cart;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class ShoppingCartItems {
    private Map<String, Double> priceMap = new HashMap<>();
    private Map<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedItems = new TreeMap<>();

    // Add a product with price
    public void addProduct(String product, double price) {
        priceMap.put(product, price);
        sortedItems.put(price, product);
    }

    // Add item to cart
    public void addToCart(String product, int quantity) {
        if (!priceMap.containsKey(product)) {
            System.out.println("Product not found!");
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    // Display cart in the order of items added
    public void displayCart() {
        System.out.println("Cart Items (Order Added): " + cart);
    }

    // Displaying items sorted by price
    public void displaySortedByPrice() {
        System.out.println("Items Sorted by Price: " + sortedItems);
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        ShoppingCartItems cart = new ShoppingCartItems();

        // Adding products
        cart.addProduct("Laptop", 120000);
        cart.addProduct("Phone", 18000);
        cart.addProduct("Headphones", 1500);
        cart.addProduct("Mouse", 500);

        // Adding items to cart
        cart.addToCart("Phone", 1);
        cart.addToCart("Mouse", 1);
        cart.addToCart("Laptop", 1);

        // Displaying results
        cart.displayCart();
        cart.displaySortedByPrice();
    }
}
