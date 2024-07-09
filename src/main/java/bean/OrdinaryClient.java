package bean;

public class OrdinaryClient extends Client {

    public OrdinaryClient(String name, String surname, int cardNumber, String cardPinCode) {
        super(name, surname, cardNumber, cardPinCode, false);
    }
}
