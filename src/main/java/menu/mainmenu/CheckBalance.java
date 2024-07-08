package menu.mainmenu;

import bean.OrdinaryClient;
import menu.mainmenu.inter.CheckBalanceInter;

public class CheckBalance implements CheckBalanceInter {

    public void process(OrdinaryClient orClnt) {
        System.out.println("Balansınız: " + orClnt.getCardBalance() + " AZN\n");
    }
}
