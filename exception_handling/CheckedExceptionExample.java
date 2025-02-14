package com.exception_handling;
import java.io.*;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Week_04\\Day_04\\src\\com\\exception_handling\\Checked Exception TestFile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
