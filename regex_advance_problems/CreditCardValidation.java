/*  Validate a Credit Card Number (Visa, MasterCard, etc.)
A Visa card number starts with 4 and has 16 digits.
A MasterCard starts with 5 and has 16 digits.
 */
package com.regex_advance_problems;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CreditCardValidation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Regex for Visa (Starts with 4, 16 digits) and MasterCard (Starts with 5, 16 digits)
        String regex = "^(4\\d{15}|5\\d{15})$";
        Pattern pattern = Pattern.compile(regex);

        System.out.print("Enter count: ");
        int n = input.nextInt();
        input.nextLine(); // Consume leftover newline

        while (n-- > 0) {
            System.out.print("Enter a credit card number: ");
            String cardNumber = input.nextLine().replaceAll("\\s", ""); // Remove spaces

            if (pattern.matcher(cardNumber).matches()) {
                System.out.println("Valid Credit Card Number");
            } else {
                System.out.println("Invalid Credit Card Number");
            }
        }
        input.close();
    }
}
