public class BrokenAccessControlExample {
    public void checkAuthorization(String role) {
        // Changed to use equalsIgnoreCase for case-insensitive comparison
        if ("admin".equalsIgnoreCase(role)) {
            // Allow access to sensitive resources
            System.out.println("Admin access granted.");
        } else {
            // Deny access
            System.out.println("Access denied.");
        }
    }

    public static void main(String[] args) {
        BrokenAccessControlExample example = new BrokenAccessControlExample();
        // Added null check for args to prevent potential NullPointerException
        if (args != null && args.length > 0) {
            example.checkAuthorization(args[0]);
        } else {
            System.out.println("No role provided.");
        }
    }
}