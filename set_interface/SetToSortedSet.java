/* Convert a Set to a Sorted List
Convert a HashSet of integers into a sorted list in ascending order.
Example:
Input: {5, 3, 9, 1} → Output: [1, 3, 5, 9].
 */
package com.set_interface;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetToSortedSet {

    static Set<Integer> convertToSortedSet(Set<Integer> set) {
        return new TreeSet<>(set);
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(90);
        set.add(45);

        Set<Integer> sortedSet = convertToSortedSet(set);
        System.out.println("Sorted Set: " + sortedSet);
    }
}
