package menu.loginmenu;

import bean.Client;
import bean.Data;
import menu.loginmenu.inter.HiddenOptionInter;

public class HiddenOption implements HiddenOptionInter {

    public void process() {
        //Bütün müştərilərin siyahısını göstərən gizli bir seçim
        for (Client c : Data.instance().getClients()) {
            System.out.println(c.getName() + " " + c.getSurname() + " " + c.getCardPinCode());
        }
        System.out.println();
    }
}
