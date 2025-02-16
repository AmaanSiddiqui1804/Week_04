/* Access Private Field: Create a class Person with a private field age.
Use Reflection to modify and retrieve its value.
 */
package com.reflection.basic_problems;

import java.lang.reflect.Field;

class Person {
    private int age = 22 ;
}
public class Problem2 {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<?> cls = person.getClass();  //Getting class object

        // Accessing private field age
        Field field = cls.getDeclaredField("age");

        field.setAccessible(true); // Allowing access to private field

        // Get field value
        System.out.println("Old age: " + field.get(person));

        // Modifying field value
        field.set(person, 30);

        // Getting modified value
        System.out.println("New Value: " + field.get(person));
    }
}
