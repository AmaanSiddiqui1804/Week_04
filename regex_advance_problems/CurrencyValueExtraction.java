/* Extract Currency Values from a Text
🔹 Example Text:
"The price is $45.99, and the discount is 10.50."
🔹 Expected Output:
$45.99, 10.50
 */
package com.regex_advance_problems;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class CurrencyValueExtraction {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Regex for extracting currency values (45.99 or 10.50)
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);

        System.out.print("Enter count: ");
        int n = input.nextInt();
        input.nextLine(); // Consumes leftover newline

        while (n-- > 0) {
            System.out.print("Enter a sentence to extract currency values in format (nn.nn): ");
            String sentence = input.nextLine().trim();

            Matcher matcher = pattern.matcher(sentence);
            ArrayList<String> values = new ArrayList<>();

            while (matcher.find()) {
                values.add(matcher.group());
            }

            if (!values.isEmpty()) {
                System.out.println(String.join(", ", values));
            } else {
                System.out.println("No currency values found.");
            }
        }
        input.close();
    }
}
