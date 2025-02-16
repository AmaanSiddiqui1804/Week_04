/* Create a Custom Object Mapper: Implement a method toObject(Class<T> clazz,
Map<String, Object> properties) that uses Reflection to set field values from a given Map
 */
package com.reflection.advance_problems;
import java.lang.reflect.Field;
import java.util.Map;
class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person { \nname='" + name + "', age=" + age + "\n}";
    }
}
public class Problem8 {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Field field;
            try {
                field = clazz.getDeclaredField(entry.getKey());
            } catch (NoSuchFieldException e) {
                continue; // Skip if field is not found
            }
            field.setAccessible(true);
            field.set(instance, entry.getValue());
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> data = Map.of("name", "Aariz", "age", 12);
        Person1 person1 = toObject(Person1.class, data);
        System.out.println(person1);
    }
}



