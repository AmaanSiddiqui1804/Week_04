/* Dynamic Method Invocation: Define a class MathOperations with multiple
public methods (add, subtract, multiply). Use Reflection to dynamically call any method
based on user input.
 */
package com.reflection.intermediate_problems;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b){
        return a+b;
    }

    public int subtract(int a, int b){
        return a-b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }
}
public class Problem5 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            //Getting class object
            Class<?> cls = MathOperations.class ;
            MathOperations obj = new MathOperations();

            //Getting method naem from user
            System.out.println("Enter method name (add, subtract, multiply): ");
            String methodName = sc.nextLine();

            Method method = cls.getMethod(methodName, int.class, int.class);

            // Getting numbers from user
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();
            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            // Invoke method dynamically
            int result = (int) method.invoke(obj, num1, num2);
            System.out.println("Result: " + result);
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Invalid method name! ");
            e.printStackTrace();
        }
    }
}
