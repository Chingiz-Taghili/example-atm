package bean;

public class PremiumClient extends Client {

    public PremiumClient(String name, String surname, String cardNumber, String cardPinCode) {
        super(name, surname, cardNumber, cardPinCode, true);
    }
}
