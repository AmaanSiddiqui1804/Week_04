/* Insurance Policy Management System
Each policy has the following attributes:
● Policy Number (unique identifier)
● Policyholder Name
● Expiry Date
● Coverage Type (e.g., Health, Auto, Home)
● Premium Amount

Requirements:
1. Store Unique Policies: Implement methods to store policies using different
types of sets (HashSet, LinkedHashSet, TreeSet), each serving different
purposes:
 HashSet for quick lookups.
 LinkedHashSet to maintain the order of insertion.
 TreeSet to maintain policies sorted by expiry date.

2. Retrieve Policies: Implement methods to retrieve and display policies based on
certain criteria:
 All unique policies.
 Policies expiring soon (within the next 30 days)
 Policies with a specific coverage type.
 Duplicate policies based on policy numbers.

3. Performance Comparison: Compare the performance of HashSet,
LinkedHashSet, and TreeSet in terms of adding, removing, and searching for
policies.
 */
package com.insurance_policy_management_system1;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor
    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters
    public String getPolicyNumber() { return policyNumber; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }

    // Overriding equals() and hashCode() for HashSet to ensure uniqueness
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Implementing compareTo() for sorting in TreeSet (by expiry date)
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return String.format("Policy[%s, %s, %s, %s, %.2f]\n", policyNumber, policyHolderName, expiryDate, coverageType, premiumAmount);
    }
}

public class PolicyManagementSystem {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    // Adding policy to all sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieving all policies
    public void displayAllPolicies() {
        System.out.println("\nAll Policies (HashSet): " + hashSetPolicies);
        System.out.println("\nAll Policies (LinkedHashSet): " + linkedHashSetPolicies);
        System.out.println("\nAll Policies (TreeSet - Sorted by Expiry Date): " + treeSetPolicies);
    }

    // Getting policies expiring within 30 days
    public void displayExpiringSoon() {
        LocalDate today = LocalDate.now();
        for (Policy policy : treeSetPolicies) {
            if (ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30) {
                System.out.println("\nExpiring Soon: " + policy);
            }
        }
    }

    // Getting policies by coverage type
    public void displayPoliciesByCoverageType(String type) {
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println("\nPolicy of Type " + type + ": " + policy);
            }
        }
    }

    // Finding duplicate policies by policy number
    public void displayDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (!seen.add(policy.getPolicyNumber())) {
                System.out.println("Duplicate Policy Found: " + policy);
            }
        }
    }

    // Performance Comparison
    public void comparePerformance() {
        int numPolicies = 100000;
        List<Policy> policies = new ArrayList<>();
        for (int i = 0; i < numPolicies; i++) {
            policies.add(new Policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i % 365), "Health", 500 + i));
        }

        long start, end;

        // HashSet Performance
        start = System.nanoTime();
        Set<Policy> hashSet = new HashSet<>(policies);
        end = System.nanoTime();
        System.out.println("HashSet Insert Time: " + (end - start) + " ns");

        start = System.nanoTime();
        hashSet.contains(policies.get(numPolicies / 2));
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        hashSet.remove(policies.get(numPolicies / 2));
        end = System.nanoTime();
        System.out.println("HashSet Remove Time: " + (end - start) + " ns");

        // LinkedHashSet Performance
        start = System.nanoTime();
        Set<Policy> linkedHashSet = new LinkedHashSet<>(policies);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Insert Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSet.contains(policies.get(numPolicies / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSet.remove(policies.get(numPolicies / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Remove Time: " + (end - start) + " ns");

        // TreeSet Performance
        start = System.nanoTime();
        Set<Policy> treeSet = new TreeSet<>(policies);
        end = System.nanoTime();
        System.out.println("TreeSet Insert Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.contains(policies.get(numPolicies / 2));
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.remove(policies.get(numPolicies / 2));
        end = System.nanoTime();
        System.out.println("TreeSet Remove Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        PolicyManagementSystem manager = new PolicyManagementSystem();
        manager.addPolicy(new Policy("P100", "Amaan", LocalDate.now().plusDays(10), "Health", 1000));
        manager.addPolicy(new Policy("P101", "Nishank", LocalDate.now().plusDays(40), "Auto", 1500));
        manager.addPolicy(new Policy("P102", "Abhay", LocalDate.now().plusDays(40), "Home", 1500));

        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayPoliciesByCoverageType("Health");
        manager.displayDuplicatePolicies();
        manager.comparePerformance();
    }
}
