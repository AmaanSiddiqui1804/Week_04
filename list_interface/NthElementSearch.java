/* Find the Nth Element from the End
Given a singly linked list (use LinkedList), find the Nth element from the end without calculating its size.
Example:
Input: [A, B, C, D, E], N=2 → Output: D
 */
package com.list_interface;

import java.util.LinkedList;

public class NthElementSearch {
    static char elementSearch(LinkedList<Character> input, int n) {
        //Reversing Linked list to access elements from start
        reverse(input, 0, input.size()-1);
        return input.get(n-1);
    }
    static void reverse(LinkedList<Character> input, int start, int end){
        while (start < end){
            char temp = input.get(start);
            input.set(start, input.get(end));
            input.set(end, temp);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {

        LinkedList<Character> linkedList = new LinkedList<>();
        linkedList.add('A');
        linkedList.add('B');
        linkedList.add('C');
        linkedList.add('D');
        linkedList.add('E');
        linkedList.add('F');

        int n = (int) (Math.random()*(linkedList.size()-1));
        System.out.println("Element at position: " + n + " is " + elementSearch(linkedList, n));
    }
}
