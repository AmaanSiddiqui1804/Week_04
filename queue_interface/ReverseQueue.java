package com.queue_interface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    static Queue<Integer> reverseQueue(Queue<Integer> queue){
        //Using stack to reverse queue
        Stack<Integer> stack = new Stack<>();
        // Pushing all elements of the queue to the stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        // Popping elements from the stack and add them back to the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        return queue;
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println("Original Queue: " + queue);
        //Calling method to reverse queue and displaying it
        System.out.println("Reversed Queue: " + reverseQueue(queue));
    }
}
