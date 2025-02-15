/*  Validate a License Plate Number
License plate format: Starts with two uppercase letters, followed by four digits.
Example: "AB1234" is valid, but "A12345" is invalid.
 */
package com.regex_practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LicensePlate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "^[A-Z][A-Z][0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("Enter count to check License Plates: ");
        int n = input.nextInt();
        while (n--> 0) {
            System.out.println("Enter License Plate");
            String licensePlate = input.next();
            Matcher matcher = pattern.matcher(licensePlate);
            System.out.println(licensePlate + " is valid: " + matcher.matches());
        }
    }
}
