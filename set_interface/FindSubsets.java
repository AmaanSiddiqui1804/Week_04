/* Find Subsets
Check if one set is a subset of another.
Example:
Set1: {2, 3}, Set2: {1, 2, 3, 4} → Output: true.
 */
package com.set_interface;

import java.util.Set;
import java.util.TreeSet;

public class FindSubsets {

    // Method to check if set1 is a subset of set2
    static boolean findSubset(Set<Integer> set1, Set<Integer> set2) {
        return set2.containsAll(set1);
    }

    public static void main(String[] args) {
        // Creating two sets
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2 = new TreeSet<>();

        // Adding elements to set1 and set2
        set1.add(2);
        set1.add(3);
        set1.add(5);
        set1.add(7);

        //Adding elements in set 2
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(5);
        set2.add(4);
        set2.add(7);

        // Calling the findSubset method to check if set1 is a subset of set2
        boolean result = findSubset(set1, set2);

        // Printing the result
        System.out.println("Is Set 1: " + set1 + "\na subset of Set 2: " + set2 +"? " + result);
    }
}

