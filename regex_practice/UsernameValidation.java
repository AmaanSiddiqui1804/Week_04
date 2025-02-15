/*Regex Problems
1️⃣ Validate a Username
A valid username:
Can only contain letters (a-z, A-Z), numbers (0-9), and underscores (_)
Must start with a letter
Must be between 5 to 15 characters long
🔹 Example Inputs & Outputs
✅ "user_123" → Valid
❌ "123user" → Invalid (starts with a number)
❌ "us" → Invalid (too short)
 */

package com.regex_practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String regex = "^[a-zA-Z][A-Z0-9a-z_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("Enter number of usernames: ");
        int n = input.nextInt();
        String[] usernames = new String[n];
        for (int i = 0; i < n; i++) {
            usernames[i] = input.next().trim();
        }

        for (String userName : usernames){
            Matcher matcher = pattern.matcher(userName);
            System.out.println(userName + " is valid: " + matcher.matches());
        }
    }
}
/*
import java.util.regex.*;
public class EmailValidation {
    public static void main(String[] args) {
        String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        String[] emails = {"test@example.com", "invalid@", "user@domain"};


        for (String email : emails) {
            Matcher matcher = pattern.matcher(email);
            System.out.println(email + " is valid: " + matcher.matches());
        }
    }


 */
