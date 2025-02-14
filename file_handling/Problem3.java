/* 3. Read User Input from Console
📌 Problem Statement:
Write a program that asks the user for their name, age, and favorite programming language, then saves this information into a file.
Requirements:
Use BufferedReader for console input.
Use FileWriter to write the data into a file.
Handle exceptions properly.
 */
package com.file_handling;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class Problem3 {
    public static void main(String[] args) {
        // Create a BufferedReader for console input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String destinationFile = "D:\\Week_04\\Day_03\\src\\TextFile301.txt";

        try {
            // Asking for user inputs
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(reader.readLine());

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Saving user input to a file
            FileWriter writer = new FileWriter(destinationFile);

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            // Closing the writer to save the file
            writer.close();

            System.out.println("Data has been written to 'TextFile301'.");

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing data." + e.getMessage());
        }
    }
}

