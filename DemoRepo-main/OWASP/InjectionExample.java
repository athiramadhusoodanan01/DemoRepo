import java.sql.*;

public class InjectionExample {
    public static void main(String[] args) {
        String userInput = "'; DROP TABLE users;";
        // Use PreparedStatement to avoid SQL Injection
        String sql = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Changed to PreparedStatement
            pstmt.setString(1, userInput); // Set userInput safely
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}