/* 3. Custom Exception (User-defined Exception)
💡 Problem Statement:
Create a custom exception called InvalidAgeException.
Write a method validateAge(int age) that throws InvalidAgeException if the age is below 18.
In main(), take user input and call validateAge().
If an exception occurs, display "Age must be 18 or above".
Expected Behavior:
If the age is >=18, print "Access granted!".
If age <18, throw InvalidAgeException and display the message.
 */
package com.exception_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class CustomExceptionExample {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
        System.out.println("Access granted!");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter age: ");
            int age = input.nextInt();
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
        } finally {
            input.close();
        }
    }
}
