# Library Management System

## Overview

The Library Management System is a Java-based desktop application designed to manage library operations. This project provides a user-friendly graphical interface for managing books, issuing and returning them, and interacting with a MySQL database.

## Features

- **Add Books**: Add new books to the library database.
- **View Books**: View all books currently in the library.
- **Issue Book**: Issue a book to a student.
- **Return Book**: Return an issued book to the library.
- **Delete Book**: Remove a book from the library database.

## Technologies Used

- **Java**: Core language for application development.
- **Java Swing**: For creating the graphical user interface (GUI).
- **JDBC**: Java Database Connectivity for interacting with the MySQL database.
- **MySQL**: Database management system for storing book and issue data.

## Getting Started

### Prerequisites

- **Java JDK**: Ensure you have Java Development Kit (JDK) installed.
- **MySQL**: Install MySQL server and set up the database.
- **MySQL Connector/J**: Add the MySQL JDBC driver to your project’s classpath.

### Setup

1. **Clone the Repository**

   ```sh
   git clone <repository-url>
   cd LibraryManagementSystem

2. **Create the Database**

    Run the following SQL commands in your MySQL database client:

    ```sql
    CREATE DATABASE library_db;
    USE library_db;

    CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    author VARCHAR(100),
    quantity INT
    );

    CREATE TABLE issued_books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    student_name VARCHAR(100),
    issue_date DATE,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES books(id)
    );
    ```

3. **Configure Database Connection**

    Update the DBConnection.java file with your MySQL database credentials:

    ```java
    String url = "jdbc:mysql://localhost:3306/library_db";
    String username = "root";
    String password = "your_mysql_password";
    ```
    Build and Run the Project

    Compile and run the Java project using your preferred IDE or build tool:

    ```sh
    javac -d bin src/*.java
    java -cp bin LibraryManagement
    ```

    Alternatively, if you are using an IDE like IntelliJ IDEA or Eclipse, you can simply run the ``LibraryManagement`` class from the IDE.

## Usage
- **Add Book:** Click on the "Add Book" button, enter the book details, and add the book to the database.
- **View Books:** Click on the "View Books" button to display all books in the library.
- **Issue Book:** Click on the "Issue Book" button, enter the book ID and student details, and issue the book.
- **Return Book:** Click on the "Return Book" button, enter the book ID to return, and update the database.

## Project Structure
- ``src/``
    - ``LibraryManagement.java``: Main GUI class for the Library Management System.
    - ``DBConnection.java``: Manages database connection.
    - ``BookManager.java``: Handles book-related operations (add, view, delete).
    - ``IssueManager.java``: Manages book issuance and returns.

## Contributing
Feel free to fork the repository and submit pull requests. For any issues or suggestions, please open an issue in the repository.

## Acknowledgements
- Java Development Kit (JDK)
- MySQL Database
- Java Swing for GUI development