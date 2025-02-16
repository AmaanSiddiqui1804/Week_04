/* Create a @ Todo Annotation for Pending Tasks
✅ Problem Statement:
Define an annotation @ Todo to mark pending features in a project.
🔹 Requirements:
The annotation should have fields:
task() (String) → Description of the task
assignedTo() (String) → Developer responsible
priority() (default: "MEDIUM")
Apply it to multiple methods.
Retrieve and print all pending tasks using Reflection.
 */
package com.annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Defining Custom Annotation
@Retention(RetentionPolicy.RUNTIME)  // Available at runtime for reflection
@interface Todo {
    String task() ;
    String assignedTo() ;
    String priority() default "MEDIUM";
}

// Applying Annotation
class PendingTasks {
    @Todo(task = "Manage CI/CD Pipelines", assignedTo = "Amaan", priority = "MEDIUM")
    public void manageCICD(){
        System.out.println("Managing CI/CD Pipelines...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Abhay", priority = "HIGH")
    public void optimizeDatabase() {
        System.out.println("Optimizing database queries...");
    }

    @Todo(task = "Improve UI Design", assignedTo = "Nishank")  // Default priority is "MEDIUM"
    public void improveUI() {
        System.out.println("Improving UI Design...");
    }

    public void management(){
        System.out.println("Management is done by project manager");
    }
}
public class CustomAnnotation_Prblm2 {
    public static void main(String[] args) {
        Class<?> cls = PendingTasks.class;

        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method Name: " + method.getName());
                System.out.println();
            }
        }
    }
}
