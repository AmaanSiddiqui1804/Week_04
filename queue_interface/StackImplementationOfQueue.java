/* Implement a Stack Using Queues
Implement a stack data structure using two queues and support push, pop, and top operations.
Example:
Push 1, 2, 3 → Pop → Output: 3.
 */

package com.queue_interface;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class StackUsingQueue {
    Queue<Integer> q1 ;
    Queue<Integer> q2 ;

    public StackUsingQueue(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    //Adding elements in queue (push operation)
    public void push(int x){
        q1.offer(x);

        while (!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        //Swap q1  and  q2
        Queue<Integer>  temp = q1;
        q1 = q2;
        q2 = temp;
    }
    //Pop Operation
    public int pop() {
        if(q1.isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        return q1.poll();
    }
    //Peek Operation
    public int peek() {
        if(q1.isEmpty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        return q1.peek();
    }
    //checking if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // Printing the current stack
    public void printStack() {
        // Simply printing the queue
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Current Stack: ");
            for (Integer element : q1) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
public class StackImplementationOfQueue {
    public static void main(String[] args) {

        StackUsingQueue stack = new StackUsingQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(50);
        stack.push(60);

        System.out.println("Original stack: ");
        stack.printStack();
        System.out.println("Top of stack: " + stack.peek());

        System.out.println("Pop Operation: " + stack.pop());
        System.out.println("Pop Operation: " + stack.pop());
        System.out.println("Is Stack Empty: " + stack.isEmpty() + "\nPrinting remaining elements of stcak");
        stack.printStack();
    }
}
