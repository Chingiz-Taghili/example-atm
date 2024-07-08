package menu.mainmenu;

import bean.Client;
import menu.mainmenu.inter.PlusBalanceInter;
import util.Check;
import util.Input;

public class PlusBalance implements PlusBalanceInter {

    public void process(Client client) {

        int amount = Check.amount(Input.text("Artırılacaq məbləği daxil edin"));
        client.plusCardBalance(amount);
        System.out.println("Balans uğurla artırıldı!\n");
    }
}
