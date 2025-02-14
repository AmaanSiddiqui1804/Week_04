/* 4. Multiple Catch Blocks
💡 Problem Statement:
Create a Java program that performs array operations.
Accept an integer array and an index number.
Retrieve and print the value at that index.
Handle the following exceptions:
ArrayIndexOutOfBoundsException if the index is out of range.
NullPointerException if the array is null.
Expected Behavior:
If valid, print "Value at index X: Y".
If the index is out of bounds, display "Invalid index!".
If the array is null, display "Array is not initialized!".
 */
package com.exception_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchBlockExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            Integer[] array = {10, 20, 30, 40, 50};
            System.out.print("Enter index: ");
            int index = input.nextInt();
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter an integer.");
        } finally {
            input.close();
        }
    }
}
