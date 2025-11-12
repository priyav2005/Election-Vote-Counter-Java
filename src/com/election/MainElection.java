package com.election;

import java.util.Scanner;

public class MainElection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DatabaseHandler db = new DatabaseHandler();
        Election election = new Election(db);

        System.out.println("🗳️ Welcome to Election Vote Counter System (MySQL Version)");
        System.out.println("----------------------------------------------------------");

        int choice;
        do {
            System.out.println("\n📋 Menu:");
            System.out.println("1. Register Candidates");
            System.out.println("2. Conduct Voting");
            System.out.println("3. Display Results");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    election.registerCandidates(sc);
                    break;
                case 2:
                    election.conductVoting(sc);
                    break;
                case 3:
                    election.displayResults();
                    break;
                case 4:
                    System.out.println("👋 Exiting... Thank you!");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
