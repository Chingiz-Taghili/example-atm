package bean;

public abstract class Client {

    private String name;
    private String surname;
    private int cardNumber;
    private String cardPinCode;
    private boolean premium;
    private int cardBalance;

    public Client(String name, String surname, int cardNumber, String cardPinCode, int cardBalance, boolean premium) {
        this.name = name;
        this.surname = surname;
        this.cardNumber = cardNumber;
        this.cardPinCode = cardPinCode;
        this.premium = premium;
        this.cardBalance = cardBalance;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getCardPinCode() {
        return cardPinCode;
    }

    public boolean isPremium() {
        return premium;
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

    public String toString() {

        return name + " " + surname + " (********" + getCardNumber() + ")";
    }
}
