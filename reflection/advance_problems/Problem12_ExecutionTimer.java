package com.reflection.advance_problems;

import java.lang.reflect.Method;

class Worker {
    public void doWork() {
        for (int i = 0; i < 1_000_000; i++); // Simulated work
        System.out.println("Work done!");
    }
}

public class Problem12_ExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        long start = System.nanoTime();
        method.invoke(obj, args);
        long end = System.nanoTime();
        System.out.println("Execution time: " + (end - start) + " ns");
    }

    public static void main(String[] args) throws Exception {
        Worker worker = new Worker();
        measureExecutionTime(worker, "doWork");
    }
}


