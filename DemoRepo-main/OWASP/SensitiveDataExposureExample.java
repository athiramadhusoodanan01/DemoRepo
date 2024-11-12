import java.util.logging.Logger;

public class SensitiveDataExposureExample {
    private static final Logger logger = Logger.getLogger(SensitiveDataExposureExample.class.getName());

    public void sendCreditCardInfo(String creditCardNumber) {
        // Corrected: Use logging instead of System.out.println for better practice and to avoid sensitive data exposure in logs
        logger.warning("Attempting to send sensitive data, operation not allowed.");
    }

    public static void main(String[] args) {
        SensitiveDataExposureExample example = new SensitiveDataExposureExample();
        example.sendCreditCardInfo("1234567890123456");
    }
}