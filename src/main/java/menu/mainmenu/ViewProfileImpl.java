package menu.mainmenu;

import bean.Client;
import bean.Data;
import bean.OrdinaryClient;
import bean.PremiumClient;
import menu.mainmenu.inter.ViewProfile;
import util.Check;
import util.File;
import util.Input;
import util.Show;

public class ViewProfileImpl implements ViewProfile {

    public void process(Client client) {
        System.out.println("Ad: " + client.getName() +
                "\nSoyad: " + client.getSurname() +
                "\nKart nömrəsi: ********" + client.getCardNumber() +
                "\nKartın pin kodu: " + client.getCardPinCode() + "\n");

        int selectedMenu = Input.number("1. Məlumatları yenilə\n2. Əsas menyuya qayıt");

        if (selectedMenu == 1) {
            String newName = Input.text("Yeni adı daxil edin");
            String newSurname = Input.text("Yeni soyadı daxil edin");
            String newPinCode = Check.cardPinCode(Input.text("Yeni pin kodu daxil edin"));

            Client newClient;
            if (client.isPremium()) {
                newClient = new PremiumClient(newName, newSurname, client.getCardNumber(), newPinCode, client.getCardBalance());
            } else {
                newClient = new OrdinaryClient(newName, newSurname, client.getCardNumber(), newPinCode, client.getCardBalance());
            }
            for (int i = 0; i < Data.instance().getClients().size(); i++) {
                if (Data.instance().getClients().get(i) == client) {
                    Data.instance().getClients().remove(i);
                    Data.instance().getClients().add(i, newClient);
                    File.writeObject(Data.instance(), "src/main/resources/Database.obj");
                    System.out.println("Məlumatlarınız uğurla yeniləndi!\n");
                    break;
                }
            }
            Show.mainMenu(newClient);

        } else if (selectedMenu == 2) {
            Show.mainMenu(client);
        } else {
            System.out.println("Menyunu düzgün daxil edin!\n");
        }
    }
}
