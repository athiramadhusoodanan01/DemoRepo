public class BrokenAccessControlExample {
    public void checkAuthorization(String role) {
        // Check for null to avoid NullPointerException
        if (role == null) {
            System.out.println("Invalid role provided.");
            return;
        }

        // Use equalsIgnoreCase to avoid case sensitivity issues
        if ("admin".equalsIgnoreCase(role.trim())) {
            // Allow access to sensitive resources
            System.out.println("Admin access granted.");
        } else {
            // Deny access
            System.out.println("Access denied.");
        }
    }

    public static void main(String[] args) {
        BrokenAccessControlExample example = new BrokenAccessControlExample();
        // Check if args length is appropriate before accessing
        if (args.length > 0) {
            example.checkAuthorization(args[0]);
        } else {
            System.out.println("No role provided.");
        }
    }
}