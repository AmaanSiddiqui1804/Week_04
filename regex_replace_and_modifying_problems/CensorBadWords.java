/* Censor Bad Words in a Sentence
Given a list of bad words, replace them with ****.
🔹 Example Input:
"This is a damn bad example with some stupid words."
🔹 Expected Output:
"This is a **** bad example with some **** words."
 */
package com.regex_replace_and_modifying_problems;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CensorBadWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter bad words separated by space to remove: ");
        String badWordsInput = input.nextLine();

        String[] badWordsArray = badWordsInput.split("\\s+"); // Splitting by spaces

        // Constructing regex pattern with OR (|)
        String regex = String.join("|", badWordsArray);
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); // Case in-sensitive match

        System.out.println("Enter a sentence to censor bad words: ");
        String sentence = input.nextLine();

        // Replacing bad words with ****
        String replacedText = sentence.replaceAll(regex, "****");
        System.out.println("Replaced Text: " + replacedText);

        input.close();
    }
}

