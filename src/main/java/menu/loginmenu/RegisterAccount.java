package menu.loginmenu;

import bean.Client;
import bean.OrdinaryClient;
import bean.Data;
import bean.PremiumClient;
import menu.loginmenu.inter.RegisterAccountInter;
import util.Check;
import util.Input;
import util.Show;

public class RegisterAccount implements RegisterAccountInter {

    public void process() {

        Client client;

        String[] nameAndSurnameArr = Check.nameAndSurname(
                Input.text("Adınız və soyadınız"));

        if (Check.accountExistence(nameAndSurnameArr)) {
            return;
        }

        String cardNumber = Check.cardNumber(
                Input.text("Kart nömrəsinin son 8 rəqəmi"));

        String cardPinCode = Check.cardPinCode(
                Input.text("Kartınızın 4 rəqəmli pin kodu"));

        int isPremium = Input.number("Premium tarifə üzv olmaq istəyirsiniz? (Qiyməti: 50 AZN)" +
                "\n1. Əlbəttə istəyirəm" +
                "\n2. Maraqlı deyil");

        while (isPremium != 1 && isPremium != 2) {
             isPremium = Input.number("Menyunu düzgün daxil edin!");
        }
        if (isPremium == 1) {
                client = new PremiumClient(nameAndSurnameArr[0], nameAndSurnameArr[1], cardNumber, cardPinCode);
                client.minusCardBalance(50);
            } else {
                client = new OrdinaryClient(nameAndSurnameArr[0], nameAndSurnameArr[1], cardNumber, cardPinCode);
            }

        Data.instance().getClients().add(client);
        System.out.println("Təbriklər " + client.getName() + " " + client.getSurname()
                + ". Qeydiyyatınız uğurla tamamlandı!\n");
        Show.mainMenu(client);
    }
}
