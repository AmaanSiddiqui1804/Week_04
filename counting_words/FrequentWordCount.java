/* 10. Count Words in a File
📌 Problem Statement:
Write a Java program that counts the number of words in a given text file and displays the top 5 most frequently occurring words.
Requirements:
Use FileReader and BufferedReader to read the file.
Use a HashMap<String, Integer> to count word occurrences.
Sort the words based on frequency and display the top 5.
 */
package com.counting_words;
import java.io.*;
import java.util.*;public class FrequentWordCount {

    public static void main(String[] args) {
        String filePath = "D:\\Week_04\\Day_03\\src\\com\\counting_words\\File To Count Words From.txt"; // File path

        HashMap<String, Integer> wordCount = new HashMap<>();
        int totalWordCount = 0;
        // Reading file and counting words
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+"); // Split on non-word chars
                for (String word : words) {
                    if (!word.isEmpty()) { // To Ignore empty strings
                        totalWordCount++;
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Sorting words by frequency in descending order
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        //Printing total word count
        System.out.println("Total Words: " + totalWordCount);
        // Printing top 5 most frequent words
        System.out.println("\n Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
            System.out.println(sortedWords.get(i).getKey() + " → " + sortedWords.get(i).getValue() + " times");
        }
    }
}
