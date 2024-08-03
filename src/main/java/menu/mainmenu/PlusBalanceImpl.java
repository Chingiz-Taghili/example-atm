package menu.mainmenu;

import bean.Client;
import bean.Data;
import menu.mainmenu.inter.PlusBalance;
import util.Check;
import util.File;
import util.Input;

public class PlusBalanceImpl implements PlusBalance {

    public void process(Client client) {

        int amount = Check.amount(Input.text("Artırılacaq məbləği daxil edin"));
        client.plusCardBalance(amount);
        File.writeObject(Data.instance(), "src/main/resources/Database.obj");
        System.out.println("Balans uğurla artırıldı!\n");
    }
}
