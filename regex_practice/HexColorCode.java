package com.regex_practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColorCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "^#([0-9A-Fa-f]{6})$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("Enter count of colour codes: ");
        int n = input.nextInt();
        while (n--> 0) {
            System.out.println("Enter Colour codes: ");
            String colourCode = input.next();
            Matcher matcher = pattern.matcher(colourCode);
            System.out.println(colourCode + " is valid: " + matcher.matches());
        }
    }
}
