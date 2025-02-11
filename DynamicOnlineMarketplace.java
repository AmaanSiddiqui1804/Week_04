/*Dynamic Online Marketplace
Concepts: Type Parameters, Generic Methods, Bounded Type Parameters
Problem Statement:
Build a generic product catalog for an online marketplace that supports various product types
like Books, Clothing, and Gadgets. Each product type has a specific price range and category.
Hints:
Define a generic class Product<T> where T is restricted to a category (BookCategory, ClothingCategory, etc.).
Implement a generic method to apply discounts dynamically (<T extends Product> void applyDiscount(T product, double percentage)).
Ensure type safety while allowing multiple product categories to exist in the same catalog.
 */
package com.dynamic_online_marketplace;

import java.util.ArrayList;
import java.util.List;

enum BookCategory {
    FICTION, NON_FICTION, SCIENCE, HISTORY, TECHNOLOGY;
}
enum ClothingCategory {
    MEN, WOMEN, KIDS, SPORTS, FORMAL;
}
enum GadgetCategory {
    MOBILE, LAPTOP, TABLET, ACCESSORY, SMARTWATCH;
}
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    //Getter methods
    public String getName() { return name; }
    public double getPrice() { return price; }
    public T getCategory() { return category; }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    //User method
    public String getProductDetails() {
        return "Product: " + name + ", Price: Rs " + price + ", Category: " + category;
    }
}
class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage){
        if (percentage < 0 || percentage > 100) {
            System.out.println("Invalid discount percentage!");
            return;
        }
        double discountAmount = product.getPrice() * (percentage / 100);
        double newPrice = product.getPrice() - discountAmount;

        product.setPrice(newPrice);
        System.out.println("Discount applied! New price of " + product.getName() + " is Rs " + newPrice);
    }
}
class ProductCatalog {
    private List <Product<?>> products;
    public ProductCatalog() {
        products = new ArrayList<>();
    }
    //Method to add products
    public void addProduct(Product<?> product) {
        products.add(product);
    }
    public void removeProduct(Product<?> product) {
        products.remove(product);
    }

    public void displayProducts() {
        for (Product<?> product : products) {
            System.out.println(product.getProductDetails());
        }
    }
}
public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        // Creating Book Products
        Product<BookCategory> book1 = new Product<>("The Alchemist", 200.0, BookCategory.FICTION);
        Product<BookCategory> book2 = new Product<>("Introduction To JAVA", 500.0, BookCategory.TECHNOLOGY);

        // Creating Clothing Products
        Product<ClothingCategory> shirt = new Product<>("Formal Shirt", 500.0, ClothingCategory.MEN);
        Product<ClothingCategory> dress = new Product<>("Evening Gown", 1000.0, ClothingCategory.WOMEN);

        // Creating Gadget Products
        Product<GadgetCategory> laptop = new Product<>("Dell G15", 150000.0, GadgetCategory.LAPTOP);
        Product<GadgetCategory> phone = new Product<>("Samsung S25", 120000.0, GadgetCategory.MOBILE);

        // Creating Product Catalog
        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book1);
        catalog.addProduct(book2);
        catalog.addProduct(shirt);
        catalog.addProduct(dress);
        catalog.addProduct(laptop);
        catalog.addProduct(phone);

        // Displaying Products Before Discount
        System.out.println("Product Catalog Before Discounts:");
        catalog.displayProducts();

        // Applying Discounts
        System.out.println("\nApplying Discounts:");
        DiscountUtil.applyDiscount(book1, 10);
        DiscountUtil.applyDiscount(shirt, 15);
        DiscountUtil.applyDiscount(laptop, 5);

        // Displaying Products After Discount
        System.out.println("\nProduct Catalog After Discounts:");
        catalog.displayProducts();
    }
}
