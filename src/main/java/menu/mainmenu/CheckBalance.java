package menu.mainmenu;

import bean.OrdinaryClient;

public class CheckBalance{

    public static void process(OrdinaryClient orClnt) {
        System.out.println("Balans: " + orClnt.getCardBalance() + " AZN\n");
    }
}
