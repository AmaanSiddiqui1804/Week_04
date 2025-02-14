/* 7. Data Streams - Store and Retrieve Primitive Data
📌 Problem Statement:
Write a Java program that stores student details (roll number, name, GPA) in a binary file and retrieves it later.
Requirements:
Use DataOutputStream to write primitive data.
Use DataInputStream to read data.
Ensure proper closing of resources.
 */
package com.data_streams;

import java.io.*;

public class StudentData {
    static final String FILE_NAME = "D:\\Week_04\\Day_03\\src\\com\\data_streams\\StudentData.dat";
    public static void main(String[] args) {
        // Writing student data to a binary file
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dataOutputStream.writeInt(211001); // Roll Number
            dataOutputStream.writeUTF("Amaan"); // Name
            dataOutputStream.writeDouble(8.8); // CGPA
            System.out.println("Student data stored successfully.");
        } catch (IOException e) {
            System.out.println("Error writing student data: " + e.getMessage());
        }

        // Reading student data from the binary file
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(FILE_NAME))) {
            int rollNumber = dataInputStream.readInt();
            String name = dataInputStream.readUTF();
            double cgpa = dataInputStream.readDouble();
            System.out.println("Retrieved Student Data:");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("CGPA: " + cgpa);
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }
    }
}
