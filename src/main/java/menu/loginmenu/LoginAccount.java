package menu.loginmenu;

import bean.OrdinaryClient;
import data.Data;
import util.Input;
import util.Menu;

public class LoginAccount {

    public static void process() {
        String name = Input.inputText("Adınız");
        int password = Input.inputNumber("Pin kodunuz");
        OrdinaryClient orClnt = null;

        if (!Data.instance().getOrClnts().isEmpty()) {

            for (int i = 0; i < Data.instance().getOrClnts().size(); i++) {
                if (name.equalsIgnoreCase(Data.instance().getOrClnts().get(i).getName()) && password == Data.instance().getOrClnts().get(i).getCardPassword()) {
                    orClnt = Data.instance().getOrClnts().get(i);
                    break;
                }
            }
            if (orClnt != null) {
                System.out.println("Salam, " + orClnt.getName() + " " + orClnt.getSurname() + "\n");
                Menu.mainMenuProcess(orClnt);
            } else {
                System.out.println("Ad və ya pin kod yanlışdır!\n");
            }
        } else {
            System.out.println(name + " adlı hesab tapılmadı. Zəhmət olmasa qeydiyyatdan keçin!\n");
        }
    }
}
