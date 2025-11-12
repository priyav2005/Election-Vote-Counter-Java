package com.election;

import java.util.ArrayList;
import java.util.Scanner;

public class Election {
    private DatabaseHandler db;

    public Election(DatabaseHandler db) {
        this.db = db;
    }

    public void registerCandidates(Scanner sc) {
        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        db.clearCandidates();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter candidate " + i + " name: ");
            String name = sc.nextLine();
            db.insertCandidate(name);
        }

        System.out.println("✅ Candidates registered successfully in database!");
    }

    public void conductVoting(Scanner sc) {
        ArrayList<Candidate> candidates = db.getAllCandidates();
        if (candidates.isEmpty()) {
            System.out.println("⚠️ No candidates registered yet!");
            return;
        }

        System.out.print("Enter number of voters: ");
        int voters = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= voters; i++) {
            System.out.println("\nVote #" + i + ": Enter candidate name to vote for:");
            for (Candidate c : candidates)
                System.out.println("- " + c.getName());
            System.out.print("Your vote: ");
            String voteName = sc.nextLine();
            db.updateVote(voteName);
        }

        System.out.println("✅ Voting completed and saved in database!");
    }

    public void displayResults() {
        ArrayList<Candidate> candidates = db.getAllCandidates();

        if (candidates.isEmpty()) {
            System.out.println("⚠️ No results to display!");
            return;
        }

        System.out.println("\n----- Election Results -----");
        Candidate winner = candidates.get(0);

        for (Candidate c : candidates) {
            System.out.println(c.getName() + " received " + c.getVotes() + " votes.");
            if (c.getVotes() > winner.getVotes()) {
                winner = c;
            }
        }

        System.out.println("\n🏆 Winner: " + winner.getName() + " with " + winner.getVotes() + " votes!");
    }
}
