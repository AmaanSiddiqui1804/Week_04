package com.set_interface;

import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

class CompareSetTest {

    // Method to check if two sets are equal
    public boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);
    }

    @Test
    void testEqualSets() {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 2, 1));

        assertTrue(areSetsEqual(set1, set2), "Sets with the same elements should be equal.");
    }

    @Test
    void testDifferentSets() {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(4, 5, 6));

        assertFalse(areSetsEqual(set1, set2), "Different sets should not be equal.");
    }

    @Test
    void testSetsWithDuplicates() {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 1, 2));

        assertTrue(areSetsEqual(set1, set2), "Sets with duplicates should still be equal.");
    }

    @Test
    void testEmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        assertTrue(areSetsEqual(set1, set2), "Empty sets should be equal.");
    }

    @Test
    void testOneEmptySet() {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>();

        assertFalse(areSetsEqual(set1, set2), "A non-empty set should not be equal to an empty set.");
    }
}
