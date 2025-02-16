/* Create a @MaxLength Annotation for Field Validation
✅ Problem Statement:
Define a field-level annotation @MaxLength(int value) that restricts the maximum length of a String field.
🔹 Requirements:
Apply it to a User class field (username).
Validate length in the constructor.
Throw IllegalArgumentException if the limit is exceeded.
 */

package com.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

// Defining @MaxLength Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// Applying the Annotation to a Field in the User Class
class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength();
    }

    private void validateMaxLength() {
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(MaxLength.class)) {
                    field.setAccessible(true);
                    String fieldValue = (String) field.get(this);
                    int maxLength = field.getAnnotation(MaxLength.class).value();

                    if (fieldValue.length() > maxLength) {
                        throw new IllegalArgumentException(
                                "Error: " + field.getName() + " exceeds max length of " + maxLength
                        );
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

public class CustomAnnotation_Prblm4 {
    public static void main(String[] args) {
        try {
            User validUser = new User("Amaan");
            System.out.println("Valid Username: " + validUser.getUsername());

            User invalidUser = new User("Amaaaaaaaaaaaaaaaaaaan");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
