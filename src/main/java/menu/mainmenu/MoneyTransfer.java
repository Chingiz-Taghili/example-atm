package menu.mainmenu;

import bean.OrdinaryClient;
import data.Data;
import util.Input;

public class MoneyTransfer {

    public static void process(OrdinaryClient orClnt) {

        int select = Input.inputNumber("1. Bank daxili hesaba köçür" +
                "\n2. Başqa bankın hesabına köçür");

        if (select == 1) {
            OrdinaryClient oc;
            for (int i = 0; i < Data.instance().getOrClnts().size(); i++) {
                oc = Data.instance().getOrClnts().get(i);
                if (oc == orClnt) {
                    continue;
                }
                System.out.println((i+1) + ". " + oc.getName() + " " + oc.getSurname());
            }
            int selectedAccount = Input.inputNumber("Köçürmək istədiyiniz hesabı seçin");
            oc = Data.instance().getOrClnts().get(selectedAccount-1);
            int amount = Input.inputNumber("Köçürüləcək məbləği daxil edin");
            orClnt.minusCardBalance(amount);
            oc.plusCardBalance(amount);
            System.out.println(amount + " AZN " + oc.getName() + " " + oc.getSurname() + " adlı hesaba köçürüldü!\n");
        } else if (select == 2) {
            Input.inputText("Köçürüləcək kartın 16 rəqəmli nömrəsini daxil edin");
            int amount = Input.inputNumber("Köçürüləcək məbləği daxil edin");
            orClnt.minusCardBalance(amount);
            System.out.println(amount + " AZN daxil etdiyiniz karta köçürüldü!\n");
        }
    }
}
