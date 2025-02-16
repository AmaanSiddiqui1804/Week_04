/* Beginner Level
1️⃣ Create an Annotation to Mark Important Methods
✅ Problem Statement:
Define a custom annotation @ImportantMethod that can be applied to methods to indicate their importance.
🔹 Requirements:
Define @ImportantMethod with an optional level parameter (default: "HIGH").
Apply it to at least two methods.
Retrieve and print annotated methods using Reflection API.
 */
package com.annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Defining Custom Annotation
@Retention(RetentionPolicy.RUNTIME)  // Available at runtime for reflection
@interface ImportantMethod {
    String level() default "HIGH";
}

// Applying Annotation
class Services {
    @ImportantMethod(level = "HIGH")
    public void criticalOperation() {
        System.out.println("Executing a critical operation...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void importantOperation() {
        System.out.println("Executing an important operation...");
    }

    public void normalOperation() {
        System.out.println("Executing an operation...");
    }
}
public class CustomAnnotation_Prblm1 {
    public static void main(String[] args) {
        Class<?> cls = Services.class;

        for(Method method : cls.getDeclaredMethods()) {
            if(method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important method: " + method.getName() + " (Level: " + annotation.level() + ")");
            }
        }
    }
}
