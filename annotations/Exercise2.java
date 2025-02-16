/* Exercise 2: Use @Deprecated to Mark an Old Method
✅ Problem Statement:
Create a class LegacyAPI with an old method oldFeature(),
which should not be used anymore. Instead, introduce a new method newFeature().
🔹 Steps to Follow:
Define a class LegacyAPI.
Mark oldFeature() as @Deprecated.
Call both methods and observe the warning.
 */
package com.annotations;
class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature method");
    }

    public void newFeature() {
        System.out.println("New feature");
    }
}
public class Exercise2 {
    public static void main(String[] args) {
        LegacyAPI legacyAPI = new LegacyAPI();

        System.out.println("Calling old feature (Deprecated)");
        legacyAPI.oldFeature();
        System.out.println("Calling new feature ");
        legacyAPI.newFeature();
    }
}
