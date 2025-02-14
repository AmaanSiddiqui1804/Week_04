/* Merge Two Maps
Merge two maps such that if a key exists in both, sum their values.
Example:
Map1: {A=1, B=2}, Map2: {B=3, C=4} → Output: {A=1, B=5, C=4}.
 */
package com.map_interface;

import java.util.HashMap;
import java.util.Map;

public class MapMerge {

    static HashMap<Character, Integer> merge(Map<Character, Integer> hashMap1, Map<Character, Integer> hashMap2) {
        HashMap<Character,Integer> mergeMap =new HashMap<>();
        for(Character it:hashMap2.keySet()){
            if(hashMap1.containsKey(it)){
                mergeMap.put(it,hashMap2.get(it)+ hashMap1.get(it));
            }
            else{
                mergeMap.put(it,hashMap2.get(it));
            }
        }
        for(Character it: hashMap1.keySet()){
            if(!hashMap2.containsKey(it)){
                mergeMap.put(it, hashMap1.get(it));
            }
        }
        return mergeMap;
    }
    public static void main(String[] args) {

        HashMap<Character,Integer> hashMap1 = new HashMap<>();
        HashMap<Character,Integer> hashMap2 = new HashMap<>();
        hashMap2.put('A',10);
        hashMap2.put('B',30);
        hashMap1.put('B',40);
        hashMap1.put('D',9);
        hashMap1.put('E',15);

        System.out.println("first map is: "+hashMap2);
        System.out.println("second map is: "+ hashMap1);
        System.out.println("merge map is: "+ merge(hashMap1, hashMap2));

    }
}