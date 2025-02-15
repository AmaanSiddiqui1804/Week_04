/* Extract All Capitalized Words from a Sentence
🔹 Example Text:
"The Eiffel Tower is in Paris and the Statue of Liberty is in New York."
🔹 Expected Output:
Eiffel, Tower, Paris, Statue, Liberty, New, York
 */
package com.regex_extraction_problems;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedSentence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String regex = "\\b[A-Z][a-z]+\\b";
        Pattern pattern = Pattern.compile(regex);

        System.out.print("Enter count: ");
        int n = input.nextInt();
        input.nextLine(); // Consume leftover newline

        while (n-- > 0) {
            System.out.print("Enter a sentence to extract capital letter words: ");
            String sentence = input.nextLine().trim();

            Matcher matcher = pattern.matcher(sentence);

            ArrayList<String> capitalizedWords = new ArrayList<>();

            while (matcher.find()) {
                capitalizedWords.add(matcher.group());
            }

            if (!capitalizedWords.isEmpty()) {
                System.out.println(String.join(", ", capitalizedWords));
            }else {
                System.out.println("No capitalized word found.");
            }
        }
        input.close();
    }
}
