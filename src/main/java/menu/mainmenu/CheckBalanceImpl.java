package menu.mainmenu;

import bean.Client;
import menu.mainmenu.inter.CheckBalance;

public class CheckBalanceImpl implements CheckBalance {

    public void process(Client client) {
        System.out.println("Balansınız: " + client.getCardBalance() + " AZN\n");
    }
}
