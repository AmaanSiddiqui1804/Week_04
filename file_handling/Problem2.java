/* 2. Buffered Streams - Efficient File Copy
📌 Problem Statement:
Create a Java program that copies a large file (e.g., 100MB) from one location to another using Buffered Streams (BufferedInputStream and BufferedOutputStream). Compare the performance with normal file streams.
Requirements:
Read and write in chunks of 4 KB (4096 bytes).
Use System.nanoTime() to measure execution time.
Compare execution time with unbuffered streams.
 */
package com.file_handling;

import java.io.*;

public class Problem2 {
    static void unbufferedStreamTime(String sourceFile, String destinationFile) {
        try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
             FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {

            int byteRead;
            while ((byteRead = fileInputStream.read()) != -1){
                fileOutputStream.write(byteRead);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    //Method for Buffered Stream reader
    static void bufferedStreamTime(String sourceFile, String destinationFile, int bufferSize) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile), bufferSize);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationFile),bufferSize)) {

            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1){
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }
            bufferedOutputStream.flush();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    //Main method
    public static void main(String[] args) {
        String sourceFile = "D:\\Week_04\\Day_03\\src\\com\\file_handling\\TextFile201.txt";  // Path to the source file
        String destinationFile = "D:\\Week_04\\Day_03\\src\\com\\file_handling\\TextFile202.txt"; // Path to the destination file
        int bufferSize = 4096; // 4 KB buffer

        // Measuring time for Buffered Stream copy
        long startTime = System.nanoTime();
        bufferedStreamTime(sourceFile, destinationFile, bufferSize);
        long endTime = System.nanoTime();
        System.out.println("Buffered Stream copy time: " + (endTime - startTime) + " ns");

        // Measuring time for Unbuffered Stream copy
        destinationFile = "D:\\Week_04\\Day_03\\src\\com\\file_handling\\TextFile203.txt"; // Path to the unbuffered copy
        startTime = System.nanoTime();
        unbufferedStreamTime(sourceFile, destinationFile);
        endTime = System.nanoTime();
        System.out.println("Unbuffered Stream copy time: " + (endTime - startTime) + " ns");
    }
}
