package com.election;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/election_db";
    private static final String USER = "root"; // change if different
    private static final String PASSWORD = "Priya@1204"; // your MySQL password

    private Connection conn;

    public DatabaseHandler() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed!");
            e.printStackTrace();
        }
    }

    public void insertCandidate(String name) {
        try {
            String query = "INSERT INTO candidates (name, votes) VALUES (?, 0)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Candidate> getAllCandidates() {
        ArrayList<Candidate> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM candidates";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Candidate(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("votes")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateVote(String name) {
        try {
            String query = "UPDATE candidates SET votes = votes + 1 WHERE name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearCandidates() {
        try {
            String query = "DELETE FROM candidates";
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

