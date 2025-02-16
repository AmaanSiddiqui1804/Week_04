/* Exercise 4: Create a Custom Annotation and Use It
✅ Problem Statement:
Create a custom annotation @TaskInfo to mark tasks with priority and assigned person.
🔹 Steps to Follow:
Define an annotation @TaskInfo with fields priority and assignedTo.
Apply this annotation to a method in TaskManager class.
Retrieve the annotation details using Reflection API.
 */

package com.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

// Defining Custom Annotation
@Retention(RetentionPolicy.RUNTIME)  // Available at runtime for reflection
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Applying Annotation
class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Amaan")
    public void completeTask() {
        System.out.println("Task completed!");
    }
}

// Retrieving Annotation via Reflection
public class Exercise4 {
    public static void main(String[] args) throws Exception {
        Method method = Services.class.getMethod("completeTask");

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}
