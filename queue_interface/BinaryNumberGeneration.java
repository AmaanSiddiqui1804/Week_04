/* Generate Binary Numbers Using a Queue
Generate the first N binary numbers (as strings) using a queue.
Example:
N=5 → Output: ["1", "10", "11", "100", "101"].
 */
package com.queue_interface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryNumberGeneration {

    // Function to generate binary numbers up to n numbers
    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();

        // Starting with "1" as the first binary number
        queue.add("1");

        for (int i = 1; i <= n; i++) {
            // Dequeue the front element from the queue
            String current = queue.poll();

            // Printing the current binary number
            System.out.print(current + " ");

            // Appending '0' and '1' to the current binary number and enqueue them
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to generate binary numbers up to the number:");
        int n = sc.nextInt();
        generateBinaryNumbers(n);
        sc.close();
    }
}
