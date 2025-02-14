/* Implement a Shopping Cart
Description:
Use HashMap to store product prices.
Use LinkedHashMap to maintain the order of items added.
Use TreeMap to display items sorted by price.
 */
package com.banking_system;

import java.util.*;

class Banking {
    private Map<String, Double> accounts = new HashMap<>();       // Stores account balances
    private TreeMap<Double, String> sortedAccounts = new TreeMap<>(); // Sorts accounts by balance
    private Queue<String> withdrawalQueue = new LinkedList<>();   // Queue for withdrawal requests

    // Add a new account
    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    // Deposit money
    public void deposit(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }
        double newBalance = accounts.get(accountNumber) + amount;
        sortedAccounts.remove(accounts.get(accountNumber)); // Remove old balance
        accounts.put(accountNumber, newBalance);
        sortedAccounts.put(newBalance, accountNumber); // Insert new balance
    }

    // Request withdrawal
    public void requestWithdrawal(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }
        withdrawalQueue.add(accountNumber);
    }

    // Process withdrawal requests
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accountNumber);
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("Accounts Sorted by Balance: " + sortedAccounts);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Banking bank = new Banking();

        // Adding accounts
        bank.addAccount("SBI121", 5000);
        bank.addAccount("SBI122", 7000);
        bank.addAccount("SBI123", 3000);

        // Deposit money
        bank.deposit("SBI121", 2000);

        // Request withdrawals
        bank.requestWithdrawal("SBI123");
        bank.requestWithdrawal("SBI121");

        // Displaying sorted accounts
        bank.displaySortedAccounts();

        // Processing withdrawal requests
        bank.processWithdrawals();
    }
}
