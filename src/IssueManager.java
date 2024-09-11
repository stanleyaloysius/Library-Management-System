import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class IssueManager {
    private Connection connection;

    public IssueManager() {
        connection = DBConnection.getConnection();
    }

    public void issueBook(int bookId, String studentName, Date issueDate, Date returnDate) {
        String sql = "INSERT INTO issued_books (book_id, student_name, issue_date, return_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            pstmt.setString(2, studentName);
            pstmt.setDate(3, new java.sql.Date(issueDate.getTime()));
            pstmt.setDate(4, new java.sql.Date(returnDate.getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int bookId) {
        String sql = "DELETE FROM issued_books WHERE book_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
