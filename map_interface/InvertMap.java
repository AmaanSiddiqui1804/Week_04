package com.map_interface;
import java.util.ArrayList;
import java.util.HashMap;
public class InvertMap {

    public static void main(String[] args) {
        HashMap<Character,Integer>mp=new HashMap<>();
        mp.put('P',1);
        mp.put('Q',2);
        mp.put('R',1);
        mp.put('S',2);
        mp.put('T',3);
        HashMap<Integer, ArrayList<Character>>mp2 = new HashMap<>();
        for(Character it:mp.keySet()){
            Character key = it;
            Integer value = mp.get(it);
            if(!mp2.containsKey(value)){
                ArrayList<Character> arr = new ArrayList<>();
                arr.add(key);
                mp2.put(value, arr);
            }
            else{
                mp2.get(value).add(key);
            }

        }
        System.out.println("Initial array is: " + mp);
        System.out.println("Inverted map is: " + mp2);


    }
}