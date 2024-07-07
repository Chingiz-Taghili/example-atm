package menu.mainmenu;

import bean.OrdinaryClient;
import util.Input;

public class MinusBalance {

    public static void process(OrdinaryClient orClnt) {
        int amount = Input.inputNumber("Nağdlaşdırılacaq məbləği daxil edin");
        orClnt.minusCardBalance(amount);
        System.out.println("Pul nağdlaşdırıldı!\n");
    }
}
