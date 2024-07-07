package menu.loginmenu;

import bean.OrdinaryClient;
import data.Data;
import util.Input;
import util.Menu;

public class RegisterAccount {

    public static void process() {
        String name = Input.inputText("Adınız");
        String surname = Input.inputText("Soyadınız");
        String cardNumber = Input.inputText("Kartınızın 16 rəqəmli nömrəsi");
//        while (cardNumber.length() != 16) {
//            cardNumber = Input.inputText("Nömrəni düzgün daxil edin!");
//        }
        int cardPassword = Input.inputNumber("Kartınızın 4 rəqəmli pin kodu");
//        while (Integer.toString(cardPassword).length() != 4) {
//            cardPassword = Input.inputNumber("Pin kodu düzgün daxil edin!");
//        }

        for (OrdinaryClient oc : Data.instance().getOrClnts()) {
            if (oc.getName().equalsIgnoreCase(name) && oc.getCardPassword() == cardPassword) {
                System.out.println("Bu adda hesab artıq mövcuddur\n");
                return;
            }
        }
        OrdinaryClient oc = new OrdinaryClient(name, surname, cardNumber, cardPassword);
        Data.instance().getOrClnts().add(oc);
        System.out.println("Qeydiyyatınız uğurla tamamlandı!\n");
        Menu.mainMenuProcess(oc);
    }
}
