package com.insurance_policy_management_system2;

import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyHolder;
    LocalDate expiryDate;
    double premiumAmount;

    public Policy(String policyNumber, String policyHolder, LocalDate expiryDate, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return String.format("\nPolicy \n[%s, %s, %s, Rs %.2f]", policyNumber, policyHolder, expiryDate, premiumAmount);
    }
}

class InsurancePolicyManagement {
    Map<String, Policy> policyMap = new HashMap<>();
    Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> policyByExpiry = new TreeMap<>();

    // Add a policy to all maps
    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);

        policyByExpiry.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    // Retrieve a policy by policy number
    public Policy getPolicy(String policyNumber) {
        return policyMap.getOrDefault(policyNumber, null);
    }

    // List all policies expiring within the next 30 days
    public List<Policy> getExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);
        List<Policy> expiringPolicies = new ArrayList<>();

        for (Map.Entry<LocalDate, List<Policy>> entry : policyByExpiry.subMap(today, true, next30Days, true).entrySet()) {
            expiringPolicies.addAll(entry.getValue());
        }
        return expiringPolicies;
    }

    // List policies for a specific policyholder
    public List<Policy> getPoliciesByHolder(String holder) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyHolder.equalsIgnoreCase(holder)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        for (LocalDate date : new ArrayList<>(policyByExpiry.headMap(today, true).keySet())) {
            for (Policy policy : policyByExpiry.get(date)) {
                policyMap.remove(policy.policyNumber);
                orderedPolicyMap.remove(policy.policyNumber);
            }
            policyByExpiry.remove(date);
        }
    }

    // Display all policies in insertion order
    public void displayAllPolicies() {
        System.out.println("\n\tAll Policies \n(Insertion Order): " + orderedPolicyMap.values());
    }
}

public class InsurancePolicy {
    public static void main(String[] args) {
        InsurancePolicyManagement view = new InsurancePolicyManagement();

        // Adding policies
        view.addPolicy(new Policy("P100", "Amaan", LocalDate.now().plusDays(10), 1000));
        view.addPolicy(new Policy("P101", "Amaan", LocalDate.now().plusDays(40), 1500));
        view.addPolicy(new Policy("P102", "Nishank", LocalDate.now().plusDays(5), 1200));
        view.addPolicy(new Policy("P103", "Tikesh", LocalDate.now().minusDays(1), 900)); // Expired

        // Display policies
        view.displayAllPolicies();

        // Retrieve a specific policy
        System.out.println("Policy P100: " + view.getPolicy("P100"));

        // List policies expiring soon
        System.out.println("\n\tPolicies Expiring Soon: " + view.getExpiringSoon());

        // List policies by policyholder
        System.out.println("\nPolicies for Amaan: " + view.getPoliciesByHolder("Amaan"));

        // Remove expired policies
        view.removeExpiredPolicies();
        System.out.println("\nPolicies after removing expired: " + view.policyMap.values());
    }
}
