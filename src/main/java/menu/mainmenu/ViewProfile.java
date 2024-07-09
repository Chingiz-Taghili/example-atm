package menu.mainmenu;

import bean.Client;
import bean.PremiumClient;
import menu.mainmenu.inter.ViewProfileInter;
import util.Check;
import util.Input;
import util.Show;

import java.awt.*;

public class ViewProfile implements ViewProfileInter {

    public void process(Client client) {
        System.out.println("Ad: " + client.getName() +
                "\nSoyad: " + client.getSurname() +
                "\nKart nömrəsi: " + client.getCardNumber() +
                "\nKartın pin kodu: " + client.getCardPinCode());

        int selectedMenu = Input.number("1. Məlumatları yenilə\n4. Əsas menyuya qayıt");

        if (selectedMenu == 1) {
            String newName = Input.text("Yeni adı daxil edin");
            String newSurname = Input.text("Yeni soyadı daxil edin");
            String newPinCode = Check.cardPinCode(Input.text("Yeni pin kodu daxil edin"));
        } else if (selectedMenu == 2) {
            Show.mainMenu(client);
        } else {
            System.out.println("Menyunu düzgün daxil edin!");
        }
    }
}
