public class BrokenAccessControlExample {
    public void checkAuthorization(String role) {
        if (role.equals("admin")) {
            // Allow access to sensitive resources
            System.out.println("Admin access granted.");
        } else {
            // Deny access
            System.out.println("Access denied.");
        }
    }

    public static void main(String[] args) {
        BrokenAccessControlExample example = new BrokenAccessControlExample();
        example.checkAuthorization("user");
    }
}