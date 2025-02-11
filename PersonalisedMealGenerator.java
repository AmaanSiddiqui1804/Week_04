/* 4. Personalized Meal Plan Generator
Concepts: Generic Methods, Type Parameters, Bounded Type Parameters
Problem Statement:
Design a Personalized Meal Plan Generator where users can choose different meal categories like
Vegetarian, Vegan, Keto, or High-Protein. The system should ensure only valid meal plans are generated.
Hints:
Define an interface MealPlan with subtypes (VegetarianMeal, VeganMeal, etc.).
Implement a generic class Meal<T extends MealPlan> to handle different meal plans.
Use a generic method to validate and generate a personalized meal plan dynamically.\
 */
package com.personalised_meal_generator;

import com.sun.jdi.InconsistentDebugInfoException;

import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealDetails();
}
class VegetarianMeal implements MealPlan {
    private String mainDish;
    private int calories;

    public VegetarianMeal(String mainDish, int calories){
        this.mainDish = mainDish;
        this.calories = calories;
    }

    @Override
    public String getMealDetails() {
        return "Vegetarian Meal - Dish: " + mainDish + ", Calories: " + calories;
    }
}
class VeganMeal implements MealPlan {
    private String plantBasedDish;
    private int calories;

    public VeganMeal(String plantBasedDish, int calories) {
        this.plantBasedDish = plantBasedDish;
        this.calories = calories;
    }

    @Override
    public String getMealDetails() {
        return "Vegan Meal - Dish: " + plantBasedDish + ", Calories: " + calories;
    }
}
class Keto implements MealPlan {
    private String proteinSource ;
    private int fatPercentage ;

    public Keto (String proteinSource, int fatPercentage) {
        this.proteinSource = proteinSource;
        this.fatPercentage = fatPercentage;
    }

    @Override
    public String getMealDetails() {
        return "Keto Meal - Protein: " + proteinSource + ", Fat %: " + fatPercentage;
    }
}
class HighProteinMeal implements MealPlan {
    private String proteinDish;
    private int proteinGrams;

    public HighProteinMeal(String proteinDish, int proteinGrams) {
        this.proteinDish = proteinDish;
        this.proteinGrams = proteinGrams;
    }

    @Override
    public String getMealDetails() {
        return "High-Protein Meal - Dish: " + proteinDish + ", Protein: " + proteinGrams + "g";
    }
}
class Meal<T extends MealPlan> {
    private List<T> meals;

    public Meal() {
        this.meals = new ArrayList<>();
    }

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public void removeMeal(T meal) {
        meals.remove(meal);
    }

    public void displayMeals() {
        for (T meal : meals) {
            System.out.println(meal.getMealDetails());
        }
    }
}
class MealUtil {
    public static <T extends MealPlan> void generateMealPlan(T meal) {
        System.out.println("Generating meal plan: " + meal.getMealDetails());
    }
}

public class PersonalisedMealGenerator {
    public static void main(String[] args) {
        // Create different meal objects
        VegetarianMeal vegMeal = new VegetarianMeal("Grilled Vegetables", 500);
        VeganMeal veganMeal = new VeganMeal("Tofu Stir-fry", 450);
        Keto ketoMeal = new Keto("Grilled Chicken with Avocado", 75);
        HighProteinMeal highProteinMeal = new HighProteinMeal("Salmon with Quinoa", 60);

        // Create separate meal categories
        Meal<VegetarianMeal> vegetarianMeals = new Meal<>();
        Meal<VeganMeal> veganMeals = new Meal<>();
        Meal<Keto> ketoMeals = new Meal<>();
        Meal<HighProteinMeal> highProteinMeals = new Meal<>();

        // Add meals to respective lists
        vegetarianMeals.addMeal(vegMeal);
        veganMeals.addMeal(veganMeal);
        ketoMeals.addMeal(ketoMeal);
        highProteinMeals.addMeal(highProteinMeal);

        // Display each meal category separately
        System.out.println("Vegetarian Meals:");
        vegetarianMeals.displayMeals();

        System.out.println("\nVegan Meals:");
        veganMeals.displayMeals();

        System.out.println("\nKeto Meals:");
        ketoMeals.displayMeals();

        System.out.println("\nHigh-Protein Meals:");
        highProteinMeals.displayMeals();

        // Use the generic method to generate meal plans dynamically
        System.out.println("\nGenerating Personalized Meal Plans:");
        MealUtil.generateMealPlan(vegMeal);
        MealUtil.generateMealPlan(veganMeal);
        MealUtil.generateMealPlan(ketoMeal);
        MealUtil.generateMealPlan(highProteinMeal);
    }
}
