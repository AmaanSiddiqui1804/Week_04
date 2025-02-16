/* Exercise 3: Suppress Unchecked Warnings
✅ Problem Statement:
Create an ArrayList without generics and use @SuppressWarnings("unchecked") to hide compilation warnings.

 */
package com.annotations;

import java.util.ArrayList;

public class Exercise3 {
    public static void main(String[] args) {

        @SuppressWarnings("unchecked")
        ArrayList al = new ArrayList();
        al.add(1011);
        al.add("Bablu");
        al.add(12.56f);

        System.out.println("Items in arraylist: " + al.toString());
    }
}
