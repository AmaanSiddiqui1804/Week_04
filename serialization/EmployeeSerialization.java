/*4. Serialization - Save and Retrieve an Object
📌 Problem Statement:
Design a Java program that allows a user to store a list of employees in a file using
Object Serialization and later retrieve the data from the file.
Requirements:
Create an Employee class with fields: id, name, department, salary.
Serialize the list of employees into a file (ObjectOutputStream).
Deserialize and display the employees from the file (ObjectInputStream).
Handle ClassNotFoundException and IOException.
 */
package com.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class (implements Serializable)
class Employee implements Serializable {
   // private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nEmployee \n{ id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "Employee.dat";

    // Serialize Employee list
    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            objectOutputStream.writeObject(employees);
            System.out.println("Employees saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    // Deserialize Employee list
    public static List<Employee> loadEmployees() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Amaan", "IT", 50000));
        employees.add(new Employee(2, "Mr.Amaan", "HR", 60000));

        // Saving employees to file
        saveEmployees(employees);

        // Retrieving employees from file
        List<Employee> loadedEmployees = loadEmployees();
        System.out.println("Retrieved Employees: " + loadedEmployees);
    }
}

