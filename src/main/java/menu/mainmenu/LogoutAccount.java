package menu.mainmenu;

import bean.Client;
import menu.mainmenu.inter.LogoutAccountInter;
import util.Show;

public class LogoutAccount implements LogoutAccountInter {

    public void process(Client client) {
        System.out.println("Hesabdan çıxıldı!\n");
        Show.loginMenu();
    }
}
