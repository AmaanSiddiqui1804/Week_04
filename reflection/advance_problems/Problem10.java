/* Custom Logging Proxy Using Reflection: Implement a Dynamic Proxy that intercepts
method calls on an interface (e.g., Greeting.sayHello()) and logs the method name
before executing it.
 */

package com.reflection.advance_problems;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello Mr.");
    }
}

// LoggingProxy handles the method invocation
class LoggingProxy implements InvocationHandler {
    private final Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Executing method: " + method.getName());
        return method.invoke(target, args);
    }
}

public class Problem10 {

    // Generic method to create proxy instance
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new LoggingProxy(target)  // Using LoggingProxy here
        );
    }

    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        Greeting proxy = createProxy(greeting, Greeting.class);
        proxy.sayHello();
    }
}
