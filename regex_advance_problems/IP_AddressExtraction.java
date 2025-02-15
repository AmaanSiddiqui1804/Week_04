package com.regex_advance_problems;

import java.util.Scanner;
import java.util.regex.Pattern;

public class IP_AddressExtraction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Regex for validating IPv4 addresses
        String regex = "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(regex);

        System.out.print("Enter count: ");
        int n = input.nextInt();
        input.nextLine(); // Consuming leftover newline

        while (n-- > 0) {
            System.out.print("Enter an IP address: ");
            String ip = input.nextLine().trim();

            if (pattern.matcher(ip).matches()) {
                System.out.println("Valid IP address");
            } else {
                System.out.println("Invalid IP address! ");
            }
        }
        input.close();
    }
}
