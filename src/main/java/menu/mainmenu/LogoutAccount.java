package menu.mainmenu;

import bean.OrdinaryClient;
import util.Menu;

public class LogoutAccount {

    public static void process(OrdinaryClient orClnt) {
        System.out.println("Hesabdan çıxıldı!\n");
        Menu.loginMenuProcess();
    }
}
