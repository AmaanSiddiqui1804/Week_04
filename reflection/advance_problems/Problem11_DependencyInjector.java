/* Custom Logging Proxy Using Reflection: Implement a Dynamic Proxy that intercepts
method calls on an interface (e.g., Greeting.sayHello()) and logs the method name
before executing it.
 */
package com.reflection.advance_problems;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class Service {
    public void perform() {
        System.out.println("Service is running...");
    }
}

class Client {
    @Inject
    private Service service;

    public void useService() {
        service.perform();
    }
}

public class Problem11_DependencyInjector {

    private final Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz) throws Exception {
        instances.put(clazz, clazz.getDeclaredConstructor().newInstance());
    }

    public void injectDependencies(Object obj) throws Exception {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(obj, instances.get(field.getType()));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Problem11_DependencyInjector di = new Problem11_DependencyInjector();
        di.register(Service.class);

        Client client = new Client();
        di.injectDependencies(client);
        client.useService();
    }
}


