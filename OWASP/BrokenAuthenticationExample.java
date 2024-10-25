public class BrokenAuthenticationExample {
    public boolean authenticate(String username, String password) {
        if (username.equals("admin") && password.equals("password")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BrokenAuthenticationExample auth = new BrokenAuthenticationExample();
        if (auth.authenticate("admin", "password")) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}