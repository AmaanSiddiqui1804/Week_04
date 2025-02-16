/* Invoke Private Method: Define a class Calculator with a private method
multiply(int a, int b). Use Reflection to invoke this method and display the result.
 */
package com.reflection.basic_problems;
import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b){
        return a*b ;
    }
}
public class Problem3 {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Class<?> cls = calc.getClass();

        // Accessing private method
        Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true); // Allowing access to private method

        // Invoking method dynamically
        int result = (int) method.invoke(calc, 5, 10);
        System.out.println("Multiplication Result: " + result);

    }
}
