/* Remove Duplicates While Preserving Order
Remove duplicate elements from a list while maintaining the original order of elements.
Example:
Input: [3, 1, 2, 2, 3, 4] → Output: [3, 1, 2, 4].
 */
package com.list_interface;

import java.util.ArrayList;

public class RemoveDuplicates {
    static void duplicateRemove(ArrayList<Integer> input){
        int n = input.size();

        for(int i=0 ; i<n; i++){
            for(int j=i+1; j<n/2 ; j++){
                if(input.get(i).equals(input.get(j))) {
                    input.remove(j);
                    j--;
                }
            }
        }

        System.out.println("Unique Elements:" + input);
    }
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(10);
        input.add(20);
        input.add(10);
        input.add(10);
        input.add(30);
        input.add(40);
        input.add(50);

        //Calling method to remove duplicate elements
        duplicateRemove(input);
    }
}
