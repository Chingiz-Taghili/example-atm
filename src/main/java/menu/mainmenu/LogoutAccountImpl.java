package menu.mainmenu;

import bean.Client;
import menu.mainmenu.inter.LogoutAccount;
import util.Show;

public class LogoutAccountImpl implements LogoutAccount {

    public void process(Client client) {
        System.out.println("Hesabdan çıxıldı!\n");
        Show.loginMenu();
    }
}
