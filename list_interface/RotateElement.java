/* Rotate Elements in a List
Rotate the elements of a list by a given number of positions.
Example:
Input: [10, 20, 30, 40, 50], rotate by 2 → Output: [30, 40, 50, 10, 20].
*/
package com.list_interface;

import java.util.ArrayList;
import java.util.Scanner;

public class RotateElement {
    static ArrayList<Integer> rotate(ArrayList<Integer> input, int rotateFrom){
        int n = input.size();

        if (n == 0 || rotateFrom % n == 0) return input; //Edge case

        rotateFrom = rotateFrom % n; // Handle cases where rotateFrom > n

        if (rotateFrom < 0) rotateFrom += n; // Handling negative rotation (convert left to right)

        //calling reverse method to reverse the entire ArrayList
        reverse(input, 0, (n-1));

        //calling method to reverse first half
        reverse(input, 0, rotateFrom-1);

        //Calling method to reverse second half
        reverse(input, rotateFrom, n-1);

        return input;
    }
    static void reverse(ArrayList<Integer> input, int start, int end){
        while (start < end){
            int temp = input.get(start);
            input.set(start, input.get(end));
            input.set(end, temp);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println("Enter elements (Enter no to stop and enter each element in new line): ");
        while (true) {
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("no")) {
                break;
            }
            try {
                arrayList.add(Integer.parseInt(str)); // Parse the input as integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number or 'no' to stop.");
            }
        }
        System.out.println("Enter index to rotate from");
        int t = sc.nextInt();

        //Calling rotate method to rotate array from
        ArrayList<Integer> output = rotate(arrayList, t);

        System.out.println("Rotated Values" + output);
        sc.close();
    }
}