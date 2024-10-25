import java.sql.*;

public class InjectionExample {
    public static void main(String[] args) {
        String userInput = "'; DROP TABLE users;";
        String sql = "SELECT * FROM users WHERE username = '" + userInput + "'";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
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