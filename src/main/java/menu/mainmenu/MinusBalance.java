package menu.mainmenu;

import bean.OrdinaryClient;
import menu.mainmenu.inter.MinusBalanceInter;
import util.Check;
import util.Input;

public class MinusBalance implements MinusBalanceInter {

    public void process(OrdinaryClient orClnt) {
        int amount = Check.amount(Input.text("Nağdlaşdırılacaq məbləği daxil edin"
                + " (Balans: " + orClnt.getCardBalance() + " AZN)"));

        while (amount > orClnt.getCardBalance()) {
            amount = Check.amount(Input.text("Nağdlaşdıra biləcəyiniz maksimum məbləğ: "
                    + orClnt.getCardBalance() + " AZN"));
        }
        orClnt.minusCardBalance(amount);
        System.out.println("Pul nağdlaşdırıldı!\n");
    }
}
