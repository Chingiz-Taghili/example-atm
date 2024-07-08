package menu.mainmenu;

import bean.OrdinaryClient;
import menu.mainmenu.inter.PlusBalanceInter;
import util.Input;

public class PlusBalance implements PlusBalanceInter {

    public void process(OrdinaryClient orClnt) {
        int amount = Input.number("Artırılacaq məbləği daxil edin");
        orClnt.plusCardBalance(amount);
        System.out.println("Balans uğurla artırıldı!\n");
    }
}
