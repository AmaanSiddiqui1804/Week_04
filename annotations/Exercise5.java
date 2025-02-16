/*
Exercise 5: Create and Use a Repeatable Annotation
✅ Problem Statement:
Define an annotation @BugReport that can be applied multiple times on a method.
🔹 Steps to Follow:
Define @BugReport with a description field.
Use @Repeatable to allow multiple bug reports.
Apply it twice on a method.
Retrieve and print all bug reports.
 */

package com.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

// Defining Repeatable Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)  // Allows multiple BugReport annotations
@interface BugReport {
    String description();
}

// Defining Container for Repeated Annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Applying Annotation Multiple Times
class Software {
    @BugReport(description = "Fix null pointer issue")
    @BugReport(description = "Optimize database query")
    public void run() {
        System.out.println("Running software balle balle shava shava...");
    }
}

// Retrieving Annotations via Reflection
public class Exercise5 {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("run");

        // Retrieving repeated annotations
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug Report: " + bug.description());
            }
        }
    }
}
