/* Find Frequency of Elements
Given a list of strings, count the frequency of each element and return the results in a Map<String, Integer>.
Example:
Input: ["apple", "banana", "apple", "orange"] → Output: {apple=2, banana=1, orange=1}
 */
package com.list_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyOfElements {
    static void frequencyCount(String[] input){

        Map<String, Integer> output = new HashMap<>();
        for (String s : input) {
            if (output.containsKey(s)) {
                output.put(s, output.get(s) + 1);
            } else {
                output.put(s, 1);
            }
        }
        for(Map.Entry<String,Integer> element : output.entrySet()) {
            System.out.print(element.getKey() + "=" + element.getValue());
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = new String[10];
        System.out.println("Enter 10 elements to find its count:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Element " + (i + 1) + ": ");
            input[i] = sc.nextLine();
        }
        System.out.println("Frequency of each Element: ");
        frequencyCount(input);
        sc.close();
    }
}
