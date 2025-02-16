/* Dynamically Create Objects: Write a program to create an instance of a
Student class dynamically using Reflection without using the new keyword.
 */
package com.reflection.basic_problems;

import java.lang.reflect.Constructor;

class Student {
    private String name ;

    public Student() {
        this.name = "default student";
    }

    // Parameterized constructor
    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}
public class Problem4 {
    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> cls = Student.class;

            // Creating an instance using the default constructor
            Object obj1 = cls.getDeclaredConstructor().newInstance();
            ((Student) obj1).display(); // Casting and calling method

            // Creating an instance using the parameterized constructor
            Constructor<?> constructor = cls.getDeclaredConstructor(String.class);
            Object obj2 = constructor.newInstance("Amaan Siddiqui");
            ((Student) obj2).display(); // Casting and calling method

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
