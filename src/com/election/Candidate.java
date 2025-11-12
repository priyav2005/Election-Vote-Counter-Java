package com.election;
public class Candidate {
    private int id;
    private String name;
    private int votes;

    public Candidate(int id, String name, int votes) {
        this.id = id;
        this.name = name;
        this.votes = votes;
    }

    public Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote() {
        this.votes++;
    }

    @Override
    public String toString() {
        return name + " (" + votes + " votes)";
    }
}
