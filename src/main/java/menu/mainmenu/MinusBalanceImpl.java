package menu.mainmenu;

import bean.Client;
import bean.Data;
import menu.mainmenu.inter.MinusBalance;
import util.Check;
import util.File;
import util.Input;

public class MinusBalanceImpl implements MinusBalance {

    public void process(Client client) {
        if (client.getCardBalance() <= 0) {
            System.out.println("Balansınızda vəsait yoxdur!\n");
            return;
        }

        int amount = Check.amount(Input.text("Nağdlaşdırılacaq məbləği daxil edin"
                + " (Balans: " + client.getCardBalance() + " AZN)"));

        while (amount > client.getCardBalance()) {
            amount = Check.amount(Input.text("Nağdlaşdıra biləcəyiniz maksimum məbləğ: "
                    + client.getCardBalance() + " AZN"));
        }
        client.minusCardBalance(amount);
        File.writeObject(Data.instance(), "src/main/resources/Database.obj");
        System.out.println("Pul nağdlaşdırıldı!\n");
    }
}
