public class SensitiveDataExposureExample {
    public void sendCreditCardInfo(String creditCardNumber) {
        // Send credit card number over HTTP without encryption
        System.out.println("Sending credit card number: " + creditCardNumber);
    }

    public static void main(String[] args) {
        SensitiveDataExposureExample example = new SensitiveDataExposureExample();
        example.sendCreditCardInfo("1234567890123456");
    }
}