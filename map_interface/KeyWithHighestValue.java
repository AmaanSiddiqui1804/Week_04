/* Find the Key with the Highest Value
Given a Map<String, Integer>, find the key with the maximum value.
Example:
Input: {A=10, B=20, C=15} → Output: B.
 */
package com.map_interface;

import java.util.HashMap;
import java.util.Map;

public class KeyWithHighestValue {

    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 20);
        inputMap.put("D", 9);
        inputMap.put("E", 15);

        String maxKey = findKeyWithMaxValue(inputMap);
        System.out.println("Key with the highest value: " + maxKey); // Outputing first biggest value
    }
}
