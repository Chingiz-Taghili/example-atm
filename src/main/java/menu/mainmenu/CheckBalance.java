package menu.mainmenu;

import bean.Client;
import menu.mainmenu.inter.CheckBalanceInter;

public class CheckBalance implements CheckBalanceInter {

    public void process(Client client) {
        System.out.println("Balansınız: " + client.getCardBalance() + " AZN\n");
    }
}
