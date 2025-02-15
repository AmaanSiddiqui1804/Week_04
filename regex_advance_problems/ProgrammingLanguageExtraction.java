package com.regex_advance_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class ProgrammingLanguageExtraction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Regex for extracting programming language names
        String regex = "\\b(JavaScript|Java|Python|Cpp|C|C#|Ruby|Go|Swift|PHP|Kotlin|Rust)\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        System.out.print("Enter count: ");
        int n = input.nextInt();
        input.nextLine(); // Consume leftover newline

        while (n-- > 0) {
            System.out.print("Enter a sentence to extract programming languages: ");
            String sentence = input.nextLine().trim();

            Matcher matcher = pattern.matcher(sentence);
            ArrayList<String> languages = new ArrayList<>();

            while (matcher.find()) {
                languages.add(matcher.group());
            }

            if (!languages.isEmpty()) {
                System.out.println(String.join(", ", languages));
            } else {
                System.out.println("No programming languages found.");
            }
        }
        input.close();
    }
}

