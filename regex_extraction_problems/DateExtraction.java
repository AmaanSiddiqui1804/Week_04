/* Extract Dates in dd/mm/yyyy Format
🔹 Example Text:
"The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020."
🔹 Expected Output:
12/05/2023, 15/08/2024, 29/02/2020
 */

package com.regex_extraction_problems;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtraction {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String regex = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(1[6-9][0-9]{2}|2[0-9]{3})\\b";
        Pattern pattern = Pattern.compile(regex);

        System.out.print("Enter count: ");
        int n = input.nextInt();
        input.nextLine(); // Consume leftover newline

        while (n-- > 0) {
            System.out.print("Enter a sentence to extract dates: ");
            String sentence = input.nextLine().trim();

            Matcher matcher = pattern.matcher(sentence);

            ArrayList<String> dates = new ArrayList<>();

            while (matcher.find()) {
                dates.add(matcher.group());
            }

            if (!dates.isEmpty()) {
                System.out.println(String.join(", ", dates));
            }else {
                System.out.println("No valid dates found.");
            }
        }
        input.close();
    }
}
