/* Symmetric Difference
Find the symmetric difference (elements present in either set but not in both) of two sets.
Example:
Set1: {1, 2, 3}, Set2: {3, 4, 5} → Output: {1, 2, 4, 5}.
 */
package com.set_interface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SymmetricDifference {

    // Method to perform symmetric difference operation on sets
    static void symmetricDifferenceOfSets(Set<Integer> set1, Set<Integer> set2) {

        Set<Integer> symmetricDifference = new HashSet<>(set1);
        symmetricDifference.addAll(set2); // Union
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // Intersection
        symmetricDifference.removeAll(intersection); // Remove intersection from union

        System.out.println("Symmetric Difference of Set 1: " + set1 + "\nand Set 2: " + set2 + "\nis " + symmetricDifference);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Creating two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Taking input for the first set
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

        // Taking input for the second set
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

        // Calling method to print symmetric difference of two sets
        symmetricDifferenceOfSets(set1, set2);

        input.close();
    }
}

