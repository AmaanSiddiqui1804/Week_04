/* Check if Two Sets Are Equal
Compare two sets and determine if they contain the same elements, regardless of order.
Example:
Set1: {1, 2, 3}, Set2: {3, 2, 1} → Output: true.
 */
package com.set_interface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CompareSet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Creating two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        System.out.println("Enter elements for the first set (enter 'done' to stop):");
        while (true) {
            String str = input.nextLine();
            if (str.equalsIgnoreCase("done")) {
                break;
            }
            try {
                set1.add(Integer.parseInt(str)); // Adding elements to set1
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        // Taking input for second set
        System.out.println("Enter elements for the second set (enter 'done' to stop):");
        while (true) {
            String str = input.nextLine();
            if (str.equalsIgnoreCase("done")) {
                break;
            }
            try {
                set2.add(Integer.parseInt(str)); // Adding elements to set2
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        if(set1.equals(set2)){
            System.out.println("YES, Set1: " + set1 +" is equal to Set2: " + set2 );
        }else {
            System.out.println("No, Set1: " + set1 +" is not equal to Set2: " + set2 );
        }
    }
}
