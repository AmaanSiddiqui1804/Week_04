/* 6. Filter Streams - Convert Uppercase to Lowercase
📌 Problem Statement:
Create a program that reads a text file and writes its contents into another file, converting all uppercase letters to lowercase.
Requirements:
Use FileReader and FileWriter.
Use BufferedReader and BufferedWriter for efficiency.
Handle character encoding issues.
 */
package com.filter_streams;

import java.io.*;

public class UppercaseToLowercase {
    public static void main(String[] args) {
        String inputFile = "D:\\Week_04\\Day_03\\src\\com\\filter_streams\\TestFile.txt" ; // Original file
        String outputFile = "D:\\Week_04\\Day_03\\src\\com\\filter_streams\\Generated_File.txt"; // Lowercase converted file

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase()); // Convert to lowercase
                bw.newLine();
            }

            System.out.println("File converted to lowercase successfully!");

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
