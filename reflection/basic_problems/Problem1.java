/* Get Class Information: Write a program to accept a class name as input and display
its methods, fields, and constructors using Reflection.
 */
package com.reflection.basic_problems;

import java.lang.reflect.*;

class Car {
    // Fields (Variables) or Attributes
    private String brand;  //Private variable
    public int speed;

    // Constructor
    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Methods
    public void drive() {
        System.out.println(brand + " is driving at " + speed + " km/h");
    }

    private void secretFeature() {
        System.out.println("This is a secret feature like the bond car has!");
    }
}

public class Problem1 {
    public static void main(String[] args) throws ClassNotFoundException {

            Class<?> cls = Car.class;

            // Printing class name
            System.out.println("Class Name: " + cls.getName());

            // Get and print methods
            Method[] methods = cls.getDeclaredMethods();
            System.out.println("\nMethods:");
            for (Method method : methods) {
                System.out.println("  " + method);
            }

            // Get and print fields
            Field[] fields = cls.getDeclaredFields();
            System.out.println("\nFields:");
            for (Field field : fields) {
                System.out.println("  " + field);
            }

            // Get and print constructors
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println("  " + constructor);
            }
    }
}
