package bean;

public class OrdinaryClient extends Client {

    public OrdinaryClient(String name, String surname, int cardNumber, String cardPinCode, int cardBalance) {
        super(name, surname, cardNumber, cardPinCode, cardBalance, false);
    }
}
