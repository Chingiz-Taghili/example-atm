package menu.mainmenu;

import bean.OrdinaryClient;
import menu.mainmenu.inter.MinusBalanceInter;
import util.Input;

public class MinusBalance implements MinusBalanceInter {

    public void process(OrdinaryClient orClnt) {
        int amount = Input.number("Nağdlaşdırılacaq məbləği daxil edin");
        orClnt.minusCardBalance(amount);
        System.out.println("Pul nağdlaşdırıldı!\n");
    }
}
