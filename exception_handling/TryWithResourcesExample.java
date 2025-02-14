/* 5. try-with-resources (Auto-closing Resources)
💡 Problem Statement:
Write a Java program that reads the first line of a file named "info.txt" using BufferedReader.
Use try-with-resources to ensure the file is automatically closed after reading.
Handle any IOException that may occur.
Expected Behavior:
If the file exists, print its first line.
If the file does not exist, catch IOException and print "Error reading file".
 */
package com.exception_handling;

import java.io.*;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        String fileNAme = "D:\\Week_04\\Day_04\\src\\com\\exception_handling\\Checked Exception TestFile.txt";
        String file2 = "D:\\Week_04\\Day_04\\src\\com\\exception_handling\\No such file exists.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileNAme))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        //Reading file that does not exist
        try (BufferedReader reader = new BufferedReader(new FileReader(file2))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
