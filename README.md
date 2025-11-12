# 🗳️ Election Vote Counter System (Java + MySQL)

## 📌 Overview
The **Election Vote Counter** is a Java-based console application designed to simulate an electronic voting system.  
It allows users to **register candidates**, **conduct voting**, **display results**, and **store data** securely in a **MySQL database**.

This project demonstrates fundamental **Object-Oriented Programming (OOP)** concepts, **file handling**, and **database connectivity** using **JDBC**.

---

## 🚀 Features
✅ Register new candidates  
✅ Cast votes for registered candidates  
✅ Display election results  
✅ Store data in MySQL database  
✅ Save results to text file  
✅ User-friendly console interface  

---

## 🧩 Technologies Used
- **Java (JDK 8 or above)**
- **MySQL Database**
- **JDBC (Java Database Connectivity)**
- **Eclipse IDE**

---

## 🗂️ Project Structure
Election-Vote-Counter-Java/
│
├── src/
│ ├── MainElection.java # Main program file (menu)
│ ├── Candidate.java # Candidate class
│ ├── Election.java # Voting logic
│ ├── FileHandler.java # Save results to file
│ └── DatabaseHandler.java # Handles MySQL operations
│
├── database/
│ └── election_db.sql # SQL file to create database & table
│
└── README.md # Project documentation

yaml
Copy code

---

## 🛠️ MySQL Database Setup
1. Open **MySQL Workbench** or command line.
2. Create a new database:
   ```sql
   CREATE DATABASE election_db;
Use the database:

sql
Copy code
USE election_db;
Create the candidates table:

sql
Copy code
CREATE TABLE candidates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    votes INT DEFAULT 0
);
🔌 JDBC Configuration
Update your database credentials in DatabaseHandler.java:

java
Copy code
private static final String URL = "jdbc:mysql://localhost:3306/election_db";
private static final String USER = "root";
private static final String PASSWORD = "yourpassword";
Make sure you add the MySQL Connector JAR to your project build path.

▶️ How to Run
Clone the repository:

bash
Copy code
git clone https://github.com/priyav2005/Election-Vote-Counter-Java.git
Open in Eclipse IDE.

Configure JDBC Driver (MySQL Connector).

Run the project → MainElection.java.

Follow the on-screen menu to register candidates and start voting!

💾 Example Output
mathematica
Copy code
Welcome to Election Vote Counter System
----------------------------------------

 Menu:
1. Register Candidates
2. Conduct Voting
3. Display Results
4. Save Results to File
5. Exit

Enter your choice: 1
Enter candidate name: Priya
Enter candidate name: Raj
Candidates registered successfully!

Enter your choice: 2
Vote for: Raj
Vote recorded!

Enter your choice: 3
Election Results:
Raj - 1 votes
Priya - 0 votes
🧠 Concepts Used
Classes and Objects

Collections (ArrayList, HashMap)

File Handling

Exception Handling

JDBC Connection

CRUD Operations

👩‍💻 Author
Priyadharshini V
📧 GitHub Profile
🎓 B.Tech Information Technology

📜 License
This project is open-source and available under the MIT License.
