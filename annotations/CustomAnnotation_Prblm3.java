/* 3️⃣ Create an Annotation for Logging Method Execution Time
✅ Problem Statement:
Define an annotation @LogExecutionTime to measure method execution time.
🔹 Requirements:
Apply @LogExecutionTime to a method.
Use System.nanoTime() before and after execution.
Print execution time.
Apply it on different methods and compare the time taken.
 */
package com.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime { }

// Creating an interface to log methods
interface Service {
    @LogExecutionTime
    void method1() ;

    @LogExecutionTime
    void method2() ;
}
//Implementing interface
class ServiceImpl implements Service {
    @Override
    public void method1() {
        System.out.println("Executing method1 (fast) ");
    }

    @Override
    public void method2() {
        System.out.println("Executing method2 (slow) ");
        try {
            Thread.sleep(6000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//Creating a dynamic proxy for logging execution time
class LoggingProxy implements InvocationHandler {
    private final Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long startTime = System.nanoTime();
            Object result = method.invoke(target, args); // Call original method
            long endTime = System.nanoTime();
            System.out.println(method.getName() + " executed in " + (endTime - startTime) / 1_000_000 + " ms");
            return result;
        }
        return method.invoke(target, args);
    }
}

public class CustomAnnotation_Prblm3 {
    public static void main(String[] args) {
        Service service = (Service) Proxy.newProxyInstance(
                Service.class.getClassLoader(),
                new Class[]{Service.class},
                new LoggingProxy(new ServiceImpl())
        );

        service.method1();  // Should execute quickly
        service.method2();  // Should take 6000ms
    }
}

