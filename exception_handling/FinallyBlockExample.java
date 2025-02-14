/* 7. finally Block Execution
💡 Problem Statement:
Write a program that performs integer division and demonstrates the finally block execution.
The program should:
Take two integers from the user.
Perform division.
Handle ArithmeticException (if dividing by zero).
Ensure "Operation completed" is always printed using finally.
Expected Behavior:
If valid, print the result.
If an exception occurs, handle it and still print "Operation completed".
 */
package com.exception_handling;

import java.util.Scanner;

public class FinallyBlockExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int num = input.nextInt();
            System.out.print("Enter denominator: ");
            int den = input.nextInt();
            System.out.println("Result: " + (num / den));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            System.out.println("Operation completed");
            input.close();
        }
    }
}
