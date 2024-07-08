package menu.mainmenu;

import bean.OrdinaryClient;
import menu.mainmenu.inter.LogoutAccountInter;
import util.Show;

public class LogoutAccount implements LogoutAccountInter {

    public void process(OrdinaryClient orClnt) {
        System.out.println("Hesabdan çıxıldı!\n");
        Show.loginMenu();
    }
}
