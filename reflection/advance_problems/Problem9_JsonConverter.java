/* Generate a JSON Representation: Write a program that converts an object to a
JSON-like string using Reflection by inspecting its fields and values.
 */
package com.reflection.advance_problems;
import java.lang.reflect.Field;

class Person1 {
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class Problem9_JsonConverter {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\":\"").append(fields[i].get(obj)).append("\"");
            if (i < fields.length - 1) {
                json.append(", ");
            }
        }
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person1 person1 = new Person1("Bob", 30);
        System.out.println(toJson(person1));
    }
}


