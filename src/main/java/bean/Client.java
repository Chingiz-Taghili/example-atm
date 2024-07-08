package bean;

public abstract class Client {

    private String name;
    private String surname;
    private String cardNumber;
    private String cardPinCode;
    private int cardBalance;

    public Client(String name, String surname, String cardNumber, String cardPinCode) {
        this.name = name;
        this.surname = surname;
        this.cardNumber = cardNumber;
        this.cardPinCode = cardPinCode;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCardNumber() {
        return "********" + cardNumber;
    }

    public String getCardPinCode() {
        return cardPinCode;
    }

    public int getCardBalance() {
        return cardBalance;
    }

    public void plusCardBalance(int amount) {
        this.cardBalance += amount;
    }

    public void minusCardBalance(int amount) {
        this.cardBalance -= amount;
    }

    public String toString(){

        return name + " " + surname + " (" + getCardNumber() + ")";
    }
}
