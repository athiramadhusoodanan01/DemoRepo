public class BrokenAuthenticationExample {
    public boolean authenticate(String username, String password) {
        // Use constant time comparison to prevent timing attacks
        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BrokenAuthenticationExample auth = new BrokenAuthenticationExample();
        // Check for null or empty arguments to prevent NullPointerException
        if (args.length >= 2 && args[0] != null && args[1] != null) {
            if (auth.authenticate(args[0], args[1])) {
                System.out.println("Authentication successful.");
            } else {
                System.out.println("Authentication failed.");
            }
        } else {
            System.out.println("Invalid input.");
        }
    }
}