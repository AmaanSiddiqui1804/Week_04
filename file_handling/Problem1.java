/* File Handling - Read and Write a Text File
📌 Problem Statement:
Write a Java program that reads the contents of a text file and writes it into a new file.
If the source file does not exist, display an appropriate message.
Requirements:
Use FileInputStream and FileOutputStream.
Handle IOException properly.
Ensure that the destination file is created if it does not exist.
 */

package com.file_handling;

import java.io.*;

public class Problem1 {
    public static void main(String[] args) {
        String sourceFile = "D:\\Week_04\\Day_03\\src\\com\\file_handling\\TextFile101.txt";
        String destinationFile = "D:\\Week_04\\Day_03\\src\\com\\file_handling\\TextFile102.txt";

        // Try-with-resources to automatically close streams
        try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
             FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {

            int byteReading;
            // Reading source file and writing to destination
            while ((byteReading = fileInputStream.read()) != -1) {
                fileOutputStream.write(byteReading);
            }

            System.out.println("File Copied Successfully");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
}
