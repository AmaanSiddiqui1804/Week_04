package com.queue_interface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueTest {

    // Method to reverse the queue
    public <E> Queue<E> reverseQueue(Queue<E> queue) {
        Stack<E> stack = new Stack<>();
        // Pushing all elements of the queue to the stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Pop elements from the stack and add them back to the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        return queue;
    }

    // Method to create a queue from an array of elements
    private <E> Queue<E> createQueue(E... elements) {
        Queue<E> queue = new LinkedList<>();
        for (E element : elements) {
            queue.add(element);
        }
        return queue;
    }

    // Test case 1: Testing with an empty queue
    @Test
    public void testEmptyQueue() {
        Queue<Integer> originalQueue = createQueue();
        Queue<Integer> reversedQueue = reverseQueue(originalQueue);

        // An empty queue should still be empty after reversing
        assertTrue(reversedQueue.isEmpty(), "The reversed queue should be empty.");
    }

    // Test case 2: Test with a single element queue
    @Test
    public void testSingleElementQueue() {
        Queue<Integer> originalQueue = createQueue(42);

        // Expected reversed queue is the same as the original
        Queue<Integer> expectedReversedQueue = createQueue(42);

        Queue<Integer> reversedQueue = reverseQueue(originalQueue);

        assertEquals(expectedReversedQueue, reversedQueue, "The reversed queue should be the same as the original.");
    }

    // Test case 3: Test with a multiple element queue
    @Test
    public void testMultipleElementQueue() {
        Queue<Integer> originalQueue = createQueue(1, 2, 3, 4);

        // Expected reversed queue
        Queue<Integer> expectedReversedQueue = createQueue(4, 3, 2, 1);

        Queue<Integer> reversedQueue = reverseQueue(originalQueue);

        assertEquals(expectedReversedQueue, reversedQueue, "The queue should be reversed.");
    }

    // Test case 4: Test with a queue that is already reversed
    @Test
    public void testAlreadyReversedQueue() {
        Queue<Integer> originalQueue = createQueue(4, 3, 2, 1);

        // Expected reversed queue
        Queue<Integer> expectedReversedQueue = createQueue(1, 2, 3, 4);

        Queue<Integer> reversedQueue = reverseQueue(originalQueue);

        assertEquals(expectedReversedQueue, reversedQueue, "The queue should be reversed back to the original order.");
    }

    // Test case 5: Test with a queue of strings
    @Test
    public void testStringQueue() {
        Queue<String> originalQueue = createQueue("apple", "banana", "cherry");

        // Expected reversed queue
        Queue<String> expectedReversedQueue = createQueue("cherry", "banana", "apple");

        Queue<String> reversedQueue = reverseQueue(originalQueue);

        assertEquals(expectedReversedQueue, reversedQueue, "The queue of strings should be reversed.");
    }
}
