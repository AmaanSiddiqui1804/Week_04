/* Extraction Problems
4️⃣ Extract All Email Addresses from a Text
🔹 Example Text:
"Contact us at support@example.com and info@company.org"
🔹 Expected Output:
support@example.com
info@company.org
 */
package com.regex_extraction_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtraction {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String regex = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b";
    Pattern pattern = Pattern.compile(regex);

    System.out.print("Enter count: ");
    int n = input.nextInt();
    input.nextLine(); // Consume leftover newline

    while (n-- > 0) {
        System.out.print("Enter a sentence with email address(es): ");
        String sentence = input.nextLine().trim();

        Matcher matcher = pattern.matcher(sentence);
        boolean found = false;

        while (matcher.find()) {
            System.out.println("Extracted email: " + matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("No valid email addresses found.");
        }
    }
    input.close();
    }
}
