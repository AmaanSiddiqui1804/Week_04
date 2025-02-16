package com.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Defining @RoleAllowed Annotation
@Retention(RetentionPolicy.RUNTIME)

@interface RoleAllowed {
    String value(); // Expected role
}

// User System
class User1 {
    private String role;

    public User1(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Secure Service with Role-Based Access Control
class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed successfully!");
    }

    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("User task executed successfully!");
    }
}

// Accessing Control Logic using Reflection
class RoleValidator {
    public static void invokeIfAuthorized(Object obj, String methodName, User1 user) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();
                if (user.getRole().equals(requiredRole)) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied! You need " + requiredRole + " role.");
                }
            } else {
                method.invoke(obj); // Execute normally if no annotation
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class CustomAnnotation_Prblm5 {
    public static void main(String[] args) {
        SecureService service = new SecureService();
        User1 admin = new User1("ADMIN");
        User1 normalUser = new User1("USER");

        System.out.println("Admin tries to access:");
        RoleValidator.invokeIfAuthorized(service, "adminTask", admin);

        System.out.println("\nUser tries to access admin task:");
        RoleValidator.invokeIfAuthorized(service, "adminTask", normalUser);

        System.out.println("\nUser tries to access user task:");
        RoleValidator.invokeIfAuthorized(service, "userTask", normalUser);
    }
}
