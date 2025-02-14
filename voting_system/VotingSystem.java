/* Design a Voting System
Description: Design a system where:
Votes are stored in a HashMap (Candidate -> Votes).
TreeMap is used to display the results in sorted order.
LinkedHashMap is used to maintain the order of votes.
 */
package com.voting_system;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class Voting {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> orderedVoteMap = new TreeMap<>();
    private Map<String, Integer> sortedVoteMap = new LinkedHashMap<>();

    //Method to cast a vote
    public void castVote(String candidate) {
        //Updating hashmap
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);

        //Updating linked hashmap
        if(!orderedVoteMap.containsKey(candidate)){
            orderedVoteMap.put(candidate, 0);
        }
        orderedVoteMap.put(candidate, orderedVoteMap.get(candidate)+ 1);

        //Updating tree map
        sortedVoteMap.put(candidate, orderedVoteMap.getOrDefault(candidate, 0)+1);
    }

    // Display results in sorted order (by candidate name)
    public void displaySortedResults() {
        System.out.println("Election Results (Sorted by Candidate Name): " + sortedVoteMap);
    }

    // Display results in order of voting
    public void displayVotesInOrder() {
        System.out.println("Votes in Order Cast: " + orderedVoteMap);
    }
}

public class VotingSystem {
    public static void main(String[] args) {
        Voting votingSystem = new Voting();

        // Casting votes
        votingSystem.castVote("Amaan");
        votingSystem.castVote("Amaan");
        votingSystem.castVote("Nishank");
        votingSystem.castVote("Abhay");
        votingSystem.castVote("Abhay");
        votingSystem.castVote("Amaan");

        // Displaying results
        votingSystem.displaySortedResults();  // Sorted results
        votingSystem.displayVotesInOrder();   // Order of voting
    }
}
