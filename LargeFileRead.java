/* 9. Read a Large File Line by Line
📌 Problem Statement:
Develop a Java program that efficiently reads a large text file (500MB+) line by line and prints only lines containing the word "error".
Requirements:
Use BufferedReader for efficient reading.
Read line-by-line instead of loading the entire file.
Display only lines containing "error" (case insensitive).
 */
package com.large_file_reading;

import java.io.*;
public class LargeFileRead {

    public static void main(String[] args) {
        String filePath = "D:\\Week_04\\Day_03\\src\\com\\large_file_reading\\250MB file.txt"; // Large File

        System.out.println("Searching for the word error in a 250 MB file");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) { // Case insensitive check
                    System.out.println(line);
                }
            }
            System.out.println("Note: File do not have the word \"error\" ");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
