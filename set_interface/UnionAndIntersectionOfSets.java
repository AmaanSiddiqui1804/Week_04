/*Union and Intersection of Two Sets
Given two sets, compute their union and intersection.
Example:
Set1: {1, 2, 3}, Set2: {3, 4, 5} → Union: {1, 2, 3, 4, 5}, Intersection: {3}.
 */
package com.set_interface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionAndIntersectionOfSets {
    //Method to perform union operation on sets
    static void unionOfSets(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union of Set 1: " + set1 + "\nand Set 2 " + set2 + "\nis " + union);
    }

    //Method to perform union operation on sets
    static void intersectionOfSets(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection of Set 1: " + set1 + "\nand Set 2 " + set2 + "\nis " + intersection);
    }
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

        //Calling methods to print union and intersection of two sets
        unionOfSets(set1, set2);
        intersectionOfSets(set1, set2);
    }
}
