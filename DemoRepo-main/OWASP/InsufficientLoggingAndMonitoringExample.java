import java.util.logging.Logger;

public class InsufficientLoggingAndMonitoringExample {
    private static final Logger logger = Logger.getLogger(InsufficientLoggingAndMonitoringExample.class.getName());

    public static void main(String[] args) {
        // Improved logging using java.util.logging.Logger
        logger.info("Action performed");
    }
}