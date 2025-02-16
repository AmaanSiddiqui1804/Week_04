/* Access and Modify Static Fields: Create a Configuration class with a
private static field API_KEY. Use Reflection to modify its value and print it.
 */
package com.reflection.intermediate_problems;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "12345-DEFAULT-KEY";
}
public class Problem7 {
    public static void main(String[] args) {
        try {
            // Getting class object
            Class<?> cls = Configuration.class;

            // Getting the private static field
            Field field = cls.getDeclaredField("API_KEY");

            // Making the field accessible
            field.setAccessible(true);

            // Printing the original API_KEY value
            System.out.println("Original API_KEY: " + field.get(null));

            // Modifying the private static field
            field.set(null, "01111-NEW-KEY");

            // Printing the modified API_KEY value
            System.out.println("Updated API_KEY: " + field.get(null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
