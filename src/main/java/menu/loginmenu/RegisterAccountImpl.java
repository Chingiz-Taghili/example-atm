package menu.loginmenu;

import bean.Client;
import bean.OrdinaryClient;
import bean.Data;
import bean.PremiumClient;
import util.Check;
import util.File;
import util.Input;
import util.Show;

import java.util.Random;

public class RegisterAccountImpl implements menu.loginmenu.inter.RegisterAccount {

    public void process() {

        Client client;

        String[] nameAndSurnameArr = Check.nameAndSurname(
                Input.text("Adınız və soyadınız"));

        if (Check.accountExistence(nameAndSurnameArr)) {
            return;
        }

        String cardPinCode = Check.cardPinCode(
                Input.text("Kartınızın 4 rəqəmli pin kodu"));

        int isPremium = Input.number("Premium tarifə üzv olmaq istəyirsiniz? (Qiyməti: 50 AZN)" +
                "\n1. Əlbəttə istəyirəm" +
                "\n2. Maraqlı deyil");

        while (isPremium != 1 && isPremium != 2) {
            isPremium = Input.number("Menyunu düzgün daxil edin!");
        }

        Random rnd = new Random();
        int cardNumber = rnd.nextInt(11111111, 99999999);

        if (isPremium == 1) {
            client = new PremiumClient(nameAndSurnameArr[0], nameAndSurnameArr[1], cardNumber, cardPinCode, -50);
        } else {
            client = new OrdinaryClient(nameAndSurnameArr[0], nameAndSurnameArr[1], cardNumber, cardPinCode, 0);
        }

        Data.instance().getClients().add(client);
        File.writeObject(Data.instance(), "src/main/resources/Database.obj");
        System.out.println("Təbriklər " + client.getName() + " " + client.getSurname()
                + ". Qeydiyyatınız uğurla tamamlandı!\n");
        Show.mainMenu(client);
    }
}
