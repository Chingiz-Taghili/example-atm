package menu.mainmenu;

import bean.OrdinaryClient;
import util.Input;

public class PlusBalance {

    public static void process(OrdinaryClient orClnt) {
        int amount = Input.inputNumber("Artırılacaq məbləği daxil edin");
        orClnt.plusCardBalance(amount);
        System.out.println("Balans uğurla artırıldı!\n");
    }
}
