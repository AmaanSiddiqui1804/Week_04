package com.list_interface;

import java.util.ArrayList;
import java.util.LinkedList;

public class ReverseList {

    // Method to reverse an ArrayList
    static ArrayList<Integer> reverseArrayList(ArrayList<Integer> al) {
        long startTime, endTime;
        System.out.println("Initial ArrayList: " + al + "\n");

        int n = al.size();
        // Reversing the ArrayList
        ArrayList<Integer> reversedList = new ArrayList<>();
        startTime = System.nanoTime();
        for (int i = n - 1; i >= 0; i--) {
            reversedList.add(al.get(i));
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by ArrayList: " + (endTime - startTime) + " ns.");
        return reversedList;  // Returning the reversed list directly
    }

    // Method to reverse a LinkedList
    static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> linkedList) {
        long startTime, endTime;
        System.out.println("Initial LinkedList: " + linkedList);

        int n = linkedList.size();
        // Reversing the LinkedList
        LinkedList<Integer> reversedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = n - 1; i >= 0; i--) {
            reversedList.add(linkedList.get(i));
        }
        endTime = System.nanoTime();
        System.out.println("\nTime taken by LinkedList: " + (endTime - startTime) + " ns.");
        return reversedList;  // Returning the reversed list directly
    }

    public static void main(String[] args) {

        // Initialize ArrayList and LinkedList with test data
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);
        arrayList.add(16);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(10);

        //Reversing and Displaying Reverse ArrayList
        System.out.println("\nReversed List via ArrayList implementation: " + reverseArrayList(arrayList));

        // Reversing and Displaying Reverse LinkedList
        System.out.println("\nReversed List via LinkedList implementation: " + reverseLinkedList(linkedList));
    }
}
