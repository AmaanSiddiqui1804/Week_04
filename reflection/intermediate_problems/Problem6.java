/* Retrieve Annotations at Runtime: Create a custom annotation
@Author(name="Author Name"). Apply it to a class and use Reflection to retrieve and
display the annotation value at runtime.
 */
package com.reflection.intermediate_problems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

//Defining custom annotation
@Retention(RetentionPolicy.RUNTIME) //Make annotation available
@interface Author {
    String name();
}

//Applying annotation to a class
@Author(name = "Amaan Siddiqui")

class MyClass {
    @Author(name = "Method Author")
    public void myMethod() {
        System.out.println("Inside myMethod()");
    }
}
public class Problem6 {
    public static void main(String[] args) {
        try {
            // Retrieving class annotation
            Class<?> cls = MyClass.class;
            readAnnotation(cls);

            // Retrieve method annotation
            Method method = cls.getMethod("myMethod");
            readAnnotation(method);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Utility method to read and print @Author annotation
    public static void readAnnotation(AnnotatedElement element) {
        if (element.isAnnotationPresent(Author.class)) {
            Author author = element.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}
