import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryManagement extends JFrame {
    private BookManager bookManager = new BookManager();
    private IssueManager issueManager = new IssueManager();

    public LibraryManagement() {
        setTitle("Library Management System");

        JButton addBookButton = new JButton("Add Book");
        JButton viewBooksButton = new JButton("View Books");
        JButton issueBookButton = new JButton("Issue Book");
        JButton returnBookButton = new JButton("Return Book");

        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Add Book
                String title = JOptionPane.showInputDialog("Enter Book Title:");
                String author = JOptionPane.showInputDialog("Enter Author:");
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));
                bookManager.addBook(title, author, quantity);
            }
        });

        viewBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle View Books
                bookManager.viewBooks();
            }
        });

        issueBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Issue Book
                int bookId = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID to Issue:"));
                String studentName = JOptionPane.showInputDialog("Enter Student Name:");
                issueManager.issueBook(bookId, studentName, new java.util.Date(), new java.util.Date());
            }
        });

        returnBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Return Book
                int bookId = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID to Return:"));
                issueManager.returnBook(bookId);
            }
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(addBookButton);
        add(viewBooksButton);
        add(issueBookButton);
        add(returnBookButton);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
