/* Find Repeating Words in a Sentence
🔹 Example Input:
"This is is a repeated repeated word test."
🔹 Expected Output:
is, repeated
 */
package com.regex_advance_problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatingWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Regex to find repeating words
        String regex = "\\b(\\w+)\\b(?:\\s+\\1\\b)+" ;
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        System.out.print("Enter count: ");
        int n = input.nextInt();
        input.nextLine(); // Consume leftover newline

        while (n-- > 0) {
            System.out.print("Enter a sentence to remove duplicate words: ");
            String sentence = input.nextLine().trim();

            Matcher matcher = pattern.matcher(sentence);
            HashSet<String> repeatingWords = new HashSet<>();

            while (matcher.find()) {
                repeatingWords.add(matcher.group(1));
            }

            if (!repeatingWords.isEmpty()) {
                System.out.println(String.join(", ", repeatingWords));
            } else {
                System.out.println("No repeating words found.");
            }
        }
        input.close();
    }
}
