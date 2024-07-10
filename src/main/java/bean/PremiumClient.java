package bean;

public class PremiumClient extends Client {

    public PremiumClient(String name, String surname, int cardNumber, String cardPinCode, int cardBalance) {
        super(name, surname, cardNumber, cardPinCode, cardBalance, true);
    }
}
