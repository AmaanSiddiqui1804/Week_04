/* Validate a Social Security Number (SSN)
🔹 Example Input:
"My SSN is 123-45-6789."
🔹 Expected Output:
✅ "123-45-6789" is valid
❌ "123456789" is invalid
 */
package com.regex_advance_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SocialSecurityNumberValidation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Regex for validating SSN (123-45-6789 format)
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);

        System.out.print("Enter count: ");
        int n = input.nextInt();
        input.nextLine(); // Consume leftover newline

        while (n-- > 0) {
            System.out.print("Enter social security number to validate: ");
            String sentence = input.nextLine();

            Matcher matcher = pattern.matcher(sentence);
            boolean found = false;

            while (matcher.find()) {
                System.out.println("\"" + matcher.group() + "\" is valid");
                found = true;
            }

            if (!found) {
                System.out.println("No valid SSN found.");
            }
        }
        input.close();
    }
}
