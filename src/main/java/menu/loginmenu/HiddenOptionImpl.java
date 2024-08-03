package menu.loginmenu;

import bean.Client;
import bean.Data;

public class HiddenOptionImpl implements menu.loginmenu.inter.HiddenOption {

    public void process() {
        //Bütün müştərilərin siyahısını göstərən gizli bir seçim
        for (Client c : Data.instance().getClients()) {
            System.out.println(c.getName() + " " + c.getSurname() + " " + c.getCardPinCode());
        }
        System.out.println();
    }
}
