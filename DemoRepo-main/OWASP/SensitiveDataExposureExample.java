import java.util.logging.Logger;

public class SensitiveDataExposureExample {
    private static final Logger logger = Logger.getLogger(SensitiveDataExposureExample.class.getName());

    public void sendCreditCardInfo(String creditCardNumber) {
        // Corrected: Use logger instead of System.out.println for better practice and to avoid console output in production
        logger.warning("Attempt to send sensitive data over insecure channel.");
        // Note: Ideally, credit card information should be sent over a secure, encrypted channel (e.g., HTTPS).
    }

    public static void main(String[] args) {
        SensitiveDataExposureExample example = new SensitiveDataExposureExample();
        example.sendCreditCardInfo("1234567890123456");
    }
}