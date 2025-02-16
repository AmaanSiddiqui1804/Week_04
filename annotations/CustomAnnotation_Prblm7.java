package com.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Defining @CacheResult Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

// Creating MathService Class with Expensive Method
class MathService {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int expensiveComputation(int num) {
        if (cache.containsKey(num)) {
            System.out.println("Fetching cached result for " + num);
            return cache.get(num);
        }

        System.out.println("Computing result for " + num);
        int result = num * num; // For a heavy computation
        cache.put(num, result);
        return result;
    }
}

public class CustomAnnotation_Prblm7  {
    public static void main(String[] args) throws Exception {
        MathService mathService = new MathService();

        // First call - should compute
        System.out.println(mathService.expensiveComputation(10));

        // Second call - should fetch from cache
        System.out.println(mathService.expensiveComputation(10));

        // Another computation
        System.out.println(mathService.expensiveComputation(5));

        // Fetching cached result
        System.out.println(mathService.expensiveComputation(5));
    }
}
