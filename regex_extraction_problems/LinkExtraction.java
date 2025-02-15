/*  Extract Links from a Web Page
🔹 Example Text:
"Visit https://www.google.com and http://example.org for more info."
🔹 Expected Output:
https://www.google.com, http://example.org
 */
package com.regex_extraction_problems;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkExtraction {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String regex = "https?://(?:www\\.)?[a-zA-Z0-9.-]+(?:/[\\w-./?%&=]*)?";
        Pattern pattern = Pattern.compile(regex);

        System.out.print("Enter count: ");
        int n = input.nextInt();
        input.nextLine(); // Consume leftover newline

        while (n-- > 0) {
            System.out.print("Enter a sentence to extract links: ");
            String sentence = input.nextLine().trim();

            Matcher matcher = pattern.matcher(sentence);

            ArrayList<String> links = new ArrayList<>();

            while (matcher.find()) {
                links.add(matcher.group());
            }

            if (!links.isEmpty()) {
                System.out.println(String.join(", ", links));
            }else {
                System.out.println("No valid links found.");
            }
        }
        input.close();
    }
}
