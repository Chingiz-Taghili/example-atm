package bean;

public class PremiumClient extends Client {

    public PremiumClient(String name, String surname, int cardNumber, String cardPinCode) {
        super(name, surname, cardNumber, cardPinCode, true);
    }
}
