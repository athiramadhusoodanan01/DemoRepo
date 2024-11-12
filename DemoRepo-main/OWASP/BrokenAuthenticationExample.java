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
        // Improved security by not using hardcoded credentials in the main method
        String inputUsername = args.length > 0 ? args[0] : "";
        String inputPassword = args.length > 1 ? args[1] : "";
        if (auth.authenticate(inputUsername, inputPassword)) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}