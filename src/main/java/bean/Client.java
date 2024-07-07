package bean;

public abstract class Client {

    private String name;
    private String surname;
    private String cardNumber;
    private int cardPassword;
    private int cardBalance;

    public Client(String name, String surname, String cardNumber, int cardPassword) {
        this.name = name;
        this.surname = surname;
        this.cardNumber = cardNumber;
        this.cardPassword = cardPassword;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCardPassword() {
        return cardPassword;
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
}
